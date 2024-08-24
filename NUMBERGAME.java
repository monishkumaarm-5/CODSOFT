import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NUMBERGAME {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel scoreLabel = new JLabel("Score: 0");
    JLabel guessedNumberLabel = new JLabel("Enter the Guessing Number:");
    JTextField answerField = new JTextField("");
    Random random = new Random();
    JButton submitButton = new JButton("Submit");
    int randomNumber;
    int score = 0;
    int rounds = 3; 
    int attempts = 3;

    public NUMBERGAME() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        panel.setLayout(null);

        randomNumber = random.nextInt(100) + 1;
        System.out.println(randomNumber);
        scoreLabel.setBounds(375, 25, 100, 50);
        panel.add(scoreLabel);
        guessedNumberLabel.setBounds(50, 100, 200, 25);
        panel.add(guessedNumberLabel);
        answerField.setBounds(250, 100, 200, 25);
        panel.add(answerField);
        submitButton.setBounds(200, 200, 100, 25);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int guessedNumber = Integer.parseInt(answerField.getText());
                    if (guessedNumber == randomNumber) {
                        JOptionPane.showMessageDialog(frame, "Congrats, you guessed the number!");
                        score++;
                        scoreLabel.setText("Score: " + score);
                        randomNumber = random.nextInt(100) + 1;
                        System.out.println(randomNumber);
                    } else {
                        attempts--;
                        if (attempts > 0) {
                            JOptionPane.showMessageDialog(frame, "Incorrect, try again. Chances left: " + attempts);
                        } else {
                            JOptionPane.showMessageDialog(frame, "No attempts left! The correct number was " + randomNumber);
                            JOptionPane.showMessageDialog(frame, "Final Score is: " + score);
                            newGame();
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void newGame() {
        attempts = 3;
        score = 0;
        scoreLabel.setText("Score: " + score);
        randomNumber = random.nextInt(100) + 1;
        answerField.setText("");
    }

    public static void main(String[] args) {
        new NUMBERGAME();
    }
}
