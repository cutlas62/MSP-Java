class Node {

	private Node next;
	private int data;

	public Node getNext() {
		return this.next;
	}

	public int getData() {
		return this.data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setData(int data) {
		this.data = data;
	}

}

public class MyLinkedList {

	private Node first;

	public static void main(String args[]) {
		MyLinkedList lista = new MyLinkedList();

		lista.add(198);
		lista.add(388);
		lista.add(551);
		lista.add(160);
		lista.add(23);
		lista.add(860);
		lista.add(891);
		lista.add(448);
		lista.add(607);
		lista.add(539);
		lista.add(681);
		lista.add(518);
		lista.add(19);
		lista.add(428);
		lista.add(667);
		lista.add(998);
		lista.add(171);
		lista.printAll();
		System.out.println("lista: " + lista.getNumberOfElements());
		System.out.println();

		MyLinkedList list = lista.Sort(lista);

		list.printAll();
		System.out.println("list: " + list.getNumberOfElements());
	}

	public void add(int data) {

		if (this.first == null) {
			Node New = new Node();
			New.setData(data);
			this.first = New;
			return;
		}
		Node newOne = new Node();
		newOne.setData(data);
		Node current = first;

		while (current.getNext() != null) {
			current = current.getNext();
		}

		current.setNext(newOne);
	}

	public void delete(int data) {
		Node current = first;
		if (current.getData() == data) {
			first = current.getNext();
			return;
		}

		while (current.getNext() != null) {
			if (current.getNext().getData() == data) {
				current.setNext(current.getNext().getNext());
			}
			current = current.getNext();
		}

	}

	public void printAll() {
		Node current = first;
		System.out.println(current.getData());
		while (current.getNext() != null) {
			current = current.getNext();
			System.out.println(current.getData());
		}
	}

	public int getNumberOfElements() {
		int number = 0;
		if (this.first == null) {
			return number;
		}

		if (this.first != null) {
			number++;
		}
		Node current = this.first;
		while (current.getNext() != null) {
			number++;
			current = current.getNext();
		}
		return number;
	}

	public int getElementByIndex(int pos) {

		Node current = first;

		for (int i = 0; i < pos; i++) {
			current = current.getNext();
		}

		return current.getData();
	}

	public void RemoveElementByIndex(int pos) {
		Node current = first;

		if (pos == 0) {
			this.first = current.getNext();
			return;
		}

		for (int i = 0; i < pos - 1; i++) {
			current = current.getNext();
		}

		if (current.getNext().getNext() != null) {
			current.setNext(current.getNext().getNext());
		} else {
			current.setNext(null);
		}
	}

	public MyLinkedList Sort(MyLinkedList ListToSort) {
		MyLinkedList less = new MyLinkedList();
		MyLinkedList greater = new MyLinkedList();

		int Number = ListToSort.getNumberOfElements();

		if (Number <= 1) {
			return ListToSort;
		}
		int pos = (int) (Number / 2);

		int pivot = ListToSort.getElementByIndex(pos);
		ListToSort.RemoveElementByIndex(pos);

		Number -= 1;

		for (int i = 0; i < Number; i++) {
			int x = ListToSort.getElementByIndex(i);
			if (x <= pivot) {
				less.add(x);
			} else {
				greater.add(x);
			}
		}

		return concatenate(less.Sort(less), pivot, greater.Sort(greater));
	}

	public MyLinkedList concatenate(MyLinkedList less, int pivot,
			MyLinkedList greater) {

		MyLinkedList sorted = new MyLinkedList();

		sorted = less;

		sorted.add(pivot);

		int Number = greater.getNumberOfElements();
		for (int i = 0; i < Number; i++) {
			sorted.add(greater.getElementByIndex(i));
		}

		return sorted;
	}

}

