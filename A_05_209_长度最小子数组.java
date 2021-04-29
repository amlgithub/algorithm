package day_0330;

/**
 * @author aml
 * @date 2021/4/3 21:08
 */
public class A_05_209_长度最小子数组 {

    /**
     * o(n)、o(1)
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = -1; //nums[l...r]为我们的滑动窗口，初始窗口无值，因此r=-1;
        int sum = 0; //子数组的和
        int res = nums.length + 1; //初始值不可能取到

        while (l < nums.length){
            if (r +1 < nums.length && sum < target){ // 如果子数组的和小于 目标值，则窗口右边移动
                r++; //移动右边窗口
                sum = sum + nums[r];  // 只要有[]，就需要注意越界问题
            }else {  // 如果子数组的和 大于等于  目标值，则获取了一个窗口
                sum = sum - nums[l];
                l++;
            }

//            对比获取最小的窗口长度
            if (sum >= target){
                res = Math.min(res, r-l+1);
            }
        }
        //如果没有解时
        if (res == nums.length + 1){
            return 0;
        }
        return res;
    }

}
