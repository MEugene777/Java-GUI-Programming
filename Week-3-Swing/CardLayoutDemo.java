
import javax.swing.*;
import java.awt.*;

public class CardLayoutDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CardLayout Demo");

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel firstCard = new JPanel();
        firstCard.add(new JLabel("Welcome to the First Screen"));

        JPanel secondCard = new JPanel();
        secondCard.add(new JLabel("Welcome to the Second Screen"));

        mainPanel.add(firstCard, "First");
        mainPanel.add(secondCard, "Second");

        JButton nextButton = new JButton("Next");
        JButton previousButton = new JButton("Previous");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);

        nextButton.addActionListener(e ->
            cardLayout.show(mainPanel, "Second")
        );

        previousButton.addActionListener(e ->
            cardLayout.show(mainPanel, "First")
        );

        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
