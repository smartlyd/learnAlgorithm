package com.lee.learn.Week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Lee
 * @version: v1.0
 * @package: com.lee.learn.Chapter2
 * @description: 第二周作业入口
 * @date: 2021/10/17
 * @time: 3:57 下午
 */
public class Week2Main {
    public static void main(String[] args) {
        System.out.println("------start--------");
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));

        int[] degree = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(degree));
    }

    //560. 和为 K 的子数组
    public static int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和 ，初始化下标0 个数1
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            // 先获得前缀和为 sum - k 的个数，加到计数变量里
            if (map.containsKey(sum - k)) {
                //取到对应元素。count +
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    /**
     * leetcode  697. 数组的度
     * @param nums
     * @description: ????滑动窗口？
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        int l = 0, r = 0, len = nums.length, res = len + 1;
        Map<Integer, Integer> map = new HashMap<>();
        int maxDegree = getDegree(nums);
        while (r < len) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            r++;
            while (map.get(nums[r - 1]) == maxDegree) {
                map.put(nums[l], map.get(nums[l]) - 1);
                res = Math.min(res, r - l);
                l++;
            }
        }
        return res;
    }

    /**
     * 找到数组的度 即找到出现频次最高的数
     * @param nums
     * @return
     */
    public static int getDegree(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            res = Math.max(res, map.get(i));
        }
        return res;
    }

}
