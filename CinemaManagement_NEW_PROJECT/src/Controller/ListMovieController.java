package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import Model.User;
import Model.Movie;

public class ListMovieController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Aa123456";

    public List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM movie";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String title = resultSet.getString("title");
                String director = resultSet.getString("director");
                String cast = resultSet.getString("cast");
                String duration = resultSet.getString("duration");
                String plot = resultSet.getString("plot");

                Movie movie = new Movie(title, director, cast, plot, duration);
                movieList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movieList;
    }
}