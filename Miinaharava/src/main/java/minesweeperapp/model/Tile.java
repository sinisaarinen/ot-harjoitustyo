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
import javafx.scene.input.MouseButton;

/**
 *
 * @author saasini
 */
public class Tile extends Button {
    private int x; 
    private int y;
    private boolean containsBomb;
    private boolean isRevealed = false;
    private boolean isFlagged;

    public Tile(int x, int y, boolean containsBomb) {
        this.x = x;
        this.y = y;
        this.containsBomb = containsBomb;
        this.isRevealed = false;
        this.isFlagged = false;
        this.setPrefSize(28, 28);
        
        this.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                openTile();
            }
            if (e.getButton() == MouseButton.SECONDARY) {
                if (!isFlagged) {
                    setFlag();
                } else {
                    removeFlag();
                }
            }
        });
    }
    
    public boolean containsBomb() {
        return containsBomb;
    }
    
    public void setFlag() {
        if (isRevealed == true) {
            return;
        }
        this.isFlagged = true;
        this.setText("F");
    }
    
    public void removeFlag() {
        this.isFlagged = false;
        this.setText("");
    }
    
    public boolean isFlagged() {
        return isFlagged;
    }

    public void openTile() {
        if (isRevealed == true || isFlagged() == true) {
            return;
        }
        if (containsBomb == true) {
            this.setText("X");
            System.out.println("Game Over, sulje sovellus!");
        }
        if (containsBomb == false) {
            this.setText("O");
        }

        isRevealed = true;
    }
}