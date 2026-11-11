
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderEventDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Slider Event Demo");

        JLabel label = new JLabel("Volume: 50");

        JSlider slider = new JSlider(0, 100, 50);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {

                int value = slider.getValue();

                label.setText("Volume: " + value);
            }
        });

        frame.setLayout(new FlowLayout());

        frame.add(label);
        frame.add(slider);

        frame.setSize(450, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
