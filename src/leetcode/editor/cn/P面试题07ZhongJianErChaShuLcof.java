//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归


package leetcode.editor.cn;
//Java：重建二叉树
public class P面试题07ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题07ZhongJianErChaShuLcof().new Solution();
        // TO TEST
    }



public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return pre_in(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    //s1，e1是先序队列的开头和结尾下标
    //s2,e2是中序队列的开头和结尾下标
    public TreeNode pre_in(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        int i=0;//记录相等元素在中序数组中的位置；
        TreeNode tem = new TreeNode(0);
        if (s1>e1) return null;
        //这一步可以用map将值在中序数组的中的对应位置记录下来
        //每次直接取key就可以了，以空间换时间
        for (int j = s2; j <= e2; j++) {
            if (preorder[s1] == inorder[j]) {
                i=j;
                break;
            }
        }
        tem.val = inorder[i];
        tem.left = pre_in(preorder,inorder,s1+1,s1+i-s2,s2,i-1);
        tem.right=pre_in(preorder,inorder,s1+i-s2+1,e1,i+1,e2);
        return tem;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}