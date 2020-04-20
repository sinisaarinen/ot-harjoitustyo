/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.model;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author saasini
 */
public class Minefield {
    
    private Tile[][] tiles;
    private int width;
    private int height;
    private GridPane grid;
    static Tile tile;
    
    public Minefield(int width, int height) {
        this.width = width;
        this.height = height;
        
        constructField();
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public Tile getTile(int x, int y) {
        Tile tile = this.tiles[x][y];
        return tile;
    }
    
    public void constructField() {
        this.tiles = new Tile[this.width][this.height];
        grid = new GridPane();
        int i = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Tile tile = new Tile(x, y, Math.random() < 0.2, this);
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
        } else if (!tile.containsBomb() && !tile.isRevealed() && !tile.isFlagged()) {
            if (findMinesNear(x, y) > 0) {
                tile.setText("" + findMinesNear(x, y));
            } else {
                tile.setText("0");
            }
            tile.setRevealed();
            
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
    
    public void openMinesNear(int x, int y) {
        int xMin = Math.max(0, x - 1);
        int xMax = Math.min(this.width - 1, x + 1);
        int yMin = Math.max(0, y - 1);
        int yMax = Math.min(this.height - 1, y + 1);
        
        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {            
                if (!this.tiles[i][j].containsBomb()) { 
                    this.tiles[i][j].setRevealed();
                    this.tiles[i][j].setNumber(findMinesNear(i, j));                             
                }
            }                
        }
    }
    
    public void revealAll() {
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[0].length; j++) {
                this.tiles[i][j].setRevealed();
            }
        }
    }
}