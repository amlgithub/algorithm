package day_0330;

/**
 * @author aml
 * @date 2021/3/30 16:51
 */
public class A_03_75_颜色分类 {

    /**
     * 三路快排：分为三部分{【0.。。0】【1.。。1】【2.。。2】}
     * o(n),o(1)
     * 遍历一边
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int zero = -1;          //nums[0...zero] == 0
        int two = nums.length; //nmus[two...n-1] == 2
        for (int i = 0; i< two;){
            if (nums[i] == 1){
                i++;
            }else if (nums[i] == 2){
                two--;
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            }else {
                assert (nums[i] == 0);
                zero++;
                swap(nums,i,zero);
                i++;
//                zero++;
//                swap(nums,i,zero);
            }
        }
    }

//    交换函数
    public static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    /**
     * 1. 统计出此三个值的个数
     * 2. 按照要求顺序进行赋值
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] count = new int[3];//初始三个值的统计都为0
        for (int i = 0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int index = 0;
        for (int i=0;i<count[0];i++){
            nums[index++] = 0;
        }
        for (int i=0;i<count[1];i++){
            nums[index++] = 1;
        }
        for (int i=0;i<count[2];i++){
            nums[index++] = 2;
        }
    }

}
