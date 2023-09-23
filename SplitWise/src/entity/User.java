package entity;

public class User {
    String userId;
    String name;
    String email;
    int mobNum;
    int amount;

    public User(String userId, String name, String email, int mobNum) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobNum = mobNum;
    }

    public User(User user) {
        this.userId = user.userId;
        this.name = user.name;
        this.email = user.email;
        this.mobNum = user.mobNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobNum() {
        return mobNum;
    }

    public void setMobNum(int mobNum) {
        this.mobNum = mobNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
