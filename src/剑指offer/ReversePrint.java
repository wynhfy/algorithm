package 剑指offer;

import java.util.*;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        if(head==null) return new int[]{};
        Stack<Integer> stack=new Stack<>();
        ListNode cur=head;
        while(cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }
        int length=stack.size();
        int[] array=new int[length];
        for(int i=0;i<length;i++){
            array[i]=stack.pop();
        }
        return array;
    }

}
