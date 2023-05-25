import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class GuessTheNumber extends JFrame implements ActionListener {

    static int guess = (int)(Math.random()*100);
    static Scanner sc = new Scanner(System.in);
    JLabel number;
    JLabel message = new JLabel();
    JTextField num;
    JButton submit;
    GuessTheNumber(){

        number = new JLabel("Enter your guessed number");
        number.setBounds(30,50,400,30);
        add(number);

        num = new JTextField();
        num.setBounds(250,50,100,30);
        add(num);

        message.setBounds(30,100,250,30);
        add(message);

        submit = new JButton("Submit");
        submit.setBounds(150,150,100,30);
        submit.addActionListener(this);
        add(submit);

        setBounds(250,150,400,250);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,"Guess the number between 1 - 100");
        JOptionPane.showMessageDialog(null,"To exit the game enter -1");


        new GuessTheNumber();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            String n = num.getText();
            String ans = check(Integer.valueOf(n));
            if (ans.equals("Congratulations! You have guessed the number right")) {
                message.setText("Congratulations!!");
                JOptionPane.showMessageDialog(null, "Congratulations! You have guessed the number right");
                System.exit(0);
            }
            else if (ans.equals("You have exited from the game") || ans.equals("Thank you for playing the game")) {
                JOptionPane.showMessageDialog(null, "You have exited from the game");
                System.exit(0);
            } 
            else {
                message.setText(ans);
                num.setText("");
            }
        }
    }
    public static String check(int n){
        while (n != -1){


            if(n == guess)
            {
                return ("Congratulations! You have guessed the number right");

            } else if (n > guess) {
                return("Your guess is greater than the number");
            }
            else if(n < guess && n!=-1){
                return("Your guess is less than the number");
            } else if (n == -1) {
                return("You have exited from the game");
            }
        }
        return ("Thank you for playing the game");

    }
}
