import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

public class LevelButtonListener implements ActionListener {

    static Japanese japanese;

    static {
        try {
            japanese = Parser.parseWord();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    ;
    @Override
    public void actionPerformed(ActionEvent e) {


        int randomIndex = (int) (Math.random() * (japanese.getTotalCount() - 1));


        Main main = new Main();


        if (e.getActionCommand() == "One") {


            JFrame subFrame = main.createFrame(200, 120);
            JLabel question = new JLabel();
            question.setText(japanese.getWord().get(randomIndex));
            question.setBounds(30,30,80,20);

            subFrame.add(question);


            JTextField answer = new JTextField();
            answer.setBounds(80, 23, 100, 20);

            JButton button = new JButton("send");
            button.setBounds(80, 43, 100, 20);
            subFrame.add(button);
            subFrame.add(answer);

            button.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (japanese.getMeans().get(randomIndex).equals(answer.getText())) {
                                JOptionPane.showMessageDialog(subFrame, "Correct!");
                            }
                            else{
                                JOptionPane.showMessageDialog(subFrame,"InCorrect!");
                            }
                        }
                    }
            );

        }

        if (e.getActionCommand() == "Two") {
            main.createFrame(300, 300);
        }
    }
}
