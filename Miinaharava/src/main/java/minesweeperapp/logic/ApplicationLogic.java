/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.logic;

import minesweeperapp.model.Minefield;

/**
 *
 * @author saasini
 */
public class ApplicationLogic {
    public Minefield minefield;
    private String difficulty;
    
    public ApplicationLogic(int width, int height, String difficulty) {
        this.minefield = new Minefield(width, height, difficulty);
    }
    
    public void setEasy() {
        this.difficulty = "easy";
    }
    
    public void setNormal() {
        this.difficulty = "normal";
    }
    
    public void setHard() {
        this.difficulty = "hard";
    }
    
    public void openTile(int x, int y) {
        this.minefield.openTile(x, y);
    }
    
    public void setFlag(int x, int y) {
        this.minefield.setFlag(x, y);
    }
    
    public Boolean passwordCorrect(String password) {
        if (password.equals("password")) {
            return true;
        }
        return false;
    }
}
