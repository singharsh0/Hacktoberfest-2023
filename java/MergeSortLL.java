package LL2;

import java.util.Scanner;
import Linkedlist.Node;

public class MergeSortLL {

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

	public static Node<Integer> midPointbetter(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast = head;

		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;	
		}
		return slow;
	}

	public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> head = null,tail = null;
		Node<Integer> t1 = head1, t2 = head2;
		if(t1.data<=t2.data) {
			head = t1;
			tail = t1;
			t1 = t1.next;
		}else {
			head = t2;
			tail = t2;
			t2 = t2.next;		
		}
		while(t1!=null && t2!=null) {
			if(t1.data<=t2.data) {
				tail.next = t1;
				tail = t1;
				t1 = t1.next;
			}else {
				tail.next = t2;
				tail = t2;
				t2 = t2.next;
			}
		}
		if(t1!=null) {
			tail.next = t1;
		}else {
			tail.next =t2;
		}
		
		return head;
	}

	public static Node<Integer> mergeSort(Node<Integer> head) {
		if(head==null || head.next == null) {
			return head;
		}
		Node<Integer> midpoint = midPointbetter(head);
		Node<Integer> secondsort = mergeSort(midpoint.next);
		midpoint.next = null;
		Node<Integer> firstsort = mergeSort(head);
		Node<Integer> sorted = mergeTwoSortedLinkedLists(firstsort, secondsort);
		
		return sorted;
		
	}
	public static void main(String[] args){
		Node<Integer> head = takeInput1();
		Node<Integer> temp1= mergeSort(head);
		print(temp1);
	}
}
