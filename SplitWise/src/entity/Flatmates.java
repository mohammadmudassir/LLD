package entity;

import java.util.HashMap;
import java.util.Map;

public class Flatmates {
    Map<String, User> friends;
    Map<String, Map<String, User>> owesList;
    Map<String, Map<String, User>> givenList;

    public Flatmates() {
        friends = new HashMap<>();
        owesList = new HashMap<>();
        givenList = new HashMap<>();
    }

    public Map<String, User> getFriends() {
        return friends;
    }

    public void setFriends(Map<String, User> friends) {
        this.friends = friends;
    }

    public Map<String, Map<String, User>> getOwesList() {
        return owesList;
    }

    public void setOwesList(Map<String, Map<String, User>> owesList) {
        this.owesList = owesList;
    }

    public Map<String, Map<String, User>> getGivenList() {
        return givenList;
    }

    public void setGivenList(Map<String, Map<String, User>> givenList) {
        this.givenList = givenList;
    }
}
