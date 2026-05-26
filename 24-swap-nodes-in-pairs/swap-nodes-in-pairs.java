/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //store linked list values in array
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        //swap in array
        for(int i=1;i<arr.size();i+=2){
            int t=arr.get(i);
            arr.set(i,arr.get(i-1));
            arr.set(i-1,t);
        }
        //put values back
        temp=head;
        int i=0;
        while(temp!=null){
            temp.val=arr.get(i);
            i++;
            temp=temp.next;
        }
        return head;
    }
}