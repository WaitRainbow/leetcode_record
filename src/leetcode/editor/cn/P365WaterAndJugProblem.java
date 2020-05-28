//有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？ 
//
// 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。 
//
// 你允许： 
//
// 
// 装满任意一个水壶 
// 清空任意一个水壶 
// 从一个水壶向另外一个水壶倒水，直到装满或者倒空 
// 
//
// 示例 1: (From the famous "Die Hard" example) 
//
// 输入: x = 3, y = 5, z = 4
//输出: True
// 
//
// 示例 2: 
//
// 输入: x = 2, y = 6, z = 5
//输出: False
// 
// Related Topics 数学


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//Java：水壶问题
public class P365WaterAndJugProblem{
    public static void main(String[] args) {
        Solution solution = new P365WaterAndJugProblem().new Solution();
        // TO TEST
        System.out.println(solution.canMeasureWater(3,5,4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //可以使用DFS算法
    public boolean canMeasureWater(int x, int y, int z) {
        //建造一个容器来储存现在两个水壶的状态
        Stack<int[]> state = new Stack<>();
        //起始状态
        int[] start = {0, 0};
        //状态入栈
        state.push(start);
        //检测是否该状态已被遍历过
        Set<int[]> visit=new HashSet<>();
        visit.add(start);
        int tem=0;
        while (!state.isEmpty()) {
            int[] curr_state = state.pop();
            //基于每种状态可以进行：
            // 1.装满任意一个水壶

            if (curr_state[0] == 0) {
                int[] add = {x, curr_state[1]};
                if (!visit.contains(add)) {
                    if (add[0] == z || add[1] == z || add[0] + add[1] == z) {
                        return true;
                    }
                    state.push(add);
                    visit.add(add);
                }
            }
            if (curr_state[1] == 0) {
                int[] add = {curr_state[0], y};
                if (!visit.contains(add)) {
                    if (add[0] == z || add[1] == z || add[0] + add[1] == z) {
                        return true;
                    }
                    state.push(add);
                    visit.add(add);
                }
            }
            // 2.清空任意一个水壶
            if (curr_state[0] != 0) {
                int[] clear = {0, curr_state[1]};
                if (!visit.contains(clear)) {
                    if (clear[0] == z || clear[1] == z || clear[0] + clear[1] == z) {
                        return true;
                    }
                    state.push(clear);
                    visit.add(clear);
                }
            }
            if (curr_state[1] != 0) {
                int[] clear = {curr_state[0], 0};
                if (!visit.contains(clear)) {
                    if (clear[0] == z || clear[1] == z || clear[0] + clear[1] == z) {
                        return true;
                    }
                    state.push(clear);
                    visit.add(clear);
                }
            }
            // 3.从一个水壶向另外一个水壶倒水，直到装满或者倒空
            //这里要考虑水壶的容量问题
            if (curr_state[0] == 0 && curr_state[1] != 0) {
                int[] damp = new int[2];
                if (curr_state[1] > x) {
                    damp[0] = x;
                    damp[1] = curr_state[1] - x;
                    if (!visit.contains(damp)) {
                        state.push(damp);
                        visit.add(damp);
                    }
                } else {
                    damp[0] = curr_state[1];
                    damp[1] = 0;
                    if (!visit.contains(damp)) {
                        state.push(damp);
                        visit.add(damp);
                    }
                }
            }
            if (curr_state[1] == 0 && curr_state[0] != 0) {
                int[] damp = new int[2];
                if (curr_state[0] > y) {
                    damp[1] = y;
                    damp[0] = curr_state[0] - y;
                    if (!visit.contains(damp)) {
                        state.push(damp);
                        visit.add(damp);
                    }
                } else {
                    damp[1] = curr_state[0];
                    damp[0] = 0;
                    if (!visit.contains(damp)) {
                        state.push(damp);
                        visit.add(damp);
                    }
                }
            }
        }



        //通过BFS如果找到了最终结果，则返回


        return false;
    }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}