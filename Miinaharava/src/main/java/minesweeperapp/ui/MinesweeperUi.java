/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeperapp.ui;

import dao.Database;
import java.sql.*;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import minesweeperapp.logic.ApplicationLogic;
/**
 *
 * Class responsible for User Interface (UI)
 */
public class MinesweeperUi extends Application {
    
    private ApplicationLogic applicationlogic;
    private GridPane gridpane;
    private Database database;
    
    /**
     * builds User Interface components
     * @throws Exception 
     */
    @Override
    public void start(Stage window) throws Exception {
        
        database = new Database("jdbc:sqlite:victories.db");
        applicationlogic = new ApplicationLogic(26, 26, "easy");
        
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
        
        //Level view
        BorderPane levelPane = new BorderPane();
        Label levelTitle = new Label("Welcome to play Minesweeper!");
        
        Label gameCount = new Label("You have played the game " + database.findAll() + " times");
        Label levelInstr = new Label("Choose difficulty");
        Button easy = new Button("Easy");
        Button normal = new Button("Normal");
        Button hard = new Button("Hard");
        Button startButton = new Button("Start");

        HBox levelHBox = new HBox();
        levelHBox.setSpacing(20);
        levelHBox.getChildren().add(easy);
        levelHBox.getChildren().add(normal);
        levelHBox.getChildren().add(hard);
        
        VBox selectLevel = new VBox();
        selectLevel.setSpacing(20);
        selectLevel.getChildren().add(gameCount);
        selectLevel.getChildren().add(levelInstr);
        selectLevel.getChildren().add(levelHBox);
        selectLevel.getChildren().add(startButton);
        
        levelPane.setTop(levelTitle);
        levelPane.setBottom(selectLevel);
        
        levelPane.setPrefSize(320, 200);
        BorderPane.setMargin(levelTitle, new Insets(10, 10, 10, 50));
        BorderPane.setMargin(selectLevel, new Insets(100, 10, 10, 10));
        
        Scene levelScene = new Scene(levelPane); 

        window.setScene(passwordscene);
        window.show();
                
        //Game view
        window.setTitle("Minesweeper");
    
        BorderPane layout = new BorderPane();

        Button newGameButton = new Button("New game");
        layout.setTop(newGameButton);
        
        Scene gamescene = new Scene(layout);
        
        
        //Buttons set on action
        loginbutton.setOnAction((event) -> {
          if (applicationlogic.passwordCorrect(passwordfield.getText().trim()) == false) {
              errormessage.setText("Wrong password!");
              return;
          }

        window.setScene(levelScene);
        
        });
        
        easy.setOnAction((event) -> {
            applicationlogic = new ApplicationLogic(10, 10, "easy");
            layout.setCenter(applicationlogic.minefield.getGrid());
            levelInstr.setText("Difficulty chosen: Easy");
        });
               
        normal.setOnAction((event) -> {
            applicationlogic = new ApplicationLogic(18, 18, "normal");
            layout.setCenter(applicationlogic.minefield.getGrid());
            levelInstr.setText("Difficulty chosen: Normal");
        });
        
        hard.setOnAction((event) -> {
            applicationlogic = new ApplicationLogic(26, 26, "hard");
            layout.setCenter(applicationlogic.minefield.getGrid());
            levelInstr.setText("Difficulty chosen: Hard");
        });
        
        startButton.setOnAction((event) -> {
            levelInstr.setText("Good luck!");
            try {
                database = new Database("jdbc:sqlite:victories.db");
            } catch (SQLException ex) {
            }
            try {
                database.save();
            } catch (SQLException ex) {
            }
            window.setScene(gamescene);
            
        });
        
        newGameButton.setOnAction((event) -> {
            window.setScene(levelScene);
            
        });
    }
    public static void main(String[] args) {
        launch(MinesweeperUi.class);
    }
}