package ca.cmpt213.as3.UI;

import ca.cmpt213.as2.MazeGame.*;
import ca.cmpt213.as3.MazeGame.Cell;
import ca.cmpt213.as3.MazeGame.Maze;
import ca.cmpt213.as3.MazeGame.MazeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Patrick on 2/15/2017.
 */

class DisplayTest {

    private final int cellRadiusView = 1;
    private final int mazeDifficulty = 155;
    private final int maxCheese = 5;
    /**
     * The symbol returned should be undiscovered if revealAll == false
     * and cell.isWall() == true
     */
    @Test
    void symbolToPrintShouldReturnUndiscovered(){
        Cell cell = new Cell();
        cell.setWall(true);
        assertEquals(MazeElements.getUnDiscoveredSymbol(),Display.symbolToPrint(cell,false));
    }

    /**
     * The symbol returned should be wall if revealAll == true
     * and cell.isWall() == true
     */
    @Test
    void symbolToPrintShouldReturnWall(){
        Cell cell = new Cell();
        cell.setWall(true);
        assertEquals(MazeElements.getWallSymbol(),Display.symbolToPrint(cell,true));
    }

    /**
     * The symbol returned should be undiscovered if revealAll == false
     * and cell.isWall() == false
     */
    @Test
    void symbolToPrintShouldReturnUndiscovered_EmptySpace(){
        Cell cell = new Cell();
        cell.setWall(false);
        assertEquals(MazeElements.getUnDiscoveredSymbol(),Display.symbolToPrint(cell,false));
    }

    /**
     * The symbol returned should be emptyspace if revealAll == true
     * and cell.isWall() == true
     */
    @Test
    void symbolToPrintShouldReturnemptySpace(){
        Cell cell = new Cell();
        cell.setWall(false);
        assertEquals(MazeElements.getEmptySpaceSymbol(),Display.symbolToPrint(cell,true));
    }

    @Test
    void symbolToPrintShouldReturn() {

    }

    @Test
    void printMazeToScreen() {
        Maze maze = MazeFactory.makeDefaultMaze(cellRadiusView, mazeDifficulty);
        maze.setRevealAll(true);
        Display.printMazePackageToScreen(maze, maxCheese);
    }

}
