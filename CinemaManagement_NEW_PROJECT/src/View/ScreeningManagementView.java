package View;
import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.ScreeningController;
import Model.Movie;
import Model.Theater;
import java.time.LocalDateTime;

public class ScreeningManagementView extends JFrame {

    private ScreeningController screeningController;
    private JTextField titleField, dateField, timeField, cinemaField, hallField;

    public ScreeningManagementView() {
        screeningController = new ScreeningController();

        setTitle("排片管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        JLabel titleLabel = new JLabel("电影标题：");
        titleField = new JTextField();
        JLabel dateLabel = new JLabel("日期：");
        dateField = new JTextField();
        JLabel timeLabel = new JLabel("时间：");
        timeField = new JTextField();
        JLabel cinemaLabel = new JLabel("影院名称：");
        cinemaField = new JTextField();
        JLabel hallLabel = new JLabel("影厅名称：");
        hallField = new JTextField();

        JButton addButton = new JButton("添加");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String date = dateField.getText();
                String time = timeField.getText();
                String cinema = cinemaField.getText();
                String hall = hallField.getText();

                // 创建电影对象、放映时间对象和放映厅对象
                Movie movie = new Movie(title);  // 假设构造方法为 Movie(String title)
                LocalDateTime startTime = LocalDateTime.parse(date + "T" + time);  // 假设日期格式为 yyyy-MM-dd，时间格式为 HH:mm
                Theater theater = new Theater(hall);  // 假设构造方法为 Theater(String cinema, String hall)

                screeningController.addScreening(movie, startTime, theater);
                clearFields();
            }
        });

        add(titleLabel);
        add(titleField);
        add(dateLabel);
        add(dateField);
        add(timeLabel);
        add(timeField);
        add(cinemaLabel);
        add(cinemaField);
        add(hallLabel);
        add(hallField);
        add(addButton);

        setVisible(true);
    }

    private void clearFields() {
        titleField.setText("");
        dateField.setText("");
        timeField.setText("");
        cinemaField.setText("");
        hallField.setText("");
    }
}



