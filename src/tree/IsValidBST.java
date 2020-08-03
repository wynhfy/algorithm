package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 */
public class IsValidBST {

  /** 使用中序遍历排序完，再判断是否为升序的方法*/

//  public boolean isValidBST(TreeNode root){
//    List<Integer> list=new ArrayList<>();
//    helper(root,list);
//    boolean flag=true;
//    for(int i=1;i<list.size();i++){
//      if(list.get(i)<=list.get(i-1)){
//        flag=false;
//        break;
//      }
//    }
//    return flag;
//  }
//
//  public void helper(TreeNode root,List<Integer> list){
//    if(root!=null){
//      if(root.left!=null){
//        helper(root.left,list);
//      }
//      list.add(root.val);
//      if(root.right!=null){
//        helper(root.right,list);
//      }
//    }
//  }

  public boolean isValidBST(TreeNode root){
    return helper(root,null,null);
  }

  public boolean helper(TreeNode root,Integer lower,Integer upper){
    if(root==null) return true;
    //判断当前节点的左右节点是否符合
    if(lower!=null && root.val<=lower) return false; //判断右节点
    if(upper!=null && root.val>=upper) return false; //判断左节点
    //递归判断左右子树
    if(!helper(root.right,root.val,upper)) return false;//判断右子树
    if(!helper(root.left,lower,root.val)) return false; //判断左子树
    return true;
  }


  public boolean isBST(TreeNode root){
    return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
  }

  public boolean isBSTUtil(TreeNode root,int min,int max){
    if(root==null) return true;
    if(root.val<min || root.val>max) return false;
    return isBSTUtil(root.left,min, root.val-1)&&isBSTUtil(root.right,root.val+1,max);
  }

}
