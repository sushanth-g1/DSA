package com.dsa.learning.arrays;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int element = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0;i<nums.length;i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            }else if(element == nums[i]){
                count++;
            }else{
                count --;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
