package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * n叉树的前序遍历
 */
public class Node {
  public int val;
  public List<Node> children;

  public Node(){}

  public Node(int _val){
    val=_val;
  }

  public Node(int _val,List<Node> _children){
    val=_val;
    children=_children;
  }

  /** 使用递归实现    */
//  public List<Integer> preorder(Node root){
//    List<Integer> list=new ArrayList<>();
//    helper(root,list);
//    return list;
//  }
//
//  public void helper(Node root,List<Integer> list){
//    if(root!=null){
//      list.add(root.val);
//      for(Node node:root.children){
//        helper(node,list);
//      }
//    }
//  }


  /** 使用迭代的方法实现
   *  通过一个栈来实现，栈顶节点是当前遍历的节点，每次逆序将节点放入栈中
   * */
  public List<Integer> preorder(Node root){
    Stack<Node> stack=new Stack<>();
    List<Integer> list=new ArrayList<>();
    if(root==null){
      return list;
    }
    stack.add(root);
    while(!stack.isEmpty()){
      Node node = stack.pop();
      list.add(node.val);
      Collections.reverse(node.children);  //将子节点逆序放入栈中，遍历出来才是前序遍历
      for(Node item:node.children){
        stack.add(item);
      }
    }
    return list;
  }

  /** n叉树的后序遍历 递归的方法 */
//  public List<Integer> postorder(Node root){
//    List<Integer> list=new ArrayList<>();
//    helper(root,list);
//    return list;
//  }
//
//  public void helper(Node root,List<Integer> list){
//    if(root!=null){
//      if(root.children!=null && root.children.size()!=0){
//        for(Node item:root.children){
//          helper(item,list);
//        }
//      }
//      list.add(root.val);
//    }
//  }

  /**
   * 迭代的方法实现n叉树的后序遍历
   * 最终的结果要逆序再输出
   * 因此我们可以使用和 N叉树的前序遍历 相同的方法，使用一个栈来得到后序遍历。我们首先把根节点入栈。当每次我们从栈顶取出一个节点 u 时，
   * 就把 u 的所有子节点顺序推入栈中。例如 u 的子节点从左到右为 v1, v2, v3，那么推入栈的顺序应当为 v1, v2, v3，这样就保证了下一个遍历到的节点
   * （即 u 的第一个子节点 v3）出现在栈顶的位置。在遍历结束之后，我们把遍历结果反转，就可以得到后序遍历。
   * @param root
   * @return
   */
  public List<Integer> postorder(Node root){
    Stack<Node> stack=new Stack<>();
    List<Integer> list=new ArrayList<>();
    if(root==null){
      return list;
    }
    stack.add(root);
    while(!stack.isEmpty()){
      Node node=stack.pop();
      list.add(node.val);
      for(Node item:node.children){
        stack.add(item);
      }
    }
    Collections.reverse(list);
    return list;
  }


}
