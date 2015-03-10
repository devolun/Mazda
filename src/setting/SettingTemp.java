package setting;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class SettingTemp extends JPanel {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_tires;
	private JTextField textField_oil;
	private JTextField textField_belts;
	private JTextField textField_breaks;


//	public static void main(String[] args) {
//		try {
//			SettingTemp dialog = new SettingTemp();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public SettingTemp() {
	//	setResizable(false);
	//	setTitle("Установка настроек");
		setBounds(100, 100, 350, 280);
	//	getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\u0423\u0441\u0442\u0430\u043D\u043E\u0432\u0438\u0442\u0435 \u043F\u0435\u0440\u0438\u043E\u0434\u0438\u0447\u043D\u043E\u0441\u0442\u044C \u0437\u0430\u043C\u0435\u043D\u044B (\u043A\u043C)");
		label.setBounds(32, 11, 264, 20);
		contentPanel.add(label);
		
		textField_tires = new JTextField();
		textField_tires.setBounds(146, 52, 150, 20);
		contentPanel.add(textField_tires);
		textField_tires.setColumns(10);
		
		textField_oil = new JTextField();
		textField_oil.setBounds(146, 83, 150, 20);
		contentPanel.add(textField_oil);
		textField_oil.setColumns(10);
		
		textField_belts = new JTextField();
		textField_belts.setBounds(146, 114, 150, 20);
		contentPanel.add(textField_belts);
		textField_belts.setColumns(10);
		
		textField_breaks = new JTextField();
		textField_breaks.setBounds(146, 145, 150, 20);
		contentPanel.add(textField_breaks);
		textField_breaks.setColumns(10);
		
		JLabel label_tires = new JLabel("\u0428\u0438\u043D\u044B");
		label_tires.setBounds(32, 55, 46, 14);
		contentPanel.add(label_tires);
		
		JLabel label_oil = new JLabel("\u041C\u0430\u0441\u043B\u043E");
		label_oil.setBounds(32, 86, 46, 14);
		contentPanel.add(label_oil);
		
		JLabel label_belts = new JLabel("\u0420\u0435\u043C\u043D\u0438");
		label_belts.setBounds(32, 117, 46, 14);
		contentPanel.add(label_belts);
		
		JLabel label_breaks = new JLabel("колодки");
		label_breaks.setBounds(32, 150, 46, 14);
		contentPanel.add(label_breaks);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(207, 240, 89, 23);
		contentPanel.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(8);
		textArea.setColumns(10);
		textArea.setLineWrap(true);
		textArea.setText("\u0432\u0432\u0435\u0434\u0438\u0442\u0435 \u0442\u0435\u043A\u0441\u0442 \u043F\u0440\u0438\u0432\u0435\u0442\u0441\u0442\u0432\u0438\u044F");
		textArea.setBounds(146, 184, 150, 29);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	//		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("\u041E\u0442\u043C\u0435\u043D\u0438\u0442\u044C");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("Сохранить");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
