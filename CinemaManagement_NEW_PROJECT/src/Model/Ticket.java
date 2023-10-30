package Model;

public class Ticket {
    private Movie movie;
    private Theater theater;
    private Screening screening;
    private int seatRow;
    private int seatColumn;

    public Ticket(Movie movie, Theater theater, Screening screening, int seatRow, int seatColumn) {
        this.movie = movie;
        this.theater = theater;
        this.screening = screening;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }
}