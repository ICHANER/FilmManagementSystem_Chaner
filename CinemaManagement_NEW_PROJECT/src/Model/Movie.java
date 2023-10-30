package Model;

public class Movie {
    private String title;   //影片名
    private String director; //导演
    private String cast; //主演
    private String plot; //剧情简介
    private String duration; //时间：单位分钟

    public Movie(String title, String director, String cast, String plot, String duration) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.plot = plot;
        this.duration = duration;
    }
    public Movie(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}