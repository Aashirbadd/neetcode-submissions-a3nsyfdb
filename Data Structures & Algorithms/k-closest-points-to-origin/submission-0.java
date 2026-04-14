class Solution {
    private int distToOrigin(Integer[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int x2 = 0;
        int y2 = 0;

        // sqrt((x1 - x2)^2 + (y1 - y2)^2);
        return (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer[]> q = new PriorityQueue<>(
            // (a,b) if dist(a) > dist(b)
            (a,b) -> this.distToOrigin(b) - this.distToOrigin(a)
        );

        for (int[] point: points) {
            q.add(new Integer[]{point[0], point[1]});
            if (q.size() > k) q.poll();
        }

        int[][] output = new int[k][2];
        for (int i = 0; i < k; i++) {
            output[i][0] = q.peek()[0];
            output[i][1] = q.peek()[1];
            q.poll();
        }

        return output;
    }
}

// K closest points to an origin.
// Input: Input: points = [[0,2],[2,2]], k = 1
    // points ~ Coordinates on 2d plane
    // k ~ integer

// Formula of dist between 2 points = sqrt((x1 - x2)^2 + (y1 - y2)^2))

// Idea: Store the k points closest to the origin, and return them
// Use a maxheap of size k, sorted based on distance to origin.
// We want the maximum value at root, and add only lower values.