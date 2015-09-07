@SuppressWarnings("unchecked")

class SingleLinkedList<T> {
	Node<T> head;
	Node<T> tail;

	public Node<T> getHead() {
		return this.head;
	}

	public Node<T> getTail() {
		return this.tail;
	}

	public void insertElement(T elemnet) {
		Node<T> node = new Node<T>();
		node.setElement(elemnet);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.setPreviousElement(tail);
			tail.setNextElement(node);
			tail = node;
		}
	}

	public void insertAfterElement(T elemnet1, T elemnet2) {
		Node<T> node = head;
		Node<T> refNode = null;
		while (true) {
			if (node == null) {
				break;
			}
			if (node.getElement().equals(elemnet1)) {
				refNode = node;
				break;
			}
			node = node.getNextElement();
		}
		if (refNode != null) {
			Node<T> nextNode = new Node<T>();
			nextNode.setElement(elemnet2);
			nextNode.setPreviousElement(refNode);
			nextNode.setNextElement(node.getNextElement());
			if (node.getNextElement() != null) {
				Node<T> n1 = node.getNextElement();
				n1.setPreviousElement(nextNode);				
			}
			if (node.getElement().equals(tail.getElement())) {
				tail = nextNode;
			}
			node.setNextElement(nextNode);
		} else {
			System.out.println("Element is not present");
		}
	}

	public void insertBeforeElement(T elemnet1, T elemnet2) {
		Node<T> beforeNode = tail;
		Node<T> refNode = null;
		while (true) {
			if (beforeNode == null) {
				break;
			}
			if (beforeNode.getElement().equals(elemnet1)) {
				refNode = beforeNode;
				break;
			}
			beforeNode = beforeNode.getPreviousElement();
		}
		if (refNode != null) {
			Node<T> previousNode = new Node<T>();
			previousNode.setElement(elemnet2);
			previousNode.setNextElement(refNode);
			previousNode.setPreviousElement(beforeNode.getPreviousElement());
			Node<T> n1 = refNode.getPreviousElement();
			n1.setNextElement(previousNode);
			if (beforeNode.getElement().equals(head.getElement())) {
				head = previousNode;
			}
			beforeNode.setPreviousElement(previousNode);
		} else {
			System.out.println("Element is not present");
		}
	}

	public void removeAtIndex(int index) {
		int count = 0;
		int flag = 0;
		Node<T> node = head;
		while (true) {
			count++;
			if (count == index) {
				flag = 1;
				Node<T> n1 = node.getPreviousElement();
				n1.setNextElement(node.getNextElement());
				break;
			}
			node = node.getNextElement();
		}
		if (flag == 0) {
			System.out.println("Index is not found");
		}
	}

	public void removeElement(T elemnet) {
		Node<T> node = head;
		int flag = 0;
		while (true) {
			if (node.getElement().equals(elemnet)) {
				flag = 1;
				Node<T> n1 = node.getPreviousElement();
				n1.setNextElement(node.getNextElement());
				break;
			}
			node = node.getNextElement();
		}
		if (flag == 0) {
			System.out.println("Element not found");
		}
	}

	public void popFront() {
		head = head.getNextElement();
	}

	public void popBack() {
		Node<T> n1 = tail.getPreviousElement();
		n1.setNextElement(null);
		tail = n1;
	}

	public void pushFront(T elemnet) {
		Node<T> n1 = new Node<T>();
		n1.setElement(elemnet);
		n1.setNextElement(head);
		head.setPreviousElement(n1);
		head = n1;
	}

	public void pushBack(T elemnet) {
		Node<T> n1 = new Node<T>();
		n1.setElement(elemnet);
		n1.setPreviousElement(tail);
		tail.setNextElement(n1);
		tail = n1;
	}

	public void concatList(SingleLinkedList list) {
		tail.setNextElement(list.getHead());
		tail = list.getTail();
	}

	public void concatListAtIndex(SingleLinkedList list, int index) {
		int count = 0;
		Node<T> node = head;
		while (true) {
			count++;
			if (count == index) {
				Node<T> n1 = node.getNextElement();
				Node<T> n2 = list.getHead();
				Node<T> n3 = list.getTail();
				n1.setPreviousElement(n3);
				n2.setPreviousElement(node);
				node.setNextElement(n2);
				n3.setNextElement(n1);
				break;
			}
			node = node.getNextElement();
		}
	}

	public void makeEmpty() {
		head = null;
	}

	public void print() {
		Node<T> printNode = head;
		int flag = 0;
		while (printNode != null) {
			flag = 1;
			System.out.println(printNode.getElement());
			printNode = printNode.getNextElement();
		}
		if (flag == 0) {
			System.out.println("List is empty");
		}
	}

	public void printReverse() {
		Node<T> printNode = tail;
		if (head != null) {
			while (printNode != null) {
			System.out.println(printNode.getElement());
			printNode = printNode.getPreviousElement();
			}
		} else {
			System.out.println("List is empty");
		}
	}
}