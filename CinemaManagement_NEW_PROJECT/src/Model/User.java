//CREATE TABLE users (
//        id INT PRIMARY KEY,
//        username VARCHAR(30),
//        password VARCHAR(30),
//        role VARCHAR(10),
//        level INT,
//        regtime DATE,
//        expsum DECIMAL(5, 2),
//        exptimes INT,
//        phone VARCHAR(20),
//        email VARCHAR(50)
//        );

package Model;
import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private int level;
    private Date regTime;
    private double expSum;
    private int expTimes;
    private String phone;
    private String email;

    public User(int id, String username, String password, String role, int level, Date regTime, double expSum,
                int expTimes, String phone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.level = level;
        this.regTime = regTime;
        this.expSum = expSum;
        this.expTimes = expTimes;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public double getExpSum() {
        return expSum;
    }

    public void setExpSum(double expSum) {
        this.expSum = expSum;
    }

    public int getExpTimes() {
        return expTimes;
    }

    public void setExpTimes(int expTimes) {
        this.expTimes = expTimes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}