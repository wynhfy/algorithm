package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 */
public class BuildTree {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder == null || inorder == null || preorder.length<=0) return null;
      //map用来记录中序遍历中每个值的下标
      Map<Integer,Integer> map=new HashMap<>();
      int length=preorder.length;
      for(int i=0;i<preorder.length;i++){
        map.put(inorder[i],i);
      }
      TreeNode root=getRoot(preorder,0,length-1,inorder,0,length-1,map);
      return root;
  }

  public TreeNode getRoot(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map){
      if(preStart>preEnd) return null;    //递归结束的条件
      int rootValue=preorder[preStart];   //前序遍历的第一个结点就是根节点
      TreeNode root=new TreeNode(rootValue);
      if(preStart == preEnd) return root;
      int index=map.get(rootValue);
      int leftNodes=index-inStart;         //找到左子树有多少个结点
      int rightNodes=inEnd-index;          //找到右子树有多少个结点
      root.left=getRoot(preorder,preStart+1,preStart+leftNodes,inorder,inStart,index-1,map);
      root.right=getRoot(preorder,preStart+leftNodes+1,preEnd,inorder,index+1,inEnd,map);
      return root;
  }

}
