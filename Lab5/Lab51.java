import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab51 {
    public static void main(String[] args) {
        CConverter c1 = new CConverter();
    }
}

class CConverter extends JFrame {
    CConverter() {
        super("Cobalt Half-life Calculator");
        GUIBuilder();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(340, 200);

        setVisible(true);

    }

    public void GUIBuilder() {

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        Container c = getContentPane();

        c.setLayout(gbl);

        JTextField input1 = new JTextField(5);
        JTextField input2 = new JTextField(5);
        JLabel l1 = new JLabel("Amount of Cobalt: ");
        JLabel l2 = new JLabel("Number of Years: ");
        JLabel l3 = new JLabel("Remaining Amount: ");
        JButton quit = new JButton("Quit");
        JButton compute = new JButton("Calculate");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(7, 2, 7, 2);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        c.add(l1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        c.add(input1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        c.add(l2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        c.add(input2, gbc);

        // gbc.fill=GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        c.add(l3, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        c.add(compute, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        c.add(quit, gbc);

        UserInput userAmount = new UserInput(input1, input2, l3);
        // UserInput userYears = new UserInput(input1, input2, l3);
        ExitButton quitter = new ExitButton();
        quit.addActionListener(quitter);
        compute.addActionListener(userAmount);
        // compute.addActionListener(userYears);
        input1.addActionListener(userAmount);
        // input2.addActionListener(userYears);
    }

}

class UserInput implements ActionListener {
    private JTextField in;
    private JTextField in2;
    private JLabel out;

    UserInput(JTextField in, JTextField in2, JLabel out) {
        this.in = in;
        this.in2 = in2;
        this.out = out;

    }

    public void actionPerformed(ActionEvent e) {
        double amount = (double) Double.parseDouble(in.getText());
        double years = (double) Double.parseDouble(in2.getText());
        double atomRemains = amount;
        if (amount > 0 && years > 0) {
            int a = 0;
            while (a < years) {
                atomRemains = atomRemains - (atomRemains * 0.12);
                a++;
            }
            if (atomRemains > 0) {

                this.out.setText("Remaining Amount: " + atomRemains);
            }

        } else
            this.out.setText("Input Error !");
    }
}

class ExitButton implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
