
public class LinkedListTest extends SinglyLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list=new SinglyLinkedList<Integer>();
		list.addToFront(2);
		list.addToFront(3);
		System.out.println(list);
	}
}
