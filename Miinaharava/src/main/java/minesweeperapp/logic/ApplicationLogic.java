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
    
    public ApplicationLogic(int width, int height, String difficulty) {
        this.minefield = new Minefield(width, height, difficulty);
    }
    
    public Boolean passwordCorrect(String password) {
        if (password.equals("password")) {
            return true;
        }
        return false;
    }
}
