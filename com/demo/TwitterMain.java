package com.demo;

import java.util.*;

class Twitter {
    Map<Integer, User> mp;
    static int timeStamp = 0;

    private class User {
        int id;
        Tweet th;
        Set<Integer> followedUsers;

        public User(int id) {
            this.id = id;
            this.th = null;
            this.followedUsers = new HashSet<>();
            this.followedUsers.add(id);
        }

        private void follow(int id) {
            this.followedUsers.add(id);
        }

        private void unfollow(int id) {
            this.followedUsers.remove(id);
        }

        private void postTweet(int id) {
            if(this.th != null) {
                Tweet t = th;
                while(t.next != null) {
                    t = t.next;
                }
                t.next = new Tweet(id);
            }
            else {
                th = new Tweet(id);
            }
        }

        private void followUser(int userId) {
            this.followedUsers.add(userId);
        }

        private void unfollowUser(int userId) {
            this.followedUsers.remove(userId);
        }

    }

    private class Tweet {
        int id;
        Tweet next;
        int time;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp;
            timeStamp++;
            this.next = null;
        }
    }



    public Twitter() {
        mp = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        //Check if user exists
        if(mp.containsKey(userId)) {
            mp.get(userId).postTweet(tweetId);
        }
        else {
            mp.put(userId, new User(userId));
            mp.get(userId).postTweet(tweetId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(mp.size()+1, (a, b) -> b.time - a.time);
        List<Integer> liRet = new ArrayList<>();
        //Check if user exists
        if(!mp.containsKey(userId)) {
            return new ArrayList<>();
        }
        else {
            Set<Integer> st = mp.get(userId).followedUsers;
            for(int s : st) {
                User u = mp.get(s);
                Tweet th = null;
                if(null != u)
                    th = u.th;
                if(null != th)
                    pq.add(th);
            }
            int n = 10;
            while(!pq.isEmpty() && n >= 0) {
                Tweet t = pq.poll();
                liRet.add(t.id);
                while(t.next != null) {
                    liRet.add(t.next.id);
                    pq.add(t.next);
                    t = t.next;
                }
                n--;
            }
        }
        return liRet;
    }

    public void follow(int followerId, int followeeId) {
        //Check if user exists
        if(mp.containsKey(followerId)) {
            mp.get(followerId).followUser(followeeId);
        }
        else {
            mp.put(followerId, new User(followerId));
            mp.get(followerId).followUser(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        //Check if user exists
        if(mp.containsKey(followerId)) {
            mp.get(followerId).unfollowUser(followeeId);
        }
        else {
            mp.put(followerId, new User(followerId));
            mp.get(followerId).unfollowUser(followeeId);
        }
    }
}

public class TwitterMain {
    public static void main(String[] args) {
          Twitter obj = new Twitter();
          obj.postTweet(1,5);
          obj.postTweet(1,3);
          obj.getNewsFeed(1);

    }
}
