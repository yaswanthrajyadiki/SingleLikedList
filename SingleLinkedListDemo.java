class SingleLinkedListDemo {
	public static void main(String[] args) {
		SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
		SingleLinkedList<Integer> sll1 = new SingleLinkedList<Integer>(); 
		sll.insertElement(1);
		sll.insertElement(2);
		sll.insertElement(3);
		sll.insertElement(4);
		sll.insertAfterElement(4,5);
		sll.insertBeforeElement(3,6);
		sll.pushBack(0);
		sll1.insertElement(10);
		sll1.insertElement(14);
		sll1.insertAfterElement(10, 11);
		sll1.insertBeforeElement(14, 13);
		sll1.pushFront(7);
		sll1.insertAfterElement(7, 8);
		sll1.insertBeforeElement(10, 9);
		sll1.popBack();
		sll.concatListAtIndex(sll1, 3);
		sll.makeEmpty();
		sll.printReverse();
	}
}