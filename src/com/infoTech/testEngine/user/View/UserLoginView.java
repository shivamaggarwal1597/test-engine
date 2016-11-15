package com.infoTech.testEngine.user.View;
import com.infoTech.testEngine.utils.MessageBundleReader;

import static com.infoTech.testEngine.utils.ApplicationStatusConstants.error;
import static com.infoTech.testEngine.utils.ApplicationStatusConstants.success;
import static com.infoTech.testEngine.utils.ApplicationStatusConstants.fail;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.infoTech.testEngine.user.DAO.UserDAO;
import com.infoTech.testEngine.user.DTO.UserDTO;

public class UserLoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	JButton btnLogin = new JButton("login");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				
	}

	/**
	 * Create the frame.
	 */
	public UserLoginView() {
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(51, 49, 56, 16);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(51, 78, 56, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(125, 46, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 75, 106, 22);
		contentPane.add(passwordField);
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doLogin();
			}
		});
		btnLogin.setBounds(59, 156, 97, 25);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("reset");
		btnReset.setBounds(214, 156, 97, 25);
		contentPane.add(btnReset);
	}
	private void doLogin(){
		UserDAO userDAO=new UserDAO();
		UserDTO userDTO =new UserDTO();
		userDTO.setUserid(textField.getText());
		userDTO.setPassword(String.valueOf(passwordField.getPassword()));
		try{
			String message=userDAO.login(userDTO);
			if(message.equals(success)){
				JOptionPane.showMessageDialog(this, "welcome  :"+userDTO.getUserid());
				quesView ques=new quesView();
				ques.setVisible(true);
				this.setVisible(false);
				this.dispose();
			}
			else{
				if(message.equals(fail)){
					JOptionPane.showConfirmDialog(this, "Invalid Userid or Password");
				}
			}
			}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
