package cursorbot.cursorSlave;

import java.awt.*;

public class CursorSlave {
    private final Robot robot = new Robot();
    private byte direction = 1;

    public CursorSlave() throws AWTException {
    }

    public void moveTheCursorLikeTheresSomeoneAround() {
        int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
        final int mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();

        byte step = 100;
        int x = mouseX + step * direction;
        changeStepDirection();
        robot.mouseMove(x, mouseY);
    }

    private void changeStepDirection() {
        direction *= -1;
    }
}
