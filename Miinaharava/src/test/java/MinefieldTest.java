/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.saxsys.javafx.test.JfxRunner;
import minesweeperapp.model.Minefield;
import minesweeperapp.model.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author saasini
 */
@RunWith(JfxRunner.class)
public class MinefieldTest {
    
    Minefield minefield;
    Tile tile;
    
    @Before
    public void setUp() {
        minefield = new Minefield(26, 26, "easy");
        tile = new Tile(2, 4, true, minefield);
    }
    
    @Test
    public void getWidthMethodReturnsCorrectWidth() {
        assertEquals(26, minefield.getWidth());
    }
    
    @Test
    public void getHeightMethodReturnsCorrectHeight() {
        assertEquals(26, minefield.getHeight());
    }
    
    @Test
    public void openTileMethodWorks() {
        minefield.openTile(2, 4);
        Tile[][] field = minefield.getField();
        Tile tile = field[2][4];
        assertTrue(tile.isRevealed());
    }
    
    @Test
    public void setFlagMethodWorks() {
        minefield.setFlag(2, 4);
        Tile[][] field = minefield.getField();
        Tile tile = field[2][4];
        assertTrue(tile.isFlagged());
        minefield.setFlag(2, 4);
        assertFalse(tile.isFlagged());
    }
}
