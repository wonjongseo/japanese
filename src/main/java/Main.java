import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        LevelButtonListener levelButtonListener = new LevelButtonListener();

        Main main = new Main();

        JFrame jFrame = main.createFrame(400, 800);

        JLabel title = new JLabel("title");
        title.setBounds(100,30,100,20);
        jFrame.add(title);

        main.setLevelButton(jFrame,levelButtonListener);


    }

    public void setLevelButton(JFrame jFrame, LevelButtonListener levelButtonListener) {

        JButton levelOneButton = new JButton("One");
        JButton levelTwoButton = new JButton("Two");
        JButton levelThreeButton = new JButton("Three");
        JButton levelFourButton = new JButton("Four");
        JButton levelFiveButton = new JButton("Five");

        levelOneButton.setBounds(130, 100, 100, 40);
        jFrame.add(levelOneButton);
        levelOneButton.addActionListener(levelButtonListener);

        levelTwoButton.setBounds(130, 200, 100, 40);
        jFrame.add(levelTwoButton);
        levelTwoButton.addActionListener(levelButtonListener);

        levelThreeButton.setBounds(130, 300, 100, 40);
        jFrame.add(levelThreeButton);
        levelThreeButton.addActionListener(levelButtonListener);

        levelFourButton.setBounds(130, 400, 100, 40);
        jFrame.add(levelFourButton);
        levelFourButton.addActionListener(levelButtonListener);

        levelFiveButton.setBounds(130, 500, 100, 40);
        jFrame.add(levelFiveButton);
        levelFiveButton.addActionListener(levelButtonListener);

    }
    public JFrame createFrame(int width, int height) {
        JFrame jFrame = new JFrame();

        jFrame.setSize(width, height);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

        return jFrame;
    }
}
