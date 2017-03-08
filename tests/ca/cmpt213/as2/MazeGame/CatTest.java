package ca.cmpt213.as2.MazeGame;


import ca.cmpt213.as2.UI.Display;
import org.junit.jupiter.api.Test;

/**
 * Created by Jordan on 17/02/2017.
 */
class CatTest {

    private final int cellRadiusView = 1;
    private final int mazeDifficulty = 155;
    private final int maxCheese = 5;

    @Test
    void moveCatTest() {
        Maze maze = MazeFactory.makeDefaultMaze(cellRadiusView, mazeDifficulty);
        maze.setRevealAll(true);
        Display.printMazePackageToScreen(maze, maxCheese);
        while (true){
            MazeController.moveCats(maze);
            Display.printMazePackageToScreen(maze, maxCheese);
            try{
                Thread.sleep(250);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}