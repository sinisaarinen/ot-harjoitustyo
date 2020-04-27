/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.model;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import minesweeperapp.logic.ApplicationLogic;

/**
 *
 * @author saasini
 */
public class Minefield {
    
    private Tile[][] tiles;
    private int width;
    private int height;
    private double minePercentage;
    private GridPane grid;
    static Tile tile;
    public ApplicationLogic applicationlogic;
    
    public Minefield(int width, int height, String difficulty) {
        this.width = width;
        this.height = height;
        this.applicationlogic = applicationlogic;
        
        constructField(difficulty);
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
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
    
    public void openTile(int x, int y) {
        Tile tile = this.tiles[x][y];
        if (tile.containsBomb() && !tile.isRevealed() && !tile.isFlagged()) {
            tile.setText("X");
            revealAll();
            System.out.println("GAME OVER!");
        } else if (!tile.containsBomb() && !tile.isRevealed() && !tile.isFlagged()) {
            if (findMinesNear(x, y) > 0) {
                tile.setText("" + findMinesNear(x, y));
            } else {
                tile.setText("0");
            }
            tile.setRevealed();
            checkGameStatus();
        }
    }
    
    public void checkGameStatus() {
        int cleared = 0;
        for (int i=0; i<this.width; i++) {
            for (int j=0; j<this.height; j++) {
                Tile tile = this.tiles[i][j];
                if (tile.isRevealed() || tile.containsBomb()) {
                    cleared++;
                }
            }
        }
        if (cleared == this.width * this.height) {
            System.out.println("YOU WIN!");
        }
    }
       
    public void setFlag(int x, int y) {
        Tile tile = this.tiles[x][y];
        
        if (!tile.isFlagged()) {
            tile.setFlag();
        } else {
            tile.removeFlag();
        }
    }
    
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
    
    public void revealAll() {
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[0].length; j++) {
                this.tiles[i][j].setRevealed();
            }
        }
    }
}