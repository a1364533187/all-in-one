package com.bigcow.cn.code.shopee.design_code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DesignTwitter355Solution {

    /**
     * user-tweet Map
     */
    Map<Integer, LinkedList<Tweet>> userTweetMap;

    /**
     * 关注用户Map
     */
    Map<Integer, LinkedHashSet<Integer>> followMap;

    int count = 0;

    public DesignTwitter355Solution() {
        userTweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    /**
     * 发布最新的tweet， 则发布到链表首节点
     * @param userId
     * @param tweetId
     */
    public void postTweet(int userId, int tweetId) {
        LinkedList<Tweet> tweets = userTweetMap.getOrDefault(userId, new LinkedList<>());
        count++;
        Tweet tweet = new Tweet(tweetId, count);
        // 插入如何快速有序
        tweets.addFirst(tweet);
        userTweetMap.put(userId, tweets);
    }

    /**
     * 读时合并, 合并K个有序Tweet 列表
     * @param userId
     * @return
     */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Tweet> res = new LinkedList<>();
        LinkedList<Tweet> userTweets = userTweetMap.getOrDefault(userId, new LinkedList<>());
        res.addAll(userTweets);
        LinkedHashSet<Integer> followeeIdSet = followMap.getOrDefault(userId,
                new LinkedHashSet<>());
        for (int followeeId : followeeIdSet) {
            res.addAll(userTweetMap.getOrDefault(followeeId, new LinkedList<>()));
        }
        res.sort(new Comparator<Tweet>() {

            @Override
            public int compare(Tweet o1, Tweet o2) {
                Long diff = o2.timestamp - o1.timestamp;
                return diff.intValue();
            }
        });
        // 按照Tweet timestap 降序合并 LinkedList<Tweet> userTweets
        List<Integer> tweetRes = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            tweetRes.add(res.get(i).getTweetId());
        }
        return tweetRes;
    }

    /**
     * 建立follower - followee Map
     * @param followerId
     * @param followeeId
     */
    public void follow(int followerId, int followeeId) {
        LinkedHashSet<Integer> followeeIdSet = followMap.getOrDefault(followerId,
                new LinkedHashSet<>());
        followeeIdSet.add(followeeId);
        followMap.put(followerId, followeeIdSet);
    }

    public void unfollow(int followerId, int followeeId) {
        LinkedHashSet<Integer> followeeIdSet = followMap.getOrDefault(followerId,
                new LinkedHashSet<>());
        followeeIdSet.remove(followeeId);
    }

    class Tweet {

        int tweetId;
        long timestamp;

        public Tweet(int tweetId, long timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }

        public int getTweetId() {
            return tweetId;
        }

        public void setTweetId(int tweetId) {
            this.tweetId = tweetId;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }

    /**
     *     ["Twitter","postTweet","postTweet","unfollow","follow","getNewsFeed"]
     *             [[],[1,4],[2,5],[1,2],[1,2],[1]]
     *
     * [null,null,null,null,null,[5,4]]
     */
    public static void main(String[] args) {
        DesignTwitter355Solution twitter = new DesignTwitter355Solution();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
        twitter.unfollow(1, 2);
        twitter.follow(1, 2);
        List<Integer> res = twitter.getNewsFeed(1);
        System.out.println(res);
    }
}
