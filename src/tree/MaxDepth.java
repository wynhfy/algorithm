package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 */
public class MaxDepth {

  /** 递归的方法实现
   *   每个节点只访问了一次，时间复杂度为O(n)
   *   深度优先搜索DFS
   *
   *   终止条件: 当前节点为空
   *   返回值：
   *     节点为空时，所以返回 0
   *     节点不为空时, 返回左右子树高度的最大值 + 1
   */
//  public int maxDepth(TreeNode root) {
//    if(root==null){
//      return 0;
//    }else{
//      int left=maxDepth(root.left);  //左子树的深度
//      int right=maxDepth(root.right);//右子树的深度
//      return Math.max(left,right)+1; //每个节点深度等于左右子树最大深度+1
//    }
//  }

  public int height(TreeNode root){
    if(root==null) return 0;
    else return Math.max(height(root.left),height(root.right))+1;
  }

  /**
   *  实现 BFS 就要用到 '先进先出' 的队列了, 具体算法流程如下:
   *    遍历二叉树节点，依次将当前节点 和它的左右子节点入队
   *    依次出队, 出队子节点重复上一步操作
   *
   *    相当于每次把每一层的所有节点放进去
   */
  public int maxDepth(TreeNode root){
    if(root==null) return 0;
    Queue<TreeNode> queue=new LinkedList();
    int depth=0;
    int size;
    queue.add(root);
    while(!queue.isEmpty()){
      depth++;
      size=queue.size();
      for(int i=0;i<size;i++){
        TreeNode node = queue.poll();
        if(node.left!=null){
          queue.add(node.left);
        }
        if(node.right!=null){
          queue.add(node.right);
        }
      }
    }
    return depth;
  }

  public static void main(String[] args) {
    TreeNode root=new TreeNode(0);
    root.left=new TreeNode(1);
    System.out.println(new MaxDepth().height(root));
  }

}
