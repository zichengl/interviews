package community;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class mainExtension {
    private static Map<Integer, Community> communityMap;
    private static Map<Integer, Follower> followerMap;
    private Set<Integer> visited;

    public mainExtension(Map<Integer, Community> communityMap, Map<Integer, Follower> followerMap) {
        this.communityMap = communityMap;
        this.followerMap = followerMap;
        this.visited = new HashSet<>();
    }

    public List<Integer> getRelatedCommunitiesWithDegree(int communityId, int degree) {
        List<Integer> relatedCommunities = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(communityId);
        relatedCommunities.add(communityId);
        int currDegree = 0;

        while (!queue.isEmpty() && currDegree <= degree) {
            int size = queue.size();
            currDegree++;

            for (int i = 0; i < size; i++) {
                int currCommunity = queue.poll();
                Community curr = communityMap.get(currCommunity);
                visited.add(currCommunity);

                for (int followerId : curr.followers) {
                    Follower f = followerMap.get(followerId);
                    for (int relatedCommunityId : f.communities) {
                        if (!visited.contains(relatedCommunityId)) {
                            queue.offer(relatedCommunityId);
                            relatedCommunities.add(relatedCommunityId);
                            visited.add(relatedCommunityId);
                        }
                    }
                }
            }
        }
        return relatedCommunities;
    }

    public static void main(String[] args) {
        communityMap = new HashMap<>();
        followerMap = new HashMap<>();

        // Populate communitiesMap and followersMap data as per the example
        Community c1 = new Community(1);
        c1.addFollower(1);
        c1.addFollower(3);
        communityMap.put(1, c1);

        Community c2 = new Community(2);
        c2.addFollower(1);
        c2.addFollower(2);
        communityMap.put(2, c2);

        Community c3 = new Community(3);
        c3.addFollower(2);
        communityMap.put(3, c3);

        Community c4 = new Community(4);
        c4.addFollower(3);
        communityMap.put(4, c4);

        Follower f1 = new Follower(1);
        f1.addCommunity(1);
        f1.addCommunity(2);
        followerMap.put(1, f1);

        Follower f2 = new Follower(2);
        f2.addCommunity(2);
        f2.addCommunity(3);
        followerMap.put(2, f2);

        Follower f3 = new Follower(3);
        f3.addCommunity(1);
        f3.addCommunity(4);
        followerMap.put(3, f3);

        mainExtension mainExtension = new mainExtension(communityMap, followerMap);
        System.out.println("get_related_communities_with_degree(C4, 1): " + mainExtension.getRelatedCommunitiesWithDegree(4, 1));
        System.out.println("get_related_communities_with_degree(C4, 2): " + mainExtension.getRelatedCommunitiesWithDegree(4, 2));
    }
}
