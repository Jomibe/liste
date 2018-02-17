package verkettete_listen;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class ListeFrame extends JFrame {
	  public ListeFrame() { 
		    super();
		    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		    int frameWidth = 674; 
		    int frameHeight = 664;
		    setSize(frameWidth, frameHeight);
		    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		    int x = (d.width - getSize().width) / 2;
		    int y = (d.height - getSize().height) / 2;
		    setLocation(x, y);
		    setTitle("listeFrame");
		    setResizable(false);
		    java.awt.Container cp = getContentPane();
		    cp.setLayout(null);
		    // Anfang Komponenten
		    
		    // Ende Komponenten
		    
		    setVisible(true);
		  } // end of public listeFrame
		  
		  // Anfang Methoden
		  
		  public static void main(String[] args) {
		    new ListeFrame();
		  } // end of main
}
