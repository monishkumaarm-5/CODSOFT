import javax.swing.*;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.*;

public class CGPA_CALCULATOR
{
    private JFrame frame = new JFrame("CGPA_CALCULATOR");
    private JPanel valuepanel = new JPanel();
    private JPanel resultpanel = new JPanel();
    private JButton submitButton= new JButton("SUBMIT->");
    private JLabel sub1Label,sub2Label,sub3Label,sub4Label,sub5Label;
    private JTextField sub1,sub2,sub3,sub4,sub5;
    CGPA_CALCULATOR()
    {
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        valuepanel.setLayout(null);
        valuepanel.setBackground(Color.lightGray);
        

        sub1Label = new JLabel("SUBJECT 1:");
        sub2Label = new JLabel("SUBJECT 2:");
        sub3Label = new JLabel("SUBJECT 3:");
        sub4Label = new JLabel("SUBJECT 4:");
        sub5Label = new JLabel("SUBJECT 5:");

        sub1 = new JTextField("  ");
        sub2 = new JTextField("  ");
        sub3 = new JTextField("  ");
        sub4 = new JTextField("  ");
        sub5 = new JTextField("  ");

        sub1Label.setBounds(100,100,200,30);
        sub1.setBounds(400,100,200,30);
        valuepanel.add(sub1);
        valuepanel.add(sub1Label);

        sub2Label.setBounds(100,200,200,30);
        sub2.setBounds(400,200,200,30);
        valuepanel.add(sub2);
        valuepanel.add(sub2Label);
        
        sub3Label.setBounds(100,300,200,30);
        sub3.setBounds(400,300,200,30);
        valuepanel.add(sub3);
        valuepanel.add(sub3Label);
     

        sub4Label.setBounds(100,400,200,30);
        sub4.setBounds(400,400,200,30);
        valuepanel.add(sub4);
        valuepanel.add(sub4Label);
        

        sub5Label.setBounds(100,500,200,30);
        sub5.setBounds(400,500,200,30);
        valuepanel.add(sub5);
        valuepanel.add(sub5Label);

        submitButton.setBounds(300,600,100,30);
        valuepanel.add(submitButton);
        submitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.remove(valuepanel);
                frame.repaint();
                frame.revalidate();
                resultpanel();
            }

        }
        );

        frame.add(valuepanel);
        frame.setVisible(true);
        

    }
    void resultpanel()
    {
        resultpanel.setLayout(null);
        resultpanel.setBackground(Color.lightGray);
        
        frame.add(resultpanel);
        frame.setVisible(true);

        int subject1 = Integer.parseInt(sub1.getText().trim());
        int subject2 = Integer.parseInt(sub2.getText().trim());
        int subject3 = Integer.parseInt(sub3.getText().trim());
        int subject4 = Integer.parseInt(sub4.getText().trim());
        int subject5 = Integer.parseInt(sub5.getText().trim());

        int Total = subject1+subject2+subject3+subject4+subject5;
        int Average = Total/5;

        String Grade; 
        if (Average > 90)
        {
            Grade ="O";
        }
        else if(Average > 80)
        {
            Grade ="A+";
        }
        else if(Average >70)
        {
            Grade="A";
        }
        else if(Average >60)
        {
            Grade="B+";
        }
        else if(Average>50)
        {
            Grade="B";
        }
        else
        {
            Grade="U";
        }

        Font font1 = new Font("TIMES NEW ROMAN",Font.BOLD, 32); 
        JLabel gradeLabel = new JLabel("Grade: " + Grade);
        gradeLabel.setFont(font1);
        gradeLabel.setBounds(300, 300, 200, 30);
        resultpanel.add(gradeLabel);

        JLabel PercentageLabel = new JLabel("Percentage" + Average);
        PercentageLabel.setFont(font1);
        PercentageLabel.setBounds(300, 400, 200, 30);
        resultpanel.add(PercentageLabel);

     

    }
    public static void main(String args[])
        {
            CGPA_CALCULATOR a = new CGPA_CALCULATOR();

        }
}