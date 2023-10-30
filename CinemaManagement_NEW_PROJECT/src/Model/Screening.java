package Model;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;                // 影片 类型为 Movie
    private LocalDateTime startTime;    // 放映时间
    private Theater theater;            // 放映厅

    public Screening(Movie movie, LocalDateTime startTime, Theater theater) {
        this.movie = movie;
        this.startTime = startTime;
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}