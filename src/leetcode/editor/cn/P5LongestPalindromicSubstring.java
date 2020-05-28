//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;
//Java：最长回文子串
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("bb"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //马拉车算法
    public String longestPalindrome(String s) {
        String t = preprocess(s);
        int n=t.length();
        int center=0,mirror=0,right=0;
        int[] p = new int[n];
        int longest=0;
        p[0]=0;
        for (int i = 1; i<n-1 ; i++) {
            mirror = 2*center -i;
            if (right > i) {
                if (mirror > 0) {
                    p[i] = Math.min(p[mirror], right - i);
                }
            } else {
                p[i] = 0;
            }
            for (int j=1; i - j- p[i] > 0 && i + j + p[i] < n - 1;) {
                if (t.charAt(i-j-p[i])==t.charAt(i+j+p[i])) p[i]++;
                else break;
            }
            if (i + p[i] >= right) {
                center = i;
                right = center+p[i];
            }
        }
        for (int i = 0; i < p.length; i++) {
            if (p[i] > longest) {
                longest=p[i];
                center = i;
            }
        }

        return s.substring((center-longest)/2,(center-longest)/2+longest);
    }
    //预处理
    //在字符直接加入#,在开头和结尾分别加入两个不对称的特殊符号以便开头结尾判断
    //这样能保证字符串字符个数始终为奇数
    public String preprocess(String s) {
        if(s.isEmpty()) return "^@";
        String res = "^";
        for (int i = 0; i < s.length(); i++) {
            res += "#" + s.charAt(i);
        }
        res += "#@";
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}