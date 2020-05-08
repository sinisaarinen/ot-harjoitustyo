/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.logic;

import minesweeperapp.model.Minefield;

/**
 *
 * Class creates the application logic
 */
public class ApplicationLogic {
    /**
    * Minefield variable from Minefield class
    */
    public Minefield minefield;
    /**
    * Method creates a new minefield with parameters depending on the
    * player's choice
    *
    * @param   width   Defines the width of the minefield
    * @param   height   Defines the height of the minefield
    * @param   difficulty   Defines the mine percentage of the minefield
    */
    public ApplicationLogic(int width, int height, String difficulty) {
        this.minefield = new Minefield(width, height, difficulty);
    }
    
    /**
    * Method checks if password given by player is correct
    *
    * @param   password   Password given to enter the game
    * 
    * @return true if the password is valid, otherwise false
    */
    public Boolean passwordCorrect(String password) {
        if (password.equals("password")) {
            return true;
        }
        return false;
    }
}
