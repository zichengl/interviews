package community;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class main {

        public static Map<Integer, Community> communitiesMap;
        public static Map<Integer, Follower> followersMap;

        public static List<Integer> getRelatedCommunities(int communityId) {
            Set<Integer> relatedCommunities = new HashSet<>();
            Community community = communitiesMap.get(communityId);
            for (int followerId : community.followers) {
                Follower follower = followersMap.get(followerId);
                for (int relatedCommunityId : follower.communities) {
                    if (relatedCommunityId != communityId) {
                        relatedCommunities.add(relatedCommunityId);
                    }
                }
            }
            List<Integer> result = new ArrayList<>(relatedCommunities);
            // Collections.sort(result);
            return result;
        }

        public static void main(String[] args) {
            communitiesMap = new HashMap<>();
            followersMap = new HashMap<>();

            // Populate communitiesMap and followersMap data as per the example
            Community c1 = new Community(1);
            c1.addFollower(1);
            c1.addFollower(3);
            communitiesMap.put(1, c1);

            Community c2 = new Community(2);
            c2.addFollower(1);
            c2.addFollower(2);
            communitiesMap.put(2, c2);

            Community c3 = new Community(3);
            c3.addFollower(2);
            communitiesMap.put(3, c3);

            Community c4 = new Community(4);
            c4.addFollower(3);
            communitiesMap.put(4, c4);

            Follower f1 = new Follower(1);
            f1.addCommunity(1);
            f1.addCommunity(2);
            followersMap.put(1, f1);

            Follower f2 = new Follower(2);
            f2.addCommunity(2);
            f2.addCommunity(3);
            followersMap.put(2, f2);

            Follower f3 = new Follower(3);
            f3.addCommunity(1);
            f3.addCommunity(4);
            followersMap.put(3, f3);

            // Test the example cases
            System.out.println(getRelatedCommunities(4));
            System.out.println(getRelatedCommunities(2));
        }
}
