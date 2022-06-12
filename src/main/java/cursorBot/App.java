package cursorbot;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.MouseInfo;


/**
 * Cursor mover!
 */
public class App {

    public static void main(String... args) {
        moveMouse();
    }

    private static void moveMouse() {
        try {
            final Robot robot = new Robot();
            int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
            final int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
            final byte step = 100;
            byte multiplier = 1;
            final short sleepTime = 15000;

            while (true) {
                int x = mouseX + step * multiplier;
                multiplier *= -1;
                robot.mouseMove(x, mouseY);
                Thread.sleep(sleepTime);
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
