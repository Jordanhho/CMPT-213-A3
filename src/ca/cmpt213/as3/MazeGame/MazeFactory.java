package ca.cmpt213.as3.MazeGame;

/**
 * Class responsible for returning a generated (playable) maze to the user.
 */
public class MazeFactory {
    private static final int DEFAULT_MAZE_HEIGHT = 15;
    private static final int DEFAULT_MAZE_WIDTH = 20;

    /**
     * Generates a playable maze with the default size of 15 tall 20 wide (including borders).
     *
     * Calls the mazeGen() and spawnCheese methods to initialize the maze.
     * @param cellRadiusView the view block radius for the player
     * @param mazeDifficulty the difficulty of maze generation on amount of blocks removed (less blocks removed is harder)
     * @return Playable maze that has been initialized
     */
    public static Maze makeDefaultMaze(int cellRadiusView, int mazeDifficulty) {
        Maze maze = new Maze(DEFAULT_MAZE_HEIGHT, DEFAULT_MAZE_WIDTH);
        MazeGenerator.mazeGen(maze, cellRadiusView, mazeDifficulty);
        MazeController.spawnCheese(maze);
        return maze;
    }

    /**
     * Creates a playable maze given a specified height and width.
     *
     * @param height    Height of the maze (with borders)
     * @param width     Width of the maze (with borders)
     * @param cellRadiusView the view block radius for the player
     * @param mazeDifficulty the difficulty of maze generation on amount of blocks removed (less blocks removed is harder)
     * @return Playable maze that has been initialized.
     */
    public static Maze makeMaze(int height, int width, int cellRadiusView, int mazeDifficulty) {
        Maze maze = new Maze(height, width);
        MazeGenerator.mazeGen(maze, cellRadiusView, mazeDifficulty);
        MazeController.spawnCheese(maze);
        return maze;
    }
}
