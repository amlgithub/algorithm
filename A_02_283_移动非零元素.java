package day_0330;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aml
 * @date 2021/3/30 13:44
 */
public class A_02_283_移动非零元素 {
    /**
     * 直接将0和非0进行交换
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int k = 0;//指针，指向0元素
        for (int i = 0;i<nums.length;i++){
            if (nums[i] != 0 ){
                if (i != k){ //当指针指示的两个元素不是同一个元素时，才会进行交换
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                    k++;
                }else {
                    k++;
                }

            }
        }
    }



    /**
     * 不使用辅助空间，设置【0~k)为非零元素
     * 1. 从头开始遍历，非零元素和第一个零元素进行位置交换
     * 2. 将所有非零元素移到【0~k）后，将后面k~n元素至为零
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int k = 0; //[0...k)的元素均为非0
        for (int i =0 ;i<nums.length;i++){
            if (nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }
        for (int j = k; j < nums.length;j++){
            nums[j] = 0;
        }

    }



    /**
     * 1. 新建一个数组 arr2
     * 2. 将原数组非零元素放置到arr2
     * 3. 将list中的元素放置回arr中
     * 4. 将剩下的元素设置为0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<nums.length;i++){
            if (nums[i] != 0){
                list.add(nums[i]);
            }
        }

        for (int j = 0; j < list.size(); j++){
            nums[j] = list.get(j);
        }

        for (int k = list.size(); k < nums.length; k++){
            nums[k] = 0;
        }

    }

}
