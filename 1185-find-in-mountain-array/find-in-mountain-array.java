/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;     
            } else {
                right = mid;      
            }
        }
        int peak = left;
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index; // This is guaranteed to be the minimum index.
        }
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }
    private int binarySearch(
            MountainArray mountainArr,
            int target,
            int left,
            int right,
            boolean ascending
    ) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);
            if (value == target) {
                return mid;
            }
            if (ascending) {
                if (value < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (value < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}