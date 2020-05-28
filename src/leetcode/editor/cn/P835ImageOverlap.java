//给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。 
//
// 我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。
// 之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
//
// （请注意，转换不包括向任何方向旋转。） 
//
// 最大可能的重叠是什么？ 
//
// 示例 1: 
//
// 输入：A = [[1,1,0],
//          [0,1,0],
//          [0,1,0]]
//     B = [[0,0,0],
//          [0,1,1],
//          [0,0,1]]
//输出：3
//解释: 将 A 向右移动一个单位，然后向下移动一个单位。 
//
// 注意: 
//
// 
// 1 <= A.length = A[0].length = B.length = B[0].length <= 30 
// 0 <= A[i][j], B[i][j] <= 1 
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.awt.*;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：图像重叠
public class P835ImageOverlap{
    public static void main(String[] args) {
        Solution solution = new P835ImageOverlap().new Solution();
        // TO TEST
        int[][] A = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] B = {{0,0,0},{0,1,1},{0,0,1}};
        System.out.println(solution.largestOverlap(A,B));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        List<Point> A1 = new ArrayList<>();
        List<Point> B1 = new ArrayList<>();
        int curr,longest=0;
        Point bias;
        Set<Point> record = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] == 1) A1.add(new Point(i,j));
                if (B[i][j] == 1) B1.add(new Point(i,j));
            }
        }
        Set<Point> Bset = new HashSet<>(B1);

        for (Point point_a : A1) {
            for (Point point_b : B1) {
                bias = new Point(point_b.x-point_a.x,point_b.y-point_a.y);
                if (!record.contains(bias)) {
                    record.add(bias);
                    curr=0;
                    for (Point point : A1) {
                        if (B1.contains(new Point(point.x + bias.x, point.y + bias.y))) {
                            curr++;
                        }
                    }
                    longest = Math.max(curr, longest);
                }
            }
        }


        return  longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//方法2
// 先计算偏移量，再对每个偏移量计数，最后同一偏移量出现次数的最大值就是结果
//class Solution {
//    public int largestOverlap(int[][] A, int[][] B) {
//        int N = A.length;
//        int[][] count = new int[2*N+1][2*N+1];
//        for (int i = 0; i < N; ++i)
//            for (int j = 0; j < N; ++j)
//                if (A[i][j] == 1)
//                    for (int i2 = 0; i2 < N; ++i2)
//                        for (int j2 = 0; j2 < N; ++j2)
//                            if (B[i2][j2] == 1)
//                                count[i-i2 +N][j-j2 +N] += 1;
//
//        int ans = 0;
//        for (int[] row: count)
//            for (int v: row)
//                ans = Math.max(ans, v);
//        return ans;
//    }
//}
}