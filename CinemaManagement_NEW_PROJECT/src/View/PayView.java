package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PayView extends JFrame {

    private JLabel successLabel;

    public PayView() {
        setTitle("付款页面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300); // 调整窗口大小以容纳下方文本
        setLocationRelativeTo(null); // 将窗口居中显示

        JTextField paymentField = new JTextField("*** 付款页面 ***"); // 创建文本框并设置文本内容
        paymentField.setEditable(false); // 禁止编辑
        paymentField.setHorizontalAlignment(JTextField.CENTER); // 居中对齐

        successLabel = new JLabel("", JLabel.CENTER); // 添加成功信息

        JButton payButton = new JButton("支付宝付款");
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //弹出支付宝首页
                    Desktop.getDesktop().browse(new URI("https://www.alipay.com"));
                    successLabel.setText("付款成功，请凭取票码取票 1204 1342 2359");
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(payButton);

        add(paymentField, BorderLayout.NORTH);
        add(successLabel, BorderLayout.CENTER); // 将成功信息添加到窗口中央
        add(buttonPanel, BorderLayout.SOUTH); // 将按钮添加到窗口底部

        setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new PayView();
//        });
//    }
    //整合为模块 Main 函数注释处理
}