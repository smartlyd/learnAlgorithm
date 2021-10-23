package com.lee.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

/**
 * @author: Lee
 * @version: v1.0
 * @package: com.lee.learn
 * @description: TODO
 * @date: 2021/10/13
 * @time: 9:03 下午
 */
public class Chapter2 {


    private HashMap<Integer, Integer> map = new HashMap();

    public int[] twoSum(int[] nums, int target) {
        int[] resu = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                resu[0] = map.get(target - nums[i]);
                resu[1] = i;
                return resu;
            }
            map.put(nums[i], i);
        }
        return resu;

    }

    private HashSet<Long> set = new HashSet();

    public int robotSim(int[] commands, int[][] obstacles) {
        //把障碍物用hashset存储
        //初始化方向数组
        int dx[], dy[];
        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{1, 0, -1, 0};
        for (int[] o : obstacles) {
            set.add(calcHash(o));
        }
        int x = 0, y = 0;
        // N = 0, E = 1, S = 2, W = 3
        int dir = 0;

        int ans = 0;
        for (int com : commands) {
            if (com == -1) {
                //右转
                dir = (dir + 1) % 4;
            } else if (com == -2) {
                //左转
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < com; i++) {
                    //  1<com <9 移动
                    int nextX = x + dx[dir];
                    int nextY = y + dy[dir];
                    int next[] = new int[2];
                    if (set.contains(next)) {
                        break;
                    }
                    x = x + nextX;
                    y = y + nextY;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }

    HashMap<String, List<String>> temMp = new HashMap<>();

    private Long calcHash(int[] ora) {
        String str = "";
        for (String key : temMp.keySet()) {

        }
        String substring = str.substring(0, 1);
        return (ora[0] + 30000) * 60001L + ora[1];
    }

    private String sort(String str) {
        char[] ar = str.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }


    private Map<String, Integer> wordsMap = new HashMap();

    public List<Integer> findSubstring(String s, String[] words) {
        int total = 0;
        int wordCount = 0;
        for (String word : words) {
            total += word.length();
            wordsMap.put(word, wordCount++);
        }
        List<Integer> ans = new ArrayList();
        for (int i = 0; i + total < s.length(); i++) {
            if (valid(s.substring(i, total), words)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean valid(String str, String[] words) {
        int k = words[0].length();
        Map<String, Integer> splitMap = new HashMap();
        int count = 0;
        for (int i = 0; i < str.length(); i += k) {
            splitMap.put(str.substring(i, k), count++);
        }
        return equalsMap(splitMap, wordsMap);
    }

    private boolean equalsMap(Map<String, Integer> target, Map<String, Integer> ori) {
        for (String key : target.keySet()) {
            int value = target.get(key);
            if (!ori.containsKey(key) || ori.get(key) != value) return false;
        }
        for (String key : ori.keySet()) {
            int value = ori.get(key);
            if (!target.containsKey(key) || target.get(key) != value) return false;
        }
        return true;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> jks = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> jk : jks) {
                List<Integer> res = new ArrayList();
                res.add(nums[i]);
                res.add(jk.get(0));
                res.add(jk.get(1));
                ans.add(res);
            }
        }
        return ans;
    }


    public List<List<Integer>> twoSum(int[] numbers, int start, int target) {
        List<List<Integer>> ans = new ArrayList();
        int j = numbers.length - 1;
        for (int i = start; i < numbers.length; i++) {
            if (i > start && numbers[i] == numbers[i - 1]) continue;
            while (i < j && numbers[i] + numbers[j] > target) j--;
            if (i < j && numbers[i] + numbers[j] == target) {
                List<Integer> res = new ArrayList();
                res.add(numbers[i]);
                res.add(numbers[j]);
                ans.add(res);
            }
        }
        return ans;

    }


    private HashMap<Integer, List<String>> resultMap = new HashMap();
    Queue<Pair<Integer,List<Integer>>> queue = new LinkedList();
    public List<String> generateParenthesis(int n) {
        if( n == 0) return null;
        //结果记录map,如果此n 已经计算过，则直接返回结果
        if(resultMap.containsKey(n)){
            return resultMap.get(n);
        }

        Pair<Boolean,Boolean> result = new Pair<>(false,false);
        List<String>  resu = new ArrayList();
        for(int k =1;k<n;k++){
            // 假设n 个数可以输出s种组合 以一个完整括号包裹某个x 为标记进行拆分
            // 则s = （X） + b
            List<String> X = generateParenthesis(k-1);
            List<String> b = generateParenthesis(n-k);
            for(String x: X ){
                for(String y: b)
                    resu.add("("+x +")" + y);
            }
        }

        resultMap.put(n,resu);
        return resu;
    }
}
