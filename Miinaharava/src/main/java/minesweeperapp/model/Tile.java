/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.model;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import javafx.scene.control.Button;

/**
 *
 * @author saasini
 */
public class Tile extends Button {
    private int x; 
    private int y;
    private boolean containsBomb;
    private boolean isRevealed = false;

    public Tile(int x, int y, boolean containsBomb) {
        this.x = x;
        this.y = y;
        this.containsBomb = containsBomb;
        this.isRevealed = false;
        this.setPrefSize(28, 28);
        
        setOnMouseClicked(e -> openTile());
    }
    
    public boolean containsBomb() {
        return containsBomb;
    }

    public void openTile() {
        if (isRevealed == true) {
            return;
        }
        if (containsBomb == true) {
            System.out.println("Game Over, sulje sovellus!");
        }

        isRevealed = true;
    }
}