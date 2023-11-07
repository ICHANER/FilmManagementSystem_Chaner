package View;

import javax.swing.*;
import java.util.List;
import Model.*;
import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private String username;
    private int UserID;
    private JButton userManagementButton;
    private JButton movieManagementButton;
    private JButton screeningManagementButton;
    private JButton ticketSaleButton;
    private JButton button;
    private JButton exitButton;
    private JButton changePasswordButton;
    private JButton resetPasswordButton;
    private JButton ticketBuyButton;

    public MainView(int userID, String username) {
        this.UserID = userID;
        this.username = username;

        //获取用户全信息................................
        UserAssignController userAssignController = new UserAssignController();
        User user = null;
        user = userAssignController.getUserById(userID);
        String userType = user.getRole();

//    }
////    void MainView(int id, String username){
////      非构造函数！！！！
////    }
//    public MainView() {
        setTitle("云南大学影城系统");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //添加面板
        JPanel panel = new JPanel();
        add(panel);

        //添加欢迎标签
        JLabel welcomeLabel = new JLabel("你好 " + "ID:" + UserID + " " + username + "，欢迎使用影城系统" + "    ");
        panel.add(welcomeLabel);
        //               <--admin-->
        //添加"用户管理"按钮
        if (userType.equals("admin")) {
            //重置用户密码部分
            resetPasswordButton = new JButton("重置用户密码");
            panel.add(resetPasswordButton);
            resetPasswordButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 弹出一个输入对话框，输入用户的id
                    String userInput = JOptionPane.showInputDialog("请输入您要修改密码的用户ID");
                    // 用户输入的值将存储在 userInput 变量中
                    if (userInput != null) {    //成功修改
                        JOptionPane.showMessageDialog(MainView.this, "您已成功修改密码为：" + "\n" + userInput + "\n" + "请牢记密码！", "密码修改成功", JOptionPane.ERROR_MESSAGE);
                        ChangePasswordController changePasswordController = new ChangePasswordController();
                        changePasswordController.changePassword(userID, userInput);

                    } else {
                        JOptionPane.showMessageDialog(MainView.this, "您没有修改密码", "撤销操作", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            //用户管理部分
            userManagementButton = new JButton("用户管理");
            panel.add(userManagementButton);
            userManagementButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UserManagementView userManagementView = new UserManagementView(MainView.this);
                    userManagementView.setVisible(true);
                    setVisible(false);
                }

            });
        }


        //               <--manager-->
        //添加“电影管理“、”排片管理“ 按钮
        if (userType.equals("manager")) {
            movieManagementButton = new JButton("电影管理");
            panel.add(movieManagementButton);
            movieManagementButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MovieManagementView movieManagementView = new MovieManagementView(MainView.this);
                    movieManagementView.setVisible(true);
                    setVisible(false);
                }
            });
            //排片管理！！！！！
            screeningManagementButton = new JButton("排片管理");
            panel.add(screeningManagementButton);
            screeningManagementButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ScreeningManagementView screeningManagementView = new ScreeningManagementView();
                    screeningManagementView.setVisible(true);
                }
            });

        }


        //               <--staff-->
        //添加 “售票” 按钮
        if (userType.equals("staff")) {
            ticketSaleButton = new JButton("售票");
            panel.add(ticketSaleButton);
        }


        //               <--user-->
        if (userType.equals("user")) {
            ticketBuyButton = new JButton("购票");
            panel.add(ticketBuyButton);
            ticketBuyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TicketPurchaseView ticketPurchaseView = new TicketPurchaseView();
                    ticketPurchaseView.setVisible(true);

                }
            });
        }


        //               <--universal-->
        //均有“修改自身密码”按钮 -----只能改自己的！-----
        changePasswordButton = new JButton("修改密码");
        panel.add(changePasswordButton);
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹出一个输入对话框，获取用户的输入值
                String userInput = JOptionPane.showInputDialog("请输入您要修改后的密码: " + "\n" + "按确认键即可修改成功");
                // 用户输入的值将存储在 userInput 变量中
                if (userInput != null) {    //成功修改
                    //JOptionPane.showMessageDialog(MainView.this, "您已成功修改密码为：" + "\n" + userInput + "\n" + "请牢记密码！", "密码修改成功", JOptionPane.ERROR_MESSAGE);
                    ChangePasswordController changePasswordController = new ChangePasswordController();
                    changePasswordController.changePassword(userID, userInput);

                } else {
                    JOptionPane.showMessageDialog(MainView.this, "您没有修改密码", "撤销操作", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //均有“退出”按钮
        exitButton = new JButton("退出");
        panel.add(exitButton);
        //-----事件启始
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LoginView loginView = new LoginView();
                loginView.setVisible(true);
            }
        });
        //-----事件结束

    }

    public JButton getUserManagementButton() {
        return userManagementButton;
    }

    public JButton getMovieManagementButton() {
        return movieManagementButton;
    }

    public JButton getScreeningManagementButton() {
        return screeningManagementButton;
    }

    public JButton getTicketSaleButton() {
        return ticketSaleButton;
    }

    public JButton getButton() {
        return button;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}