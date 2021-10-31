package Week4;

/**
 * @author: Lee
 * @version: v1.0
 * @package: Week4
 * @description: TODO
 * @date: 2021/10/31
 * @time: 4:02 下午
 */
public class Week4Main {

    public static void main(String[] args) {
        System.out.println("start");

        ConvertBSTTOGreaterTree convertBSTTOGreaterTree = new ConvertBSTTOGreaterTree();
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] borad = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        surroundedRegions.solve(borad);
    }
}
