package View;

import javax.swing.*;
import java.awt.*;

public class PayView extends JFrame {

    public PayView() {
        setTitle("Payment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150); // 调整窗口大小以容纳下方文本

        JTextField paymentField = new JTextField("付款"); // 创建文本框并设置文本内容
        paymentField.setEditable(false); // 禁止编辑
        paymentField.setHorizontalAlignment(JTextField.CENTER); // 居中对齐

        JLabel successLabel = new JLabel("付款成功 请凭取票码取票 1204 1342 2359", JLabel.CENTER); // 添加成功信息

        add(paymentField, BorderLayout.NORTH);
        add(successLabel, BorderLayout.CENTER); // 将成功信息添加到窗口中央

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PayView();
        });
    }
}
