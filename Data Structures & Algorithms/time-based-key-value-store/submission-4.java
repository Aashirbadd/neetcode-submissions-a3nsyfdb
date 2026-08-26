class TimeMap {
    // Better yet to have a class with both string list and integerList... but for now..
    HashMap<String, List<String>> wordMap;
    HashMap<String, List<Integer>> timeMap;

    public TimeMap() {
        wordMap = new HashMap<>();
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<String> wordList = wordMap.getOrDefault(key, new ArrayList<String>());
        wordList.add(value);
        wordMap.put(key, wordList);

        List<Integer> timeList = timeMap.getOrDefault(key, new ArrayList<Integer>());
        timeList.add(timestamp);
        timeMap.put(key, timeList);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        List<Integer> timeList = timeMap.get(key);

        int l = 0, r = timeList.size() - 1;

        // Find a value <= timestamp
        int index = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (timeList.get(mid) == timestamp) {
                index = mid;
                break;
            }
            else if (timeList.get(mid) < timestamp) {
                index = mid;
                l = mid + 1;
                // Keep searching for a closer match
            }
            else {
                // Search left
                r = mid - 1;
            }
        }
        if (index == -1) return "";
        else return wordMap.get(key).get(index);
    }
}

// Design a time based key-value store that can store multiple values for the same key
// at different time stamps, and retrieve the key's value at a certian timestamp.

// The main difference from this and a normal hashmap is that this allows you to 
// also store timestamps, and it's not just a key -> value, it's key, timestamp, value

// Timemap() just inits

// set -> Stores key, value, timestamp
// Get -> Returns the value that was most recently set with timestamp <= timestamp, if there are no values it returns ""

// Big O constraints?
// O(lon(n) for get) ... okay... And I assume only incrementing timestamps can be stored?
// Yes -> All timestamps of Set are strictly increasing!
// Simple then arrayList!