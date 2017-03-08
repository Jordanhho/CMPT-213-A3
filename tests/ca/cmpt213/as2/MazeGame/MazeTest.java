
package ca.cmpt213.as2.MazeGame;

import ca.cmpt213.as2.UI.Display;
import org.junit.jupiter.api.Test;

/**
 * Created by patri on 2/15/2017.
 */


class MazeTest {

    private final int cellRadiusView = 1;
    private final int mazeDifficulty = 266;
    private final int maxCheese = 5;

    @Test
    void cheeseInitiallyNull(){
        Maze maze = MazeFactory.makeDefaultMaze(cellRadiusView, mazeDifficulty);
        maze.setRevealAll(true);
        Display.printMazePackageToScreen(maze, maxCheese);
    }

    @Test
    void cheeseAlreadyPresent(){
        Maze maze = MazeFactory.makeDefaultMaze(cellRadiusView, mazeDifficulty);
        maze.setRevealAll(true);
        System.out.println("Spawn cheese called");
        MazeController.spawnCheese(maze);
        System.out.println("Spawn cheese called");
        MazeController.spawnCheese(maze);
        System.out.println("Spawn cheese called");
        MazeController.spawnCheese(maze);
        Display.printMazePackageToScreen(maze, maxCheese);
    }
}

