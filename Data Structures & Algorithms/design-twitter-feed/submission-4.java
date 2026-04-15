class Twitter {
    // FollowerID --> Followee
    // Follow Up, what if tweetID is not based on timestamp
    private int time = 0;
    private HashMap<Integer, Set<Integer>> follows; // Follower -> Followee
    private HashMap<Integer, List<Integer>> tweets; // UserID -> TweetID
    private HashMap<Integer, Integer> timeStamp;    // TweetID -> timeStamp

    public Twitter() {
        this.follows = new HashMap<>();
        this.tweets = new HashMap<>();
        this.timeStamp = new HashMap<>();
    }
    
    // Tweets are simply hashmap with int userID, List(tweetID)
    // O(1)
    public void postTweet(int userId, int tweetId) {
        List<Integer> tweetList = tweets.getOrDefault(userId, new ArrayList<>());
        tweetList.add(tweetId);
        timeStamp.put(tweetId, time++);
        tweets.put(userId, tweetList);
    }
    
    // O(nlog(10)) --> Sort that means...
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> q = new PriorityQueue<>(
            // a is smaller (oldest time at root)
            (a,b) -> timeStamp.get(a) - timeStamp.get(b)
        );
        Set<Integer> following = follows.getOrDefault(userId, new HashSet<>());
        following.add(userId);
        for (int user: following) {
            // Add all thier tweets to the priorityqueue
            List<Integer> tweetList = tweets.getOrDefault(user, new ArrayList<>());
            for (int tweet : tweetList) {
                q.add(tweet);
                if (q.size() > 10) q.poll();
            }
        }

        LinkedList<Integer> output = new LinkedList<>();
        while (!q.isEmpty()) {
            // Allows us to add as first element, so we have in descending order.
            output.addFirst(q.poll());
        }
        return output;
    }
    
    // O(1) Time, O(n) space
    public void follow(int followerId, int followeeId) {
        Set<Integer> followSet = follows.getOrDefault(followerId, new HashSet<>());
        followSet.add(followeeId);
        follows.put(followerId, followSet);
    }
    // O(1) Time, O(1) space
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followSet = follows.getOrDefault(followerId, new HashSet<>());
        followSet.remove(followeeId);
        follows.put(followerId, followSet);
    }
}

// Implement a simplified version of twitter which allows users to:
    // 1. Post tweets
    // 2. Follow/unfollow each other
    // 3. View the recent 10 tweets within their news feed

// PostTweet: userId, tweetId
    // We can simply use both as a form of ID (hashmap)
// GetNewsFeed: (userId)
    // Returns 10 recent tweets that either the user or the people they followed posted
    // Priority queue sorted on posttime (tweetID will be based on time)
// follow (followerId, followedID)
    // Hashmap (for each followed show who follows them)
// unfollow (simple remove operation)


