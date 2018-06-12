import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SettingsMenu extends JPanel implements MouseListener {
    public SettingsMenu(){
        addMouseListener(this);

//        strBuffer = new StringBuffer();
//        addItem("initializing the apple ", getGraphics());
    }

    public void mouseEntered(MouseEvent event) {
    }
    public void mouseExited(MouseEvent event) {
    }
    public void mousePressed(MouseEvent event) {
    }
    public void mouseReleased(MouseEvent event) {
    }
    public void mouseClicked(MouseEvent event) {
//        addItem("mouse clicked! ");
        event.getPoint();
//        revalidate();
    }
}
