package net.davebish.hotelmanager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import de.wannawork.jcalendar.JCalendarComboBox;
import org.joda.time.DateTime;

public class ReservationNewChangeUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFirstName;
	private JTextField txtLastName;

	/**
	 * Create the dialog.
	 */
	public ReservationNewChangeUI(JFrame owner, boolean isModal) {
		super(owner, isModal);
		setTitle("Reservation");
		setBounds(100, 100, 540, 394);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(49, 32, 78, 16);
		contentPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(49, 57, 78, 16);
		contentPanel.add(lblLastName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(139, 26, 225, 28);
		contentPanel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(139, 51, 225, 28);
		contentPanel.add(txtLastName);
		txtLastName.setColumns(10);
		
		JCalendarComboBox calcbxArrivalDate = new JCalendarComboBox();
		calcbxArrivalDate.setBounds(139, 81, 225, 28);
		DateTime currDate = new DateTime();
		calcbxArrivalDate.setDate(currDate.toDate());
		contentPanel.add(calcbxArrivalDate);		
		JLabel lblArrivalDate = new JLabel("Arrival Date:");
		lblArrivalDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArrivalDate.setBounds(42, 87, 85, 16);
		contentPanel.add(lblArrivalDate);
		
		JLabel lblDepartureDate = new JLabel("Departure Date:");
		lblDepartureDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartureDate.setBounds(20, 116, 107, 16);
		contentPanel.add(lblDepartureDate);
		
		JCalendarComboBox calcbxDepartureDate = new JCalendarComboBox();
		calcbxDepartureDate.setBounds(139, 116, 225, 28);
		DateTime nextDay = currDate.plusDays(1);
		calcbxDepartureDate.setDate(nextDay.toDate());
		contentPanel.add(calcbxDepartureDate);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		setLocationRelativeTo(null);
	}
}
