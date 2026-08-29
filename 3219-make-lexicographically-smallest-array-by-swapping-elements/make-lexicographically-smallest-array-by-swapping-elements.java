class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length; 
        int arr[][] = new int[n][2]; 
        for(int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; 
            arr[i][1] = i; 
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0])); 
        List<Integer> idxGrp = new ArrayList<>(); 
        int left = 0; 
        idxGrp.add(arr[0][1]); 
        for(int right = 1; right < n; right++) {
            if(arr[right][0] - arr[right-1][0] <= limit) {
                idxGrp.add(arr[right][1]); 
            } else {
                Collections.sort(idxGrp);
                for(int k = 0; k < idxGrp.size(); k++) {
                    nums[idxGrp.get(k)] = arr[left++][0]; 
                }
                idxGrp.clear(); 
                idxGrp.add(arr[right][1]); 
            }
        }
        Collections.sort(idxGrp); 
        for(int k = 0; k < idxGrp.size(); k++) {
            nums[idxGrp.get(k)] = arr[left++][0]; 
        }
        return nums; 
    }
    public int[] lexicographicallySmallestArray1(int[] nums, int limit) {
        int arr[] = nums.clone(); 
        int n = nums.length; 
        Arrays.sort(arr); 
        int idx = 1; 
        HashMap<Integer, Deque<Integer>> grp = new HashMap<>(); 
        HashMap<Integer, Integer> grpId = new HashMap<>(); 
        grp.put(idx, new ArrayDeque<>()); 
        grp.get(idx).addLast(arr[0]); 
        grpId.put(arr[0], idx); 
        for(int i = 1; i < n; i++) {
            if(arr[i] - arr[i - 1] <= limit) {
                grp.get(idx).addLast(arr[i]); 
            } else {
                idx++; 
                grp.put(idx, new ArrayDeque<>()); 
                grp.get(idx).addLast(arr[i]); 
            }
            grpId.putIfAbsent(arr[i], idx); 
        }
        for(int i = 0; i < n; i++) {
            int id = grpId.get(nums[i]); 
            nums[i] = grp.get(id).pollFirst(); 
        }
        return nums; 
    }
}