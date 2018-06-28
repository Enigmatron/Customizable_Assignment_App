import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
//import com.apple.eawt.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BooleanApp {

    
    private enum Screen{
        MENU,
        WELCOME,
        TEST,
        LESSON,
        SETTINGS
    }
    
    public static void swapToMenu(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new Menu());
        frame.setVisible(true);
        frame.validate();
    }
    public static void swapToLesson(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new LessonWindow());
        frame.setVisible(true);
        frame.validate();
    }
    public static void swapToSettings(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new Menu());
        frame.setVisible(true);
        frame.validate();
    }
    public static void swapToTest(int num){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new TestTaker(num));
        frame.setVisible(true);
        frame.validate();
    }
    public static void swapToTest(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new TestTaker());
        frame.setVisible(true);
        frame.validate();
    }
    public static void swapToTestResults(ArrayList<TestGenerator.TestQuestion> q,
    ArrayList<Boolean> a){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new TestResults(q, a));
        frame.setVisible(true);
        frame.validate();
    }
    public static void swapToTestSelector(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new TestSelectorScreen());
        frame.setVisible(true);
        frame.validate();
    }
    
    static Screen screen = Screen.MENU;
//    StringBuffer strBuffer;
    static JFrame frame = new JFrame("Boolean Teacher");
    static JButton button = new JButton("option");
//    static WelcomeWindow welcomeWin = new WelcomeWindow();
//    static Menu menu = new Menu();
    static TestTaker testWin = new TestTaker();
    //static WelcomeWindow menu = new WelcomeWindow();

//    static File setupFolder = null;
//    static JButton settingButton = new JButton();
//    static LessonButton lessonButton = new LessonButton();
    public static void main(String[] args) throws IOException {
//        while(frame.is)
        frame.setSize(720,480);
        frame.setMaximumSize(new Dimension(720,480));
        frame.setMinimumSize(new Dimension(720,480));
//        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String name = "";
        try{
            FileHandler.initialize();
//            name = FileHandler.initialize(); 
//            System.out.println(name);
            if(name.equals("")){
            frame.getContentPane().add(new WelcomeWindow());
            frame.setVisible(true);
            frame.validate();
        }
        else
        {
            frame.getContentPane().add(new Menu());
            frame.setVisible(true);
            frame.validate();
        }
        }
        finally{
            name = "";
        }
        /*
//        if(name.equals("")){
//            frame.getContentPane().add(new WelcomeWindow());
//            frame.setVisible(true);
//            frame.validate();
//        }
//        else
//        {
//            frame.getContentPane().add(new Menu());
//            frame.setVisible(true);
//            frame.validate();
//        }
//
//        /* step 2 
//        MainMenu menu = new MainMenu();
//        MenuButtons panel = new MenuButtons();
//
//        frame.setContentPane(menu);
//        frame.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.weightx = 1;
//        gbc.weighty = 1;
//        gbc.anchor = GridBagConstraints.SOUTHEAST;
//        gbc.insets = new Insets(30, 30, 30, 30);
//        panel.setOpaque(true);
//
////        menu.set
//        /* step 3
////        JButton button = new JButton("Submit");
////        panel.add(button);
////
////        JTextField txtnum1 = new JTextField();
////        txtnum1.setPreferredSize(new Dimension(30, 50));
////        panel.add(txtnum1);
////
////        JButton button2 = new JButton("Clear");
////        panel.add(button2);
//
////        menu.add(panel);
//        /* step 4 
//
//        frame.add(panel, gbc);
////        frame.getContentPane().add(panel);
//
//        /* step 5 
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        panel.setVisible(true);
//        frame.validate();
//        GridBagLayout gbl = new GridBagLayout();
//        GridBagConstraints gbc = new GridBagConstraints();

//        setIcon();
////        frame.setLayout(gbl);
//        frame.setSize(720,480);
//        frame.setMaximumSize(new Dimension(720,480));
//        frame.setMinimumSize(new Dimension(720,480));
//        JFrame.setDefaultLookAndFeelDecorated(true);
////        frame.getContentPane().add(button);
//        try{
//            //setupFolder = new File(new URL(""))
//        }
//        finally {
//
//        }
//        frame.getContentPane().add(menu);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setVisible(true);
//
//        JButton button = new JButton("Submit");
//        menu.add(button);
//        frame.getContentPane().paint(frame.getGraphics());
//        frame.setVisible(true);
//        frame.revalidate();
//        frame.repaint();






//        try {
//            Image img = ImageIO.read(new File("src/assets/Settings Button.png"));
//            settingButton.setIcon(new ImageIcon(img));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        settingButton.setMargin(new Insets(0, 0, 0, 0));
//        settingButton.setBorder(null);
//        settingButton.setBackground(Color.white);

//        JFrame.setDefaultLookAndFeelDecorated(true);

//        menu.add(button);
//        button.setPreferredSize(new Dimension(60,60));
//        //frame.getContentPane().add(button);
//        button.setVisible(true);
//frame.pack();
*/
    }
    public void ChangePanel_MainMenu(){

    }
    public void ChangePanel_Test(){

    }
    public void ChangePanel_Lesson(){

    }
    public void ChangePanel_Homework(){

    }

//    public static boolean hasAUser(){
//        return setupFolder != null;
//    }
    public static void setIcon(){
        try{
            frame.setIconImage(ImageIO.read(new File("src/assets/appIcon.jpg")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
//    public void start() {
//        addItem("starting the applet ");
//    }
//
//    public void stop() {
//        addItem("stopping the applet ");
//    }
//
//    public void destroy() {
//        addItem("unloading the applet");
//    }
//
//    void addItem(String word) {
//        System.out.println(word);
//        strBuffer.append(word);
//        repaint();
//    }
//
//    public void paint(Graphics g) {
//        // Draw a Rectangle around the applet's display area.
//        g.drawRect(0, 0,
//                getWidth() - 1,
//                getHeight() - 1);
//
//        // display the string inside the rectangle.
//        g.drawString(strBuffer.toString(), 10, 20);
//    }
//
//
//    public void mouseEntered(MouseEvent event) {
//    }
//    public void mouseExited(MouseEvent event) {
//    }
//    public void mousePressed(MouseEvent event) {
//    }
//    public void mouseReleased(MouseEvent event) {
//    }
//    public void mouseClicked(MouseEvent event) {
//        addItem("mouse clicked! ");
//    }


}
