package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListScreeningController {
    private static final int NUM_SCREENINGS = 5;  // 有5个放映厅
    private boolean[][][] seats = new boolean[NUM_SCREENINGS][7][12];

    public void initializeSeatsFromDatabase() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 数据库连接配置
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "root";
            String password = "Aa123456";

            // 建立数据库连接
            connection = DriverManager.getConnection(url, user, password);

            for (int screeningId = 1; screeningId <= NUM_SCREENINGS; screeningId++) {
                // SQL 查询语句，根据放映厅ID获取座位状态
                String sql = "SELECT row_num, line_num, is_available FROM seats WHERE screening_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, screeningId);
                resultSet = preparedStatement.executeQuery();

                // 初始化座位状态
                while (resultSet.next()) {
                    int row = resultSet.getInt("row_num");
                    int line = resultSet.getInt("line_num");
                    boolean isAvailable = resultSet.getBoolean("is_available");
                    seats[screeningId - 1][row][line] = isAvailable;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean[][][] getSeats() {
        return seats;
    }

    public static void main(String[] args) {
        ListScreeningController controller = new ListScreeningController();
        controller.initializeSeatsFromDatabase();

        // 现在 seats 数组中包含了座位状态的初始化数据
        boolean[][][] seats = controller.getSeats();

        // 可以在这里进行其他操作，如输出座位状态
    }
}
