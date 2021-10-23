package Week3;

/**
 * @author: Lee
 * @version: v1.0
 * @package: Week3
 * @description: 第三周课程入口
 * @date: 2021/10/23
 * @time: 6:13 下午
 */
public class Week3Main {

    public static void main(String[] args) {


        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        InorderAndPostorder or = new InorderAndPostorder();
        or.buildTree(inorder, postorder);

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        Curriculum2 c = new Curriculum2();
        c.findOrder(numCourses,prerequisites);
    }
}
