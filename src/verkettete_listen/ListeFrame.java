package verkettete_listen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListeFrame extends JFrame {
	private JProgressBar jProgressBar1 = new JProgressBar();
	private JButton jButton1 = new JButton();
	private JSpinner jSpinner1 = new JSpinner();
	private SpinnerNumberModel jSpinner1Model = new SpinnerNumberModel(0, 0, 100, 1);

	public ListeFrame() {
		super();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 300;
		int frameHeight = 300;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setTitle("fenster");
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);

		jProgressBar1.setBounds(5, 250, 285, 16);
		jProgressBar1.setStringPainted(true);
		jProgressBar1.setMinimum(0);
		jProgressBar1.setMaximum(100000);
		jProgressBar1.setValue(50);
		cp.add(jProgressBar1);
		jButton1.setBounds(32, 144, 75, 25);
		jButton1.setText("jButton1");
		jButton1.setMargin(new Insets(2, 2, 2, 2));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		cp.add(jButton1);
		jSpinner1.setBounds(168, 152, 30, 24);
		jSpinner1.setValue(0);
		jSpinner1.setModel(jSpinner1Model);
		cp.add(jSpinner1);

		setVisible(true);
	}

	public void jButton1_ActionPerformed(ActionEvent evt) {
		this.setProgress(20);
	}

	public void setProgress(int _progress) {
		if (_progress > 0 && _progress < 100000) {
			jProgressBar1.setValue(_progress);
		}

		else {
			System.out.println("ERROR: " + _progress + " ist nicht im Bereich 0 - 100!");
		}
	}
}
