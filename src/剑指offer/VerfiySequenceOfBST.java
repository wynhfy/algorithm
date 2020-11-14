package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  二叉搜索树的后续遍历序列
 */
public class VerfiySequenceOfBST {

    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null || postorder.length==0) return true;
        return verify(postorder,0,postorder.length-1);
    }

    private boolean verify(int[] postorder, int i, int j) {
        if(i>=j) return true;//只有一个节点，肯定是对的
        //找到第一个大于根节点的索引
        int p=i;
        while(postorder[p]<postorder[j]) p++;
        int m=p;
        //判断右子树是否都大于根节点
        while(postorder[p]>postorder[j]) p++;
        return p==j && verify(postorder,i,m-1) && verify(postorder,m,j-1);
    }

    public static void main(String[] args) {
        int[] nums={5,7,6,9,11,10,8};
        System.out.println(new VerfiySequenceOfBST().verifyPostorder(nums));

    }

}
