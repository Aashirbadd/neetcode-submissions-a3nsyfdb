class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        for (char task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            // a is before b if a is larger than b. (largest at root)
            (a,b) -> b-a
        );
        // Also try value.
        for (char key : frequency.keySet()) {
            maxHeap.add(frequency.get(key));
        }

        // Queue for cooldown, [frequency, timeWhenFreed]
        LinkedList<int[]> q = new LinkedList<>();

        // Now the meat of the actual algorithm
        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            // Increment time (this is the curr time that a CPU task will be implemented)
            time += 1;
            // Take tasks out of cooldown if permitted
            while (!q.isEmpty() && time > q.peek()[1]) { 
                maxHeap.add(q.poll()[0]);
            }
            // EDGECASE when we can use no current task, and we will be idle instead
            if (maxHeap.isEmpty())  continue;
            // Curr task to process (now -1) because they will be processed now
            int currTask = maxHeap.poll() - 1;
            // Put it in cooldown if there are some remaining
            if (currTask > 0) q.add(new int[] {currTask, time + n});
            // Debug
            // System.out.printf("CurrElement: %d, CurrTime: %d, n: %d \n", currTask, time, time+n);
        }
        return time;
    }
}

// Input: char[] tasks = ["X","X","Y","Y"], int n = 2
    // tasks ~ cpu tasks (task[i] = uppercase letter)
    // n ~ identical tasks must be seperated by n cpu cycles to cooldown the CPU

// Goal: Return the minimum CPU cycles to complete all tasks.

// Visualise:
    // Input: tasks = ["X","X","Y","Y"], n = 2

    // ["X","Y",IDLE,"X","Y"]
    // This will require a frequency map.
    // The tasks with the highest frequencies should be placed first, and ones with lower
    // frequencies should be placed in between.

    // Output: 5

    // Input: tasks = ["A","A","A","B","C"], n = 3
    // [A,B,C,BREAK,A,BREAK,BREAK,BREAK,A]
    // For just A's (9)
    // For just B(1)
    // For just C(1)
    // Output: 9


    // Input: tasks = [A,A,A,B,B,B], n = 3

    // [A,B,BREAK,BREAK,A,B,BREAK,BREAK,A,B]
    // Output = 10
    // I have no clue.

    // Frequency Map, MaxHeap (For most frequent task first)
    // After selecting it, we must make sure it's not processed again for another n seconds
    // (How to enforce cooldown)? Idk.
    // You can have a queue to maintain the order of processed tasks.
        // Idk how we'd use a queue? or why
        // I'm thinking use an array or arraylist, and track the last index or something.
        // Got it, the queue is used to store the tasks that we can't use yet
        // because it's in cooldown. Essentially either a task is in maxheap, or q
        // Maxheap shows us the preferred task to use, the q tells us which one we need
        // to wait until a certian time to use. Once we have those things decided, we can
        // get the job done and solve the problem.

