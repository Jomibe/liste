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
		// TODO Fehler wenn Liste leer ist
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

	// TODO getter setter
	public Element getElementByValue(int _value) {
		aktuell = this.getStart();
		while (aktuell.getValue() != _value) {
			if (aktuell.getNext() != null) {
				aktuell = aktuell.getNext();
			} else {
				this.setAktuell(null);
				System.out.println("DEBUG: Es gibt kein Element " + _value + ".");
				break;
			}
		}
		return aktuell;
	}

	public Element getNextSmallerElement(int _value) {
		aktuell = this.getStart();
		while (aktuell.getNext().getValue() < _value) {
			aktuell = aktuell.getNext();
		}
		return aktuell;
	}

	public void addElement(int _value) {
		// Liste leer?
		if (this.getStart() == null & this.getEnde() == null) {
			this.addFirstElement(_value);
		}
		// Existiert das Element noch nicht?
		else if (this.getElementByValue(_value) == null) {
			// Kleiner als start?
			if (_value < this.getStart().getValue()) {
				this.addElementBeforeStart(_value);
			}
			// Groesser als Ende?
			else if (_value > this.getEnde().getValue()) {
				this.addElementAfterEnde(_value);
			}
			// Fuege nach dem naechstkleineren ein
			else {
				this.addElementBetween(_value);
			}
		}

		else {
			System.out.println("ERROR: Element " + _value + " existiert schon!");
		}
	}

	private void addElementBeforeStart(int _value) {
		System.out.println("DEBUG: Lege neues Element " + _value + " vor Start an.");
		this.setNeu(new Element(_value), _value);
		this.getNeu().setNext(this.getStart());
		this.getStart().setPrev(this.getNeu());
		this.setStart(this.getNeu());
		this.getNeu().setPrev(null);
	}

	private void addElementAfterEnde(int _value) {
		System.out.println("DEBUG: Lege neues Element " + _value + " nach Ende an.");
		this.setNeu(new Element(_value), _value);
		this.getNeu().setPrev(this.getEnde());
		this.getEnde().setNext(this.getNeu());
		this.setEnde(this.getNeu());
		this.getNeu().setNext(null);
	}

	private void addElementBetween(int _value) {
		// Finde naechstkleineres Element
		this.setAktuell(this.getNextSmallerElement(_value));
		// Fuege danach ein
		this.setNeu(new Element(_value), _value);
		System.out.println("DEBUG: Lege Element " + this.getNeu().getValue() + " nach Element "
				+ this.getAktuell().getValue() + " an.");
		this.getNeu().setNext(this.getAktuell().getNext());
		this.getAktuell().getNext().setPrev(this.getNeu());
		this.getAktuell().setNext(this.getNeu());
		this.getNeu().setPrev(this.getAktuell());
	}

	private void addFirstElement(int _value) {
		System.out.println("DEBUG: Lege erstes Element " + _value + " an.");
		this.setNeu(new Element(_value), _value);
		this.getNeu().setNext(null);
		this.getNeu().setPrev(null);
		this.setStart(this.getNeu());
		this.setEnde(this.getNeu());
	}
	
	public void deleteElement(int _value) {
		//Liste leer?
		if(this.getStart() == null & this.getEnde() == null) {
			System.out.println("ERROR: Kann Element nicht entfernen, Liste ist leer");
		}
		
		//Liste hat nur noch ein Element?
		else if(this.getStart() == this.getEnde()) {
			this.deleteLastElement();
		}
		
		//Existiert das Element?
		else if(this.getElementByValue(_value) != null) {
			aktuell = this.getElementByValue(_value);
			
			//Steht das Element am Start?
			if(this.getAktuell() == this.getStart()) {
				this.deleteStartElement(_value);
			}
			
			// Steht das Element am Ende?
			if(this.getAktuell() == this.getEnde()) {
				this.deleteEndeElement(_value);
			}
		
			//Entferne Element in der Mitte
			else {
				this.deleteElementBetween(_value);
			}
		}
	}
	
	private void deleteStartElement(int _value) {
		System.out.println("DEBUG: Entferne erstes Element " + _value + ".");
		this.setAktuell(this.getStart());
		this.getStart().getNext().setPrev(null);
		this.setStart(this.getStart().getNext());
		this.getAktuell().setNext(null);
		System.out.println("Der Start liegt nun bei " + this.getStart() + ".");
		
		this.setAktuell(null);
	}
	
	private void deleteLastElement() {
		System.out.println("DEBUG: Entferne letztes vorhandenes Element " + this.getStart().getValue() + ".");
		this.setStart(null);
		this.setEnde(null);
	}
	
	private void deleteEndeElement(int _value) {
		System.out.println("DEBUG: Entferne letztes Element " + _value);
		this.setAktuell(this.getEnde());
		this.setEnde(this.getEnde().getPrev());
		this.getEnde().setNext(null);
		this.getAktuell().setPrev(null);
		System.out.println("DEBUG: Das Ende liegt nun bei " + this.getEnde());
		
		this.setAktuell(null);		
	}
	
	private void deleteElementBetween(int _value) {
		System.out.println("DEBUG: Entferne Element " + _value);
		this.setAktuell(this.getElementByValue(_value));
		this.getAktuell().getPrev().setNext(this.getAktuell().getNext());
		this.getAktuell().getNext().setPrev(this.getAktuell().getPrev());
		this.getAktuell().setNext(null);
		this.getAktuell().setPrev(null);
		this.setAktuell(null);
	}

	// TODO removeDuplicate Methode, welche doppelte Einträge entfernt
	// TODO merge Methode, welche mehrere Listen sortiert
	// TODO append Methode, welche eine Liste vorne oder hinten anfuegt
}
