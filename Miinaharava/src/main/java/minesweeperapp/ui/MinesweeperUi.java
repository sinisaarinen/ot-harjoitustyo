/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import minesweeperapp.logic.ApplicationLogic;
/**
 *
 * @author saasini
 */
public class MinesweeperUi extends Application {
    
    private ApplicationLogic applicationlogic;
    private GridPane gridpane;
    
    @Override
    public void start(Stage window) throws Exception {
        
        applicationlogic = new ApplicationLogic(26, 26);
        
        //Log in view

        Label instr = new Label("Log in to begin");
        PasswordField passwordfield = new PasswordField();
        Button loginbutton = new Button("Login");
        Label errormessage = new Label("");

        GridPane firstlayout = new GridPane();

        firstlayout.add(instr, 0, 0);
        firstlayout.add(passwordfield, 0, 1);
        firstlayout.add(loginbutton, 0, 2);
        firstlayout.add(errormessage, 0, 3);

        firstlayout.setPrefSize(320, 200);
        firstlayout.setAlignment(Pos.BOTTOM_CENTER);
        firstlayout.setVgap(15);
        firstlayout.setHgap(15);
        firstlayout.setPadding(new Insets(25, 25, 25, 25));

        Scene passwordscene = new Scene(firstlayout);
        
        //Game view
        window.setTitle("Minesweeper");
    
        BorderPane layout = new BorderPane();

        Label text = new Label("Do not click on the bombs");
        layout.setTop(text);
        layout.setCenter(applicationlogic.minefield.getGrid());
        
        Scene gamescene = new Scene(layout);
        
        loginbutton.setOnAction((event) -> {
          if (applicationlogic.passwordCorrect(passwordfield.getText().trim()) == false) {
              errormessage.setText("Wrong password!");
              return;
          }

        window.setScene(gamescene);
      });

      window.setScene(passwordscene);
        window.show();

    }
    public static void main(String[] args) {
        launch(MinesweeperUi.class);
    }
}