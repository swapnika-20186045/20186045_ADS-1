class Node {
	int data;
	Node next;

	Node() {
		//unused.
	}

	Node(int data) {
		this.data = data;
	}
}

class Queue {
	private Node head;
	private Node tail;
	public int size;

	Queue() {
		head = new Node();
		tail = new Node();
		size = 0;
	}

	void enqueue (int item) {
		Node temp = new Node(item);
		if (size == 0) {
			head = temp;
			tail = temp;
			size++;
			return;
		}
		tail.next = temp;
		tail = temp;
		size++;
	}

	int dequeue() {
		int data = head.data;
		head = head.next;
		size--;
		return data;
	}

	boolean isEmpty() {
		return size == 0;
	}

	int size() {
		return size;
	}
}