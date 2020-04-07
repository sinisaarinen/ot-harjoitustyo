/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.model;

/**
 *
 * @author saasini
 */
public class Minefield {
    
    int[][] mines;
    boolean[][] flags;
    boolean[][] revealed;
    
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
