/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
/**
 *
 * @author saasini
 */
public class MinesweeperUi extends Application {
    
    private Button[] tiles = new Button[625];
    
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Minesweeper");
    
        BorderPane layout = new BorderPane();

        Label text = new Label("Do not click the bombs");
        layout.setTop(text);
        GridPane grid = new GridPane();
        int i = 0;
        for (int x = 1; x <= 25; x++) {
            for (int y = 1; y <= 25; y++) {
                tiles[i] = new Button(" ");
                    tiles[i].setFont(Font.font("Monospaced", 10));
                    grid.add(tiles[i], x, y);                   
                    i++;
            }
        }
        layout.setCenter(grid);
        

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }
    public static void main(String[] args) {
        launch(MinesweeperUi.class);
    }
}
