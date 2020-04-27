/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.saxsys.javafx.test.JfxRunner;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import minesweeperapp.model.Minefield;
import minesweeperapp.model.Tile;
import org.junit.Before;
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
    Minefield minefield;
    
    @Before
    public void setUp() {
        minefield = new Minefield(26, 26, "easy");
        tile = new Tile(2, 4, true, minefield);
    }
    
    @Test
    public void getXMethodReturnsCorrectValue() {
        assertEquals(2, tile.getX());
    }
    
    @Test
    public void getYMethodReturnsCorrectValue() {
        assertEquals(4, tile.getY());
    }
    
    @Test
    public void containsBombMethodReturnsTrueIfTileContainsBomb() {
        assertTrue(tile.containsBomb());
    }
    
    @Test
    public void setFlagMethodTurnsTileFlagged() {
        tile.setFlag();
        assertTrue(tile.isFlagged());
    }
    
    @Test
    public void setFlagMethodWritesFOnTile() {
        tile.setFlag();
        assertEquals("F", tile.getText());
    }
    
    @Test
    public void setFlagMethodDoesNothingIfTileIsRevealed() {
        tile.setRevealed();
        tile.setFlag();
        assertFalse(tile.isFlagged());
    }
    
    @Test
    public void unopenedTileHasNoText() {
        assertEquals("", tile.getText());
    }
    
    @Test
    public void removeFlagMethodRemovesTextFromTile() {
        tile.removeFlag();
        assertEquals("", tile.getText());
    }
    
    @Test
    public void removeFlagMethodChangesBooleanValue() {
        tile.removeFlag();
        assertFalse(tile.isFlagged());
    }
    
    @Test
    public void isRevealedMethodReturnsCorrectValue() {
        tile.setRevealed();
        assertTrue(tile.isRevealed());
    }
    
    @Test
    public void setRevealedMethodWritesXOnATileWithMine() {
        tile.setRevealed();
        assertTrue(tile.containsBomb());
        assertEquals("X", tile.getTextOnTile());
    }
}