import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LevelButtonListener implements ActionListener {

    public static int randomIndex =  0;


    @Override
    public void actionPerformed(ActionEvent e) {


        Main main = new Main();

        if (e.getActionCommand().equals("One")) {
            showJapanVoca(main, ExcelParser.japanese_level1, "1");
        }
        if (e.getActionCommand().equals("Two")) {
            showJapanVoca(main, ExcelParser.japanese_level2,"2");
        }

        if (e.getActionCommand().equals("Three")) {

            showJapanVoca(main, ExcelParser.japanese_level3, "3");
        }
        if (e.getActionCommand().equals("Four")) {
            showJapanVoca(main, ExcelParser.japanese_level4,"4");
        }
        if (e.getActionCommand().equals("Five")) {
            showJapanVoca(main, ExcelParser.japanese_level5,"5");
        }
    }

    public void showJapanVoca(Main main, Japanese japanese, String level) {

        randomIndex = (int) (Math.random() * (japanese.getTotalCount() - 1));

        JFrame subFrame = main.createFrame(500, 200,level);

        JLabel labelKanji = new JLabel();

        if (japanese.getKanji().get(randomIndex).equals("")) {
            labelKanji.setText(japanese.getHiragana().get(randomIndex));
        }else
            labelKanji.setText(japanese.getKanji().get(randomIndex));

        labelKanji.setBounds(80, 20, 300, 20);

        JLabel labelHiragana = new JLabel();
        labelHiragana.setBounds(80, 43, 400, 20);

        JButton buttonHiragana = new JButton("hiragana");
        buttonHiragana.setBounds(80, 43, 100, 20);

        JLabel labelMeans = new JLabel();
        labelMeans.setBounds(80, 63, 1000, 20);
        JButton buttonMeans = new JButton("means");
        buttonMeans.setBounds(80, 63, 100, 20);


        JButton buttonNext = new JButton("next");
        buttonNext.setBounds(80, 83, 100, 20);

        subFrame.add(labelHiragana);
        subFrame.add(labelKanji);
        subFrame.add(buttonHiragana);
        subFrame.add(buttonMeans);
        subFrame.add(labelMeans);
        subFrame.add(buttonNext);

        buttonHiragana.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        labelHiragana.setText(japanese.getHiragana().get(randomIndex));
                        buttonHiragana.setVisible(false);
                    }
                }
        );

        buttonMeans.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        labelMeans.setText(japanese.getMeans().get(randomIndex));
                        buttonMeans.setVisible(false);
                    }
                }
        );
        buttonNext.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        randomIndex = (int) (Math.random() * (japanese.getTotalCount() - 1));
                        labelHiragana.setText("");
                        labelMeans.setText("");


                        if (japanese.getKanji().get(randomIndex).equals("")) {
                            labelKanji.setText(japanese.getHiragana().get(randomIndex));
                        }else
                            labelKanji.setText(japanese.getKanji().get(randomIndex));

                        buttonMeans.setVisible(true);
                        buttonHiragana.setVisible(true);
                    }
                }
        );

    }


}
