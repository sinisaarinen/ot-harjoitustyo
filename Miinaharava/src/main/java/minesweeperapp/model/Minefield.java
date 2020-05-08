/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import minesweeperapp.logic.ApplicationLogic;

/**
 *
 * Creates the class responsible for minefield
 */
public class Minefield {
    /**
    * ApplicationLogic variable from ApplicationLogic class
    */
    public ApplicationLogic applicationlogic;
    
    private Tile[][] tiles;
    private int width;
    private int height;
    private double minePercentage;
    private GridPane grid;
    static Tile tile;
    
    /**
    * Method creates a new minefield and calls method constructField
    *
    * @param   width   Width of minefield
    * @param   height    Height of minefield
    * @param   difficulty    Defines mine percentage of minefield
    */
    public Minefield(int width, int height, String difficulty) {
        this.width = width;
        this.height = height;
        this.applicationlogic = applicationlogic;
        
        constructField(difficulty);
    }
    
    public double getMinePercentage() {
        return this.minePercentage;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    /**
     * Creates minefield that's size and mine percentage depend on player's
     * choice of difficulty
     * 
     * @param   difficulty    Defines mine percentage of minefield
     */
    public void constructField(String difficulty) {
        this.tiles = new Tile[this.width][this.height];
        grid = new GridPane();
        int i = 0;
        if (difficulty.equals("easy")) {
            this.minePercentage = 0.1;
        } else if (difficulty.equals("normal")) {
            this.minePercentage = 0.2;
        } else if (difficulty.equals("hard")) {
            this.minePercentage = 0.3;
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Tile tile = new Tile(x, y, Math.random() < minePercentage, this);
                tile.setFont(Font.font("Monospaced", 10));
                tiles[x][y] = tile;
                grid.add(tiles[x][y], x, y);
            }
        }
    }
    
    public GridPane getGrid() {
        return grid;
    }
    
    public Tile[][] getField() {
        return this.tiles;
    }   
    
     /**
     * Method that opens the tile clicked by the player. If tile contains mine,
     * calls methods revealAll and gameOver to reveal remaining mines and
     * end game. If tile does not contain mine, method calls another method
     * to calculate mines around the tile and reveals tile to the player with
     * the number of mines around it written on the tile. Then it sets tile
     * revealed and check's if game is still running.
     * 
     * @param   x    x coordinate
     * @param   y    y coordinate
     */
    public void openTile(int x, int y) {
        Tile tile = this.tiles[x][y];
        if (tile.containsBomb() && !tile.isRevealed() && !tile.isFlagged()) {
            tile.setText("X");
            revealAll();
            gameOver();
        } else if (!tile.containsBomb() && !tile.isRevealed() && !tile.isFlagged()) {
            if (findMinesNear(x, y) > 0) {
                tile.setText("" + findMinesNear(x, y));
            } else {
                tile.setText("0");
                openTilesAround(x, y);
            }
            tile.setRevealed();
            checkGameStatus();
        }
    }
     /**
     * Method that checks if player has won the game and informs the player if
     * the game has been won. If the game is still on, nothing happens.
     */
    public void checkGameStatus() {
        int cleared = 0;
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                Tile tile = this.tiles[i][j];
                if (tile.isRevealed() || tile.containsBomb()) {
                    cleared++;
                }
            }
        }
        if (cleared == this.width * this.height) {
            victory();
            revealAll();
        }
    }  
    /**
     * Method opens all unrevealed tiles without mines if a clicked tile has
     * zero mines around it.
     * 
     * @param   x    x coordinate
     * @param   y    y coordinate
     */   
    public void openTilesAround(int x, int y) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i >= 0 && x + i < this.width && y + j >= 0 && y + j < this.height) {
                    Tile tile = tiles[x + i][y + j];    
                    if (!tile.containsBomb() && !tile.isRevealed()) { 
                        tile.setRevealed();
                        if (findMinesNear(x + i, y + j) > 0) {
                            tile.setText("" + findMinesNear(x + i, y + j));
                        } else {
                            tile.setText("0");
                            openTilesAround(x + i, y + j);
                        }
                    }
                }                    
            }
        }
    }
    
     /**
     * Method informs the player that the game is over by showing an alert.
     */
    public void gameOver() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("GAME OVER!");
        alert.setHeaderText(null);
        alert.setContentText("Click New game to try again!");
        alert.showAndWait();
    }
     /**
     * Method informs the player about victory by showing an alert.
     */
    public void victory() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("YOU WIN!");
        alert.setHeaderText(null);
        alert.setContentText("Click New game to try again!");
        alert.showAndWait();
    }
    
     /**
     * Method sets flag on the clicked tile or, if the tile is already flagged,
     * removes the flag from the tile.
     * 
     * @param   x    x coordinate
     * @param   y    y coordinate
     */   
    public void setFlag(int x, int y) {
        Tile tile = this.tiles[x][y];
        
        if (!tile.isFlagged()) {
            tile.setFlag();
        } else {
            tile.removeFlag();
        }
    }
    
     /**
     * Method calculates the number of mines around the clicked tile.
     * 
     * @param   x    x coordinate
     * @param   y    y coordinate
     * 
     * @return number of mines around the clicked tile
     */   
    public int findMinesNear(int x, int y) {
        int minesNear = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i >= 0 && x + i < this.width && y + j >= 0 && y + j < this.height && this.tiles[x + i][y + j].containsBomb()) {
                    minesNear++;
                }
            }
        }
        return minesNear;
    }
    /**
     * Method reveals all remaining unrevealed tiles.
     */   
    public void revealAll() {
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[0].length; j++) {
                this.tiles[i][j].setRevealed();
            }
        }
    }
}