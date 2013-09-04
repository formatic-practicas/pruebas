import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.GridLayout;


public class Ventana {

	private JFrame frame;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnHolaMundo = new JButton("1");
		panel.add(btnHolaMundo);
		
		JButton button_3 = new JButton("4");
		panel.add(button_3);
		
		JButton button_1 = new JButton("2");
		panel.add(button_1);
		
		JButton button_2 = new JButton("3");
		panel.add(button_2);
		
		JButton button_4 = new JButton("5");
		panel.add(button_4);
		
		JButton button_5 = new JButton("6");
		panel.add(button_5);
		
		textField = new JTextField();
		panel_1.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"5");
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText()+"3");
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText()+"2");
			}
		});
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText()+"4");
			}
		});
		btnHolaMundo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText()+"1");
			}
		});
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFichero = new JMenu("Fichero");
		menuBar.add(mnFichero);
		
		JMenuItem mntmHola = new JMenuItem("hola");
		mntmHola.setAction(action);
		mnFichero.add(mntmHola);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Una acci\u00F3n");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

		}
	}
}
