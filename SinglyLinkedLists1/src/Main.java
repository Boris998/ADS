import java.lang.IllegalArgumentException;
import java.util.*;

public class Main
{
    //private  ListNode head;

    private static class ListNode
    {
        private int data;
        private ListNode next;

        public ListNode(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    public void display(ListNode head)
    {
        if(head==null)
        {
            return;
        }
        ListNode curr=head;
        while (curr!=null)
        {
            System.out.print(curr.data+"-->");//print
            curr=curr.next;
        }
        System.out.print(curr);
    }

    public int length(ListNode head)
    {
        if(head==null)
        {
            return 0;
        }
        //create counter==0
        int c=0;
        ListNode curr=head;
        while (curr!=null)
        {
            c++;
            curr=curr.next;
        }
        return c;
    }

    public ListNode insertAtBeginning(ListNode head,int data)
    {
        ListNode newNode=new ListNode(data);

        if(head==null)
        {
            return newNode;
        }
        newNode.next=head;
        head=newNode;
        return head;
    }

    public ListNode insertAtEnd(ListNode head,int data)
    {
        ListNode newNode=new ListNode(data);

        if(head==null)
        {
            return newNode;
        }
        ListNode curr=head;
        while (null!=curr.next)
        {
            curr=curr.next;
        }
        curr.next=newNode;
        return head;
    }

    //insert a node after a given node
    public void insertAfter(ListNode prev,int data)
    {
        if(prev==null)
        {
            System.out.println("the prev node cannot be null");
            return;
        }
        ListNode newNode=new ListNode(data);
        newNode.next=prev.next;
        prev.next=newNode;
    }

    //insert a node at a given position
    public ListNode insertAtPosition(ListNode head,int data,int pos)
    {
        int size=length(head);//check of boundary
        if(pos>size+1||pos<1)
        {
            System.out.println("invalid position");
            return head;
        }
        ListNode newNode=new ListNode(data);
        if(pos==1)
        {
            newNode.next=head;
            return newNode;
        }
        else
        {
            ListNode prev=head;
            int count=1;
            while (count<pos-1)
            {
                prev=prev.next;
                count++;
            }
            ListNode curr=prev.next;
            newNode.next=curr;
            prev.next=newNode;
            return head;
        }
    }

    public ListNode giveTheFirst(ListNode head)
    {
        if(head==null)
        {
            return head;
        }
        ListNode temp=head;
        head=head.next;
        temp.next=null;
        return temp;
    }

    public ListNode deleteTheLast(ListNode head)
    {
        if(head==null)
        {
            return head;
        }
        ListNode last=head;
        ListNode prevToLast=head;
        while (last.next!=null)
        {
            prevToLast=last;
            last=last.next;
        }
        prevToLast.next=null;
        return last;
    }

    public ListNode deleteAtPosition(ListNode head,int pos)
    {
        int size=length(head);//check of boundary
        if(pos>size+1||pos<1)
        {
            System.out.println("invalid position");
            return head;
        }

        if(pos==1)
        {
            ListNode tmp=head;
            head=head.next;
            tmp.next=null;
            return tmp;
        }
        else
        {
            ListNode prev=head;
            int count=1;
            while (count<pos-1)
            {
                prev=prev.next;
                count++;
            }
            ListNode curr=prev.next;
            prev.next=curr.next;
            curr.next=null;
            return curr;
        }
    }

    public boolean find(ListNode head, int searchKey)
    {
        if(head == null)
        {
            return false;
        }
        ListNode curr=head;
        while (curr!=null)
        {
            if(curr.data==searchKey)
            {
                return true;
            }
            curr=curr.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head)
    {
        if(head==null)
        {
            return head;
        }

        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while (curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public ListNode getMiddleNode(ListNode head)
    {
        if(head==null)
        {
            return null;
        }

        ListNode slowPtr=head;
        ListNode fastPtr=head;

        while (fastPtr!=null && fastPtr.next!=null)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode getNthNodeFormEnd(ListNode head,int n)
    {
        if(head==null)
        {
            return null;
        }

        if(n<=0)
        {
            throw new IllegalArgumentException("Invalid value: n= "+n);
        }

        ListNode mainPrt=head;
        ListNode refPrt=head;
        int count=0;
        while (count<n)
        {
            if (refPrt==null)
            {
                throw new IllegalArgumentException(n+"greater than the n of nodes");
            }
            refPrt=refPrt.next;
            count++;
        }
        while (refPrt!=null)
        {
            mainPrt=mainPrt.next;
            refPrt=refPrt.next;
        }
        return mainPrt;
    }

    public ListNode removeDuplicatesSorted(ListNode head)
    {
        if(head==null)
        {
            return head;
        }

        ListNode curr=head;
        while (curr!=null&&curr.next!=null)
        {
            if(curr.data==curr.next.data)
            {
                curr.next=curr.next.next;
            }
            else
            {
                curr=curr.next;
            }
        }
        return head;
    }

    public ListNode insertInSortedList(ListNode head,int value)
    {
        ListNode newNode=new ListNode(value);

        if (head==null)
        {
            return newNode;
        }
        ListNode curr=head;
        ListNode temp=null;

        while (curr!=null && curr.data<newNode.data)
        {
            temp=curr;
            curr=curr.next;
        }
        newNode.next=curr;
        temp.next=newNode;
        return head;
    }

    public ListNode deleteKeyNode(ListNode head,int key)
    {
        if(head==null)
        {
            return head;
        }
        ListNode curr=head;
        ListNode temp=null;

        if(curr!=null && curr.data==key)
        {
            head=curr.next;
            return head;
        }

        while (curr!=null && curr.data!=key)
        {
            temp=curr;
            curr= curr.next;
        }
        if(curr==null)
        {
            return head;
        }
        temp.next=curr.next;
        return head;
    }




    public static void main(String[] args)
    {

        ListNode head=new ListNode(1);
        ListNode second=new ListNode(8);
        ListNode third=new ListNode(9);
        ListNode fourth=new ListNode(14);
        ListNode fifth=new ListNode(18);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;

        System.out.println("original");
        Main singlyLinkedList=new Main();
        singlyLinkedList.display(head);

        System.out.println();
        /*
        System.out.println("Insert at end");
        ListNode newHead=singlyLinkedList.insertAtEnd(head,111);
        singlyLinkedList.display(newHead);

        System.out.println();
        System.out.println("length"+singlyLinkedList.length(head));

        System.out.println("Insert after a given one");
        singlyLinkedList.insertAfter(second,122222);
        singlyLinkedList.display(head);
        System.out.println();

        System.out.println("Insert after given position");
        head=singlyLinkedList.insertAtPosition(head,123,1);
        singlyLinkedList.display(head);

        System.out.println("Delete first");
        ListNode first=singlyLinkedList.giveTheFirst(head);
        System.out.println(first.data);
        singlyLinkedList.display(head);

        System.out.println();
        System.out.println("Delete last");
        ListNode last=singlyLinkedList.deleteTheLast(head);
        System.out.println(last.data);
        singlyLinkedList.display(head);

        System.out.println();
        System.out.println("Delete at position");
        ListNode thirdNode=singlyLinkedList.deleteAtPosition(head,3);
        System.out.println(thirdNode.data);
        singlyLinkedList.display(head);

        System.out.println("whether is present or not");
        if(singlyLinkedList.find(head,10))
        {
            System.out.println("Search key found");
        }
        else
        {
            System.out.println("Search key not found");
        }

        ListNode reverseListHead=singlyLinkedList.reverse(head);
        singlyLinkedList.display(reverseListHead);

        System.out.println("Get middle node");
        ListNode middleNode= singlyLinkedList.getMiddleNode(head);
        System.out.println("Middle node is "+ middleNode.data);

        System.out.println();
        ListNode nthNodeFromEnd= singlyLinkedList.getNthNodeFormEnd(head,2);
        System.out.println("Nth node is "+nthNodeFromEnd.data);

        System.out.println();
        ListNode remove=singlyLinkedList.removeDuplicatesSorted(head);
        singlyLinkedList.display(remove);

        System.out.println("it does not terminates for nums<1 but it's still ok");
        ListNode insert=singlyLinkedList.insertInSortedList(head,8);
        singlyLinkedList.display(insert);
        */

        System.out.println();
        ListNode deletee=singlyLinkedList.deleteKeyNode(head,9);
        singlyLinkedList.display(deletee);

    }
}