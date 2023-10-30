//package View;
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.util.List;
//import Model.User;
//import Controller.ListUsersController;
//
//public class UserManagementView extends JFrame {
//    private JTable table;
//    private DefaultTableModel tableModel;
//    private JFrame originalWindow;
//
//    public UserManagementView(JFrame originalWindow) {
//        this.originalWindow = originalWindow;
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 使用 DISPOSE_ON_CLOSE 而不是 EXIT_ON_CLOSE
//        setTitle("用户管理");
//        setSize(800, 600);
//        setLayout(new BorderLayout());
//
//        // 创建表格模型
//        tableModel = new DefaultTableModel();
//        tableModel.addColumn("ID");
//        tableModel.addColumn("用户名");
//        tableModel.addColumn("角色");
//        tableModel.addColumn("用户级别");
//        tableModel.addColumn("注册时间");
//        tableModel.addColumn("手机号码");
//        tableModel.addColumn("积累消费金额");
//        tableModel.addColumn("积累消费次数");
//        tableModel.addColumn("邮箱");
//
//        // 创建表格并设置模型
//        table = new JTable(tableModel);
//
//        // 创建滚动面板，并将表格添加到滚动面板中
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        // 添加滚动面板到窗口的中央区域
//        add(scrollPane, BorderLayout.CENTER);
//
//        // 创建 ListUsersController 对象
//        ListUsersController listUsersController = new ListUsersController();
//
//        // 获取所有用户列表
//        List<User> userList = listUsersController.getAllUsers();
//
//        // 将用户列表添加到表格模型中
//        for (User user : userList) {
//            Object[] rowData = {
//                    user.getId(),
//                    user.getUsername(),
//                    user.getRole(),
//                    user.getLevel(),
//                    user.getRegTime(),
//                    user.getPhone(),
//                    user.getExpSum(),
//                    user.getExpTimes(),
//                    user.getEmail()
//            };
//            tableModel.addRow(rowData);
//        }
//
//        // 添加窗口关闭事件监听器
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                originalWindow.setVisible(true); // 恢复原窗口的显示
//            }
//        });
//
//        // 将窗口居中显示
//        setLocationRelativeTo(null);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame originalWindow = new JFrame(); // 原窗口示例
//            originalWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            originalWindow.setSize(400, 300);
//            originalWindow.setVisible(true);
//
//            UserManagementView userManagementView = new UserManagementView(originalWindow);
//            userManagementView.setVisible(true);
//        });
//    }
//}



package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import Model.User;
import Controller.ListUsersController;

public class UserManagementView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JFrame originalWindow;
    private JTextField searchField;
    private JButton searchButton;
    private JButton deleteButton;

    public UserManagementView(JFrame originalWindow) {
        this.originalWindow = originalWindow;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 使用 DISPOSE_ON_CLOSE 而不是 EXIT_ON_CLOSE
        setTitle("用户管理");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // 创建顶部面板用于搜索用户
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("搜索");
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // 创建表格模型
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("用户名");
        tableModel.addColumn("角色");
        tableModel.addColumn("用户级别");
        tableModel.addColumn("注册时间");
        tableModel.addColumn("手机号码");
        tableModel.addColumn("积累消费金额");
        tableModel.addColumn("积累消费次数");
        tableModel.addColumn("邮箱");

        // 创建表格并设置模型
        table = new JTable(tableModel);

        // 创建滚动面板，并将表格添加到滚动面板中
        JScrollPane scrollPane = new JScrollPane(table);

        // 创建底部面板用于删除用户
        JPanel deletePanel = new JPanel();
        deleteButton = new JButton("删除用户");
        deletePanel.add(deleteButton);

        // 添加顶部面板、滚动面板和底部面板到窗口的相应位置
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(deletePanel, BorderLayout.SOUTH);

        // 创建 ListUsersController 对象
        ListUsersController listUsersController = new ListUsersController();

        // 获取所有用户列表
        List<User> userList = listUsersController.getAllUsers();

        // 将用户列表添加到表格模型中
        for (User user : userList) {
            Object[] rowData = {
                    user.getId(),
                    user.getUsername(),
                    user.getRole(),
                    user.getLevel(),
                    user.getRegTime(),
                    user.getPhone(),
                    user.getExpSum(),
                    user.getExpTimes(),
                    user.getEmail()
            };
            tableModel.addRow(rowData);
        }

        // 添加搜索按钮的点击事件监听器
        searchButton.addActionListener(e -> {
            String searchTerm = searchField.getText();
            // 根据 ID 或用户名搜索用户
            // 在这里执行搜索用户的逻辑
            // 将搜索结果显示在表格中
            // 示例代码中仅显示搜索词
            JOptionPane.showMessageDialog(UserManagementView.this,
                    "搜索用户：" + searchTerm,
                    "搜索结果",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // 添加删除按钮的点击事件监听器
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int confirmation = JOptionPane.showConfirmDialog(UserManagementView.this,
                        "确定要删除用户吗？",
                        "删除用户",
                        JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    // 执行删除
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(UserManagementView.this,
                            "用户已删除",
                            "删除用户",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(UserManagementView.this,
                        "请先选择要删除的用户",
                        "删除用户",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // 添加窗口关闭事件监听器
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                originalWindow.setVisible(true); // 恢复原窗口的显示
            }
        });

        // 将窗口居中显示
        setLocationRelativeTo(null);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame originalWindow = new JFrame(); // 原窗口示例
//            originalWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            originalWindow.setSize(400, 300);
//            originalWindow.setVisible(true);
//
//            UserManagementView userManagementView = new UserManagementView(originalWindow);
//            userManagementView.setVisible(true);
//        });
//    }

}