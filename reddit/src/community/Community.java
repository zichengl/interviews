package community;

import java.util.ArrayList;
import java.util.List;

class Community {
    int id;
    List<Integer> followers;

    public Community(int id) {
        this.id = id;
        followers = new ArrayList<>();
    }

    public void addFollower(int followerId) {
        followers.add(followerId);
    }
}
