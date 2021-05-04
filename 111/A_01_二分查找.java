package day_0330;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author aml
 * @date 2021/3/30 12:35
 */
public class A_01_二分查找 {

    /**
     * 二分查找，在【l...r】的范围寻找目标值
     */
    public static  int binarySearch(int[] arr, int n, int target){
        int l = 0,r = n-1;
        while(l <= r){
            int mid = (l+r) >> 1; // 等价于 / 2 ;  mid = l + (r-l)/2
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);
        List<Integer> list  = new ArrayList<>();
        int[] arr = new int[5];
        for (int i=0; i < arr.length ;i++){
            arr[i] = cin.nextInt();
        }

cin.close();

        int target = 3;
        int n = 5;
        System.out.println(binarySearch(arr,n,target));

    }

}
