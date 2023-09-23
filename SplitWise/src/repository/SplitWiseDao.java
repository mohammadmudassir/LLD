package repository;

import entity.Flatmates;
import entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWiseDao {
    Flatmates flatmates;
    public SplitWiseDao() {
        flatmates = new Flatmates();
    }

    public void addFriend(User user) {
        Map<String, User> friendList = flatmates.getFriends();
        if (friendList.containsKey((user.getUserId()))) {
            System.out.println("This user already exists !!");
        }
        else {
            friendList.put(user.getUserId(), user);
        }
    }

    public void displayFriends() {
        Map<String, User> friendList = flatmates.getFriends();
        for (Map.Entry<String, User> entrySet : friendList.entrySet()) {
            System.out.println("user id : " + entrySet.getValue().getName());
        }
    }

    private boolean isIOwened(String paidTo, String paidBy) {
        if (!flatmates.getOwesList().containsKey(paidBy)) {
            return false;
        }
        else {
            Map<String, User> paidToList = flatmates.getOwesList().get(paidBy);
            if (!paidToList.containsKey(paidTo)) {
                return false;
            }
            else {
                return true;
            }
        }
    }

    public void addExpenseEqual(String whoPaid, int totalAmount, List<String> whomPaid) {
        int totalFriend = whomPaid.size();
        int owesAmount = totalAmount / totalFriend;
        if (!flatmates.getOwesList().containsKey(whoPaid)) {
            Map<String, User> paidToList = new HashMap<>();
            for (String userid : whomPaid) {
                if (whoPaid.equals(userid)) continue;
                User friend = flatmates.getFriends().get(userid);
                User user = new User(friend);
                if (isIOwened(whoPaid, userid)) {
                    int satteledAmount = flatmates.getOwesList().get(userid).get(whoPaid).getAmount();
                    if (satteledAmount - owesAmount <= 0) {
                        flatmates.getOwesList().get(userid).get(whoPaid).setAmount(0);
                        user.setAmount((satteledAmount - owesAmount) * -1);
                    }
                }
                else {
                    user.setAmount(owesAmount);
                }
                paidToList.put(userid, user);
            }
            flatmates.getOwesList().put(whoPaid, paidToList);
        }
        else {
            Map<String, User> paidToList = flatmates.getOwesList().get(whoPaid);
            for (String userid : whomPaid) {
                if (whoPaid.equals(userid)) continue;
                if (paidToList.containsKey(userid)) {
                    int amount = paidToList.get(userid).getAmount();
                    paidToList.get(userid).setAmount(amount + owesAmount);
                }
                else {
                    User friend = flatmates.getFriends().get(userid);
                    User user = new User(friend);
                    if (isIOwened(whoPaid, userid)) {
                        int satteledAmount = flatmates.getOwesList().get(userid).get(whoPaid).getAmount();
                        if (satteledAmount - owesAmount <= 0) {
                            flatmates.getOwesList().get(userid).get(whoPaid).setAmount(0);
                            user.setAmount((satteledAmount - owesAmount) * -1);
                        }
                    }
                    else {
                        user.setAmount(owesAmount);
                    }
                    paidToList.put(userid, user);
                }
            }
        }
    }

    public void displayOwesAmount() {
        Map<String, Map<String, User>> owesUser = flatmates.getOwesList();
        for (Map.Entry<String, Map<String, User>> owesList : owesUser.entrySet()) {
            String paidBy = owesList.getKey();
            for (Map.Entry<String, User> paidTo : owesList.getValue().entrySet()) {
                System.out.println(paidBy + " paid to " + paidTo.getKey() + " amount : " + paidTo.getValue().getAmount());
            }
        }
    }
}
