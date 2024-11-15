package leetcode;

import java.util.Arrays;

public class Problem2563{
	public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        int start =0, end = nums.length-1;
        while(start<=end) {
        	int count = 0;
	        while(nums[start] + nums[end]> upper && end > start) {
	    		end--;
	    	}
	        
	        int mid = (start + (end-start))/2;
	        
	        while(nums[start] + nums[mid] >= lower && mid > start) {
	        	mid--;
	        	
	        	
	        }
	        ans+= (end-mid);
	        start++;
        }
        
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,7,9,2,5};
        int lower = 11;
        int upper = 11;
        Problem2563 tester= new Problem2563();
        System.out.println(tester.countFairPairs(nums, lower, upper));
        
	}

}
