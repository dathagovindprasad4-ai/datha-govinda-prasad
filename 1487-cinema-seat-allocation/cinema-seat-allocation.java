class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reserved = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            reserved
                .computeIfAbsent(row, k -> new HashSet<>())
                .add(col);
        }
        int answer = (n - reserved.size()) * 2;
        for (Set<Integer> seats : reserved.values()) {

            boolean left = true;   // seats 2-5
            boolean middle = true; // seats 4-7
            boolean right = true;  // seats 6-9
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    left = false;
                    break;
                }
            }
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    middle = false;
                    break;
                }
            }
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    right = false;
                    break;
                }
            }
            if (left && right) {
                answer += 2;
            } else if (left || middle || right) {
                answer += 1;
            }
        }
        return answer;
    }
}