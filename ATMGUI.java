import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BAcc {
    private double bal;

    public BAcc(double initBal) {
        this.bal = initBal;
    }

    public double getBal() {
        return bal;
    }

    public void dep(double amt) {
        bal += amt;
    }

    public boolean with(double amt) {
        if (amt <= bal) {
            bal -= amt;
            return true;
        } else {
            return false; 
        }
    }
}

class ATM {
    private BAcc acc;

    public ATM(BAcc acc) {
        this.acc = acc;
    }

    public boolean with(double amt) {
        return acc.with(amt);
    }

    public void dep(double amt) {
        acc.dep(amt);
    }

    public double checkBal() {
        return acc.getBal();
    }
}

public class ATMGUI {
    private ATM atm;

    public ATMGUI(ATM atm) {
        this.atm = atm;

        JFrame frame = new JFrame("ATM Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton withBtn = new JButton("Withdraw");
        withBtn.setBounds(350,300,100,25);
        JButton depBtn = new JButton("Deposit");
        depBtn.setBounds(350,400,100,25);
        JButton balBtn = new JButton("Check Balance");
        balBtn.setBounds(350,500,100,25);

        JLabel resLbl = new JLabel("");
        resLbl.setBounds(350,600,300,25);
        JLabel atmlabel = new JLabel("ATM");
        atmlabel.setBounds(350,200,100,25);
        Font font = new Font("TIMES NEW ROMAN", Font.BOLD, 24);
        atmlabel.setFont(font);

        panel.add(withBtn);
        panel.add(depBtn);
        panel.add(balBtn);
        panel.add(resLbl);
        panel.add(atmlabel); 

        withBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amtStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                try {
                    double amt = Double.parseDouble(amtStr);
                    boolean success = atm.with(amt);
                    if (success) {
                        resLbl.setText("Withdrawal successful. New balance: " + atm.checkBal());
                    } else {
                        resLbl.setText("Insufficient funds. Current balance: " + atm.checkBal());
                    }
                } catch (NumberFormatException ex) {
                    resLbl.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        depBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amtStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                try {
                    double amt = Double.parseDouble(amtStr);
                    atm.dep(amt);
                    resLbl.setText("Deposit successful. New balance: " + atm.checkBal());
                } catch (NumberFormatException ex) {
                    resLbl.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        balBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resLbl.setText("Current balance: " + atm.checkBal());
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        BAcc acc = new BAcc(1000); 
        ATM atm = new ATM(acc);
        new ATMGUI(atm);
    }
}
