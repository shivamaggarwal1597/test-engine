package com.infoTech.testEngine.user.View;

import static com.infoTech.testEngine.utils.MessageBundleReader.getQuesValue;
import static com.infoTech.testEngine.utils.MessageBundleReader.getConfigValue;
import java.awt.EventQueue;

import static com.infoTech.testEngine.utils.ApplicationStatusConstants.fail;
import static com.infoTech.testEngine.utils.ApplicationStatusConstants.success;





import com.infoTech.testEngine.user.DTO.UserDTO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class quesView extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	JButton btnPrevious = new JButton("previous");
	int i=1 ;
	int score;
	JLabel score_lbl = new JLabel("score:"+score);
	
	JRadioButton option_4 = new JRadioButton(getQuesValue("ques_"+i+"_option_4"));
	JRadioButton option_2 = new JRadioButton(getQuesValue("ques_"+i+"_option_2"));
	JRadioButton option_3 = new JRadioButton(getQuesValue("ques_"+i+"_option_3"));
	JRadioButton option_1 = new JRadioButton(getQuesValue("ques_"+i+"_option_1"));
	ButtonGroup bg=new ButtonGroup();
	
	public static void main(String[] args) {
		
					quesView frame = new quesView();
					frame.setVisible(true);
				
		
	}

	/**
	 * Create the frame.
	 */
	
private void quizOver(){
	if(isQuizOver(i)){
		JOptionPane.showMessageDialog(this, "you have completed your quiz and your score is"+i);
	}
}
	
	private boolean isQuizOver(int score){
		
		if(score==5){
		return true;
		}else
			return false;
	}
	private boolean checkAns(){
		if(checkSelectedOption().equals(getQuesValue("ans_"+i))){
			JOptionPane.showMessageDialog(this, "your ans is correct...now try the next question");
			
				btnPrevious.setEnabled(true);
			
			return true;
		}
		else{
			
			JOptionPane.showMessageDialog(this, "oopsss...wrong ans");
			return false;
		}
		
	}
	private String checkSelectedOption(){
		String message=fail;
		if(option_1.isSelected()){
			return option_1.getText();
		}
		else
			if(option_2.isSelected()){
				return option_2.getText();
			}
			else
				if(option_3.isSelected()){
					return option_3.getText();
				}
				else
					if(option_4.isSelected()){
						return option_4.getText();
						
					}
					else{
						return message;
					}
	}
	
	
	public quesView() {
		getContentPane().setBackground(Color.WHITE);
		i=1;score=0;
		setBounds(100, 100, 495, 435);
		this.getContentPane().setLayout(null);
		
		JLabel welcome_Label = new JLabel("WELCOME");
		welcome_Label.setBounds(200, 13, 232, 16);
		getContentPane().add(welcome_Label);
		
		JLabel lblQues = new JLabel("ques");
		lblQues.setBounds(22, 72, 41, 33);
		getContentPane().add(lblQues);
		
		JLabel ques_Label = new JLabel(getQuesValue("ques_"+i));
		ques_Label.setBounds(105, 72, 283, 33);
		getContentPane().add(ques_Label);
		option_1.setBackground(Color.WHITE);
		
		
		option_1.setBounds(22, 158, 127, 25);
		getContentPane().add(option_1);
		option_2.setBackground(Color.WHITE);
		
		
		option_2.setBounds(273, 158, 174, 25);
		getContentPane().add(option_2);
		option_3.setBackground(Color.WHITE);
		
		
		option_3.setBounds(22, 246, 127, 25);
		getContentPane().add(option_3);
		option_4.setBackground(Color.WHITE);
		
		
		option_4.setBounds(273, 246, 127, 25);
		getContentPane().add(option_4);
		bg.add(option_1);
		bg.add(option_2);
		bg.add(option_3);
		bg.add(option_4);
		if(score==0){
			btnPrevious.setEnabled(false);
		}
		JButton btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				if(checkAns()){
				score++;
				i++;
				ques_Label.setText(getQuesValue("ques_"+i));
				option_1.setText(getQuesValue("ques_"+i+"_option_1"));
				option_2.setText(getQuesValue("ques_"+i+"_option_2"));
				option_3.setText(getQuesValue("ques_"+i+"_option_3"));
				option_4.setText(getQuesValue("ques_"+i+"_option_4"));
			   
				
			}
				bg.clearSelection();
				score_lbl.setText("score: "+score);
				quizOver();
			}
		});
		btnNext.setBounds(266, 318, 97, 25);
		getContentPane().add(btnNext);
		
		
		
		score_lbl.setBounds(7, 13, 56, 16);
		getContentPane().add(score_lbl);
		
		
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				i--;
				ques_Label.setText(getQuesValue("ques_"+i));
				option_1.setText(getQuesValue("ques_"+i+"_option_1"));
				option_2.setText(getQuesValue("ques_"+i+"_option_2"));
				option_3.setText(getQuesValue("ques_"+i+"_option_3"));
				option_4.setText(getQuesValue("ques_"+i+"_option_4"));
			    bg.clearSelection();
			}
		});
		btnPrevious.setBounds(62, 318, 97, 25);
		getContentPane().add(btnPrevious);
		
		JLabel label = new JLabel("");
		label.setBounds(344, 13, 121, 50);
		getContentPane().add(label);
		Icon icon=new ImageIcon(getConfigValue("logoPath"));
		label.setIcon(icon);
		
		JLabel back_label = new JLabel("");
		//Icon watermark=new ImageIcon(getConfigValue("watermark"));
		//back_label.setIcon(watermark);
		back_label.setBounds(0, 0, 477, 388);
		getContentPane().add(back_label);
		
		
	}
}
