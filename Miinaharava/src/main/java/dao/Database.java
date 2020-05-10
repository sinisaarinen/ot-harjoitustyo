/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
/**
 * 
 * Creates the class responsible for database connections, adding information
 * to the database and retrieving information from the database
 */
public class Database {
   
    private String database;
    private Connection db;
    
    /**
    * Method sets up database connections and calls the method createDataBase
    *
    * @param   database   Defines the name of the database
    */
    public Database(String database) {
        try {
            this.database = database;
            this.db = DriverManager.getConnection(database);
            createDataBase();
        } catch (SQLException ex) {
            //if fails, method does not do anything
        }
    }
    /**
    * Method creates database table
    * 
    * @return true if creating database is completed, otherwise false
    */
    public boolean createDataBase() {
        try {
            this.db = DriverManager.getConnection(database);
            Statement s = db.createStatement();
            s.execute("PRAGMA foreign_keys = ON");
            s.execute("CREATE TABLE Games (game TEXT)");
            return true;
        } catch (SQLException ex) {
            //return false if fails
            return false;
        }
    }
    /**
    * Method used to get database connection
    *
    * @return database connection if connecting to the database works,
    * otherwise return null
    */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(database);
        } catch (SQLException ex) {
            //return null if fails
            return null;
        }
    }
    /**
    * Method retrieves information about the number of games played 
    * from the database
    *
    * @return number of times played if retrieving information works, 
    * otherwise return -1
    */
    public int findAll() {
        try {
            ArrayList<String> games = new ArrayList<>();
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Games");
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                games.add(results.getString("game"));
            }
            ps.close();
            results.close();
            c.close();
            if (games.isEmpty()) {
                return 0;
            }
            return games.size();
        } catch (SQLException ex) {
            //return -1 when fails
            return -1;
        }
    }
    /**
    * Method saves information to the database
    * 
    * @return true if saving is completed, otherwise false
    */
    public boolean save() {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO Games"
                    + " (game)"
                    + " VALUES (?)"
            );
            ps.setString(1, "newgame");
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (SQLException ex) {
            //return false when fails
            return false;
        }
    }
}
