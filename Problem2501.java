package leetcode;

import java.util.Set;
import java.util.HashSet;

public class Problem2501 {
	public int longestSquareStreak(int[] nums) {
		int longestStreak = 0;
		
		//create a set to store all unique numbers from an input array
		Set<Integer> uniqueNums = new HashSet<>();
		
		for(int num : nums){
            uniqueNums.add(num);
        }
		
		//iterate through each number in the input array
		for(int startNumber : nums) {
			int currentStreak = 0;
			long current = startNumber;
			
			//iterate through each number as we find the next square
			//in the set
			
			while(uniqueNums.contains((int)current)){
				currentStreak++;
				//break if the next square would be larger than 10^5 (problem constraint)
                if(current * current > 1e5) break;
                
                current *= current;
			}
			longestStreak = Math.max(currentStreak, longestStreak);
		}
		
		//return -1 if no valid streak found, otherwise return the longest streak
        return longestStreak <2 ? -1 : longestStreak;
	}
	public static void main(String[] args) {
		Problem2501 prob = new Problem2501();
		int[] nums = {4,3,6,16,8,2};
		
		System.out.println(prob.longestSquareStreak(nums));
	}
}
