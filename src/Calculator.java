import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator implements ActionListener {

    JFrame calculator;
    JTextField text;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, bc, beq;

    public void createAndShowGUI() {
        // create the main frame
        calculator = new JFrame("Calculator");
        calculator.setLayout(new FlowLayout());
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a text field
        text = new JTextField(16);
        text.setEditable(false);

        // create number buttons and add action listeners
        b0 = new JButton("0");
        b0.addActionListener(this);

        b1 = new JButton("1");
        b1.addActionListener(this);

        b2 = new JButton("2");
        b2.addActionListener(this);

        b3 = new JButton("3");
        b3.addActionListener(this);

        b4 = new JButton("4");
        b4.addActionListener(this);

        b5 = new JButton("5");
        b5.addActionListener(this);

        b6 = new JButton("6");
        b6.addActionListener(this);

        b7 = new JButton("7");
        b7.addActionListener(this);

        b8 = new JButton("8");
        b8.addActionListener(this);

        b9 = new JButton("9");
        b9.addActionListener(this);

        // equals button
        beq = new JButton("=");
        beq.addActionListener(this);

        // create operator buttons
        ba = new JButton("+");
        ba.addActionListener(this);

        bs = new JButton("-");
        bs.addActionListener(this);

        bd = new JButton("/");
        bd.addActionListener(this);

        bm = new JButton("*");
        bm.addActionListener(this);

        bc = new JButton("C");
        bc.addActionListener(this);

        // create . button
        be = new JButton(".");
        be.addActionListener(this);

        // create panels
        JPanel textPanel = new JPanel();
        JPanel buttons = new JPanel();
        // makes a 4x4 grid
        buttons.setLayout(new GridLayout(4, 4));
        JPanel equals = new JPanel();

        // add components to panels
        textPanel.add(text);
        buttons.add(ba);
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(bs);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(bm);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);
        buttons.add(bd);
        buttons.add(be);
        buttons.add(b0);
        buttons.add(bc);
        equals.add(beq);

        // set background of panels
        buttons.setBackground(Color.blue);
        textPanel.setBackground(Color.blue);
        equals.setBackground(Color.blue);

        // add panels to frame
        calculator.add(textPanel);
        calculator.add(buttons);
        calculator.add(equals);

        // set visibility of frame
        calculator.setSize(300, 250);
        calculator.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // actions for number buttons
        try {
            if (e.getSource() == b0) {
                text.setText(text.getText() + "0");
            } else if (e.getSource() == b1) {
                text.setText(text.getText() + "1");
            } else if (e.getSource() == b2) {
                text.setText(text.getText() + "2");
            } else if (e.getSource() == b3) {
                text.setText(text.getText() + "3");
            } else if (e.getSource() == b4) {
                text.setText(text.getText() + "4");
            } else if (e.getSource() == b5) {
                text.setText(text.getText() + "5");
            } else if (e.getSource() == b6) {
                text.setText(text.getText() + "6");
            } else if (e.getSource() == b7) {
                text.setText(text.getText() + "7");
            } else if (e.getSource() == b8) {
                text.setText(text.getText() + "8");
            } else if (e.getSource() == b9) {
                text.setText(text.getText() + "9");
            }
            // actions for operator buttons
            // adding
            else if (e.getSource() == ba) {
                text.setText(text.getText() + "+");
            }
            // dividing
            else if (e.getSource() == bd) {
                text.setText(text.getText() + "/");
            }
            // multiplying
            else if (e.getSource() == bm) {
                text.setText(text.getText() + "*");
            }
            // subtracting
            else if (e.getSource() == bs) {
                text.setText(text.getText() + "-");
            }

            // action for . button
            else if (e.getSource() == be) {
                text.setText(text.getText() + ".");
            }

            // action for clear button
            else if (e.getSource() == bc) {
                text.setText("");
            }

            // action for equals button
            else if (e.getSource() == beq) {
                String text = this.text.getText();
                // if adding
                if (text.contains("+")) {
                    String[] numbers = text.split("\\+");
                    double sum = 0;
                    for (String number : numbers) {
                        sum += Double.parseDouble(number);
                    }
                    this.text.setText(Double.toString(sum));
                }
                // if multiplying
                else if (text.contains("*")) {
                    String[] numbers = text.split("\\*");
                    double prod = 1;
                    for (String number : numbers) {
                        prod *= Double.parseDouble(number);
                    }
                    this.text.setText(Double.toString(prod));
                }
                // if dividing
                else if (text.contains("/")) {
                    String[] numbers = text.split("/");
                    double quo = Double.parseDouble(numbers[0]);
                    for (int i = 1; i < numbers.length; i++) {
                        quo /= Double.parseDouble(numbers[i]);
                    }
                    this.text.setText(Double.toString(quo));
                }
                // if subtracting
                else if (text.contains("-")) {
                    if (text.charAt(0) == '-') {
                        String[] numbers = text.substring(1).split("-");
                        double diff = Double.parseDouble("-" + numbers[0]);
                        for (int i = 1; i < numbers.length; i++) {
                            diff -= Double.parseDouble(numbers[i]);
                        }
                        this.text.setText(Double.toString(diff));
                    } else {
                        String[] numbers = text.split("-");
                        double diff = Double.parseDouble(numbers[0]);
                        for (int i = 1; i < numbers.length; i++) {
                            diff -= Double.parseDouble(numbers[i]);
                        }
                        this.text.setText(Double.toString(diff));
                    }
                }
            }

        } catch (Exception ex) {
            text.setText("Error");
        }
    }

    public static void main(String[] args) {
        // create a new calculator object and call the createAndShowGUI method

        Calculator c = new Calculator();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                c.createAndShowGUI();
            }
        });
    }
}