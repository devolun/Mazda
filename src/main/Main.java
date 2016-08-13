package main;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import frame.MyFrame;

public class Main {

	public static void main(String[] args)
			throws UnsupportedLookAndFeelException, SQLException {

		UIManager.setLookAndFeel(new AeroLookAndFeel());
		JFrame.setDefaultLookAndFeelDecorated(true);

		MyFrame frame = new MyFrame("MazdaCars v1.0 by Yevhen Nenko", 600, 400);

		frame.setVisible(true);

	}

}
