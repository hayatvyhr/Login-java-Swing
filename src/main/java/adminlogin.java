

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class adminlogin {
    private JTextField tfEmail;
    private JPasswordField jpAdmin;
    private JButton loginButton;
    private JPanel Panellogin;
    private JLabel emailj;
    private JLabel emailji;
    private JLabel test1;
    private JLabel label2;
    private JPanel panel2;
    private JFrame frame;

    public adminlogin (){
        frame = new JFrame("adminlogin");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 470));
        frame.setResizable(false);
        frame.add(Panellogin);

        frame.pack();
        frame.setLocationRelativeTo(null);



        // Initialize loginButton before setting the action listener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String motdepasse = String.valueOf(jpAdmin.getPassword());
                admin authenticatedAdmin = authenticateUser(email, motdepasse);
                if (authenticatedAdmin != null) {
                    JOptionPane.showMessageDialog(null, "Connexion réussie!");
                } else {
                    String errorMessage = "La connexion a échoué!";
                    if (!isValidEmail(email)) {
                        errorMessage = "Adresse e-mail incorrecte!";
                    }
                    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });


        frame.setVisible(true); // Don't set visible here, move it to the main method
    }

    private admin authenticateUser(String email, String motdepasse) {
        if (email.equals("admin@gmail.com") && motdepasse.equals("1234")) {
            return new admin(); // Just return a new instance directly
        } else {
            return null;
        }
    }

    private boolean isValidEmail(String email) {
        return email.contains("admin@gmail.com");
    }


    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new adminlogin();
            });
        }

}

