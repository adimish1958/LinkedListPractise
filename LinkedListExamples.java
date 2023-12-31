import java.util.Scanner;

public class LinkedListExamples {
	static class Node{
		int data;
		Node next;
		Node(int d){
			data =d;
			next=null;
		}
		
	}
	public static Node head=null;
	
	//Method to insert a new node
	public void insert(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
		}
		else {
			Node last=head;
			while(last.next!=null) {
				last=last.next;
			}
			last.next=newNode;
		}
	}
	
	public Node delete(Node temp,int data) {
		if(temp.data==data)
		{
			Node del=temp;
			temp=temp.next;
			del.next=null;
		}
		else {
		while(temp.next.data!=data && temp!=null) {
			temp=temp.next;
		}
		Node del=temp.next;
		temp.next=temp.next.next;
		del.next=null;
	}
		return temp;
	}
	
	public Node reverse(Node temp) {
		Node curr=temp;
		Node prev=null;
		Node next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
		
	}
	
	public Node reverseInGroup(Node temp,int k) {
		Node curr=temp;
		Node prev=null;
		Node next=null;
		int count =0;
		while(curr!=null&&count<k) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			count++;
		}
		if(next!=null)
			temp.next=reverseInGroup(next,k);
		
		return prev;
		
	}
	
	
	
	//Method to print
	public void printList() {
		Node temp=head;
		while (temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		if(temp==null) {
			System.out.print("null");
			System.out.println();
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListExamples ll=new LinkedListExamples();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter How many nodes");
		int numberofNodes=sc.nextInt();
		for(int i=0; i<numberofNodes;i++) {
			System.out.println("enter node value"+i);
			ll.insert(sc.nextInt());
		}
		ll.printList();
		head=ll.reverse(head);
		ll.printList();
		head=ll.reverseInGroup(head,2);
		ll.printList();
		head=ll.delete(head,5);
		ll.printList();

	}

}
