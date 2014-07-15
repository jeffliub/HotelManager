package net.davebish.hotelmanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

public class HomeUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public HomeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setupMenu();		
		setContentPane(contentPane);
	}

	private void setupMenu() {
		JMenu reservation = new JMenu("Reservations");
		reservation.setMnemonic('R');
		
		JMenuItem newItem = new JMenuItem("New");
		newItem.setMnemonic('N');
		reservation.add(newItem);
		newItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// handle the new reservation request
					}
				});
		
		JMenuItem modifyItem = new JMenuItem("Modify");
		modifyItem.setMnemonic('M');
		reservation.add(modifyItem);
		modifyItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// handle the modify reservation request
					}
				});		
		
		JMenuItem cancelItem = new JMenuItem("Cancel");
		cancelItem.setMnemonic('C');
		reservation.add(cancelItem);		
		cancelItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// handle the cancel reservation request
					}
				});	
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(reservation);
	}
}
