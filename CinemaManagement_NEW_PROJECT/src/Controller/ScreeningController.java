package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.*;
import java.time.LocalDateTime;

public class ScreeningController {
    private List<Screening> screenings;

    public ScreeningController() {
        screenings = new ArrayList<>();
    }

    public void addScreening(Movie movie, LocalDateTime startTime, Theater theater) {
        Screening screening = new Screening(movie, startTime, theater);
        screenings.add(screening);
        System.out.println("电影排片添加成功！");
    }

    public void updateScreening(Movie movie, LocalDateTime startTime, Theater theater, Theater newTheater) {
        for (Screening screening : screenings) {
            if (screening.getMovie().equals(movie) && screening.getStartTime().equals(startTime) && screening.getTheater().equals(theater)) {
                screening.setTheater(newTheater);
                System.out.println("电影排片修改成功！");
                return;
            }
        }
        System.out.println("找不到指定的电影排片！");
    }

    public void deleteScreening(Movie movie, LocalDateTime startTime, Theater theater) {
        Screening screeningToRemove = null;
        for (Screening screening : screenings) {
            if (screening.getMovie().equals(movie) && screening.getStartTime().equals(startTime) && screening.getTheater().equals(theater)) {
                screeningToRemove = screening;
                break;
            }
        }
        if (screeningToRemove != null) {
            screenings.remove(screeningToRemove);
            System.out.println("电影排片删除成功！");
        } else {
            System.out.println("找不到指定的电影排片！");
        }
    }
}