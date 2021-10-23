package Week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Lee
 * @version: v1.0
 * @package: Week3
 * @description: Leecode 210 课程表2
 * @date: 2021/10/23
 * @time: 6:13 下午
 * @link(https://leetcode-cn.com/problems/course-schedule-ii/)
 */
public class Curriculum2 {

    private int[] inDeg;
    private int[] result;
    private ArrayList<ArrayList<Integer>> to = new ArrayList();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        inDeg = new int[numCourses];
        result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            inDeg[i] = 0;
            to.add(new ArrayList<Integer>());
        }
        //初始化出边数组
        for (int[] p : prerequisites) {
            int ca = p[0];
            int cb = p[1];
            to.get(cb).add(ca);
            inDeg[ca]++;
        }
        Queue<Integer> q = new LinkedList();
        //将所有入度为0的存储入队
        for (int i = 0; i < numCourses; i++)
            if (inDeg[i] == 0) q.add(i);
        int index = 0;
        while (!q.isEmpty()) {
            int x = q.peek();
            q.poll();
            result[index++] = x;
            for (int y : to.get(x)) {
                inDeg[y]--;
                //没有入度，表示可以入队
                if (inDeg[y] == 0) {
                    q.add(y);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }

}
