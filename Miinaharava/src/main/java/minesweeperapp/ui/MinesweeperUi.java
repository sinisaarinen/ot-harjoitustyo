/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.ui;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 *
 * @author saasini
 */
public class MinesweeperUi extends Application {
    
    @Override
    public void start(Stage window) {
        window.setTitle("Minesweeper");
        window.show();
    }

    public static void main(String[] args) {
        launch(MinesweeperUi.class);
    }
}
