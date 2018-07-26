package leetcode;

/**
 * Created by Airy on 2018/7/26
 */

public class rebuildTreeFromPreAndInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode ans = doIt(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return ans;
    }

    /**
     * 建树
     * @param pre
     * @param pl
     * @param pr
     * @param in
     * @param il
     * @param ir
     * @return
     */
    private TreeNode doIt(int[] pre,int pl,int pr,int[] in,int il,int ir){
        if(pl > pr || il > ir) // 说明已经重建完毕
            return null;
        TreeNode root = new TreeNode(pre[pl]);  // 前序，根左右，那么用前序第一个必是根节点构造所有的根节点
        for(int i = il;i<= ir;i++){ // 在中序里面找根节点
            if(in[i] == pre[pl]){ // 当中序碰到根节点，那么中序的左边就是左子树，右边就是右子树
                root.left = doIt(pre,pl+1,pl+i-il,in,il,i-1);
                // pl+1 左子树用前序做根肯定+1啊
                // pl+i-il 左子树，确定了前序可以构造的范围，左边界加上了（i-il）这样理解好点，就是中序左边的size
                // il 左子树左边界，因为使用中序构建的，根节点分开了中序的左右子树
                // i-1 左子树右边界，除去根节点
                root.right = doIt(pre,i-il+pl+1,pr,in,i+1,ir);
                //（i-il）中序左边的size + 前序右边界（就是一开始选定的根边界） + 跳过真正的根 = 前序中的右子树的左边界
                // pr 就是右边界，肯定是右子树的边界
                // i+1 中序跳过根就是右子树的左边界、
                // ir 就是右子树的右边界
                break; // 用根构造，找到根就可以溜了
            }
        }
        return root; // 返回节点的根
    }
}
