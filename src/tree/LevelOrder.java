package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 */
public class LevelOrder {

  /**
   * 使用广度优先搜索 BFS
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result=new ArrayList<>();
    if(root==null) return result;
    Queue<TreeNode> queue=new LinkedList<>();
    queue.add(root);
    int size;
    while(!queue.isEmpty()){
      size=queue.size();
      List<Integer> list=new ArrayList<>();
      for(int i=0;i<size;i++){
        TreeNode node = queue.poll();
        list.add(node.val);
        if(node.left!=null) queue.add(node.left);
        if(node.right!=null) queue.add(node.right);
      }
      result.add(list);
    }
    return result;
  }


}
