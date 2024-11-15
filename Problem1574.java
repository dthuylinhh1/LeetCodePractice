package leetcode;

/* Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements 
 * in arr are non-decreasing.

* Return the length of the shortest subarray to remove.

* A subarray is a contiguous subsequence of the array.*/
public class Problem1574 {
	
	public int findLengthOfShortestSubarray(int[] arr) {
		int ans = 0;
		int right = arr.length-1;
		 
		
		//#1 we need to find the prefix to remove
		//means the longest non-decreasing array from the end
		while(right > 0 && arr[right-1] <= arr[right]) {
			right -=1;
		}
		
		ans = right;
		
		
		//#2 we need to calculate the postfix to remove
		// l          r
		//[1,2,3,10,9,1,2,3]
		
		int left = 0;
		
		while(left < right) {
			
			//Expand the invalid window
			while(right < arr.length && arr[left] > arr[right]) {
				right+=1;
			}
			ans = Math.min(ans, right - left -1);
			
			if(arr[left] > arr[left+1]) {
				break;
			}
			
			left+=1;
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,10,4,2,3,5};
		
		Problem1574 test = new Problem1574();
		
		System.out.println(test.findLengthOfShortestSubarray(arr));
	}
}
