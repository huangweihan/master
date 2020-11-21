package com.han.algorithm.example;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// 三数之和为0-找出所有满足条件且不重复的三元组。
public class getThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Set<List<Integer>> result1 = method1(nums);
        Set<List<Integer>> result2 = method2(nums);
        System.out.println(result1);
        System.out.println("------------------------");
        System.out.println(result2);
    }

    // 暴力求法
    private static Set<List<Integer>> method1(int[] nums) {
        if (nums.length < 2){
            return null;
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if ((nums[i] + nums[j]) == -nums[k]){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return result;
    }

    // 双指针法
    private static Set<List<Integer>> method2(int[] nums){
        if (nums.length < 2){
            return null;
        }
        Arrays.sort(nums);
        int aIndex;
        int bIndex;
        int cIndex;
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            aIndex = i;
            bIndex = i + 1;
            cIndex = nums.length - 1;
            while (cIndex > bIndex){
                if (-nums[aIndex] == nums[bIndex] + nums[cIndex]){
                    result.add(Arrays.asList(nums[aIndex], nums[bIndex], nums[cIndex]));
                    break;
                } else if(-nums[aIndex] > nums[bIndex] + nums[cIndex]){
                    ++bIndex;
                } else {
                    --cIndex;
                }
            }
        }
        return result;
    }
}
