import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main {

    static String[] questions = {
            "What is a palindrome?",
            "What is a loop?",
            "What is an array?",
            "What is OOP?",
            "What is inheritance?",
            "What is polymorphism?",
            "What is recursion?",
            "Difference between while loop and for loop?",
            "What is encapsulation?",
            "What is a constructor in Java?"
    };

    static String[] panicMessages = {
            "Interviewer is judging silently...",
            "Confidence level dropping...",
            "HR is taking notes...",
            "Stay calm... maybe.",
            "Typing speed critical.",
            "Interviewer raised one eyebrow.",
            "Sweating level increased.",
            "Your future depends on this click.",
            "The interviewer asked: 'Are you confident?'",
            "Keyboard sounds intensify..."
    };

    static int score = 0;
    static int timeLeft = 10;
    static Timer timer;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Interview Panic Simulator");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // BLACK BACKGROUND
        frame.getContentPane().setBackground(Color.BLACK);

        JLabel title = new JLabel("Welcome to Interview Panic Simulator");

        // PINK TITLE
        title.setForeground(Color.PINK);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JButton startButton = new JButton("Start Interview");

        JLabel questionLabel = new JLabel("Click Start to begin");
        questionLabel.setForeground(Color.WHITE);

        JLabel panicLabel = new JLabel("");
        panicLabel.setForeground(Color.RED);

        JLabel timerLabel = new JLabel("Time Left: 10");
        timerLabel.setForeground(Color.CYAN);

        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.GREEN);

        JLabel resultLabel = new JLabel("");
        resultLabel.setForeground(Color.ORANGE);

        Random random = new Random();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int q = random.nextInt(questions.length);
                int p = random.nextInt(panicMessages.length);

                questionLabel.setText("Question: " + questions[q]);
                panicLabel.setText(panicMessages[p]);

                // INCREASE SCORE
                score += 10;
                scoreLabel.setText("Score: " + score);

                // RESET TIMER
                timeLeft = 10;
                timerLabel.setText("Time Left: " + timeLeft);

                if (timer != null) {
                    timer.stop();
                }

                // TIMER LOGIC
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        timeLeft--;

                        timerLabel.setText("Time Left: " + timeLeft);

                        if (timeLeft <= 0) {

                            timer.stop();

                            // RESULT MESSAGES
                            if (score >= 50) {

                                resultLabel.setText(
                                        "Result: Potential software engineer detected.");

                            } else if (score >= 30) {

                                resultLabel.setText(
                                        "Result: You survived the interview.");

                            } else {

                                resultLabel.setText(
                                        "Result: Needs more caffeine and recursion.");
                            }
                        }
                    }
                });

                timer.start();
            }
        });

        frame.add(title);
        frame.add(startButton);
        frame.add(questionLabel);
        frame.add(panicLabel);
        frame.add(timerLabel);
        frame.add(scoreLabel);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}