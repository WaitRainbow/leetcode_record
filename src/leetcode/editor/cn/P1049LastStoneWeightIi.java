//有一堆石头，每块石头的重量都是正整数。 
//
// 每一回合，从中选出任意两块石头，然后将它们一起粉碎。
// 假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例： 
//
// 输入：[2,7,4,1,8,1]
//输出：1
//解释：
//组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
//组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
//组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
//组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 动态规划


package leetcode.editor.cn;
//Java：最后一块石头的重量 II
public class P1049LastStoneWeightIi{
    public static void main(String[] args) {
        Solution solution = new P1049LastStoneWeightIi().new Solution();
        // TO TEST
        System.out.println(solution.lastStoneWeightII(new int[]{1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (int stone : stones) {
            sum+=stone;
        }
        int maximum = sum/2;
        int[] dp = new int[maximum+1];
        for (int i = 0; i < stones.length; i++) {
            int curr = stones[i];
            for (int j = maximum; j >= curr; j--) {
                dp[j] = Math.max(dp[j],dp[j-curr]+curr);
            }
        }

        return sum-dp[maximum]*2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}