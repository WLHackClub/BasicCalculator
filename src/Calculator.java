import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator implements ActionListener {

    JFrame calculator;
    JTextField l;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, bc, beq;

    public void createAndShowGUI() {
        // create the main frame
        calculator = new JFrame("Calculator");
        calculator.setLayout(new FlowLayout());
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a text field and add action listeners
        l = new JTextField(16);

        // create number buttons
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

        // create a panels
        JPanel o = new JPanel();
        JPanel p = new JPanel();
        // makes a 4x4 grid
        p.setLayout(new GridLayout(4,4));
        JPanel e = new JPanel();

        // add components to panels
        o.add(l);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(bc);
        e.add(beq);

        // set background of panels
        p.setBackground(Color.blue);
        o.setBackground(Color.blue);
        e.setBackground(Color.blue);

        // add panels to frame
        calculator.add(o);
        calculator.add(p);
        calculator.add(e);

        // set visibility of frame
        calculator.setSize(300, 250);
        calculator.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        // actions for number buttons
        try {
            if (e.getSource() == b0) {
                l.setText(l.getText() + "0");
            } else if (e.getSource() == b1) {
                l.setText(l.getText() + "1");
            } else if (e.getSource() == b2) {
                l.setText(l.getText() + "2");
            } else if (e.getSource() == b3) {
                l.setText(l.getText() + "3");
            } else if (e.getSource() == b4) {
                l.setText(l.getText() + "4");
            } else if (e.getSource() == b5) {
                l.setText(l.getText() + "5");
            } else if (e.getSource() == b6) {
                l.setText(l.getText() + "6");
            } else if (e.getSource() == b7) {
                l.setText(l.getText() + "7");
            } else if (e.getSource() == b8) {
                l.setText(l.getText() + "8");
            } else if (e.getSource() == b9) {
                l.setText(l.getText() + "9");
            }
            // actions for operator buttons
            // adding
            else if (e.getSource() == ba) {
                l.setText(l.getText() + "+");
            }
            // dividing
            else if (e.getSource() == bd) {
                l.setText(l.getText() + "/");
            }
            // multiplying
            else if (e.getSource() == bm) {
                l.setText(l.getText() + "*");
            }
            // subtracting
            else if (e.getSource() == bs) {
                l.setText(l.getText() + "-");
            }

            // action for . button
            else if (e.getSource() == be) {
                l.setText(l.getText() + ".");
            }

            // action for clear button
            else if (e.getSource() == bc) {
                l.setText("");
            }

            // action for equals button
            else if (e.getSource() == beq) {
                String text = l.getText();
                // if adding
                if (text.contains("+")) {
                    String[] numbers = text.split("\\+");
                    double sum = 0;
                    for (String number : numbers) {
                        sum += Double.parseDouble(number);
                    }
                    l.setText(Double.toString(sum));
                }
                // if multiplying
                else if (text.contains("*")) {
                    String[] numbers = text.split("\\*");
                    double prod = 1;
                    for (String number : numbers) {
                        prod *= Double.parseDouble(number);
                    }
                    l.setText(Double.toString(prod));
                }
                // if dividing
                else if (text.contains("/")) {
                    String[] numbers = text.split("/");
                    double quo = Double.parseDouble(numbers[0]);
                    for (int i = 1; i < numbers.length; i++) {
                        quo /= Double.parseDouble(numbers[i]);
                    }
                    l.setText(Double.toString(quo));
                }
                // if subtracting
                else if (text.contains("-")) {
                    if (text.charAt(0) == '-') {
                        String[] numbers = text.substring(1).split("-");
                        double diff = Double.parseDouble("-" + numbers[0]);
                        for (int i = 1; i < numbers.length; i++) {
                            diff -= Double.parseDouble(numbers[i]);
                        }
                        l.setText(Double.toString(diff));
                    } else {
                        String[] numbers = text.split("-");
                        double diff = Double.parseDouble(numbers[0]);
                        for (int i = 1; i < numbers.length; i++) {
                            diff -= Double.parseDouble(numbers[i]);
                        }
                        l.setText(Double.toString(diff));
                    }
                }
            }

        } catch (Exception ex) {
            l.setText("Error");
        }
    }

    public static void main(String[] args) {
        // create a new calculator object and call the createAndShowGUI method
        Calculator c = new Calculator();
        c.createAndShowGUI();
    }
}