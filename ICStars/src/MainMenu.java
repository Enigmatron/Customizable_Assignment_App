import java.applet.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JPanel implements MouseListener{


    StringBuffer name;
    StringBuffer testName;
    StringBuffer lessonname;

    File settings;
//    JButton settingsB = new JButton();
//    JPanel settingsBpanel = new JPanel();
//    JButton testB = new JButton();
//    JPanel testBpanel = new JPanel();
    JButton settingB = new JButton("hi");

//    SettingButton settingButton = new SettingButton();
//    LessonButton lessonButton = new LessonButton();
    public MainMenu(){
//        setLayout(null);
        //revalidate();
        addMouseListener(this);
//        JFrame frame = (JFrame)getTopLevelAncestor();
        name = new StringBuffer();


//        try {
//            Image img = ImageIO.read(getClass().getResource("assets/Settings Button.png"));
//            settingB.setIcon(new ImageIcon(img));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        settingB.setVisible(true);
//        this.add(settingB);
////        settingB.setLocation(625,15);
//        revalidate();
//        repaint();
//        settingB.requestFocusInWindow();
//        this.add("lesson", lessonButton);
////        revalidate();
////        frame.repaint();
//        this.add("settings",settingButton);
//        this.revalidate();
//        this.repaint();
//        revalidate();
//        frame.repaint();

//        lessonButton.setVisible(true);
//        revalidate();
//        frame.repaint();
//        settingButton.setVisible(true);

//        revalidate();
//        frame.repaint();

//        java.net.URL imgURL = MainMenu.class.getResource("assets/Settings Button.png");
//
//        try{
////            imgURL = MainMenu.class.getResource("src/assets/Settings Button.png");
////            BufferedImage img = (ImageIO.read(new File("src/assets/Settings Button.png")));
//            ImageIcon img = new ImageIcon(imgURL);
//
//            settingsB.setIcon(img);
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        GridBagLayout gbl = new GridBagLayout();
//        Insets insets = settingsBpanel.getInsets();
//        Dimension size = settingsB.getPreferredSize();
////        this.add(settingsB);
////
////        settingsB.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
//        SettingsButtonListener listener = new SettingsButtonListener();
//        settingsB.addActionListener(listener);
////        Insets insets = this.getInsets();
////        settingsBpanel.setLayout(null);
////        Dimension size = settingsB.getPreferredSize();
////        settingsB.setBounds(70 + insets.left, 40 + insets.top,
////                size.width, size.height);
////        size = settingsB.getPreferredSize();
//        try{
//            Image img = ImageIO.read(getClass().getResource("assets/Settings Button.png"));
//            settingsB.setIcon(new ImageIcon(img));
//
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        settingsB.setMargin(new Insets(0, 0, 0, 0));
//        settingsB.setBorder(null);
//        settingsB.setBackground(Color.white );
//
//        settingsBpanel.setBounds(615,
//                12 ,90+insets.right+insets.left,40+insets.top+insets.bottom);
//        settingsBpanel.setPreferredSize(new Dimension(90, 40));
//        settingsBpanel.setLocation(625,15);
//        settingsBpanel.setBackground(Color.white);
//        settingsBpanel.setPreferredSize(new Dimension(200,80));
//        settingsBpanel.setBounds(700, 30, settingsBpanel.getWidth(), settingsBpanel.getHeight());
//        settingsBpanel.setLocation(625,30);
//        settingsBpanel.setBackground(Color.white);
//        settingsBpanel.add(settingsB);
//        add(settingsBpanel);

//        settingsB.setVisible(true);
//        settingsB.setMnemonic(KeyEvent.VK_E);
//        settingsB.setActionCommand("enable");
//        settingsB.setEnabled(false);

        //____________________________________
//
////        Dimension size = settingsB.getPreferredSize();
////        this.add(settingsB);
////
////        settingsB.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
////        SettingsButtonListener listener = new SettingsButtonListener();
//        insets = testBpanel.getInsets();
//
//        testB.addActionListener(listener);
////        Insets insets = this.getInsets();
////        settingsBpanel.setLayout(null);
////        Dimension size = settingsB.getPreferredSize();
////        settingsB.setBounds(70 + insets.left, 40 + insets.top,
////                size.width, size.height);
////        size = settingsB.getPreferredSize();
//        try{
//            Image img = ImageIO.read(getClass().getResource("assets/Settings Button.png"));
//            testB.setIcon(new ImageIcon(img));
//
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        testB.setMargin(new Insets(0, 0, 0, 0));
//        testB.setBorder(null);
//        testB.setBackground(Color.white );
//
//        testBpanel.setBounds(615,
//                12 ,90+insets.right+insets.left,40+insets.top+insets.bottom);
////        settingsBpanel.setPreferredSize(new Dimension(90, 40));
////        settingsBpanel.setLocation(625,15);
////        settingsBpanel.setBackground(Color.white);
////        settingsBpanel.setPreferredSize(new Dimension(200,80));
////        settingsBpanel.setBounds(700, 30, settingsBpanel.getWidth(), settingsBpanel.getHeight());
////        settingsBpanel.setLocation(625,30);
////        settingsBpanel.setBackground(Color.white);
//        testBpanel.add(testB);
//        add(testBpanel);
//
//        testB.setVisible(true);

////_______________
////        Dimension size = settingsB.getPreferredSize();
//        insets = lessonBpanel.getInsets();
//
////        this.add(settingsB);
////
////        settingsB.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
////        SettingsButtonListener listener = new SettingsButtonListener();
//        lessonB.addActionListener(listener);
////        Insets insets = this.getInsets();
////        settingsBpanel.setLayout(null);
////        Dimension size = settingsB.getPreferredSize();
////        settingsB.setBounds(70 + insets.left, 40 + insets.top,
////                size.width, size.height);
////        size = settingsB.getPreferredSize();
//        try{
//            Image img = ImageIO.read(getClass().getResource("assets/GenericButton.png"));
//            lessonB.setIcon(new ImageIcon(img));
//
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        lessonB.setMargin(new Insets(0, 0, 0, 0));
//        lessonB.setBorder(null);
//        lessonB.setBackground(Color.white );
//
//        lessonBpanel.setBounds(615,
//                12 ,90+insets.right+insets.left,40+insets.top+insets.bottom);
////        settingsBpanel.setPreferredSize(new Dimension(90, 40));
////        settingsBpanel.setLocation(625,15);
////        settingsBpanel.setBackground(Color.white);
////        settingsBpanel.setPreferredSize(new Dimension(200,80));
////        settingsBpanel.setBounds(700, 30, settingsBpanel.getWidth(), settingsBpanel.getHeight());
////        settingsBpanel.setLocation(625,30);
////        settingsBpanel.setBackground(Color.white);
//        lessonBpanel.add(lessonB);
//        add(lessonBpanel);
//
//        lessonB.setVisible(true);
//        if(!BooleanApp.hasAUser())
//            addItem("initializing the applet", getGraphics());
//        else
//            addItem("something is wrong", getGraphics());
    }
    public MainMenu(File settings){
        addMouseListener(this);

        name = new StringBuffer();
        addItem("initializing the applet ", getGraphics());
    }


    void addItem(String word, Graphics g) {
//        if(!settingButton.isShowing())
//            settingButton.setVisible(true);
        System.out.println(word);
        name.append(word);
        repaint();
    }
    void addItem(String word){
        addItem(word, getGraphics());
    }

//        public void start() {
//        addItem("starting the applet ");
//    }
//
//
//
//    public void stop() {
//        addItem("stopping the applet ");
//    }
//
//    public void destroy() {
//        addItem("unloading the applet");
//    }
    public void paint(Graphics g) {
//        super.paintComponent(g);

        // Draw a Rectangle around the applet's display area.
//        g.setColor(Color.cyan);
//        g.drawRect(0, 0,
//                getWidth() - 1,
//                getHeight() - 1);
//        g.setColor(Color.red);
        try{
            BufferedImage img = (ImageIO.read(new File("src/assets/GenericScreen.png")));
            g.drawImage(img, 0,0,null);

        }
        catch (IOException e){
            e.printStackTrace();
        }
        this.setBackground(Color.white);

        Font nameFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        g.setFont(nameFont);
        g.setColor(Color.white);
        // display the string inside the rectangle.
        g.drawString(name.toString(), 145, 55);
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
//        if(event.getPoint().x>624 && event.getPoint().x<696 &&event.getPoint().y>14 && event.getPoint().y<46) {
//            System.out.println("Settings");
//        }
//        revalidate();
    }

//    private class SettingsButtonListener implements ActionListener{
//
////        JFrame settings = new JFrame("Settings");
////        JPanel panel = new JPanel();
//        @Override
//        //Overriding the ActionPerformed method of ActionListener
//        public void actionPerformed(ActionEvent action) {
//
//
////            if(action.getSource()== exitButton)
////                System.exit(0);
//        }
//    }
}