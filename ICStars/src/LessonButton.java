
//Deprecated

/*import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LessonButton extends JPanel {

    JButton lessonB = new JButton();
//    JPanel lessonBpanel
    public LessonButton() {
        Insets insets = this.getInsets();
        Dimension size = lessonB.getPreferredSize();
        try {
            Image img = ImageIO.read(getClass().getResource("assets/Settings Button.png"));
            lessonB.setIcon(new ImageIcon(img));

        } catch (IOException e) {
            e.printStackTrace();
        }
//        lessonB.setL
        lessonB.setMargin(new Insets(0, 0, 0, 0));
        lessonB.setBorder(null);
        lessonB.setBackground(Color.white);
//        SettingButton.SettingsButtonListener listener = new SettingButton.SettingsButtonListener();
//        lessonB.addActionListener(listener);

//        try {
//            Image img = ImageIO.read(getClass().getResource("assets/Settings Button.png"));
//            lessonB.setIcon(new ImageIcon(img));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        lessonB.setMargin(new Insets(0, 0, 0, 0));
//        lessonB.setBorder(null);
//        lessonB.setBackground(Color.white);

        this.setBounds(500,
                12, 90 + insets.right + insets.left, 40 + insets.top + insets.bottom);
        add(lessonB);

        lessonB.setVisible(true);

//        Dimension size = lessonB.getPreferredSize();
//        Insets insets = this.getInsets();
//        LessonButtonListener listener = new LessonButtonListener();
//        lessonB.addActionListener(listener);
//        this.setBackground(Color.white);
//        lessonB.setBackground(Color.white);
//        try {
//            Image img = ImageIO.read(getClass().getResource("assets/Settings Button.png"));
//            System.out.println("loaded");
//
//            lessonB.setIcon(new ImageIcon(img));
//            lessonB.setBorder(null);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        lessonB.setMargin(new Insets(0, 0, 0, 0));
//
//
//        this.setBounds(40,
//                12, 120 + insets.right + insets.left, 40 + insets.top + insets.bottom);
//        add(lessonB);
//        lessonB.setVisible(true);
    }

//    public void paint(Graphics g){
//
//
////        Font nameFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
////        g.setFont(nameFont);
////        g.setColor(Color.white);
////        g.drawString("Lessons" ,10,20);
////        revalidate();
//
//    }
    private static class LessonButtonListener implements ActionListener {

//        JFrame settings = new JFrame("Settings");
//        JPanel panel = new JPanel();
        @Override
        //Overriding the ActionPerformed method of ActionListener
        public void actionPerformed(ActionEvent action) {


//            if(action.getSource()== exitButton)
//                System.exit(0);
        }
    }
}*/
