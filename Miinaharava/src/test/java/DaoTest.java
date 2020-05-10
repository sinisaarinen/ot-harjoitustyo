/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.Database;
import java.io.File;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author saasini
 */
public class DaoTest {

    @Test
    public void savingToDatabaseWorks() {
        Database database = new Database("jdbc:sqlite:test.db");
        database.save();
        assertEquals(1, database.findAll());
        deleteDatabase();
    }
    
    @Test
    public void findAllMethodReturns0IfDatabaseIsEmpty() {
        Database database = new Database("jdbc:sqlite:test.db");
        assertEquals(0, database.findAll());
    }
    
    @AfterClass
    public static void deleteDatabase() {
        File f = new File("test.db");
        f.delete();
    }
}
