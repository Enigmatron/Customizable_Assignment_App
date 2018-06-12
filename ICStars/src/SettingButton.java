import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SettingButton extends JPanel {

    JButton settingsB = new JButton();
    public SettingButton() {
//        this.setLayout(null);
        Insets insets = this.getInsets();
        Dimension size = settingsB.getPreferredSize();
        SettingsButtonListener listener = new SettingsButtonListener();
        settingsB.addActionListener(listener);

        try {
            Image img = ImageIO.read(getClass().getResource("assets/Settings Button.png"));
            settingsB.setIcon(new ImageIcon(img));

        } catch (IOException e) {
            e.printStackTrace();
        }
        settingsB.setMargin(new Insets(0, 0, 0, 0));
        settingsB.setBorder(null);
        settingsB.setBackground(Color.white);

        this.setBounds(625,
                12, 90 + insets.right + insets.left, 40 + insets.top + insets.bottom);
//        add(settingsB);

        settingsB.setVisible(true);


//        this.setPreferredSize(new Dimension(90, 40));
//        this.setLocation(625,15);
//        this.setBackground(Color.white);
//        this.setPreferredSize(new Dimension(200,80));
//        this.setBounds(700, 30, this.getWidth(), this.getHeight());
//        this.setLocation(625,30);
//        this.setBackground(Color.white);
        this.add(settingsB);
    }

//    public void paint(Graphics g){
//
//    }

    private static class SettingsButtonListener implements ActionListener {

        //        JFrame settings = new JFrame("Settings");
//        JPanel panel = new JPanel();
        @Override
        //Overriding the ActionPerformed method of ActionListener
        public void actionPerformed(ActionEvent action) {


//            if(action.getSource()== exitButton)
//                System.exit(0);
        }
    }
}
