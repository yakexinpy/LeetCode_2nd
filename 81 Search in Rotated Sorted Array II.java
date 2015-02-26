public class Solution {
    public boolean search(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(A[mid] == target) return true;
            if(A[mid] > A[l]){
                if(target >= A[l] && target < A[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            else if(A[mid] < A[l]){
                if(A[r] >= target && A[mid] < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            else l++;
        }
        return false;
    }
}
