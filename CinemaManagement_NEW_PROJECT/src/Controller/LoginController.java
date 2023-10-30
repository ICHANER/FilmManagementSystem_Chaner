//package Controller;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class LoginController {
//
//    public static void main(String[] args) {
//        String username = "your_username";
//        String password = "your_password";
//        boolean userExists = checkUserExists(username, password);
//        System.out.println("User exists: " + userExists);
//    }
//
//    public static boolean checkUserExists(String username, String password) {
//        String url = "jdbc:mysql://localhost:3306/mydatabase";
//        String user = "root";
//        String dbPassword = "Aa123456";
//
//        try {
//            Connection conn = DriverManager.getConnection(url, user, dbPassword);
//            String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";   //SQL查询语句
//            PreparedStatement statement = conn.prepareStatement(query);
//            statement.setString(1, username);
//            statement.setString(2, password);
//            ResultSet resultSet = statement.executeQuery();
//            resultSet.next();
//            int count = resultSet.getInt(1);
//            conn.close();
//            return count > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}

package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginController {
    public int authenticateUser(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String dbPassword = "Aa123456";
        int userId = 0;

        try {
            Connection conn = DriverManager.getConnection(url, user, dbPassword);
            String query = "SELECT id FROM users WHERE username = ? AND password = ?";   //SQL查询语句
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userId = resultSet.getInt("id");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userId;
    }
}