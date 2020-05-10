
package minesweeperapp.model;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;

/**
 * 
 * Class responsible for individual tiles and their functions
 */
public class Tile extends Button {
    private int x; 
    private int y;
    private boolean containsBomb;
    private boolean isRevealed = false;
    private boolean isFlagged;
    private String minesNear;
    private Minefield minefield;
    
    /**
    * Method creates a new tile and handles mouse clicks
    *
    * @param   x   x coordinate
    * @param   y   y coordinate
    * @param   containsBomb    Defines if tile has mine
    * @param   minefield    Variable from Minefield class
    */
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
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    /**
    * Method for checking if tile has mine
    * 
    * @return true if tile has mine, otherwise false
    */
    public boolean containsBomb() {
        return containsBomb;
    }
    /**
    * Method removes mine from tile
    */
    public void removeBomb() {
        this.containsBomb = false;
    }
    /**
    * Method sets tile revealed and writes X on a tile with mine
    */
    public void setRevealed() {
        this.isRevealed = true;
        if (this.containsBomb == true) {
            this.setText("X");
        }
    }
    
    public String getTextOnTile() {
        return this.getText();
    }
    
    /**
    * Method for checking if tile is revealed
    * 
    * @return true if tile is revealed, otherwise false
    */
    public boolean isRevealed() {
        return this.isRevealed;
    }
    
    /**
    * Method sets flag on a tile if tile is not revealed
    */
    public void setFlag() {
        if (isRevealed == true) {
            return;
        }
        this.isFlagged = true;
        this.setText("F");
    }
    
    /**
    * Method removes flag from a flagged tile
    */
    public void removeFlag() {
        this.isFlagged = false;
        this.setText("");
    }
    /**
    * Method for checking if tile is flagged
    * 
    * @return true if tile is flagged, otherwise false
    */
    public boolean isFlagged() {
        return isFlagged;
    }
}