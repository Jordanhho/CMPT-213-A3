package ca.cmpt213.as2.MazeGame;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Generator class to generate movement for cats and maze
 */
public class Generator {
    /**
     * Generates the maze
     *
     * @param row input the height of the maze
     * @param col input the width of the maze
     * @return Coordinate with row between 0 and row(exclusive) and
     * with col between 0 and col(exclusive)
     */
    public static Coordinate getRandomCoordinate(int row, int col) {
        Random random = new Random();
        return new Coordinate(random.nextInt(row), random.nextInt(col));
    }

    /**
     * Returns the ValidInputs, UP, DOWN, LEFT, RIGHT in a random order.
     *
     * @return List of ValidInputs UP, DOWN, LEFT and RIGHT
     */
    public static List<ValidInput> getRandomDirections() {
        List<ValidInput> validInputList = new ArrayList<>();

        validInputList.add(ValidInput.UP);
        validInputList.add(ValidInput.DOWN);
        validInputList.add(ValidInput.LEFT);
        validInputList.add(ValidInput.RIGHT);

        Collections.shuffle(validInputList);
        return validInputList;
    }

    /**
     * Generates the random Cat movement direction
     *
     * @param cat input a cat
     * @return the direction the generator creates
     */
    public static ValidInput getRandomCatDirection(Cat cat) {
        List<ValidInput> validInputList = getRandomDirections();
        ValidInput newDirection;

        boolean isNewDirection = false;
        do {
            //shuffles valid directions
            Collections.shuffle(validInputList);
            newDirection = validInputList.get(0);

            if (cat.getPrevDirection() == null) {
                isNewDirection = true;
            } else if (!newDirection.equals(cat.getPrevDirection())) {
                isNewDirection = true;
            }
        } while (!isNewDirection);
        return newDirection;
    }
}
