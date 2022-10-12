import java.util.Scanner;

import Linkedlist.Node;

public class DeleteEveryNnodes {
	public static Node<Integer> takeInput1(){
		Scanner s= new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail = null;
		while(data != -1){
			Node<Integer> currentNode= new Node<Integer>(data);
			if(head==null){
				head=currentNode;
				tail=currentNode;
			}else{
				tail.next = currentNode;
				tail=currentNode;    //tail=tail.next;
			}
			data=s.nextInt();
		}
		return head;
	}

	public static void print(Node<Integer> head){
		while(head!= null){
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}

	public static Node<Integer> evenAfterOdd(Node<Integer> head) {
		//1 11 3 6 8 0 9 -1
		if(head ==null || head.next == null) {
			return head;
		}
		Node<Integer> temp = head,oddhead = null,oddtail =null,evenhead = null,eventail=null;

		while(temp!=null) {
			if(temp.data%2 !=0) {
				if(oddhead == null) {
					oddhead = temp;
					oddtail = temp;
				}else {
					oddtail.next = temp;
					oddtail = oddtail.next;
				}
			}else {
				if(evenhead == null) {
					evenhead = temp;
					eventail = temp;
				}else {
					eventail.next = temp;
					eventail = eventail.next;
				}
			}
			temp = temp.next;
		}
		eventail.next = null;
		if(oddhead==null) {
			return evenhead;
		}
		//		else if(evenhead==null) {
		//			return oddhead;
		//		}
		oddtail.next = evenhead;

		return oddhead;
	}

	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		if(head ==null || head.next == null) {
			return head;
		}
		Node<Integer> temp = head,temp1 = head;
		int count1 = M, count2 = N;
		while(temp!=null) {
			if(count1==1) {
				
				//System.out.println(count2+" "+count1);
				if(count2==0) {
					temp1.next = temp.next;
					System.out.println(temp.data);
					//print(head);
					count2 = N;
					count1 = M;
				}else {
					count2--;
//					System.out.println(count2+" "+temp.data);
				}
				
			}else {
				temp1 = temp1.next;
				count1--;
			}
			temp = temp.next;
//			temp1 = temp1.next;
		}
		return head;
	}
	public static void main(String[] args){
		Node<Integer> head = takeInput1();
		Node<Integer> temp1= skipMdeleteN(head,2,2);
		print(temp1);
	}
}
