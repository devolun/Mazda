package frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class PanelButtonsCenter extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelButtonsCenter() {
		super.setPreferredSize(new Dimension(600, 250));
		super.setLayout(new FlowLayout());
		super.setVisible(false);
	}

}
