package model;

import exceptions.*;
import interfaces.Movable;

/**
 * Created by sgrecu on 10/22/2018.
 */
public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle() {
    }

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        try {
            setRadius(radius);
        } catch (CircleOutOfPlainException e) {
            throw new MovableRuntimeException("Could not create Circle instance!", e);
        } catch (InvalidRadiusException e) {
            throw new MovableRuntimeException("Could not create Circle instance!", e);
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws CircleOutOfPlainException, InvalidRadiusException {
        if (radius <= 0) {
            throw new InvalidRadiusException("Radius must be a positive number.");
        } else {
            if ((this.center.getX() + radius <= PLAIN_X_MAX) && (this.center.getX() - radius >= PLAIN_X_MIN) &&
                    (this.center.getY() + radius <= PLAIN_Y_MAX) && (this.center.getY() - radius >= PLAIN_Y_MIN)) {
                this.radius = radius;
            } else {
                throw new CircleOutOfPlainException("For the set Radius, the Circle will get out of the plain!");
            }
        }
    }

    public void setCenter(MovablePoint center) throws InvalidCenterException {
        try {

            if ((center.getX() + radius > PLAIN_X_MAX) || (center.getX() - radius < PLAIN_X_MIN) ||
                    (center.getY() + radius > PLAIN_Y_MAX) || (center.getY() - radius < PLAIN_Y_MIN)) {
                throw new CircleOutOfPlainException("For the set Radius, the Circle will get out of the plain!");
            }
            this.center.setX(center.getX());
            this.center.setY(center.getY());
            this.center.setxSpeed(center.getxSpeed());
            this.center.setySpeed(center.getySpeed());
        } catch (PointOutOfPlainException e) {
            throw new InvalidCenterException("The new center is out of the plain!");
        } catch (CircleOutOfPlainException e) {
            throw new InvalidCenterException("For the new Center and the current Radius, the Circle will get out of the plain!");
        } catch (InvalidSpeedException e) {
            throw new InvalidCenterException("The Speed of the new Center must be a positiv number under 2000!");
        }
    }

    public int getX() {
        return center.getX();
    }

    public void setX(int x) throws InvalidCenterException {
        try {

            if ((x + radius > PLAIN_X_MAX) || (x - radius < PLAIN_X_MIN) ) {
                throw new CircleOutOfPlainException("For the set Radius, the Circle will get out of the plain!");
            }
            this.center.setX(x);

        } catch (PointOutOfPlainException e) {
            throw new InvalidCenterException("The new center is out of the plain!");
        } catch (CircleOutOfPlainException e) {
            throw new InvalidCenterException("For the new Center and the current Radius, the Circle will get out of the plain!");
        }
    }

    public int getY() {
        return center.getY();
    }
    public void setY(int y) throws InvalidCenterException {
        try {

            if ((y + radius > PLAIN_Y_MAX) || (y - radius < PLAIN_Y_MIN) ) {
                throw new CircleOutOfPlainException("For the set Radius, the Circle will get out of the plain!");
            }
            this.center.setY(y);

        } catch (PointOutOfPlainException e) {
            throw new InvalidCenterException("The new center is out of the plain!");
        } catch (CircleOutOfPlainException e) {
            throw new InvalidCenterException("For the new Center and the current Radius, the Circle will get out of the plain!");
        }
    }

    public int getxSpeed() {
        return center.getxSpeed();
    }

    public void setxSpeed(int xSpeed) throws InvalidSpeedException {
        if ((xSpeed <= 0) || (xSpeed > PLAIN_X_MAX - PLAIN_X_MIN-radius)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_X_MAX - PLAIN_X_MIN-radius) + "!");
        } else {
            center.setxSpeed(xSpeed);
        }
    }

    public int getySpeed() {
        return center.getySpeed();
    }

    public void setySpeed(int ySpeed) throws InvalidSpeedException {
        if ((ySpeed <= 0) || (ySpeed > PLAIN_Y_MAX - PLAIN_Y_MIN-radius)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_Y_MAX - PLAIN_Y_MIN-radius) + "!");
        } else {
            center.setySpeed(ySpeed);
        }
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    // pusesem liniile din try invers pentru ca am crezut ca odata aruncata exceptia se anuleaza si ce a fost inainte
    // si asa mai intai verificam ca centrul e ok si apoi restul, facand mai putine call-uri
    // acum am testat cu finally si am vazut ca centrul avea coordonatele modificate chiar daca era aruncata exceptia.

    @Override
    public void moveUp() throws InvalidMoveUpException {
        try {

            if (center.getY() + center.getySpeed() + radius > PLAIN_Y_MAX) {
                throw new OutOfPlainException("Can't move, the top of the circle will get out of the plain!");
            }
            center.setY(center.getY() + center.getySpeed());

        } catch (OutOfPlainException e) {
            throw new InvalidMoveUpException("Can't move up, the Circle will get out of the plain!");
        }
    }

    @Override
    public void moveDown() throws InvalidMoveDownException {
        try {
            if (center.getY() - center.getySpeed()- radius < PLAIN_Y_MIN) {
                throw new OutOfPlainException("Can't move, the bottom of the circle will get out of the plain!");
            }
            center.setY(center.getY() - center.getySpeed());


        } catch (OutOfPlainException e) {
            throw new InvalidMoveDownException("Can't move down, the Circle will get out of the plain!");
        }
    }

    @Override
    public void moveLeft() throws InvalidMoveToLeftException {
        try {
            if (center.getX() -center.getxSpeed() - radius < PLAIN_X_MIN) {
                throw new OutOfPlainException("Can't move, the left of the circle will get out of the plain!");
            }
            center.setX(center.getX() - center.getxSpeed());

        } catch (OutOfPlainException e) {
            throw new InvalidMoveToLeftException("Can't move left, the Circle will get out of the plain!");
        }
    }

    @Override
    public void moveRight() throws InvalidMoveToRightException {
        try {
            if (center.getX() + center.getxSpeed() +radius > PLAIN_X_MAX) {
                throw new OutOfPlainException("Can't move, the right of the circle will get out of the plain!");
            }
            center.setX(center.getX() + center.getxSpeed());

        } catch (OutOfPlainException e) {
            throw new InvalidMoveToRightException("Can't move right, the Circle will get out of the plain!");
        }
    }

    @Override
    public void moveUp(int howMuch) throws InvalidMoveUpException, InvalidSpeedException {
        if (howMuch <= 0)  {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_Y_MAX - center.getY() -radius) + "!");
        } else {
            try {
                if (center.getY() + howMuch + radius > PLAIN_Y_MAX) {
                    throw new OutOfPlainException("Can't move, the top of the circle will get out of the plain!");
                }
                center.setY(center.getY() + howMuch);

            } catch (OutOfPlainException e) {
                throw new InvalidMoveUpException("Can't move up, the Circle will get out of the plain!");
            }
        }}

    @Override
    public void moveDown(int howMuch) throws InvalidMoveDownException, InvalidSpeedException {
        if ((howMuch <= 0) || (howMuch > PLAIN_Y_MAX - PLAIN_Y_MIN - radius)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_Y_MAX - PLAIN_Y_MIN-radius) + "!");
        } else {
        try {
            if (center.getY() -howMuch- radius < PLAIN_Y_MIN) {
                throw new OutOfPlainException("Can't move, the bottom of the circle will get out of the plain!");
            }
            center.setY(center.getY() - howMuch);

        } catch (OutOfPlainException e) {
            throw new InvalidMoveDownException("Can't move down, the Circle will get out of the plain!");
        }
    }}

    @Override
    public void moveLeft(int howMuch) throws InvalidMoveToLeftException, InvalidSpeedException {
        if ((howMuch <= 0) || (howMuch > PLAIN_X_MAX - PLAIN_X_MIN-radius)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_X_MAX - PLAIN_X_MIN-radius) + "!");
        } else {
            try {
                if (center.getX() -howMuch- radius < PLAIN_X_MIN) {
                    throw new OutOfPlainException("Can't move, the left of the circle will get out of the plain!");
                }
                center.setX(center.getX() - howMuch);

            } catch (OutOfPlainException e) {
                throw new InvalidMoveToLeftException("Can't move left, the Circle will get out of the plain!");
            }
        }
    }

    @Override
    public void moveRight(int howMuch) throws InvalidMoveToRightException, InvalidSpeedException {
        if ((howMuch <= 0) || (howMuch > PLAIN_X_MAX - PLAIN_X_MIN)) {
            throw new InvalidSpeedException("Speed must be a positive number under " + (PLAIN_X_MAX - PLAIN_X_MIN) + "!");
        } else {
            try {
                if (center.getX() +howMuch+ radius > PLAIN_X_MAX) {
                    throw new OutOfPlainException("Can't move, the right of the circle will get out of the plain!");
                }
                center.setX(center.getX() + howMuch);

            } catch (OutOfPlainException e) {
                throw new InvalidMoveToRightException("Can't move right, the Circle will get out of the plain!");
            }
        }
    }
}
