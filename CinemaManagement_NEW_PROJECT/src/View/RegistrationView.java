package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JFrame originalWindow;

    public RegistrationView(JFrame originalWindow) {
        this.originalWindow = originalWindow;

        setTitle("用户注册");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("用户名:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("密码:");
        passwordField = new JPasswordField();

        registerButton = new JButton("注册");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // 空标签，用于布局
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // 在这里执行注册逻辑
                // 示例代码中仅显示注册信息
                JOptionPane.showMessageDialog(RegistrationView.this,
                        "注册成功！\n用户名: " + username + "\n密码: " + password,
                        "注册成功",
                        JOptionPane.INFORMATION_MESSAGE);

                // 注册成功后清空输入框
                usernameField.setText("");
                passwordField.setText("");

                // 恢复原来的窗口的显示
                originalWindow.setVisible(true);
            }
        });
    }
}