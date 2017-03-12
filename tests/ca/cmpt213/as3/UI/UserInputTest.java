
package ca.cmpt213.as3.UI;

import ca.cmpt213.as3.MazeGame.ValidInput;
import ca.cmpt213.as3.UI.INPUT.UserInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by patri on 2/17/2017.
 */

class UserInputTest {
    @Test
    void shouldReturnUp(){
        String testInput = "w";
        assertEquals(ValidInput.UP, UserInput.getValidInput(testInput));
    }
    @Test
    void shouldReturnDown(){
        String testInput = "s";
        assertEquals(ValidInput.DOWN, UserInput.getValidInput(testInput));
    }

    @Test
    void shouldReturnLeft(){
        String testInput = "a";
        assertEquals(ValidInput.LEFT, UserInput.getValidInput(testInput));
    }

    @Test
    void shouldReturnRight(){
        String testInput = "d";
        assertEquals(ValidInput.RIGHT, UserInput.getValidInput(testInput));
    }

    @Test
    void shouldReturnMap(){
        String testInput = "m";
        assertEquals(ValidInput.MAP, UserInput.getValidInput(testInput));
    }

    @Test
    void shouldReturnHelp(){
        String testInput = "?";
        assertEquals(ValidInput.HELP, UserInput.getValidInput(testInput));
    }

    @Test
    void shouldReturnInvalid(){
        String testInput = "p";
        assertEquals(ValidInput.INVALID, UserInput.getValidInput(testInput));
    }
}

