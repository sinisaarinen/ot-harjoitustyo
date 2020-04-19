/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import minesweeperapp.logic.ApplicationLogic;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
/**
 *
 * @author saasini
 */
public class MiinaharavaTest {
    
    ApplicationLogic applicationlogic;
    
    @Before
    public void setUp() {
        applicationlogic = new ApplicationLogic();
    }
    
    @Test
    public void wrongPasswordCreatesErrorMessage() {
        assertFalse(applicationlogic.passwordCorrect("wrongpassword"));
    }
}
