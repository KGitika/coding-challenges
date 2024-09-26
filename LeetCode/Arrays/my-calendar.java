// Problem: My Calendar I
// URL: https://leetcode.com/problems/my-calendar-i/


//Brute Force Approach-
    // Time complexity: O(N^2);
    // Space Complexity: O(N);


  public class MyCalendar {
    List<int[]> calendar;

    MyCalendar() {
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1]) {
                return false;
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
  }





// Optimized(Sorted List + Binary Search)-
    // Time Complexity: O(NlogN);
    // Space Complexity: O(N);

class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}