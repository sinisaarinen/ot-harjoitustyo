/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.saxsys.javafx.test.JfxRunner;
import minesweeperapp.logic.ApplicationLogic;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author saasini
 */
@RunWith(JfxRunner.class)
public class ApplicationLogicTest {
 
    ApplicationLogic applicationlogic;
    
    @Before
    public void setUp() {
        applicationlogic = new ApplicationLogic(26, 26, "easy");
    }
    
    @Test
    public void wrongPasswordCreatesErrorMessage() {
        assertFalse(applicationlogic.passwordCorrect("wrongpassword"));
    }
    
    @Test
    public void correctPasswordReturnsTrue() {
        assertTrue(applicationlogic.passwordCorrect("password"));
    }
}