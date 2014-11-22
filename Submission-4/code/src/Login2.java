import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.CardLayout;

import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.JButton;

import MessGUI.ClerkClientLogin;
import MessGUI.ClerkScan;
import MessGUI.EmployeeWindow;
import MessManagerGUI.ManagerLoginGUI;
import StudentGUI.student;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import javax.swing.SpringLayout;

import java.awt.GridLayout;

import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Login2 {

	private JFrame frmLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login2 window = new Login2();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();

		frmLogin.setTitle("LOGIN");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Employee", "Mess Manager", "Clerk Client"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(122, 69, 199, 51);
		frmLogin.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int select = comboBox.getSelectedIndex();
				switch(select){
					case 0: EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										student window = new student();
										window.frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										frmLogin.setVisible(false);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						break;
						
				case 1: EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EmployeeWindow window = new EmployeeWindow();
							window.frmEmployeeLogin.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frmLogin.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
					break;
					
				case 2: EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManagerLoginGUI window = new ManagerLoginGUI();
							window.frmManagerLogin.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frmLogin.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
					break;
					
				case 3: EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ClerkClientLogin window = new ClerkClientLogin();
							window.frmClerkClientLogin.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							frmLogin.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
					break;
					
				default: break;	
				}
			}
		});
		btnNewButton.setBounds(122, 131, 199, 56);
		frmLogin.getContentPane().add(btnNewButton);
		InputMap im = btnNewButton.getInputMap();
		
	    im.put(KeyStroke.getKeyStroke("ENTER"), "none");
	    im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
	    
	    frmLogin.getRootPane().setDefaultButton(btnNewButton);
	}


}
