package tree;

/**
 * 面试题 04.10. 检查子树
 */
public class CheckSubTree {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        boolean result=false;
        if(t1!=null && t2!=null){
            //如果根节点相同了，则判断是否是子树
            if(t1.val==t2.val){
                result=hasSubTree(t1,t2);
            }
            if(!result){ //如果根节点相同了，但不是子树，则从根结点的左边开始判断
                result=checkSubTree(t1.left,t2);
            }
            if(!result){ //如果左边也没有子树，则从右边开始判断
                result=checkSubTree(t1.right,t2);
            }
        }
        return result;
    }

    /**
     *  先判断根结点是否相同，如果相同再递归判断左右结点是否相同
     */
    private boolean hasSubTree(TreeNode t1, TreeNode t2) {
        if(t2==null) return true;
        if(t1==null) return false;
        if(t1.val!=t2.val){
            return false;
        }
        return hasSubTree(t1.left,t2.left) && hasSubTree(t1.right,t2.right);
    }

}
