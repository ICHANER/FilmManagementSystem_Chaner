package Controller;

import java.sql.*;
import Model.User;

public class UserAssignController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Aa123456";

    public User getUserById(int userId) {       //传入一个 id
        User user = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                int level = resultSet.getInt("level");
                Date regTime = resultSet.getDate("regtime");
                double expSum = resultSet.getDouble("expsum");
                int expTimes = resultSet.getInt("exptimes");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                user = new User(id, username,password , role, level, regTime, expSum, expTimes, phone, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;    //返回一个 user
    }
}