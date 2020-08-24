package tree.impl;

/**
 * 二叉查找树的实现
 * 其中每一个结点都含有Comparable的键(以及相关联的值)，且每个结点的键都大于其左子树中的任意结点的键而小于右子树的任意结点的键
 *
 * 使用二叉查找树的算法的运行时间取决于树的形状，而树的形状取决于键被插入的先后顺序。最好的情况下，一棵含有N个结点的树是完全平衡的，
 * 最坏的情况下搜索路径上可能含有N个结点。
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;//根结点

    private class Node{
        private Key key;            //键
        private Value value;        //值
        private Node left,right;    //左右结点
        private int N;              //以该结点为根的子树的结点总数

        public Node(Key key,Value val,int N){
            this.key=key;
            this.value=val;
            this.N=N;
        }
    }

    //查看二叉查找树的大小,size会将叶子节点的N值当作0，这样就能保证这个公式对于二叉树中的任意结点x总是成立
    // size(x)=size(x.left)+size(x.right)+1
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x==null) return 0;
        return x.N;
    }

    //在二叉查找树中查找结点值
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0) return get(x.left,key);
        else if(cmp>0) return get(x.right,key);
        else return x.value;
    }

    //在二叉查找树中插入，同时更新size的值
    public void put(Key key,Value value){
        root=put(root,key,value);
    }
    private Node put(Node x,Key key,Value val){
        if(x==null) x=new Node(key,val,1);
        int cmp=key.compareTo(x.key);
        if(cmp<0) x.left=put(x.left,key,val);
        else if(cmp>0) x.right=put(x.right,key,val);
        else x.value=val;
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    //二叉查找树中的最小值
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left==null) return x;
        return min(x.left);
    }

    //在二叉查找树中的最大值
    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right==null) return x;
        return max(x.right);
    }

    //删除最小值
    public void deleteMin(){
        root=deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left==null) return x.right;
        x.left=deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    //删除结点
    public void delete(Key key){
        root=delete(root,key);
    }
    private Node delete(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0) x.left=delete(x.left,key);
        else if(cmp>0) x.right=delete(x.right,key);
        else{  //找到要删除的结点了
            if(x.right==null) return x.left;
            if(x.left==null) return x.right;
            Node t=x; //保留要删除的结点
            x=min(t.right); //x是要删除结点的右子树的最小结点
            x.right=deleteMin(t.right); //删除右子树中的最小结点，同时将x的右子树指向它
            x.left=t.left; //x的左子树指向被删除结点的左结点
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }


    //查找排名为k的键，即树中正好有k个小于它的键
    public Key select(int k){
        return select(root,k).key;
    }
    private Node select(Node x,int k){
        if(x==null) return null;
        int t=size(x.left);
        if(t>k) return select(x.left,k);
        else if(t<k) return select(x.right,k-t-1);
        else return x;
    }

    //返回给定键的排名
    public int rank(Key key){
        return rank(key,root);
    }
    private int rank(Key key,Node x){
        if(x==null) return 0;
        int cmp=key.compareTo(x.key);
        if(cmp<0) return rank(key,x.left);
        else if(cmp>0) return 1+size(x.left)+rank(key,x.right);
        else return size(x.left);
    }

    //向下取整
    public Key floor(Key key){
        Node x=floor(root,key);
        if(x!=null) return x.key;
        return null;
    }
    private Node floor(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0) return x;
        else if(cmp<0) return floor(x.left,key);
        Node t=floor(x.right,key);
        if(t==null) return x;
        return t;
    }

    //向上取整
    public Key ceiling(Key key){
        Node x=ceiling(root,key);
        if(x!=null) return x.key;
        return null;
    }
    private Node ceiling(Node x,Key key){
        if(x==null) return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0) return x;
        if(cmp>0) return ceiling(x.right,key);
        Node t=ceiling(x.left,key);
        if(t==null) return x;
        return t;
    }

}
