import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LessonPage extends JPanel implements MouseListener {

    public LessonPage(){
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
        if(event.getPoint().x>624 && event.getPoint().x<696 &&event.getPoint().y>14 && event.getPoint().y<46) {
            System.out.println("Settings");
        }
        //addItem("mouse clicked! ");
//        revalidate();
    }
}
//    JFrame frame = new JFrame();
//    JPanel panel = new JPanel();
//        for (int i = 0; i < 10; i++) {
//        panel.add(new JButton("Hello-" + i));
//        }
//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        scrollPane.setBounds(50, 30, 300, 50);
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(500, 400));
//        contentPane.add(scrollPane);
//        frame.setContentPane(contentPane);
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setVisible(true);