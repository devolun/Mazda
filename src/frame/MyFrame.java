package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import journal.JournalMazda3;
import journal.JournalMazda6;
import journal.JournalMazdaCX5;
import main.Mazda3;
import main.Mazda6;
import main.MazdaCX5;
import main.MazdaDB;
import main.MazdaStrings;
import setting.SettingMazda3;
import setting.SettingMazda6;
import setting.SettingMazdaCX5;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyFrame(String title, int weight, int height) throws SQLException {
		ImageIcon img = new ImageIcon("res/mazda-logo.png");
		super.setIconImage(img.getImage());
		super.setTitle(title);
		super.setResizable(false);
		super.setSize(600, 400);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BorderLayout());

		final MyJTextField textField = new MyJTextField("Choose your car model");

		JPanel panelButtons = new JPanel();
		final JPanel panelDesc = new JPanel();

		final Mazda3 mazda3 = new Mazda3();
		final Mazda6 mazda6 = new Mazda6();
		final MazdaCX5 mazdacx5 = new MazdaCX5();

		final MyJTextArea textArrea = new MyJTextArea();

		String welcom = MazdaDB.getInstance().welcome("Mazda");
		textArrea.setText(welcom);

		final MyButton bMazda3 = new MyButton("Mazda 3", new ImageIcon(
				"res/mazda3.png"));
		final MyButton bMazda6 = new MyButton("Mazda 6", new ImageIcon(
				"res/mazda6.png"));
		final MyButton bMazdaCX5 = new MyButton("Mazda CX5", new ImageIcon(
				"res/mazda-cx5.png"));

		MazdaStrings txt = new MazdaStrings();
		String prices = txt.prices;
		String servise = txt.servise;
		String tyres = txt.tyres;
		String oil = txt.oil;
		String belts = txt.belts;
		String brakes = txt.brakes;
		String journal = txt.journal;
		String settings = txt.settings;
		final String oldOil = txt.oldOil;
		final String oldBelt = txt.oldBelt;
		final String oldBrakes = txt.oldBrakes;

		final String km = txt.txtKm;

		ImageIcon iconMazdaNotes = new ImageIcon("res/notes.png");
		ImageIcon iconMazdaOil = new ImageIcon("res/oil.png");
		ImageIcon iconMazdaWheel = new ImageIcon("res/wheel.png");
		ImageIcon iconMazdaBrake = new ImageIcon("res/brake.png");
		ImageIcon iconMazdaPrice = new ImageIcon("res/price.png");
		ImageIcon iconMazdaService = new ImageIcon("res/service.png");
		ImageIcon iconMazdaBelt = new ImageIcon("res/belt.png");
		ImageIcon iconSetting = new ImageIcon("res/setting.png");

		panelButtons.add(bMazda3);
		panelButtons.add(bMazda6);
		panelButtons.add(bMazdaCX5);

		panelDesc.setBackground(Color.WHITE);
		panelDesc.setPreferredSize(new Dimension(450, 150));

		panelDesc.add(textField); // add field Title of description
		panelDesc.add(textArrea); // add field description

		getContentPane().add(panelButtons, BorderLayout.PAGE_START);
		getContentPane().add(panelDesc, BorderLayout.SOUTH);

		final PanelButtonsCenter panelGridCenterMazda3 = new PanelButtonsCenter();

		MyButton buttonTOMazda3 = new MyButton(servise, iconMazdaService);
		panelGridCenterMazda3.add(buttonTOMazda3);
		buttonTOMazda3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String service = MazdaDB.getInstance().fromDB("Mazda3_oil",
							"change_old");
					String belt = MazdaDB.getInstance().fromDB("Mazda3_belt",
							"change_old");
					String breaks = MazdaDB.getInstance().fromDB(
							"Mazda3_breaks", "change_old");
					textArrea.setText(oldOil + service + km + "\n" + oldBelt
							+ belt + km + "\n" + oldBrakes + breaks + km);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		MyButton buttonOilMazda3 = new MyButton(oil, iconMazdaOil);
		panelGridCenterMazda3.add(buttonOilMazda3);
		buttonOilMazda3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					MazdaDB.getInstance();
					String oil = MazdaDB.getInstance().fromDB("Mazda3_oil",
							"name");
					int oilChange = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("Mazda3_oil", "change"));
					int oilOldChange = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("Mazda3_oil", "change_old"));
					int oilNext = oilOldChange + oilChange;
					textArrea.setText(oil + oilChange + km
							+ "\nMy last change: " + oilOldChange + km
							+ "\n\nNext change: " + oilNext + km);

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});

		MyButton buttonBeltMazda3 = new MyButton(belts, iconMazdaBelt);
		panelGridCenterMazda3.add(buttonBeltMazda3);
		buttonBeltMazda3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int beltChange = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("Mazda3_belt", "change"));
					int beltOld = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("Mazda3_belt", "change_old"));
					int beltNext = beltOld + beltChange;
					textArrea.setText("Change belt for Mazda 3 every: "
							+ beltChange + km + "\nMy last change: " + beltOld
							+ km + "\n\nNext change: " + beltNext + km);

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});

		MyButton buttonBreakstMazda3 = new MyButton(brakes, iconMazdaBrake);
		panelGridCenterMazda3.add(buttonBreakstMazda3);
		buttonBreakstMazda3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int oldBreaks = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("Mazda3_breaks", "change_old"));
					int recChange = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("Mazda3_breaks", "change"));
					int breaksChangeNext = oldBreaks + recChange;
					textArrea.setText("Change brakes for Mazda 3 every: "
							+ recChange + " or by sounds :-)"
							+ "\nMy last change: " + oldBreaks + km
							+ "\n\nNext change: " + breaksChangeNext + km);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		MyButton buttonTiresMazda3 = new MyButton(tyres, iconMazdaWheel);
		panelGridCenterMazda3.add(buttonTiresMazda3);

		buttonTiresMazda3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					MazdaDB.getInstance();
					String tires = MazdaDB.getInstance().fromDB("Mazda3",
							"tires");
					textArrea.setText(tires);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		final MyButton buttonDialogShow = new MyButton(journal, iconMazdaNotes);
		panelGridCenterMazda3.add(buttonDialogShow);

		buttonDialogShow.addActionListener(new ActionListener() {

			JournalMazda3 jm3 = new JournalMazda3();

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(panelGridCenterMazda3, jm3,
						"Journal of Accounting Services " + bMazda3.getText(),
						JOptionPane.OK_CANCEL_OPTION);
			}
		});

		MyButton buttonPriceMazda3 = new MyButton(prices, iconMazdaPrice);
		panelGridCenterMazda3.add(buttonPriceMazda3);
		buttonPriceMazda3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mazda3.setUrlMazda(mazda3.urlMazda);
				mazda3.goToLink();
			}
		});

		MyButton btnSettingMazda3 = new MyButton(settings, iconSetting);
		panelGridCenterMazda3.add(btnSettingMazda3);
		btnSettingMazda3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SettingMazda3 settingMazda3 = new SettingMazda3();
				JOptionPane.showConfirmDialog(panelGridCenterMazda3,
						settingMazda3,
						"Settings periods changes " + bMazda3.getText(),
						JOptionPane.CLOSED_OPTION);
			}
		});

		// end buttons Center Mazda3

		// Central Box Mazda6
		final PanelButtonsCenter panelGridCenterMazda6 = new PanelButtonsCenter();

		MyButton buttonTOMazda6 = new MyButton(servise, iconMazdaService);
		panelGridCenterMazda6.add(buttonTOMazda6);
		buttonTOMazda6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String service = MazdaDB.getInstance().fromDB("Mazda6_oil",
							"change_old");
					String belt = MazdaDB.getInstance().fromDB("Mazda6_belt",
							"change_old");
					String breaks = MazdaDB.getInstance().fromDB(
							"Mazda6_breaks", "change_old");
					textArrea.setText(oldOil + service + km + "\n" + oldBelt
							+ belt + km + "\n" + oldBrakes + breaks + km);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		MyButton buttonOilMazda6 = new MyButton(oil, iconMazdaOil);
		panelGridCenterMazda6.add(buttonOilMazda6);
		buttonOilMazda6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					String oil = MazdaDB.getInstance().fromDB("Mazda6_oil",
							"name");
					int change = Integer.parseInt(MazdaDB.getInstance().fromDB(
							"Mazda6_oil", "change"));
					int changeOld = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("Mazda6_oil", "change_old"));
					int changeNext = changeOld + change;
					textArrea.setText(oil + change + km + "\nMy last change: "
							+ changeOld + " km" + "\n\nNext change: "
							+ changeNext + " km");

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});

		MyButton buttonBeltMazda6 = new MyButton(belts, iconMazdaBelt);
		panelGridCenterMazda6.add(buttonBeltMazda6);

		buttonBeltMazda6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int change = Integer.parseInt(MazdaDB.getInstance().fromDB(
							"Mazda6_belt", "change"));
					int changeOld = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("Mazda6_belt", "change_old"));
					int changeNext = changeOld + change;
					textArrea.setText("Change belt for Mazda 6 every: "
							+ change + " km" + "\nMy last change: " + changeOld
							+ " km" + "\n\nNext change: " + changeNext + " km");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		MyButton buttonBreakstMazda6 = new MyButton(brakes, iconMazdaBrake);
		panelGridCenterMazda6.add(buttonBreakstMazda6);

		buttonBreakstMazda6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String breaks = MazdaDB.getInstance().fromDB(
							"Mazda6_breaks", "breaks");
					int change = Integer.parseInt(MazdaDB.getInstance().fromDB(
							"Mazda6_breaks", "change"));
					int changeOld = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("Mazda6_breaks", "change_old"));
					int changeNext = changeOld + change;

					textArrea.setText(breaks + change + " km"
							+ "\nMy last change: " + changeOld + " km"
							+ "\n\nNext change: " + changeNext + " km");

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});

		MyButton buttonTiresMazda6 = new MyButton(tyres, iconMazdaWheel);
		panelGridCenterMazda6.add(buttonTiresMazda6);
		buttonTiresMazda6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tires;
				try {
					tires = MazdaDB.getInstance().fromDB("Mazda6", "tires");
					textArrea.setText(tires);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		final MyButton buttonDialogShowMazda6 = new MyButton(journal,
				iconMazdaNotes);
		panelGridCenterMazda6.add(buttonDialogShowMazda6);

		buttonDialogShowMazda6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JournalMazda6 jm6 = new JournalMazda6();
				JOptionPane.showConfirmDialog(panelGridCenterMazda6, jm6,
						"Journal of Accounting Services " + bMazda6.getText(),
						JOptionPane.OK_CANCEL_OPTION);
			}
		});

		MyButton buttonPriceMazda6 = new MyButton(prices, iconMazdaPrice);
		panelGridCenterMazda6.add(buttonPriceMazda6);
		buttonPriceMazda6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mazda6.setUrlMazda(mazda6.urlMazda);
				mazda6.goToLink();
			}
		});

		MyButton btnSettingMazda6 = new MyButton(settings, iconSetting);
		panelGridCenterMazda6.add(btnSettingMazda6);
		btnSettingMazda6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SettingMazda6 setingMazda6 = new SettingMazda6();
				JOptionPane.showConfirmDialog(panelGridCenterMazda6,
						setingMazda6,
						"Settings periods changes " + bMazda6.getText(),
						JOptionPane.CLOSED_OPTION);
			}
		});

		// end buttons Center Mazda6

		// Main box for buttons MazdaCX 5
		final PanelButtonsCenter panelGridCenterMazdaCX5 = new PanelButtonsCenter();

		MyButton buttonTOMazdaCX5 = new MyButton(servise, iconMazdaService);
		panelGridCenterMazdaCX5.add(buttonTOMazdaCX5);
		buttonTOMazdaCX5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String service = MazdaDB.getInstance().fromDB(
							"MazdaCX5_oil", "change_old");
					String belt = MazdaDB.getInstance().fromDB("MazdaCX5_belt",
							"change_old");
					String breaks = MazdaDB.getInstance().fromDB(
							"MazdaCX5_breaks", "change_old");
					textArrea.setText(oldOil + service + km + "\n" + oldBelt
							+ belt + km + "\n" + oldBrakes + breaks + km);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		MyButton buttonOilMazdaCX5 = new MyButton(oil, iconMazdaOil);
		panelGridCenterMazdaCX5.add(buttonOilMazdaCX5);
		buttonOilMazdaCX5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					String oil = MazdaDB.getInstance().fromDB("MazdaCX5_oil",
							"name");
					int change = Integer.parseInt(MazdaDB.getInstance().fromDB(
							"MazdaCX5_oil", "change"));
					int changeOld = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("MazdaCX5_oil", "change_old"));
					int changeNext = changeOld + change;
					textArrea.setText(oil + change + " km"
							+ "\nMy last change: " + changeOld + " km"
							+ "\n\nNext change: " + changeNext + " km");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		MyButton buttonBeltMazdaCX5 = new MyButton(belts, iconMazdaBelt);
		panelGridCenterMazdaCX5.add(buttonBeltMazdaCX5);
		buttonBeltMazdaCX5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int change = Integer.parseInt(MazdaDB.getInstance().fromDB(
							"MazdaCX5_belt", "change"));
					int changeOld = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("MazdaCX5_belt", "change_old"));
					int changeNext = changeOld + change;
					textArrea.setText("Change belt for Mazda CX5 every: "
							+ change + " km" + "\nMy last change: " + changeOld
							+ " km" + "\n\nNext change: " + changeNext + " km");

				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}
			}
		});

		MyButton buttonBreakstMazdaCX5 = new MyButton(brakes, iconMazdaBrake);
		panelGridCenterMazdaCX5.add(buttonBreakstMazdaCX5);
		buttonBreakstMazdaCX5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String breaks = MazdaDB.getInstance().fromDB(
							"MazdaCX5_breaks", "breaks");
					int change = Integer.parseInt(MazdaDB.getInstance().fromDB(
							"MazdaCX5_breaks", "change"));
					int changeOld = Integer.parseInt(MazdaDB.getInstance()
							.fromDB("MazdaCX5_breaks", "change_old"));
					int changeNext = changeOld + change;
					textArrea.setText(breaks + change + " km"
							+ "\nMy last change: " + changeOld + " km"
							+ "\n\nNext change: " + changeNext + " km");

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		MyButton buttonTiresMazdaCX5 = new MyButton(tyres, iconMazdaWheel);
		panelGridCenterMazdaCX5.add(buttonTiresMazdaCX5);
		buttonTiresMazdaCX5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tires;
				try {
					tires = MazdaDB.getInstance().fromDB("MazdaCX5", "tires");
					textArrea.setText(tires);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		final MyButton buttonDialogShowMazdaCX5 = new MyButton(journal,
				iconMazdaNotes);
		panelGridCenterMazdaCX5.add(buttonDialogShowMazdaCX5);

		buttonDialogShowMazdaCX5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JournalMazdaCX5 jp = new JournalMazdaCX5();
				JOptionPane
						.showConfirmDialog(
								panelGridCenterMazdaCX5,
								jp,
								"Journal of Accounting Services "
										+ bMazdaCX5.getText(),
								JOptionPane.OK_CANCEL_OPTION);

			}
		});

		MyButton buttonPriceMazdaCX5 = new MyButton(prices, iconMazdaPrice);
		panelGridCenterMazdaCX5.add(buttonPriceMazdaCX5);
		buttonPriceMazdaCX5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mazdacx5.setUrlMazda(mazdacx5.urlMazda);
				mazdacx5.goToLink();
			}
		});

		MyButton btnSettingMazdaCX5 = new MyButton(settings, iconSetting);
		panelGridCenterMazdaCX5.add(btnSettingMazdaCX5);

		btnSettingMazdaCX5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SettingMazdaCX5 setingMazdaCX5 = new SettingMazdaCX5();
				JOptionPane.showConfirmDialog(panelGridCenterMazdaCX5,
						setingMazdaCX5,
						"Settings periods changes " + bMazdaCX5.getText(),
						JOptionPane.CLOSED_OPTION);
			}
		});

		// end buttons Center Mazda CX5

		add(panelGridCenterMazda3, BorderLayout.LINE_START);
		add(panelGridCenterMazda6, BorderLayout.CENTER);
		add(panelGridCenterMazdaCX5, BorderLayout.LINE_END);

		// ActionListener for Main button Mazda3
		bMazda3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(bMazda3.getText());
				panelGridCenterMazda3.setVisible(true);
				panelGridCenterMazda6.setVisible(false);
				panelGridCenterMazdaCX5.setVisible(false);

				try {
					String welcomeMazda3 = MazdaDB.getInstance().fromDB(
							"Mazda3", "welcome");
					textArrea.setText(welcomeMazda3);

				} catch (SQLException e) {
					e.printStackTrace();
				}
				bMazda3.setEnabled(false);
				bMazda6.setEnabled(true);
				bMazdaCX5.setEnabled(true);
			}
		});
		// end ActionListener for Main button Mazda3

		// ActionListener for button Mazda6
		bMazda6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(bMazda6.getText());

				panelGridCenterMazda6.setVisible(true);
				panelGridCenterMazda3.setVisible(false);
				panelGridCenterMazdaCX5.setVisible(false);

				try {
					MazdaDB.getInstance();
					String welcomeMazda6 = MazdaDB.getInstance().fromDB(
							"Mazda6", "welcome");
					textArrea.setText(welcomeMazda6);

				} catch (SQLException e) {
					e.printStackTrace();
				}

				bMazda6.setEnabled(false);
				bMazda3.setEnabled(true);
				bMazdaCX5.setEnabled(true);
			}
		});

		// ActionListener for button MazdaCX5
		bMazdaCX5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(bMazdaCX5.getText());
				bMazda6.setEnabled(true);
				bMazda3.setEnabled(true);
				bMazdaCX5.setEnabled(false);
				panelGridCenterMazdaCX5.setVisible(true);
				panelGridCenterMazda3.setVisible(false);
				panelGridCenterMazda6.setVisible(false);

				try {
					MazdaDB.getInstance();
					String welcomeMazdaCX5 = MazdaDB.getInstance().fromDB(
							"MazdaCX5", "welcome");
					textArrea.setText(welcomeMazdaCX5);

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});

	}

	public MyFrame(String title, int weight, int height, Component comp)
			throws SQLException {
		this(title, weight, height);
		super.add(comp);
		pack();

	}

}
