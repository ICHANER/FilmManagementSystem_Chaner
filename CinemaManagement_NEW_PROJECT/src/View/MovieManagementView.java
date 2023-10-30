package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import Controller.*;
import Model.Movie;

public class MovieManagementView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JFrame originalWindow;
    private JTextField searchField;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton addButton;
    private JButton editButton;

    public MovieManagementView(JFrame originalWindow) {
        this.originalWindow = originalWindow;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 使用 DISPOSE_ON_CLOSE 而不是 EXIT_ON_CLOSE
        setTitle("电影管理");
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
        tableModel.addColumn("电影名");
        tableModel.addColumn("导演");
        tableModel.addColumn("演员");
        tableModel.addColumn("故事情节");
        tableModel.addColumn("时长");

        // 创建表格并设置模型
        table = new JTable(tableModel);

        // 创建滚动面板，并将表格添加到滚动面板中
        JScrollPane scrollPane = new JScrollPane(table);

        // 创建底部面板用于删除用户
//        JPanel deletePanel = new JPanel();
//        deleteButton = new JButton("删除电影");
//        deletePanel.add(deleteButton);
//        // 添加顶部面板、滚动面板和底部面板到窗口的相应位置
//        add(searchPanel, BorderLayout.NORTH);
//        add(scrollPane, BorderLayout.CENTER);
//        add(deletePanel, BorderLayout.SOUTH);

        // 创建底部面板用于删除、添加和修改电影
        JPanel buttonPanel = new JPanel();
        deleteButton = new JButton("删除电影");
        addButton = new JButton("添加影片");
        editButton = new JButton("修改影片");
        buttonPanel.add(deleteButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);

        // 添加顶部面板、滚动面板和底部面板到窗口的相应位置
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 创建 ListUsersController 对象
        ListMovieController listMovieController = new ListMovieController();

        // 获取所有用户列表
        List<Movie> movieList = listMovieController.getAllMovies();

        // 将用户列表添加到表格模型中
        for (Movie movie : movieList) {
            Object[] rowData = {
                    movie.getTitle(),
                    movie.getDirector(),
                    movie.getCast(),
                    movie.getPlot(),
                    movie.getDuration()
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
            JOptionPane.showMessageDialog(MovieManagementView.this,
                    "搜索电影：" + searchTerm,
                    "搜索结果",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // 添加删除按钮的点击事件监听器
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int confirmation = JOptionPane.showConfirmDialog(MovieManagementView.this,
                        "确定要删除电影吗？",
                        "删除用户",
                        JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    //// 执行删除用户的逻辑
                    MovieController movieController = new MovieController();
                    String title = (String) table.getValueAt(selectedRow, 0);
                    movieController.deleteMovie(title);

                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(MovieManagementView.this,
                            "电影已删除",
                            "电影用户",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(MovieManagementView.this,
                        "请先选择要删除的用户",
                        "删除用户",
                        JOptionPane.ERROR_MESSAGE);
            }
        });


        // 添加添加电影按钮的点击事件监听器
//        addButton.addActionListener(e -> {
//            // 在这里执行添加电影的逻辑
//            // 示例代码中仅显示添加提示
//            JOptionPane.showMessageDialog(MovieManagementView.this,
//                    "点击了添加影片按钮",
//                    "添加影片",
//                    JOptionPane.INFORMATION_MESSAGE);
//        });
        // 添加添加电影按钮的点击事件监听器
        addButton.addActionListener(e -> {
            // 创建并显示添加影片窗口
            showAddMovieWindow();
        });


        // 添加修改电影按钮的点击事件监听器
        editButton.addActionListener(e -> {
            MovieController movieController = new MovieController();
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // 获取选中行的数据
                String title = (String) table.getValueAt(selectedRow, 0);
                String director = (String) table.getValueAt(selectedRow, 1);
                String cast = (String) table.getValueAt(selectedRow, 2);
                String plot = (String) table.getValueAt(selectedRow, 3);
                String duration = (String) table.getValueAt(selectedRow, 4);

                // 调用控制器的方法，更新电影信息到数据库
                movieController.updateMovie(title, director, cast, plot, duration);

                JOptionPane.showMessageDialog(MovieManagementView.this,
                        "影片信息已成功更新到数据库中。",
                        "修改影片",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MovieManagementView.this,
                        "请先选择要修改的电影。",
                        "修改影片",
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

    private void showAddMovieWindow() {
        // 创建添加影片的窗口
        JFrame addMovieFrame = new JFrame("添加影片");
        addMovieFrame.setSize(400, 300);
        addMovieFrame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

// 创建文本框和标签用于输入电影内容
        JLabel titleLabel = new JLabel("电影名:");
        JTextField titleField = new JTextField(20);
        JLabel directorLabel = new JLabel("导演:");
        JTextField directorField = new JTextField(20);
        JLabel castLabel = new JLabel("演员:");
        JTextField castField = new JTextField(20);
        JLabel plotLabel = new JLabel("故事情节:");
        JTextField plotField = new JTextField(20);
        JLabel durationLabel = new JLabel("时长(分钟):");
        JTextField durationField = new JTextField(20);

// 创建确认按钮
        JButton confirmButton = new JButton("确认");

// 设置文本框和标签的排版
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5,5,5,5); //设置间距
        addMovieFrame.add(titleLabel, constraints);

        constraints.gridx = 1;
        addMovieFrame.add(titleField, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        addMovieFrame.add(directorLabel, constraints);

        constraints.gridx = 1;
        addMovieFrame.add(directorField, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        addMovieFrame.add(castLabel, constraints);

        constraints.gridx = 1;
        addMovieFrame.add(castField, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        addMovieFrame.add(plotLabel, constraints);

        constraints.gridx = 1;
        addMovieFrame.add(plotField, constraints);

        constraints.gridy = 4;
        constraints.gridx = 0;
        addMovieFrame.add(durationLabel, constraints);

        constraints.gridx = 1;
        addMovieFrame.add(durationField, constraints);

        constraints.gridy = 5;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        addMovieFrame.add(confirmButton, constraints);

        // 添加确认按钮的点击事件监听器
        confirmButton.addActionListener(e -> {
            // 获取用户输入的电影内容
            String title = titleField.getText();
            String director = directorField.getText();
            String cast = castField.getText();
            String plot = plotField.getText();
            String duration = durationField.getText();

            //导入至数据库
            MovieController movieController = new MovieController();
            movieController.insertMovie(title, director, cast, plot, duration);

            // 创建电影对象
            Movie newMovie = new Movie(title, director, cast, plot, duration);

            // 将电影对象添加到表格模型中
            Object[] rowData = {
                    newMovie.getTitle(),
                    newMovie.getDirector(),
                    newMovie.getCast(),
                    newMovie.getPlot(),
                    newMovie.getDuration()
            };
            tableModel.addRow(rowData);

            // 关闭添加影片窗口
            addMovieFrame.dispose();
        });

// 设置添加影片窗口居中显示
        addMovieFrame.setLocationRelativeTo(this);

// 显示添加影片窗口
        addMovieFrame.setVisible(true);
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
