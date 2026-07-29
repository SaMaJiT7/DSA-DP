package HEAP;

import java.util.*;

public class Design_Twitter {
    HashMap<Integer, Set<Integer>> followlist;
    HashMap<Integer, List<int[]>> tweetMap;

    public Design_Twitter() {
        this.followlist = new HashMap<>();

        this.tweetMap = new HashMap<>();
    }
    int timestamp = 0;
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        tweetMap.computeIfAbsent(userId,k -> new ArrayList<>()).add(new int[]{timestamp,tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        initializeUser(userId);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0],b[0]));
        Set<Integer> following = followlist.get(userId);
        for(int user : following){
            List<int[]> posts = tweetMap.get(user);

            if(posts != null){
                for(int[] tweet : posts){
                    pq.add(tweet);

                    while (pq.size() > 10){
                        pq.poll();
                    }
                }
            }
        }
        List<Integer> feed = new ArrayList<>();
        while(!pq.isEmpty()){
            feed.add(0,pq.poll()[1]);
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        initializeUser(followerId);
        followlist.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if(followlist.containsKey(followerId)) {
            followlist.get(followerId).remove(followeeId);
        }
    }
    public void initializeUser(int userId){
        followlist.computeIfAbsent(userId,k -> new HashSet<>()).add(userId);
    }
}
