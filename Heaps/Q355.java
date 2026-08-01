import java.util.*;

public class Q355 {
    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);

        List<Integer> feed = obj.getNewsFeed(1);
        System.out.println(feed);

        obj.follow(1, 2);
        obj.postTweet(2, 6);

        List<Integer> feed2 = obj.getNewsFeed(1);
        System.out.println(feed2);

        obj.unfollow(1, 2);

        List<Integer> feed3 = obj.getNewsFeed(1);
        System.out.println(feed3);
    }
}


class Twitter {

    class Tweet{
        int tweetId;
        int time;
        Tweet next;
        Tweet(int tweetId, int time){
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    HashMap<Integer, Set<Integer>> map;

    HashMap<Integer, Tweet> tweets;

    int timestamp;

    public Twitter() {
        map = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet (tweetId,timestamp++);
        t.next = tweets.get(userId);
        tweets.put(userId, t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> b.time - a.time);

        if(tweets.get(userId) != null){
            pq.add(tweets.get(userId));
        }

        if(map.get(userId) != null){
            for(Integer followee : map.get(userId)){
                if(tweets.get(followee) != null){
                    pq.add(tweets.get(followee));
                }
            }
        }

        while(ans.size() < 10 && !pq.isEmpty()){
            Tweet curr = pq.poll();
            ans.add(curr.tweetId);
            if(curr.next != null){
                pq.add(curr.next);
            }
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return ;
        if(map.containsKey(followerId)){
            Set<Integer> set = map.get(followerId);
            set.add(followeeId);
        }
        else{
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            map.put(followerId, set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        
        Set<Integer> set = map.get(followerId);
        if(set != null){
            set.remove(followeeId);
        }
        
    }
}