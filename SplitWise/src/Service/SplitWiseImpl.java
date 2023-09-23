package Service;

import entity.User;

import java.util.List;

public interface SplitWiseImpl {
    public void addFriend(User user);
    public void displayFriends();
    public void addExpenseEqual(String whoPaid, int totalAmount, List<String> whomPaid);

    public void displayOwesAmount();
}
