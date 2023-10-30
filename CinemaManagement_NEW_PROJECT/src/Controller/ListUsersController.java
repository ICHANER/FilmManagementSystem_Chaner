package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.User;

public class ListUsersController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Aa123456";

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
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

                User user = new User(id, username,password, role, level, regTime, expSum, expTimes, phone, email);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}