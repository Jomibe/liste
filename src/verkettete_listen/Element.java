package verkettete_listen;

import java.util.Random;

public class Element {
	static Random generator = new Random();

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

	public static int getRandom() {
		int random = generator.nextInt(1000000);
		return random;
	}

	public static void main(String[] args) {
		System.out.println("DEBUG: Lege Liste an.");
		Liste liste = new Liste();

		for (int i = 0; i < 1000000000; i++) {
			liste.addElement(getRandom());
		}

		liste.printListe();
	}

}