package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {

  /**
   * 通过递归的方式
   * 属于深度优先遍历
   */
  public int minDepth(TreeNode root){
    if(root==null) return 0;
    int left=minDepth(root.left);
    int right=minDepth(root.right);
    if(left==0){   //该判断用来处理特殊情况，即如果没有左子树或者右子树，是不算的,例如极端的情况就是线性的时候
      return right+1;
    }else if(right==0){
      return left+1;
    }else{
      return Math.min(left,right)+1;
    }
  }

  /**
   * BFS 广度优先遍历
   */
  public int minDepth1(TreeNode root){
    if(root==null) return 0;
    Queue<TreeNode> queue=new LinkedList<>();
    queue.add(root);
    int level=0; //代表层数
    int size;
    while(!queue.isEmpty()){
      level++;
      size=queue.size();
      for(int i=0;i<size;i++){
        TreeNode node = queue.poll();
        if(node.left==null && node.right==null) return level; //表面该节点是叶子结点，返回该层即可
        if(node.left!=null) queue.add(node.left);
        if(node.right!=null) queue.add(node.right);
      }
    }
    return level;
  }


  public static void main(String[] args) {
    TreeNode root=new TreeNode(3);
    root.left=new TreeNode(9);
    root.right=new TreeNode(20);
    root.right.left=new TreeNode(15);
    root.right.right=new TreeNode(7);
    System.out.println(new MinDepth().minDepth(root));
  }

}
