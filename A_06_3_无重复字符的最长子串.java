package day_0330;

/**
 * 438 、 76
 * @author aml
 * @date 2021/4/3 21:45
 */
public class A_06_3_无重复字符的最长子串 {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l=0, r = -1; //滑动窗口s[l...r]初始为0
        int res = 0;

//        整个循环从l==0; r==-1, 这个空窗口开始
//        到l==s.length(); r==s.length()-1, 这个空窗口截止
//        在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        while (l < s.length()){
            if (r+1 < s.length() && freq[s.charAt(r+1)] == 0){
                r++;
                freq[s.charAt(r)]++;
            }else { //r已经到头 || freq[s[r+1]] == 1
                freq[s.charAt(l)]--;
                l++;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bacabcbb"));
    }

}
