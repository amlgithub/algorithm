package day_0330;

/**
 * leetcode 练习题：
 * 125、344 、345 、11
 * @author aml
 * @date 2021/4/3 20:49
 */
public class A_04_167_两数之和 {


    /**
     * o(n)
     * 对撞指针 方法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length-1;
        while ((l < r)){
            if (numbers[l] + numbers[r] < target){
                l++;
            }else if (numbers[l] + numbers[r] > target){
                r--;
            }else {
                res[0] = l+1;
                res[1] = r + 1;
                break;
            }
        }
        return  res;
    }
}
