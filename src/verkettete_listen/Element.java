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
		int random = generator.nextInt(10);
		return random;
	}

	public static void main(String[] args) {
		System.out.println("DEBUG: Lege Liste an.");
		Liste liste = new Liste();

		/*
		 * for(int i = 0; i<4; i++) { int ran = getRandom(); System.out.println("ran: "
		 * + ran); liste.addElement(ran); }
		 */

		liste.addElement(6);
		liste.addElement(9);
		liste.addElement(9);
		liste.addElement(10);
		liste.addElement(10);

		liste.printListe();
	}

}