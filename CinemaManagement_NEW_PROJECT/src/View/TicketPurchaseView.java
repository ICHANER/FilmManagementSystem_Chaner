package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketPurchaseView extends JFrame {
    private JPanel seatPanel;
    private char[][] seats = new char[7][12];
    private Font font = new Font("Arial", Font.BOLD, 14);

    public TicketPurchaseView() {
        setTitle("Ticket Purchase");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500); // 调整窗口高度以容纳底部按钮和顶部文本

        JLabel topLabel = new JLabel("点击 O 区域即可选择座位", JLabel.CENTER); // 顶部文本
        add(topLabel, BorderLayout.NORTH);

        seatPanel = new JPanel(new GridLayout(7, 12));
        initializeSeats();
        add(seatPanel);

        seatPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = e.getY() / (seatPanel.getHeight() / 7);
                int column = e.getX() / (seatPanel.getWidth() / 12);
                toggleSeatStatus(row, column);
            }
        });

        JPanel bottomPanel = new JPanel(); // 底部面板
        JButton purchaseButton = new JButton("购买电影票"); // 创建购买按钮
        bottomPanel.add(purchaseButton); // 将按钮添加到底部面板

        // 添加购买按钮的点击事件监听器
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开付款界面 PayView.java
                PayView payView = new PayView();
                payView.setVisible(true);
            }
        });

        add(bottomPanel, BorderLayout.SOUTH); // 将底部面板添加到窗口底部

        setVisible(true);
    }

    private void initializeSeats() {
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 12; column++) {
                seats[row][column] = 'O';

                JLabel seatLabel = new JLabel(String.valueOf(seats[row][column]), JLabel.CENTER);
                seatLabel.setFont(font);
                seatLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                seatPanel.add(seatLabel);
            }
        }
    }

    private void toggleSeatStatus(int row, int column) {
        if (row >= 0 && row < 7 && column >= 0 && column < 12) {
            if (seats[row][column] == 'O') {
                seats[row][column] = 'X';
            } else {
                seats[row][column] = 'O';
            }

            Component component = seatPanel.getComponent(row * 12 + column);
            if (component instanceof JLabel) {
                JLabel seatLabel = (JLabel) component;
                seatLabel.setText(String.valueOf(seats[row][column]));
                if (seats[row][column] == 'X') {
                    seatLabel.setFont(new Font("Arial", Font.BOLD, 14));
                    seatLabel.setForeground(Color.RED);
                } else {
                    seatLabel.setFont(font);
                    seatLabel.setForeground(Color.BLACK);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TicketPurchaseView();
        });
    }
}
