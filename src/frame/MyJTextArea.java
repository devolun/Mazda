package frame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;

public class MyJTextArea extends JTextArea {

	private static final long serialVersionUID = 1L;

	String welcome = "Welcome Mazda Owners.";

	public MyJTextArea() {

		super.setText(welcome);
		super.setPreferredSize(new Dimension(450, 140));
		super.setBackground(Color.WHITE);
		super.setLineWrap(true);
		super.setEditable(false);
		super.setWrapStyleWord(true);

	}

}
