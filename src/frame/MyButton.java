package frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton {

	private static final long serialVersionUID = 1L;

	public MyButton(String text) {
		super.setText(text);
		super.setFocusable(false);
	}

	public MyButton(String text, ImageIcon icon) {
		super.setText(text);
		super.setIcon(icon);
		super.setFocusable(false);
	}

}
