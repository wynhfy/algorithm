package tree;

import java.util.*;

public class TreeNode {
  public int val;
  public TreeNode left,right;
  public TreeNode(int val){
    this.val=val;
    this.left=null;
    this.right=null;
  }


  /**
   * 遍历二叉搜索树
   * @param root
   * @return
   */
  public List<Integer> Traversal(TreeNode root){
    List<Integer> res=new ArrayList<>();
    helper(root,res);
    return res;
  }

  /**
   * 中序遍历
   * @param root
   * @param res
   */
  public void helper(TreeNode root,List<Integer> res){
    if(root!=null){
      if(root.left!=null){
        helper(root.left,res);
      }
      res.add(root.val);
      if(root.right!=null){
        helper(root.right,res);
      }
    }
  }

  public void insert(int value){
    if(val>value){
      if(left==null){
        left=new TreeNode(value);
      }else{
        left.insert(value);
      }
    }else{
      if(right==null){
        right=new TreeNode(value);
      }else{
        right.insert(value);
      }
    }
  }

  /**
   * 前序遍历非递归实现
   * @param root
   * @return
   */
  public List<Integer> preOrder(TreeNode root){
    List<Integer> list=new ArrayList<>();
    Stack<TreeNode> stack=new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
      TreeNode node=stack.pop();
      list.add(node.val);
      if(node.right!=null) stack.push(node.right);
      if(node.left!=null) stack.push(node.left);
    }
    return list;
  }

  /**
   * 中序遍历（非递归实现）
   * @param root
   * @return
   */
  public List<Integer> inOrder(TreeNode root){
    List<Integer> list=new ArrayList<>();
    Stack<TreeNode> stack=new Stack<>();
    while(root!=null || !stack.isEmpty()){  //栈非空的时候，root!=null是因为刚开始栈是空的
      //从根节点开始一直往左，将节点放入栈中
      while(root!=null){
        stack.push(root);
        root=root.left;
      }
      TreeNode node=stack.pop();
      list.add(node.val);
      root=node.right;
    }
    return list;
  }

  /**
   * 后续遍历（非递归实现）
   * @param root
   * @return
   */
  public List<Integer> postOrder(TreeNode root){
    List<Integer> list=new ArrayList<>();
    Stack<TreeNode> s1=new Stack<>();
    Stack<TreeNode> s2=new Stack<>();
    s1.push(root);
    while(!s1.isEmpty()){
      TreeNode node = s1.pop();
      s2.push(node);
      if(node.left!=null) s1.push(node.left);
      if(node.right!=null) s1.push(node.right);
    }
    while(!s2.isEmpty()){
      list.add(s2.pop().val);
    }
    return list;
  }

  public static void main(String[] args) {
    TreeNode root=new TreeNode(5);
    root.insert(3);
    root.insert(2);
    root.insert(7);
    root.insert(4);
    root.insert(6);
    root.insert(8);
    for(Integer i:root.Traversal(root)){
      System.out.print(i);
    }
    System.out.println();
    for(Integer i:root.preOrder(root)){
      System.out.print(i);
    }
    System.out.println();
    for(Integer i:root.inOrder(root)){
      System.out.print(i);
    }
    System.out.println();
    for(Integer i:root.postOrder(root)){
      System.out.print(i);
    }
  }

}
