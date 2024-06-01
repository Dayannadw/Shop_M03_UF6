package views;

import java.awt.EventQueue;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Employee;
import exception.LimitLoginException;

public class LoginView extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JDialog insertWindow;
    JLabel lblNewLabel_1;
    private JButton btnNewButton;
    private JTextField textField;
    private JPasswordField passwordField;
    private JFrame frame;
    private int loginAttempts = 0;
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    
    //Main
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try { 
                    LoginView frame = new LoginView();
                    frame.LoginView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //longinView to open frame 
    private void LoginView() {
        frame = new JFrame();
        frame.setBounds(400, 100, 745, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Login");
        setSize(414, 298);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Numero de empleado");
        lblNewLabel.setBounds(6, 79, 115, 16);
        getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(188, 74, 132, 26);
        getContentPane().add(textField);
        textField.setColumns(10);

        lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setBounds(6, 119, 59, 16);
        getContentPane().add(lblNewLabel_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(188, 114, 132, 26);
        getContentPane().add(passwordField);

        btnNewButton = new JButton("Acceder");
        btnNewButton.setBounds(314, 235, 94, 29);
        btnNewButton.addActionListener(this);
        getContentPane().add(btnNewButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewButton) {
            Employee employee = new Employee(null);
            try {
                int employeeNumber = Integer.parseInt(textField.getText());
                String password = new String(passwordField.getPassword());
                
                if (employee.login(employeeNumber, password)) {
                    System.out.println("Funcionaaa :)");
                    this.setVisible(false);
                    ShopView miTienda = new ShopView();
                    miTienda.setVisible(true);
                } else {
                    handleFailedLogin("UPS! La contraseña o el usuario es incorrecto");
                }
            } catch (NumberFormatException ex) {
                handleFailedLogin("UPS! Introduzca un número válido");
            }
        }
    }

    private void handleFailedLogin(String errorMessage) {
        loginAttempts++;
        JOptionPane.showMessageDialog(insertWindow, errorMessage, "Error ", JOptionPane.ERROR_MESSAGE);
        if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
            JOptionPane.showMessageDialog(insertWindow,
                    "Ha superado el número de intentos para inicar sesión",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            // Clean textField
            textField.setText("");
            passwordField.setText("");
        }
    }
}
