
package minesweeperapp.model;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import minesweeperapp.model.Minefield;

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
    private String minesNear;
    private Minefield minefield;


    public Tile(int x, int y, boolean containsBomb, Minefield minefield) {
        this.x = x;
        this.y = y;
        this.minefield = minefield;
        this.containsBomb = containsBomb;
        this.isRevealed = false;
        this.isFlagged = false;
        this.setPrefSize(28, 28);
        this.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                minefield.openTile(x, y);
            }
            if (event.getButton() == MouseButton.SECONDARY) {
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
    
    public void setRevealed() {
        this.isRevealed = true;
        if (this.containsBomb == true) {
            this.setText("X");
        }
    }
    
    public String setNumber(int number) {
        this.minesNear = "" + number;
        return this.minesNear;
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
}