/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.logic;

/**
 *
 * @author saasini
 */
public class ApplicationLogic {
    
    public Boolean passwordCorrect(String password) {
         if (password.equals("password")) {
             return true;
        }
        return false;
    }
}
