package com.infoTech.testEngine.user.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import org.omg.CORBA.portable.InputStream;

public class AdminQuesAdd extends JFrame {

	private JPanel contentPane;
	private JTextField ques;
	private JTextField option_1;
	private JTextField option_2;
	private JTextField option_3;
	private JTextField option_4;
    InputStream in=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminQuesAdd frame = new AdminQuesAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public AdminQuesAdd() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ques = new JTextField();
		ques.setBounds(12, 41, 380, 40);
		contentPane.add(ques);
		ques.setColumns(10);
		
		option_1 = new JTextField();
		option_1.setBounds(12, 111, 116, 22);
		contentPane.add(option_1);
		option_1.setColumns(10);
		
		option_2 = new JTextField();
		option_2.setBounds(231, 111, 116, 22);
		contentPane.add(option_2);
		option_2.setColumns(10);
		
		option_3 = new JTextField();
		option_3.setBounds(12, 178, 116, 22);
		contentPane.add(option_3);
		option_3.setColumns(10);
		
		option_4 = new JTextField();
		option_4.setBounds(231, 178, 116, 22);
		contentPane.add(option_4);
		option_4.setColumns(10);
		Properties prop = new Properties();
		InputStream in = (InputStream) getClass().getResourceAsStream("ques.properties");
		prop.load(in);
		prop.setProperty("ques_6", "how are you");
	}
}
