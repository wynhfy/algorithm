package tree;


import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 */
public class SerializeTree {

    private String NULL="null";
    private String split=",";

  /**
   *  使用前序遍历进行序列化
   */
    public String serialize(TreeNode root){
      StringBuilder stringBuilder=new StringBuilder();
      preOrder(root,stringBuilder);
      return stringBuilder.toString();
    }

    public void preOrder(TreeNode root,StringBuilder stringBuilder){
      if(root==null){
        stringBuilder.append(NULL).append(split);
        return;
      }
      stringBuilder.append(root.val).append(split);
      preOrder(root.left,stringBuilder);
      preOrder(root.right,stringBuilder);
    }

    public TreeNode deserialize(String data){
      LinkedList list=new LinkedList();
      //将String转换为数组
      for(String string:data.split(split)){
        list.add(string);
      }
      return deserialize(list);
    }

  /**
   *  列表的第一个元素就是一棵树的根节点，所以只要将列表的第一个元素取出作为根节点，剩下的交给递归函数去解决即可
   */
    public TreeNode deserialize(LinkedList<String> list){
      if(list.isEmpty()) return null;
      //得到根节点
      String first = list.removeFirst();
      if(first.equals(NULL)) return null;
      TreeNode root=new TreeNode(Integer.parseInt(first));
      root.left=deserialize(list);
      root.right=deserialize(list);
      return root;
    }


  public static void main(String[] args) {
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.right.left=new TreeNode(4);
    root.right.right=new TreeNode(5);
    System.out.println(new SerializeTree().serialize(root));
  }

}
