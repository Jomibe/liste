package verkettete_listen;

public class Liste {
	private Element start;
	private Element ende;
	private Element aktuell;
	private Element neu;

	@SuppressWarnings("unused")
	public Liste() {
		Element start;
		Element ende;
		Element aktuell;
		Element neu;
	}

	public Element getStart() {
		return start;
	}

	public void setStart(Element _start) {
		this.start = _start;
	}

	public Element getEnde() {
		return ende;
	}

	public void setEnde(Element _ende) {
		this.ende = _ende;
	}

	public Element getAktuell() {
		return aktuell;
	}

	public void setAktuell(Element _aktuell) {
		this.aktuell = _aktuell;
	}

	public Element getNeu() {
		return neu;
	}

	public void setNeu(Element _neu, int _value) {
		_neu.setValue(_value);
		this.neu = _neu;
	}

	public void printListe() {
		System.out.println("START: " + this.getStart().getValue());
		System.out.println("---");

		aktuell = this.getStart();
		while (aktuell != null) {
			if (aktuell.getPrev() != null) {
				System.out.println("Prev: " + aktuell.getPrev().getValue());
			}

			else {
				System.out.println("Prev: null");
			}
			System.out.println(aktuell.getValue());
			if (aktuell.getNext() != null) {
				System.out.println("Next: " + aktuell.getNext().getValue());
			}

			else {
				System.out.println("Next: null");
			}
			System.out.println("---");
			aktuell = aktuell.getNext();
		}

		System.out.println("ENDE: " + this.getEnde().getValue());
	}

	public Element getElementByValue(int _value) {
		aktuell = this.getStart();
		while (aktuell.getValue() != _value) {
			aktuell = aktuell.getNext();
		}

		return aktuell;
	}

	public void addElement(int _value) {
		if (this.getStart() == null & this.getEnde() == null) {
			this.addFirstElement(_value);
		}

		else {

			if (_value < this.getStart().getValue()) {
				this.addElementBeforeStart(_value);
			}

			else if (_value > this.getStart().getValue()) {
				if (_value > this.getEnde().getValue()) {
					this.addElementAfterEnde(_value);
				}

				else {
					this.addElementBetween(_value);
				}
			}

		}
	}

	public void addElementBeforeStart(int _value) {
		System.out.println("DEBUG: Lege neues Element " + _value + " vor Start an.");
		this.setNeu(new Element(_value), _value);
		this.getNeu().setNext(this.getStart());
		this.getStart().setPrev(this.getNeu());
		this.setStart(this.getNeu());
		this.getNeu().setPrev(null);
	}

	public void addElementAfterEnde(int _value) {
		System.out.println("DEBUG: Lege neues Element " + _value + " nach Ende an.");
		this.setNeu(new Element(_value), _value);
		this.getNeu().setPrev(this.getEnde());
		this.getEnde().setNext(this.getNeu());
		this.setEnde(this.getNeu());
		this.getNeu().setNext(null);
	}

	// TODO addElementBetween
	public void addElementBetween(int _value) {
		System.out.println("DEBUG: Lege neues Element " + _value + " nach Element "
				+ getElementByValue(_value - 1).getValue() + " an.");
		this.setAktuell(this.getElementByValue(_value - 1));
		if (this.getAktuell().getNext().getValue() == _value) {
			System.out.println("ERROR: Element " + _value + " existiert schon!");
		}

		else {
			this.setNeu(new Element(_value), _value);
			this.getNeu().setPrev(this.getAktuell());
			this.getNeu().setNext(this.getAktuell().getNext());
			this.getAktuell().setNext(this.getNeu());
			this.getAktuell().getNext().setPrev(this.getAktuell());
		}
	}

	public void addFirstElement(int _value) {
		System.out.println("DEBUG: Lege erstes Element " + _value + " an.");
		this.setNeu(new Element(_value), _value);
		this.getNeu().setNext(null);
		this.getNeu().setPrev(null);
		this.setStart(this.getNeu());
		this.setEnde(this.getNeu());
	}

	// TODO removeDuplicate Methode, welche doppelte Einträge entfernt
	// TODO merge Methode, welche mehrere Listen sortiert
	// TODO append Methode, welche eine Liste vorne oder hinten anfuegt
}
