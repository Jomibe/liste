package verkettete_listen;

public class Element {
	private int value;
	private Element prev;
	private Element next;

	@SuppressWarnings("unused")
	public Element(int _value) {
		int value = _value;
		Element prev = null;
		Element next = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int _value) {
		this.value = _value;
	}

	public Element getPrev() {
		return prev;
	}

	public void setPrev(Element _prev) {
		this.prev = _prev;
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element _next) {
		this.next = _next;
	}

	public static void main(String[] args) {
		System.out.println("DEBUG: Lege Liste an.");
		Liste liste = new Liste();

		liste.addElement(5);
		liste.addElement(3);
		liste.addElement(4);

		System.out.println("DEBUG: Gebe Liste aus.");
		liste.printListe();
	}

}