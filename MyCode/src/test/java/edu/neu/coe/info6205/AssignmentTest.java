package edu.neu.coe.info6205;

import org.junit.Test;

public class AssignmentTest {
    @Test
    public void test(){
        int[] input ={-1,0,1,0,3,-3};
        System.out.println(threeSum(input));
    }

    public static int threeSum(int[] nums){
        int count=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                for(int k=j+1;k<length;k++){
                    if(nums[i]+nums[j]+nums[k]==0)
                        count++;
                }
            }
        }
        return count;
    }
}
