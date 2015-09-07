class Node<T> {
	T element;
	Node<T> nextElement;
	Node<T> previousElement;

	public void setElement(T element) {
		this.element = element;
	}

	public T getElement() {
		return this.element;
	}

	public void setNextElement(Node<T> nextElement) {
		this.nextElement = nextElement;
	}

	public Node<T> getNextElement() {
		return this.nextElement;
	}

	public void setPreviousElement(Node<T> previousElement) {
		this.previousElement = previousElement;
	}

	public Node<T> getPreviousElement() {
		return this.previousElement;
	}
}