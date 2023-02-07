package community;

import java.util.ArrayList;
import java.util.List;

class Follower {
    int id;
    List<Integer> communities;

    public Follower(int id) {
        this.id = id;
        communities = new ArrayList<>();
    }

    public void addCommunity(int communityId) {
        communities.add(communityId);
    }
}