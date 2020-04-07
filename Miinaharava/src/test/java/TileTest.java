/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.saxsys.javafx.test.JfxRunner;
import minesweeperapp.logic.ApplicationLogic;
import minesweeperapp.logic.Tile;
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
public class TileTest {
    
    Tile tile;
    
    @Before
    public void setUp() {
        tile = new Tile(2, 4, true);
    }
    
    @Test
    public void containsBombMethodReturnsTrueIfTileContainsBomb() {
        tile.openTile();
        assertTrue(tile.containsBomb());
    }
}
