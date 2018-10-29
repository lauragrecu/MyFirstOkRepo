import exceptions.*;
import javafx.scene.PointLight;
import javafx.scene.shape.Circle;
import model.MovableCircle;
import model.MovablePoint;

/**
 * Created by sgrecu on 10/23/2018.
 */

/**  The Point and Shape don't have to be able to move from start in any direction.
 *   They will move only in the directions where they don't get out of the plain.
 *   The the code must be completed so the user would be informed and asked to make a different move.
 */

public class MovableTest {
    public static void main(String[] args) {

        try {
            MovablePoint point = new MovablePoint(0, 0, 1, 1);
            point.moveUp();
            point.moveDown();
            point.moveLeft();
            point.moveRight();
            point.setY(3);
            point.setX(3);
            point.setxSpeed(3);
            point.setySpeed(4);
            point.moveUp(50);
            point.moveDown(20);
            point.moveLeft(50);
            point.moveRight(20);

            MovableCircle circle = new MovableCircle(400,-400,250,250,500);

            circle.moveUp();
            circle.moveDown();
            circle.moveLeft();
            circle.moveRight();

           MovablePoint center = new MovablePoint(300, 300, 1, 1);
            circle.setCenter(center);
            circle.setRadius(50);
            circle.moveUp(800);
            circle.moveDown(200);
            circle.moveLeft(500);
            circle.moveRight(200);

            circle.setX(300);
            circle.setY(300);
            circle.setxSpeed(500);
            circle.setySpeed(500);


            System.out.println(point.toString());
            System.out.println(circle.toString());


        }catch (MovableRuntimeException e){
            System.out.println(e.getMessage());
        }catch (InvalidCenterException e){
            System.out.println(e.getMessage());
        }catch (InvalidSpeedException e){
            System.out.println(e.getMessage());
        }catch (InvalidRadiusException e){
            System.out.println(e.getMessage());
        }catch (OutOfPlainException e){
            System.out.println(e.getMessage());
        }catch (InvalidMoveUpException e){
            System.out.println(e.getMessage());
        }catch (InvalidMoveDownException e){
            System.out.println(e.getMessage());
        }catch (InvalidMoveToLeftException e){
            System.out.println(e.getMessage());
        }catch (InvalidMoveToRightException e){
            System.out.println(e.getMessage());
        }

    }
}
