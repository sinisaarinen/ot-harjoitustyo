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
    * @throws SQLException
    */
    public Database(String database) throws SQLException {
        this.database = database;
        this.db = DriverManager.getConnection(database);
        createDataBase();
    }
    /**
    * Method creates database table
    */
    public void createDataBase() {
        try {
            this.db = DriverManager.getConnection(database);
            Statement s = db.createStatement();
            s.execute("PRAGMA foreign_keys = ON");
            s.execute("CREATE TABLE Games (game TEXT)");
        } catch (SQLException e) {
        }
    }
    /**
    * Method used to get database connection
    *
    * @return database connection
    * @throws SQLException
    */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(database);
    }
    /**
    * Method retrieves information about the number of games played 
    * from the database
    *
    * @return number of times played
    * @throws SQLException
    */
    public int findAll() throws SQLException {
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
    }
    /**
    * Method saves information to the database
    * 
    * @throws SQLException
    */
    public void save() throws SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO Games"
                + " (game)"
                + " VALUES (?)"
        );
        ps.setString(1, "newgame");
        ps.executeUpdate();
        ps.close();
        c.close();
    }
}
