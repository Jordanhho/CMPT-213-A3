package ca.cmpt213.as3shapes.A3;

/**
 * Triangle class to create a triangle object
 */
public class Triangle {

    private int pointACoord;
    private int pointBCoord;
    private int pointCCoord;

    public Triangle(int pointACoord, int pointBCoord, int pointCCoord) {
        this.pointACoord = pointACoord;
        this.pointBCoord = pointBCoord;
        this.pointCCoord = pointCCoord;
    }

    protected boolean isBorder(int something, int something2) {
        return true;
    }

    protected boolean isInside(int something, int something2) {
        return true;
    }
}
