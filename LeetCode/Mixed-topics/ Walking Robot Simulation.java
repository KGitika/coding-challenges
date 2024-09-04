import java.util.HashSet;
import java.util.Set;

//  Includes arrays, hashset, and simulation
// Time complexity: O(m+n);
// Space complexity: O(n);


class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Define direction vectors: North, East, South, West
        int[] dir_X = new int[] { 0, 1, 0, -1 };
        int[] dir_Y = new int[] { 1, 0, -1, 0 };
        
        // Store obstacles in a HashSet
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }

        int res = 0;
        int x = 0, y = 0;  // Corrected: Added semicolon
        int d = 0;  // 0: North, 1: East, 2: South, 3: West

        for (int command : commands) {
            if (command == -1) {  // Turn right
                d = (d + 1) % 4;
            } else if (command == -2) {  // Turn left
                d = (d + 3) % 4;  // Corrected: Changed +3 to +3
            } else {  // Move forward
                for (int i = 1; i <= command; i++) {
                    // Calculate next position
                    int nextX = x + dir_X[d];
                    int nextY = y + dir_Y[d];
                    
                    // Check if next position is an obstacle
                    if (!set.contains(nextX + " " + nextY)) {
                        x = nextX;
                        y = nextY;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, x * x + y * y);  // Calculate the maximum Euclidean distance
            }
        }
        return res;
    }
}

