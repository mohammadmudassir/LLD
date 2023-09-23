package client;

import Service.SplitWiseImpl;
import Service.SplitWiseService;
import entity.User;

import java.util.ArrayList;
import java.util.Arrays;

public class SplitWiseClient {
    public static void main(String [] args) {
        SplitWiseImpl splitWiseClient = new SplitWiseService();

        splitWiseClient.addFriend(new User("u1", "mudassir", "mudassir@gmail.com", 87687687));
        splitWiseClient.addFriend(new User("u2", "muzammil", "muzammil@gmail.com", 87687687));
        splitWiseClient.addFriend(new User("u3", "user3", "user3@gmail.com", 87687687));
        splitWiseClient.addFriend(new User("u4", "user4", "user4@gmail.com", 87687687));

        splitWiseClient.addExpenseEqual("u1", 10000, new ArrayList(Arrays.asList("u1", "u2", "u3", "u4")));

        splitWiseClient.displayOwesAmount();

        splitWiseClient.displayFriends();

    }
}
