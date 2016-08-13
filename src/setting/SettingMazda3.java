package setting;

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

public class SettingMazda3 extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textField_oil;
	private JTextField textField_breaks;
	private JTextField textField_belt;

	MazdaStrings txt = new MazdaStrings();

	String changeOilText = txt.changeOilText;
	String changeBrakesText = txt.changeBrakesText;
	String changeBeltText = txt.changeBeltText;
	String checkInt = txt.checkInt;
	String btnSave = txt.save;

	public SettingMazda3() {

		setLayout(new MigLayout("", "[85.00px][86.00][100.00px,grow]", "[][][][20.00][20.00][40.00][]"));

		final JLabel label = new JLabel(changeOilText);
		add(label, "cell 0 0,growx,aligny top");

		textField_oil = new JTextField();
		textField_oil.setText("");
		add(textField_oil, "cell 1 0,growx,aligny top");
		textField_oil.setColumns(10);

		JButton btnOilOld = new JButton(btnSave, new ImageIcon("res/save.png"));
		add(btnOilOld, "cell 2 0");

		// проверка на ввод целого числа в поле "замена масла"
		btnOilOld.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int oilOld = Integer.parseInt(textField_oil.getText());
					MazdaDB.getInstance().inDB("Mazda3_oil", "change", oilOld);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, checkInt);
				}
			}
		});

		JLabel label_2 = new JLabel(changeBeltText);
		add(label_2, "cell 0 1,alignx left");

		textField_belt = new JTextField();
		add(textField_belt, "cell 1 1,growx");
		textField_belt.setColumns(10);

		JButton btnBeltOld = new JButton(btnSave, new ImageIcon("res/save.png"));
		add(btnBeltOld, "cell 2 1");

		// проверка на ввод целого числа в поле "замена ремня"
		btnBeltOld.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int beltOld = Integer.parseInt(textField_belt.getText());
					MazdaDB.getInstance().inDB("Mazda3_belt", "change", beltOld);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, checkInt);
				}

			}
		});

		JLabel label_1 = new JLabel(changeBrakesText);
		add(label_1, "cell 0 2,alignx left");

		textField_breaks = new JTextField();
		add(textField_breaks, "cell 1 2,growx");
		textField_breaks.setColumns(10);

		JButton btnBreaksOld = new JButton(btnSave, new ImageIcon("res/save.png"));
		add(btnBreaksOld, "cell 2 2");

		// проверка на ввод целого числа в поле "замена колодок"
		btnBreaksOld.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int oilOld = Integer.parseInt(textField_breaks.getText());
					MazdaDB.getInstance().inDB("Mazda3_breaks", "change", oilOld);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, checkInt);
				}

			}
		});

	}

}
