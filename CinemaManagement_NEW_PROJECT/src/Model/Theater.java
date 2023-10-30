package Model;

public class Theater {
    private String name;
    private int seatRowCount;     //座位排数
    private int seatColumnCount;  //座位列数
    private boolean[][] seatAvailability;  //座位预定情况

    public Theater(String name) {
        this.name = name;
        this.seatRowCount = 7;
        this.seatColumnCount = 12;
        this.seatAvailability = new boolean[seatRowCount][seatColumnCount];
        initializeSeatAvailability();
    }


    public String getName() {
        return name;
    }

    public int getSeatRowCount() {
        return seatRowCount;
    }

    public int getSeatColumnCount() {
        return seatColumnCount;
    }

    public boolean isSeatAvailable(int row, int column) {  //判断作为是否可用
        return seatAvailability[row][column];
    }

    public void reserveSeat(int row, int column) {     //预定作为
        seatAvailability[row][column] = false;
    }

    public void releaseSeat(int row, int column) {     //释放座位
        seatAvailability[row][column] = true;
    }

    private void initializeSeatAvailability() {     //座位初始化均为 True
        for (int i = 0; i < seatRowCount; i++) {
            for (int j = 0; j < seatColumnCount; j++) {
                seatAvailability[i][j] = true; // 默认所有座位可用
            }
        }
    }
}