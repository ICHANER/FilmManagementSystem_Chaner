package View;

import java.util.Scanner;
import java.sql.*;

import Controller.LoginController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;


    public LoginView() {
        setTitle("欢迎来到云大影城");
        setSize(936, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

//        JPanel panel = new JPanel();
//        add(panel);

        // 创建自定义的 JPanel，并设置为内容面板
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 绘制背景图像
                ImageIcon backgroundImage = new ImageIcon(getClass().getResource("background.png"));
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        setContentPane(panel);
        panel.setLayout(null);

        // 大标题
        JLabel headLine = new JLabel("欢迎使用云南大学电影院管理系统");
        headLine.setBounds(80, 80, 550, 50);
        headLine.setFont(new Font("Arial", Font.BOLD, 30)); // 设置字体为Arial，粗体，字号为20
        panel.add(headLine);


        //用户名模块
        JLabel usernameLabel = new JLabel("用户名："); //用户名标签
        usernameLabel.setBounds(100,175,160,50);
        panel.add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(170,180,300,50);  //设置绝对位置
        panel.add(usernameField);

        //密码模块
        JLabel passwordLabel = new JLabel("密  码："); //密码标签
        passwordLabel.setBounds(100,245,160,50);
        panel.add(passwordLabel);
        //
        passwordField = new JPasswordField(20);
        passwordField.setBounds(170,250,300,50);
        panel.add(passwordField);

        //登录按钮
        loginButton = new JButton("登录");  //登录按钮
        loginButton.setBounds(110,350,160,50);   //设置绝对位置
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {       //按钮事件
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                LoginController loginController = new LoginController();
                int UserID;

                UserID = loginController.authenticateUser(username, password);   //登陆认证
                if (UserID != 0) {
                    MainView mainView = new MainView(UserID, username);    //传入主窗口！！！！！！！！！
                    mainView.setVisible(true);
                    setVisible(false);
                    // 用户存在，执行登录成功的逻辑
                    // 例如：跳转到主界面或执行其他操作
                    System.out.println("登录成功");
                } else {    //用户不存在，弹“密码错误”窗
                    JOptionPane.showMessageDialog(LoginView.this, "密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        registerButton = new JButton("注册");
        registerButton.setBounds(310,350,160,50);   //设置绝对位置
        panel.add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                RegistrationView registrationView = new RegistrationView(this.loginView);
//                registrationView.setVisible(true);
//                setVisible(false);
                SwingUtilities.invokeLater(() -> {
                    JFrame originalWindow = new JFrame("原窗口");
                    originalWindow.setSize(400, 300);
                    originalWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    originalWindow.setLocationRelativeTo(null);
                    originalWindow.setVisible(true);

                    RegistrationView registration = new RegistrationView(originalWindow);
                    registration.setVisible(true);
                    originalWindow.setVisible(false); // 隐藏原窗口
                });

            }
        });

    }
}