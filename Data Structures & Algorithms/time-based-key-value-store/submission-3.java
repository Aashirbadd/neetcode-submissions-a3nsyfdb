class TimeMap {
    HashMap<String, List<Integer>> tMap;
    HashMap<String, List<String>> vMap;

    public TimeMap() {
        this.tMap = new HashMap<>();
        this.vMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (vMap.containsKey(key)) {
            this.vMap.get(key).add(value);
            this.tMap.get(key).add(timestamp);
        } else {
            List<Integer> times = new ArrayList<Integer>(List.of(timestamp));
            this.tMap.put(key, times);

            List<String> values = new ArrayList<String>(List.of(value));
            this.vMap.put(key, values);
        }
    }
    
    public String get(String key, int timestamp) {
        // Assume the time and value map are in ascending order
        if (!vMap.containsKey(key)) return "";

        List<Integer> times = this.tMap.get(key);
        List<String> values = this.vMap.get(key);

        int l = 0;
        int r = times.size() - 1;
        int closest = -1;
        while (l <= r) {
            int mid = (r + l)/2;

            if (times.get(mid) == timestamp) { 
                return values.get(mid);
            }
            else if (times.get(mid) < timestamp) { 
                closest = Math.max(closest, mid);
                l = mid + 1;
            }
            else { 
                r = mid - 1;
            }
        }
        // System.out.printf("closest:%d key:%s timestamp:%d\n",closest,key,timestamp);
        if (closest >= 0) return values.get(closest);
        else return "";
    }
}

// Implement a time based key-value data structure that supports:
    // 1. Storing multiple value of the same key at specified time stamps
    // 2. Retrieving a key at a specified timestamp

// Hashmap within a hashmap?
    // HashMap<Key,int[timestamp][value]>

// What's the main thing/challenge that we need to address?
// 1. How to store the timestamp,value array.
// Sorted ovbs, but O(1) time for set, and log(n) time for get means bs
// But how to insert in O(1) time, that's the challenge
// [1:val, 3:val, 6:val]
// If I insert 4:val, how do I insert it in O(1) time inside such an array?
// I have no clue bro tbh. I think looking at the solution is wise here.

// I didn't read this, but all calls to set are strictly in increasing order
// LEL. That's a reminder to focus, and read the question in its entirety. 

// TimeMap() creates the object
// set() stores the key, value, and timestamp
// get() returns the most recent value of key if set was preiously called on it
    // AND and the most recent timestamp for that key prev_timestamp <= inputted timestamp
    // prev_timestamp <= timestamp, if there are no values, return "".
    // What do they mean most recent latest entry <= timestamp.
