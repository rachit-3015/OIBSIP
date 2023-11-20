import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class GuessingGameByRachit {

    static JFrame gameFrame = new JFrame();
    int targetNumber;
    int remainingAttempts;
    int currentRound;
    Map<Integer, Integer> scoreSheet;

    public GuessingGameByRachit() {
        targetNumber = 0;
        remainingAttempts = 0;
        currentRound = 1;
        scoreSheet = new HashMap<>();
    }

    public static void main(String[] args) {
        GuessingGameByRachit guessingGameByRachit = new GuessingGameByRachit();
        setUIStyle();

        while (true) {
            try {
                String input = JOptionPane.showInputDialog(gameFrame,
                "This is a Number Guessing Game. It is Task-2 for Java Development Intern under surveillance of Oasis Infobyte.\nCheck out the task.\n\nPress\n1. Start The Game\n2. Will Play It Later\n\n");
                if (input == null) {
                    guessingGameByRachit.exitGame();
                }
                int play = Integer.parseInt(input);

                switch (play) {
                    case 1:
                        JOptionPane.showMessageDialog(gameFrame,
                                "A number will have been chosen which will be ranging from 0 to upperbound entered by you.\nYou will have to choose a number. You will be give 10 chances to guess it.\nOtherwise, You will lose the game.\n\n");
                        guessingGameByRachit.initializeTargetNumber();
                        guessingGameByRachit.playGameByRachit();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(gameFrame, "Oh, That's Too Bad. See You Later Then!!");
                        guessingGameByRachit.exitGame();
                        break;
                    default:
                        throw new InputMismatchException("Invalid Choice!! Please Try Again!");
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(gameFrame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void setUIStyle() {
        gameFrame.setSize(1000, 500);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().setBackground(new Color(255, 255, 153));
        gameFrame.setLayout(new BoxLayout(gameFrame.getContentPane(), BoxLayout.Y_AXIS));

        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 20));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 20));
        
        UIManager.put("OptionPane.background", new Color(255, 255, 153));
        UIManager.put("Button.background", new Color(255, 165, 0));
    }

    public void playGameByRachit() {
        remainingAttempts = 10;
        while (remainingAttempts > 3) {
            String input = JOptionPane.showInputDialog(gameFrame, "Enter your guess");
            if (input == null) {
                exitGame();
            }
            int num = Integer.parseInt(input);
            if (num == targetNumber) {
                JOptionPane.showMessageDialog(gameFrame, "CONGRATS!! You Guessed it correct", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                scoreSheet.put(currentRound, remainingAttempts);
                break;
            }
            if (num > targetNumber) {
                JOptionPane.showMessageDialog(gameFrame, "Guess Below", "Hint", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(gameFrame, "Guess Above", "Hint", JOptionPane.INFORMATION_MESSAGE);
            }
            remainingAttempts--;
        }
        if (remainingAttempts == 3) {
            JOptionPane.showMessageDialog(gameFrame, "Your turns are exhausted", "Unfortunately , Your game is over", JOptionPane.INFORMATION_MESSAGE);
            scoreSheet.put(currentRound, 0);
        }
        currentRound++;
        gameMenu();
    }

    public void gameMenu() {
        try {
            String input = JOptionPane.showInputDialog(gameFrame,
                    "Nominate Your Choice.\n\n1. Play Again\n2. View Scoreboard\n3. Exit");
            int option = Integer.parseInt(input);
            switch (option) {
                case 1:
                    initializeTargetNumber();
                    playGameByRachit();
                    break;
                case 2:
                    viewScoreSheet();
                    gameMenu();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(gameFrame, "Thank You For Using Our Product", "See You Soon", JOptionPane.INFORMATION_MESSAGE);
                    exitGame();
                default:
                    throw new InputMismatchException("Invalid Choice!");
            }
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(gameFrame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            gameMenu();
        }
    }

    public void initializeTargetNumber() {
        String input = JOptionPane.showInputDialog(gameFrame,
                "Enter the upperbound to chase a number (from 1 to X)");
        if (input == null) {
            exitGame();
        }
        int range = Integer.parseInt(input);
        Random generator = new Random();
        targetNumber = generator.nextInt(range) + 1;
    }

    public void viewScoreSheet() {
        StringBuilder scores = new StringBuilder();
        scoreSheet.forEach((k, v) -> scores.append("Round " + k + ": Score " + v + "\n"));
        JOptionPane.showMessageDialog(gameFrame, "Scoreboard:\n" + scores.toString(), "Scoreboard", JOptionPane.PLAIN_MESSAGE);
    }

    public void exitGame() {
        System.exit(0);
    }
}



// line 135 error --> now removed