//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//  如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
// Related Topics 树 二分查找


package leetcode.editor.cn;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.Stack;

//Java：二叉搜索树中第K小的元素
public class P230KthSmallestElementInABst{
    public static void main(String[] args) {
        Solution solution = new P230KthSmallestElementInABst().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }


class Solution {
    //    int count=0;
//    int res=0;
    public int kthSmallest(TreeNode root, int k) {
//        inorder(root,k);
//        return res;
        Stack<TreeNode> stack = new Stack<>();
        //这里可以设置一个count来计数，保证在tree.size中循环
        //但是由于题目中指定k<=tree.size,因此可以用死循环来写
        while (true) {
            while (root != null) {
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
//    public void inorder(TreeNode root,int k) {
//        if(root == null) return;
//        inorder(root.left, k);
//        count++;
//        if (count==k) res=root.val;
//        if (res == 0) {
//            inorder(root.right,k);
//        }
//
//    }


//leetcode submit region end(Prohibit modification and deletion)


}