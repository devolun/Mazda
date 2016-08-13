package journal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MazdaDB;
import main.MazdaStrings;
import net.miginfocom.swing.MigLayout;

public class JournalMazda3 extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textField_oil;
	private JTextField textField_breaks;
	private JTextField textField_belt;

	MazdaStrings txt = new MazdaStrings();
	String btnSave = txt.save;
	String checkInt = txt.checkInt;
	String oldOilChange = txt.oldOil;
	String oldBelt = txt.oldBelt;
	String oldBrakes = txt.oldBrakes;

	public JournalMazda3() {

		setLayout(new MigLayout("", "[85.00px][86.00][100.00px,grow]", "[][][][20.00][20.00][40.00][]"));

		final JLabel label = new JLabel(oldOilChange);
		add(label, "cell 0 0,growx,aligny top");

		textField_oil = new JTextField();
		textField_oil.setText("");
		add(textField_oil, "cell 1 0,growx,aligny top");
		textField_oil.setColumns(10);

		JButton btnOilOld = new JButton(btnSave, new ImageIcon("res/save.png"));
		add(btnOilOld, "cell 2 0");

		// Button last change oil Mazda3 (journal)
		btnOilOld.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int oilOld = Integer.parseInt(textField_oil.getText());
					MazdaDB.getInstance().inDB("Mazda3_oil", "change_old", oilOld);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, checkInt);
				}
			}
		});

		JLabel label_2 = new JLabel(oldBelt);
		add(label_2, "cell 0 1,alignx left");

		textField_belt = new JTextField();
		textField_belt.setText("");
		add(textField_belt, "cell 1 1");
		textField_belt.setColumns(10);

		JButton btnBeltOld = new JButton(btnSave, new ImageIcon("res/save.png"));
		add(btnBeltOld, "cell 2 1");
		btnBeltOld.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int beltOld = Integer.parseInt(textField_belt.getText());
					MazdaDB.getInstance().inDB("Mazda3_belt", "change_old", beltOld);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, checkInt);
				}

			}
		});

		JLabel label_1 = new JLabel(oldBrakes);
		add(label_1, "cell 0 2,alignx left");

		textField_breaks = new JTextField();
		textField_breaks.setText("");
		add(textField_breaks, "cell 1 2,growx");
		textField_breaks.setColumns(10);

		JButton btnBreaksOld = new JButton(btnSave, new ImageIcon("res/save.png"));
		add(btnBreaksOld, "cell 2 2");
		btnBreaksOld.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int breaksOld = Integer.parseInt(textField_breaks.getText());
					MazdaDB.getInstance().inDB("Mazda3_breaks", "change_old", breaksOld);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, checkInt);
				}

			}
		});

	}

}
