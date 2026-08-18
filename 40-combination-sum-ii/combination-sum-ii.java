class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] a, int target) {
        Arrays.sort(a);
        backtrack(a, target, 0, new ArrayList<>());
        return ans;
    }
    void backtrack(int[] a, int target, int start, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < a.length && a[i] <= target; i++) {
            if (i > start && a[i] == a[i - 1]) continue;
            list.add(a[i]);
            backtrack(a, target - a[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}