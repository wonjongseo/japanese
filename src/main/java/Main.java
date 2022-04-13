import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main {
    public static String path;
    public  static  JFrame mainFrame = createFrame(380, 500, "JLPT");
    public static void main(String[] args) {

    // /Users/wonjongseo/aStudy/coding/pythonProject
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        Main main = new Main();


        path = JOptionPane.showInputDialog(mainFrame,"Input Excel file path");
        if ( path == null) {
            path = System.getProperty("user.dir");
        }

        JLabel title = new JLabel("Select JLPT Level");
        title.setBounds(130, 50, 300, 40);
        mainFrame.add(title);

        main.setLevelButton(mainFrame, new LevelButtonListener());


    }

    public void setLevelButton(JFrame jFrame, LevelButtonListener levelButtonListener) {

        JButton levelOneButton = new JButton("One");
        JButton levelTwoButton = new JButton("Two");
        JButton levelThreeButton = new JButton("Three");
        JButton levelFourButton = new JButton("Four");
        JButton levelFiveButton = new JButton("Five");
        JButton exitButton = new JButton("Exit");

        levelOneButton.setBounds(130, 100, 100, 40);
        jFrame.add(levelOneButton);
        levelOneButton.addActionListener(levelButtonListener);

        levelTwoButton.setBounds(130, 150, 100, 40);
        jFrame.add(levelTwoButton);
        levelTwoButton.addActionListener(levelButtonListener);

        levelThreeButton.setBounds(130, 200, 100, 40);
        jFrame.add(levelThreeButton);
        levelThreeButton.addActionListener(levelButtonListener);

        levelFourButton.setBounds(130, 250, 100, 40);
        jFrame.add(levelFourButton);
        levelFourButton.addActionListener(levelButtonListener);

        levelFiveButton.setBounds(130, 300, 100, 40);
        jFrame.add(levelFiveButton);
        levelFiveButton.addActionListener(levelButtonListener);

        exitButton.setBounds(130, 350, 100, 40);
        jFrame.add(exitButton);
        exitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(jFrame, "Should you really exit ?!");

                        switch (result) {
                            case 0:
                                System.exit(0);
                                break;
                            case 1:
                            case 2:
                                JOptionPane.showMessageDialog(jFrame, "You have a good choice!!");
                                break;

                        }
                    }
                }
        );

    }

    static public JFrame createFrame(int width, int height,String level) {

        JFrame jFrame = new JFrame("JLPT level " + level);

        jFrame.setSize(width, height);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);

        return jFrame;
    }
}
