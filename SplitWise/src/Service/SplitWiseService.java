package Service;

import entity.User;
import repository.SplitWiseDao;

import java.util.List;

public class SplitWiseService implements SplitWiseImpl{
    SplitWiseDao splitWiseDao;
    public SplitWiseService() {
        splitWiseDao = new SplitWiseDao();
    }
    @Override
    public void addFriend(User user) {
        splitWiseDao.addFriend(user);
    }

    @Override
    public void displayFriends() {
        splitWiseDao.displayFriends();
    }

    @Override
    public void addExpenseEqual(String whoPaid, int totalAmount, List<String> whomPaid) {
        splitWiseDao.addExpenseEqual(whoPaid, totalAmount, whomPaid);
    }

    @Override
    public void displayOwesAmount() {
        splitWiseDao.displayOwesAmount();
    }

}
