package model;

import exceptions.*;
import interfaces.Movable;

/**
 * Created by sgrecu on 10/22/2018.
 */
public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint() {
    }

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        try {
            setX(x);
            setY(y);
            setxSpeed(xSpeed);
            setySpeed(ySpeed);
        } catch (PointOutOfPlainException e) {
            throw new MovableRuntimeException("Could not create a Point instance!", e);
        } catch (InvalidSpeedException e) {
            throw new MovableRuntimeException("Could not create a Point instance!", e);
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws PointOutOfPlainException {
        if ((x >= PLAIN_X_MIN) && (x <= PLAIN_X_MAX)) {
            this.x = x;
        } else {
            throw new PointOutOfPlainException("X is out of limits!");
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws PointOutOfPlainException {
        if ((y >= PLAIN_Y_MIN) && (y <= PLAIN_Y_MAX)) {
            this.y = y;
        } else {
            throw new PointOutOfPlainException("Y is out of limits!");
        }
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) throws InvalidSpeedException {
        if ((xSpeed <= 0) || (xSpeed > PLAIN_X_MAX - PLAIN_X_MIN)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_X_MAX - PLAIN_X_MIN) + "!");
        } else {
            this.xSpeed = xSpeed;
        }
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) throws InvalidSpeedException {
        if ((ySpeed <= 0) || (ySpeed > PLAIN_Y_MAX - PLAIN_Y_MIN)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_Y_MAX - PLAIN_Y_MIN) + "!");
        } else {
            this.ySpeed = ySpeed;
        }
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    @Override
    public void moveUp() throws InvalidMoveUpException {
        try {
            setY(getY() + ySpeed);
        } catch (PointOutOfPlainException e) {
            throw new InvalidMoveUpException("Can't move up, the Point will get out of the plain!");
        }
    }

    @Override
    public void moveDown() throws InvalidMoveDownException {
        try {
            setY(getY() - ySpeed);
        } catch (PointOutOfPlainException e) {
            throw new InvalidMoveDownException("Can't move down, the Point will get out of the plain!");
        }
    }

    @Override
    public void moveLeft() throws InvalidMoveToLeftException {
        try {
            setX(getX() - xSpeed);
        } catch (PointOutOfPlainException e) {
            throw new InvalidMoveToLeftException("Can't move left, the Point will get out of the plain!");
        }
    }

    @Override
    public void moveRight() throws InvalidMoveToRightException {
        try {
            setX(getX() + xSpeed);
        } catch (PointOutOfPlainException e) {
            throw new InvalidMoveToRightException("Can't move right, the Point will get out of the plain!");
        }
    }

    @Override
    public void moveUp(int howMuch) throws InvalidMoveUpException, InvalidSpeedException {
        if ((howMuch <= 0) || (howMuch > PLAIN_Y_MAX - PLAIN_Y_MIN)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_Y_MAX - PLAIN_Y_MIN) + "!");
        } else {
            try {
                setY(getY() + howMuch);
            } catch (PointOutOfPlainException e) {
                throw new InvalidMoveUpException("Can't move up, the Point will get out of the plain!");
            }
        }
    }

    @Override
    public void moveDown(int howMuch) throws InvalidMoveDownException, InvalidSpeedException {
        if ((howMuch <= 0) || (howMuch > PLAIN_Y_MAX - PLAIN_Y_MIN)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_Y_MAX - PLAIN_Y_MIN) + "!");
        } else {
            try {
                setY(getY() - howMuch);
            } catch (PointOutOfPlainException e) {
                throw new InvalidMoveDownException("Can't move down, the Point will get out of the plain!");
            }
        }
    }

    @Override
    public void moveLeft(int howMuch) throws InvalidMoveToLeftException, InvalidSpeedException {
        if ((howMuch <= 0) || (howMuch > PLAIN_X_MAX - PLAIN_X_MIN)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_X_MAX - PLAIN_X_MIN) + "!");
        } else {
            try {
                setX(getX() - howMuch);
            } catch (PointOutOfPlainException e) {
                throw new InvalidMoveToLeftException("Can't move left, the Point will get out of the plain!");
            }
        }
    }

    @Override
    public void moveRight(int howMuch) throws InvalidMoveToRightException, InvalidSpeedException {
        if ((howMuch <= 0) || (howMuch > PLAIN_X_MAX - PLAIN_X_MIN)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_X_MAX - PLAIN_X_MIN) + "!");
        } else {
            try {
                setX(getX() + howMuch);
            } catch (PointOutOfPlainException e) {
                throw new InvalidMoveToRightException("Can't move right, the Point will get out of the plain!");
            }
        }
    }
}
