package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

public class MyJTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	public MyJTextField(String text) {
		super.setText(text);
		super.setBorder(null);
		Font h1 = new Font("SansSerif", Font.BOLD, 20);
		super.setFont(h1);
		super.setEditable(false);
		super.setBackground(Color.WHITE);
		super.setPreferredSize(new Dimension(450, 35));
	}

}
