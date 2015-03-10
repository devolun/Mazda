package frame;

import main.*;

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

import setting.SettingMazda3;
import setting.SettingMazda6;
import setting.SettingMazdaCX5;
import journal.JournalMazda3;
import journal.JournalMazda6;
import journal.JournalMazdaCX5;


public class MyFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public MyFrame(String title, int weight, int height) throws SQLException {
	ImageIcon img = new ImageIcon("res/mazda-logo.png");
	super.setIconImage(img.getImage());
	super.setTitle(title);
	super.setResizable(false);
	super.setSize(600,400);
	super.setLocationRelativeTo(null);
	super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	super.setLayout(new BorderLayout());
	
	
	final MyJTextField textField = new MyJTextField("Выберите модель автомобиля");
	
	JPanel panelButtons = new JPanel();
	final JPanel panelDesc = new JPanel();
	
	final Mazda3 mazda3 = new Mazda3();
	final Mazda6 mazda6 = new Mazda6();
	final MazdaCX5 mazdacx5 = new MazdaCX5();
	
	final MyJTextArea textArrea = new MyJTextArea();
	
	String welcom = MazdaDB.getInstance().welcome("Mazda");
	textArrea.setText(welcom);
	
	final MyButton bMazda3 = new MyButton("Mazda 3", new ImageIcon("res/mazda3.png"));
	final MyButton bMazda6 = new MyButton("Mazda 6", new ImageIcon("res/mazda6.png"));
	final MyButton bMazdaCX5 = new MyButton("Mazda CX5", new ImageIcon("res/mazda-cx5.png"));
	
	
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
	panelDesc.setPreferredSize( new Dimension( 450, 150 ) );

	panelDesc.add(textField); // add field Title of description
	panelDesc.add(textArrea);  // add field description
	
	getContentPane().add(panelButtons, BorderLayout.PAGE_START);
	getContentPane().add(panelDesc, BorderLayout.SOUTH);
	
    final PanelButtonsCenter panelGridCenterMazda3 = new PanelButtonsCenter();

	MyButton buttonPriceMazda3 = new MyButton("Цены", iconMazdaPrice);
	
	panelGridCenterMazda3.add(buttonPriceMazda3);
				
	buttonPriceMazda3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mazda3.setUrlMazda(mazda3.urlMazda);
			mazda3.goToLink();
		}
	});
	
	MyButton buttonTOMazda3 = new MyButton("Сервис Mazda", iconMazdaService);
	panelGridCenterMazda3.add(buttonTOMazda3);
	buttonTOMazda3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			 
			try {
			String service = MazdaDB.getInstance().fromDB("Mazda3_oil", "change_old");
			String belt = MazdaDB.getInstance().fromDB("Mazda3_belt", "change_old");
			String breaks = MazdaDB.getInstance().fromDB("Mazda3_breaks", "change_old");
			textArrea.setText("Последняя замена масла " + service + " км." + "\nПоследняя замена ремня " + belt + " км." + "\nПоследняя замена колодок " + breaks + " км.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});
	
	MyButton buttonTiresMazda3 = new MyButton("Шины", iconMazdaWheel);
	panelGridCenterMazda3.add(buttonTiresMazda3);
	
	buttonTiresMazda3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
			MazdaDB.getInstance();
				String tires = MazdaDB.getInstance().fromDB("Mazda3", "tires");
				textArrea.setText(tires);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});

	
	MyButton buttonOilMazda3 = new MyButton("Масло", iconMazdaOil);
	panelGridCenterMazda3.add(buttonOilMazda3);
	buttonOilMazda3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				MazdaDB.getInstance();
				String oil = MazdaDB.getInstance().fromDB("Mazda3_oil", "name");
				int oilChange = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda3_oil", "change"));  
				int oilOldChange = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda3_oil", "change_old")); 
				int oilNext = oilOldChange + oilOldChange; 
				textArrea.setText(oil + oilChange + " км." + "\nМоя последняя замена: " + oilOldChange + " км." + "\n\nСледующая замена: " + oilNext + " км." );
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});
	
	
	MyButton buttonBeltMazda3 = new MyButton("Ремни", iconMazdaBelt);
	panelGridCenterMazda3.add(buttonBeltMazda3);
	buttonBeltMazda3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				int beltChange = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda3_belt", "change"));
				int beltOld = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda3_belt", "change_old"));
				int beltNext = beltOld + beltChange;
				textArrea.setText("Замена ремня ГРМ в Mazda 3 каждые: " + beltChange + " км." + "\nМоя последняя замена: " + beltOld + " км." + "\n\nСледующая замена: " + beltNext + " км.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	});
	
	MyButton buttonBreakstMazda3 = new MyButton("Колодки", iconMazdaBrake);
	panelGridCenterMazda3.add(buttonBreakstMazda3);
	buttonBreakstMazda3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				int oldBreaks = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda3_breaks", "change_old"));
				int recChange = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda3_breaks", "change"));
				int breaksChangeNext = oldBreaks + recChange;
				textArrea.setText("Замена тормозных колодок каждые "
						+ recChange + " км, или по звуку )-:"
						+ "\nМоя последняя замена: " + oldBreaks + " км."
						+ "\n\nСледующая замена: " + breaksChangeNext
						+ " км.");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});
	
	final MyButton buttonDialogShow = new MyButton("Журнал", iconMazdaNotes);
	panelGridCenterMazda3.add(buttonDialogShow);
	
	buttonDialogShow.addActionListener(new ActionListener() {
		
		JournalMazda3 jm3 = new JournalMazda3();
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showConfirmDialog(panelGridCenterMazda3,jm3, "Журнал учета обслуживания " + bMazda3.getText(), JOptionPane.OK_CANCEL_OPTION);
		}
	});
	
	
	MyButton btnSettingMazda3 = new MyButton("Настройки", iconSetting);
	panelGridCenterMazda3.add(btnSettingMazda3);
	
	btnSettingMazda3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			SettingMazda3 settingMazda3 = new SettingMazda3();
			JOptionPane.showConfirmDialog(panelGridCenterMazda3,settingMazda3, "Настройки периодов замены " + bMazda3.getText(), JOptionPane.CLOSED_OPTION);
		}
	});
	
	
	// end buttons Center Mazda3
	
	
	
	
	// Central Box Mazda6
	final PanelButtonsCenter panelGridCenterMazda6 = new PanelButtonsCenter();
	
	MyButton buttonPriceMazda6 = new MyButton("Цены", iconMazdaPrice);
	
	panelGridCenterMazda6.add(buttonPriceMazda6);
				
	buttonPriceMazda6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mazda6.setUrlMazda(mazda6.urlMazda);
			mazda6.goToLink();
		}
	});
	
	MyButton buttonTOMazda6 = new MyButton("Сервис Mazda", iconMazdaService);
	panelGridCenterMazda6.add(buttonTOMazda6);
	buttonTOMazda6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				String service = MazdaDB.getInstance().fromDB("Mazda6_oil", "change_old");
				String belt = MazdaDB.getInstance().fromDB("Mazda6_belt", "change_old");
				String breaks = MazdaDB.getInstance().fromDB("Mazda6_breaks", "change_old");
				textArrea.setText("Последняя замена масла " + service + " км." + "\nПоследняя замена ремня " + belt + " км." + "\nПоследняя замена колодок " + breaks + " км.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});
	
	
	MyButton buttonTiresMazda6 = new MyButton("Шины", iconMazdaWheel);
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

	
	MyButton buttonOilMazda6 = new MyButton("Масло", iconMazdaOil);
	panelGridCenterMazda6.add(buttonOilMazda6);
	buttonOilMazda6.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				String oil = MazdaDB.getInstance().fromDB("Mazda6_oil", "name");
				int change = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda6_oil", "change"));
				int changeOld = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda6_oil","change_old"));
				int changeNext = changeOld +change;
				textArrea.setText(oil + change + " км." + "\nМоя последняя замена: " + changeOld + " км." + "\n\nСледующая замена: " + changeNext + " км.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	});
	
	MyButton buttonBeltMazda6 = new MyButton("Ремни", iconMazdaBelt);
	panelGridCenterMazda6.add(buttonBeltMazda6);
	
	buttonBeltMazda6.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				int change = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda6_belt", "change"));
				int changeOld = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda6_belt", "change_old"));
				int changeNext = changeOld + change;
				textArrea.setText("Замена ремня ГРМ в Mazda 6 каждые " + change + " км." + "\nМоя последняя замена: " + changeOld + " км." + "\n\nСледующая замена: " + changeNext + " км.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});
	
	
	MyButton buttonBreakstMazda6 = new MyButton("Колодки", iconMazdaBrake);
	panelGridCenterMazda6.add(buttonBreakstMazda6);

	buttonBreakstMazda6.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String breaks = MazdaDB.getInstance().fromDB("Mazda6_breaks", "breaks");
				int change = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda6_breaks", "change"));
				int changeOld = Integer.parseInt(MazdaDB.getInstance().fromDB("Mazda6_breaks", "change_old"));
				int changeNext = changeOld + change;
				
				textArrea.setText(breaks + change + " км." + "\nМоя последняя замена: " + changeOld + " км." + "\n\nСледующая замена: " + changeNext + " км.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	});

	final MyButton buttonDialogShowMazda6 = new MyButton("Журнал",iconMazdaNotes);
	panelGridCenterMazda6.add(buttonDialogShowMazda6);

	buttonDialogShowMazda6.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JournalMazda6 jm6 = new JournalMazda6();
			JOptionPane.showConfirmDialog(panelGridCenterMazda6,jm6,
					"Журнал учета обслуживания " + bMazda6.getText(),JOptionPane.OK_CANCEL_OPTION );
		}
	});
	
	MyButton btnSettingMazda6 = new MyButton("Настройки", iconSetting);
	panelGridCenterMazda6.add(btnSettingMazda6);
	
	btnSettingMazda6.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			SettingMazda6 setingMazda6 = new SettingMazda6();
			JOptionPane.showConfirmDialog(panelGridCenterMazda6,setingMazda6, "Настройки периодов замены " + bMazda6.getText(), JOptionPane.CLOSED_OPTION);
		}
	});
	
	
	
	// end buttons Center Mazda6
	
	
	
	// Центральный блок кнопок MazdaCX 5
	final PanelButtonsCenter panelGridCenterMazdaCX5 = new PanelButtonsCenter();
	
	MyButton buttonPriceMazdaCX5 = new MyButton("Цены", iconMazdaPrice);
	
	panelGridCenterMazdaCX5.add(buttonPriceMazdaCX5);
				
	buttonPriceMazdaCX5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mazdacx5.setUrlMazda(mazdacx5.urlMazda);
			mazdacx5.goToLink();
		}
	});
	
	MyButton buttonTOMazdaCX5 = new MyButton("Сервис Mazda", iconMazdaService);
	panelGridCenterMazdaCX5.add(buttonTOMazdaCX5);
	buttonTOMazdaCX5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String service = MazdaDB.getInstance().fromDB("MazdaCX5_oil", "change_old");
				String belt = MazdaDB.getInstance().fromDB("MazdaCX5_belt", "change_old");
				String breaks = MazdaDB.getInstance().fromDB("MazdaCX5_breaks", "change_old");
				textArrea.setText("Последняя замена масла " + service + " км." + "\nПоследняя замена ремня " + belt + " км." + "\nПоследняя замена колодок " + breaks + " км.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});
	
	
	MyButton buttonTiresMazdaCX5 = new MyButton("Шины", iconMazdaWheel);
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
	

	
	MyButton buttonOilMazdaCX5 = new MyButton("Масло", iconMazdaOil);
	panelGridCenterMazdaCX5.add(buttonOilMazdaCX5);
	
	buttonOilMazdaCX5.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				String oil = MazdaDB.getInstance().fromDB("MazdaCX5_oil", "name");
				int change = Integer.parseInt(MazdaDB.getInstance().fromDB("MazdaCX5_oil", "change"));
				int changeOld = Integer.parseInt(MazdaDB.getInstance().fromDB("MazdaCX5_oil", "change_old"));
				int changeNext = changeOld + change;
				textArrea.setText(oil + change + " км." + "\nМоя последняя замена: " + changeOld + " км." + "\n\n Следующая замена: " + changeNext + " км.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});
	
	MyButton buttonBeltMazdaCX5 = new MyButton("Ремни", iconMazdaBelt);
	panelGridCenterMazdaCX5.add(buttonBeltMazdaCX5);
	buttonBeltMazdaCX5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				int change = Integer.parseInt(MazdaDB.getInstance().fromDB("MazdaCX5_belt", "change"));
				int changeOld = Integer.parseInt(MazdaDB.getInstance().fromDB("MazdaCX5_belt", "change_old"));
				int changeNext = changeOld + change;
				textArrea.setText("Замена ремня ГРМ для Mazda CX5 производится каждые " + change + " км." + "\nМоя последняя замена: " + changeOld + " км." + "\n\nСледующая замена: " + changeNext + " км.");
			
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}
	});
	
	MyButton buttonBreakstMazdaCX5 = new MyButton("Колодки", iconMazdaBrake);
	panelGridCenterMazdaCX5.add(buttonBreakstMazdaCX5);
	
	buttonBreakstMazdaCX5.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String breaks = MazdaDB.getInstance().fromDB("MazdaCX5_breaks", "breaks");
				int change = Integer.parseInt(MazdaDB.getInstance().fromDB("MazdaCX5_breaks", "change"));
				int changeOld = Integer.parseInt(MazdaDB.getInstance().fromDB("MazdaCX5_breaks", "change_old"));
				int changeNext = changeOld + change;
				textArrea.setText(breaks + change + " км." + "\nМоя последняя замена: " + changeOld + " км." + "\n\nСледующая замена: " + changeNext + " км.");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	});
	
	
	
	final MyButton buttonDialogShowMazdaCX5 = new MyButton("Журнал", iconMazdaNotes);
	panelGridCenterMazdaCX5.add(buttonDialogShowMazdaCX5);
	
	buttonDialogShowMazdaCX5.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JournalMazdaCX5 jp = new JournalMazdaCX5();
			JOptionPane.showConfirmDialog(panelGridCenterMazdaCX5,jp, "Журнал учета обслуживания " + bMazdaCX5.getText(), JOptionPane.OK_CANCEL_OPTION);
			
		}
	});
	
		
	MyButton btnSettingMazdaCX5 = new MyButton("Настройки", iconSetting);
	panelGridCenterMazdaCX5.add(btnSettingMazdaCX5);
	
	btnSettingMazdaCX5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			SettingMazdaCX5 setingMazdaCX5 = new SettingMazdaCX5();
			JOptionPane.showConfirmDialog(panelGridCenterMazdaCX5,setingMazdaCX5, "Настройки периодов замены " + bMazdaCX5.getText(), JOptionPane.CLOSED_OPTION);
		}
	});
	

	// end buttons Center Mazda CX5
	
	

	//----------------------------------------------------------------------
	
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
				String welcomeMazda3 = MazdaDB.getInstance().fromDB("Mazda3", "welcome");
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
	
	
	
	//_________________________________________________________________________________________
	
	
	// ActionListener for button Mazda 6
	bMazda6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			textField.setText(bMazda6.getText());
			
			panelGridCenterMazda6.setVisible(true);
			panelGridCenterMazda3.setVisible(false);
			panelGridCenterMazdaCX5.setVisible(false);
			
			try {
				MazdaDB.getInstance();
				String welcomeMazda6 = MazdaDB.getInstance().fromDB("Mazda6", "welcome");
				textArrea.setText(welcomeMazda6);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			bMazda6.setEnabled(false);
			bMazda3.setEnabled(true);
			bMazdaCX5.setEnabled(true);
		}
	});
	
	//_________________________________________________________________________________________
	
	
	// ActionListener for button Mazda CX5
	bMazdaCX5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			textField.setText(bMazdaCX5.getText());
//			mazdacx5.setPathFile(mazdacx5.pathFile);
			bMazda6.setEnabled(true);
			bMazda3.setEnabled(true);
			bMazdaCX5.setEnabled(false);
			panelGridCenterMazdaCX5.setVisible(true);
			panelGridCenterMazda3.setVisible(false);
			panelGridCenterMazda6.setVisible(false);
			
			try {
				MazdaDB.getInstance();
				String welcomeMazdaCX5 = MazdaDB.getInstance().fromDB("MazdaCX5", "welcome");
				textArrea.setText(welcomeMazdaCX5);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	});
	
	}
	
	public MyFrame(String title, int weight, int height, Component comp) throws SQLException {
		this(title,weight, height);
		super.add(comp);
		pack();
	
	}
	


}
