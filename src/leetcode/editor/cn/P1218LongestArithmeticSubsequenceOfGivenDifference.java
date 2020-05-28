//给你一个整数数组 arr 和一个整数 difference，
// 请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中
//最长的等差子序列的长度。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,2,3,4], difference = 1
//输出：4
//解释：最长的等差子序列是 [1,2,3,4]。 
//
// 示例 2： 
//
// 输入：arr = [1,3,5,7], difference = 1
//输出：1
//解释：最长的等差子序列是任意单个元素。
// 
//
// 示例 3： 
//
// 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
//输出：4
//解释：最长的等差子序列是 [7,5,3,1]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -10^4 <= arr[i], difference <= 10^4 
// 
// Related Topics 数学 动态规划


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：最长定差子序列
public class P1218LongestArithmeticSubsequenceOfGivenDifference{
    public static void main(String[] args) {
        Solution solution = new P1218LongestArithmeticSubsequenceOfGivenDifference().new Solution();
        // TO TEST
        solution.longestSubsequence(new int[]{3,4,-3,-2,-4},-5);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        //设置map，key为末尾的数字，value为长度
        Map<Integer, Integer> map = new HashMap<>();
        //如果map中已有key=this.val-difference,那么更新map
        //key=this.val value=key+1
        int max=1;
        for (int i = 0; i < arr.length; i++) {
            int temp=arr[i]-difference;
            if (map.containsKey(temp)) {
                map.put(arr[i], map.get(temp) + 1);
                max= Math.max(max,map.get(arr[i]));
            } else {
                //否则，key=this.val,vaule=1;
                map.put(arr[i],1);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}