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
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReservationNewChangeUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtRoomRate;
	private JTextField textField_1;
	private JTextField txtNameOnCard;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtZipCode;
	private Reservation reservation;

	/**
	 * Create the dialog.
	 */
	public ReservationNewChangeUI(JFrame owner, boolean isModal) {
		// General setup
		super(owner, isModal);
		setTitle("Reservation");
		setBounds(100, 100, 546, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Label and field setup
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(123, 29, 78, 16);
		contentPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(123, 54, 78, 16);
		contentPanel.add(lblLastName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(213, 23, 262, 28);
		contentPanel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(213, 48, 262, 28);
		contentPanel.add(txtLastName);
		txtLastName.setColumns(10);
		
		JCalendarComboBox calcbxArrivalDate = new JCalendarComboBox();
		calcbxArrivalDate.setBounds(213, 78, 262, 28);
		DateTime currDate = new DateTime();
		calcbxArrivalDate.setDate(currDate.toDate());
		contentPanel.add(calcbxArrivalDate);		
		JLabel lblArrivalDate = new JLabel("Arrival Date:");
		lblArrivalDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArrivalDate.setBounds(116, 84, 85, 16);
		contentPanel.add(lblArrivalDate);
		
		JLabel lblDepartureDate = new JLabel("Departure Date:");
		lblDepartureDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartureDate.setBounds(94, 119, 107, 16);
		contentPanel.add(lblDepartureDate);
		
		JCalendarComboBox calcbxDepartureDate = new JCalendarComboBox();
		calcbxDepartureDate.setBounds(213, 113, 262, 28);
		DateTime nextDay = currDate.plusDays(1);
		calcbxDepartureDate.setDate(nextDay.toDate());
		contentPanel.add(calcbxDepartureDate);
		
		JPanel panelNumGuests = new JPanel();
		panelNumGuests.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Number of Guests", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNumGuests.setBounds(94, 153, 381, 68);
		contentPanel.add(panelNumGuests);
		panelNumGuests.setLayout(null);
		
		JLabel lblAdults = new JLabel("Adults:");
		lblAdults.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdults.setBounds(57, 33, 45, 16);
		panelNumGuests.add(lblAdults);
		
		JSpinner spnAdults = new JSpinner();
		spnAdults.setBounds(123, 27, 37, 28);
		panelNumGuests.add(spnAdults);
		
		JLabel lblChildren = new JLabel("Children:");
		lblChildren.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChildren.setBounds(198, 33, 61, 16);
		panelNumGuests.add(lblChildren);
		
		JSpinner spnChildren = new JSpinner();
		spnChildren.setBounds(280, 27, 37, 28);
		panelNumGuests.add(spnChildren);
		
		JLabel lblRoomType = new JLabel("Room Type:");
		lblRoomType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomType.setBounds(116, 233, 85, 16);
		contentPanel.add(lblRoomType);
		
		JComboBox cbxRoomType = new JComboBox();
		cbxRoomType.setModel(new DefaultComboBoxModel(new String[] {"Single King", "Two Queens", "Suite"}));
		cbxRoomType.setBounds(213, 229, 262, 27);
		contentPanel.add(cbxRoomType);
		
		JLabel lblRate = new JLabel("Rate:");
		lblRate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRate.setBounds(140, 270, 61, 16);
		contentPanel.add(lblRate);
		
		txtRoomRate.setBounds(213, 264, 262, 28);
		contentPanel.add(txtRoomRate);
		txtRoomRate.setColumns(10);
		
		JPanel panelCCType = new JPanel();
		panelCCType.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Credit Card Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCCType.setBounds(94, 298, 381, 56);
		contentPanel.add(panelCCType);
		panelCCType.setLayout(null);
		
		JRadioButton rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setSelected(true);
		rdbtnVisa.setBounds(72, 27, 75, 23);
		panelCCType.add(rdbtnVisa);
		
		JRadioButton rdbtnMasterCard = new JRadioButton("Master Card");
		rdbtnMasterCard.setBounds(147, 27, 141, 23);
		panelCCType.add(rdbtnMasterCard);
		
		JRadioButton rdbtnAmex = new JRadioButton("AMEX");
		rdbtnAmex.setBounds(271, 27, 75, 23);
		panelCCType.add(rdbtnAmex);
		
		JLabel lblCreditCard = new JLabel("Credit Card #:");
		lblCreditCard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCard.setBounds(94, 366, 107, 16);
		contentPanel.add(lblCreditCard);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 360, 262, 28);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblExpirationMonth = new JLabel("Expiration Month:");
		lblExpirationMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpirationMonth.setBounds(80, 400, 121, 16);
		contentPanel.add(lblExpirationMonth);
		
		JComboBox cbxExpMonth = new JComboBox();
		cbxExpMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbxExpMonth.setBounds(213, 395, 61, 27);
		contentPanel.add(cbxExpMonth);
		
		JLabel lblExpirationYear = new JLabel("Expiration Year:");
		lblExpirationYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExpirationYear.setBounds(286, 400, 99, 16);
		contentPanel.add(lblExpirationYear);
		
		JComboBox cbxExpirationYear = new JComboBox();
		cbxExpirationYear.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		cbxExpirationYear.setBounds(390, 395, 85, 27);
		contentPanel.add(cbxExpirationYear);
		
		JLabel lblNameOnCard = new JLabel("Name on Card:");
		lblNameOnCard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameOnCard.setBounds(94, 434, 107, 16);
		contentPanel.add(lblNameOnCard);
		
		txtNameOnCard = new JTextField();
		txtNameOnCard.setBounds(213, 428, 262, 28);
		contentPanel.add(txtNameOnCard);
		txtNameOnCard.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(140, 466, 61, 16);
		contentPanel.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(213, 460, 262, 28);
		contentPanel.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(140, 498, 61, 16);
		contentPanel.add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setBounds(213, 492, 262, 28);
		contentPanel.add(txtCity);
		txtCity.setColumns(10);
		
		JLabel lblState = new JLabel("State:");
		lblState.setHorizontalAlignment(SwingConstants.RIGHT);
		lblState.setBounds(140, 532, 61, 16);
		contentPanel.add(lblState);
		
		JComboBox cbxState = new JComboBox();
		cbxState.setModel(new DefaultComboBoxModel(new String[] {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"}));
		cbxState.setBounds(213, 528, 77, 27);
		contentPanel.add(cbxState);
		
		JLabel lblZip = new JLabel("Zip:");
		lblZip.setBounds(302, 532, 29, 16);
		contentPanel.add(lblZip);
		
		txtZipCode = new JTextField();
		txtZipCode.setBounds(330, 526, 145, 28);
		contentPanel.add(txtZipCode);
		txtZipCode.setColumns(10);
		
		// Setup the OK and Cancel buttons
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// validate the input fields using the Reservation class
						
					}
				});
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
		
		// Center the JFrame
		setLocationRelativeTo(null);
	}
}
