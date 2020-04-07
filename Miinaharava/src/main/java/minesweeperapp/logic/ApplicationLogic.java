/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.logic;

import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author saasini
 */
public class ApplicationLogic {
    
    int[][] mines;
    boolean[][] flags;
    boolean[][] revealed;
    
    public Boolean passwordCorrect(String password) {
         if (password.equals("password")) {
             return true;
        }
        return false;
    }
    
    public int findMinesNear(int x, int y) {
        int minesNear=0;
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                minesNear=minesNear+mines[i+x][j+y];
            }
        }
        return minesNear;
    }
}
