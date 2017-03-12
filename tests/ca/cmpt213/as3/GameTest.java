package ca.cmpt213.as3;

import ca.cmpt213.as3.MazeGame.*;
import ca.cmpt213.as3.UI.Display;
import org.junit.jupiter.api.Test;

/**
 * Created by patri on 2/17/2017.
 */
class GameTest {
    private final int cellRadiusView = 1;
    private final int mazeDifficulty = 234;
    private final int maxCheese = 5;

    @Test
    void movePlayerTest(){
        Maze maze = MazeFactory.makeDefaultMaze(cellRadiusView, mazeDifficulty);
        maze.setRevealAll(true);
        Display.printMazePackageToScreen(maze, maxCheese);

        while (true){
            Display.printPromptMsg();
            ValidInput input = Generator.getRandomDirections().get(0);
            System.out.println(input);
            if(input == ValidInput.UP || input == ValidInput.DOWN || input == ValidInput.LEFT || input == ValidInput.RIGHT){
                if(!MazeController.movePlayer(input, maze, cellRadiusView)){
                    Display.printWallMsg();
                }
            }
            Display.printMazePackageToScreen(maze, maxCheese);
            try{
                Thread.sleep(4000);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}