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
    
    int[][] mines;
    boolean[][] flags;
    boolean[][] revealed;
    private Tile[][] tiles = new Tile[26][26];
    private GridPane grid;
    
    public Minefield() {
        grid = new GridPane();
        int i = 0;
        for (int x = 1; x <= 25; x++) {
            for (int y = 1; y <= 25; y++) {
                Tile tile = new Tile(x, y, Math.random() < 0.2);
                tile.setFont(Font.font("Monospaced", 10));
                tiles[x][y] = tile;
                grid.add(tiles[x][y], x, y);
            }
        }
    }
    
    public GridPane getGrid() {
        return grid;
    }
    
    public int findMinesNear(int x, int y) {
        int minesNear = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                minesNear = minesNear + mines[i + x][j + y];
            }
        }
        return minesNear;
    }
}
