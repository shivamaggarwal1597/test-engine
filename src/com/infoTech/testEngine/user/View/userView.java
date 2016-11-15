package com.infoTech.testEngine.user.View;
import java.io.IOException;

import java.awt.Color;

import com.infoTech.testEngine.user.DAO.UserDAO;
import com.infoTech.testEngine.user.DTO.UserDTO;
import com.infoTech.testEngine.utils.*;

import static com.infoTech.testEngine.utils.MessageBundleReader.getValue;
import static com.infoTech.testEngine.utils.MessageBundleReader.getConfigValue;
import static com.infoTech.testEngine.utils.ApplicationStatusConstants.error;
import static com.infoTech.testEngine.utils.ApplicationStatusConstants.fail;
import static com.infoTech.testEngine.utils.ApplicationStatusConstants.success;

import com.infoTech.testEngine.utils.ApplicationStatusConstants;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Field;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
public class userView extends JFrame {

	/**
	 * 
	 */
	 static userView frame = new userView();
	JButton btnRegister = new JButton(getValue("reg.bt"));
	JLabel lblCity = new JLabel(getValue("field.city"));
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField useridTxt;
	private JPasswordField passwordField;
	ButtonGroup bg = new ButtonGroup();
	JRadioButton rdbtnMale = new JRadioButton(getValue("male"),false);
	JRadioButton rdbtnFemale = new JRadioButton(getValue("female"),false);
	JComboBox cityCombo = new JComboBox();
	JButton btnNext = new JButton(getValue("user.next"));
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public userView() {
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setTitle(getValue("regform.title"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		this.getContentPane().setLayout(null);
		
		JLabel lblUserRegisterHere = new JLabel(getValue("regform.heading"));
		lblUserRegisterHere.setBounds(159, 34, 169, 16);
		getContentPane().add(lblUserRegisterHere);
		
		JLabel lblUserid = new JLabel(getValue("field.userID"));
		lblUserid.setBounds(31, 103, 61, 16);
		getContentPane().add(lblUserid);
		
		JLabel lblPassword = new JLabel(getValue("field.password"));
		lblPassword.setBounds(31, 169, 61, 16);
		getContentPane().add(lblPassword);
		
		useridTxt = new JTextField();
		useridTxt.setBounds(123, 98, 181, 26);
		getContentPane().add(useridTxt);
		useridTxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 164, 181, 26);
		getContentPane().add(passwordField);
		

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
				reset();
			}
		});
		btnRegister.setMnemonic('R');
	Icon registerIcon = new ImageIcon(getConfigValue("imagePath"));
		btnRegister.setBounds(27, 330, 149, 62);
		btnRegister.setIcon(registerIcon);
		getContentPane().add(btnRegister);
		
		
		rdbtnMale.setBounds(118, 223, 88, 23);
		getContentPane().add(rdbtnMale);
		
		
		rdbtnFemale.setBounds(241, 223, 141, 23);
		getContentPane().add(rdbtnFemale);
		bg.add(rdbtnFemale);
		bg.add(rdbtnMale);
		JLabel lblGender = new JLabel(getValue("field.gender"));
		lblGender.setBounds(31, 227, 61, 16);
		getContentPane().add(lblGender);
		
		
		cityCombo.addItem(getValue("city1"));
		cityCombo.addItem(getValue("city2"));
		cityCombo.addItem(getValue("city3"));
		
		cityCombo.setBounds(118, 268, 159, 27);
		getContentPane().add(cityCombo);
		
		
		lblCity.setBounds(31, 273, 61, 16);
		getContentPane().add(lblCity);
		
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				UserLoginView frame2= new UserLoginView();
				frame2.setVisible(true);
			}
		});
		btnNext.setBounds(220, 330, 162, 62);
		getContentPane().add(btnNext);
	}
	private void register() {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(useridTxt.getText());
		userDTO.setPassword(String.valueOf(passwordField.getPassword()));
		if(rdbtnMale.isSelected()){
			userDTO.setGender(rdbtnMale.getText());	
		}
		else
			if(rdbtnFemale.isSelected())	
		{
			userDTO.setGender(rdbtnFemale.getText());
		}
		userDTO.setCity((String)cityCombo.getSelectedItem());
		UserDAO dao = new UserDAO();
		try {
			String message = dao.Register(userDTO);
			if(message.equals(success)){
				JOptionPane.showMessageDialog(this, "User Register SuccessFully !");
			}
			else
			if(message.equals(fail)){	
				JOptionPane.showMessageDialog(this, "Problem in User Register");
			}
			else
			if(message.equals(ERROR)){	
				JOptionPane.showMessageDialog(this, "Contact to System Vendor , there is some problem in Application");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Contact to System Vendor , there is some problem in Application");
			e.printStackTrace();
		}

	}
    private void reset()
    {
    	useridTxt.setText(" ");
    	passwordField.setText("");
    	bg.clearSelection();
    	
    }
}
