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
 * @author saasini
 */
public class Database {
   
    private String database;
    private Connection db;
    
    public Database(String database) throws SQLException {
        this.database = database;
        this.db = DriverManager.getConnection("jdbc:sqlite:victories.db");
        createDataBase();
    }
    
    public void createDataBase() {
        try {
            this.db = DriverManager.getConnection("jdbc:sqlite:victories.db");
            Statement s = db.createStatement();
            s.execute("PRAGMA foreign_keys = ON");
            s.execute("CREATE TABLE Games (game TEXT)");
        } catch (SQLException e) {
        }
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(database);
    }
    
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
