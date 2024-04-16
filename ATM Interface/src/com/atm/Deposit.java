package com.atm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
	JTextField amount;
	JButton deposit, back;
	String pinNumber;

	Deposit(String Deposit) {
		
		this.pinNumber=pinNumber; 
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(720, 720, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel Image = new JLabel(i3);
		Image.setBounds(0, 0, 720, 720);
		add(Image);

		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 13));
		text.setBounds(130,120,300,23);
		Image.add(text);

		amount=new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 13));
		amount.setBounds(130, 170, 280,23);
		Image.add(amount);
		
		deposit=new JButton("Deposit");
		deposit.setBounds(260, 340, 150, 30);
		deposit.addActionListener(this);
		Image.add(deposit);
		
		back=new JButton("Back");
		back.setBounds(260, 375, 150, 30);
		back.addActionListener(this);
		Image.add(back);
		
		setSize(720, 720);
		setLocation(350, 0);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== deposit){
			String number= amount.getText();
			Date date= new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "please enter the amount you want to deposit");
			}else {
				try {
				Conn conn=new Conn();
				String query ="Insert into Bank values('"+pinNumber+"','"+date+"','Deposit' ,'"+number+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, " Rs "+ number +" Deposited Successfully ");
				setVisible(false);new Transactions(pinNumber).setVisible(true);
			}catch(Exception ex) {
				System.out.println(ex);
			}
				
			}
		}else if(e.getSource()== back) {
		}
		setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}	
	
	public static void main(String[] args) {
		new Deposit("");
	}

	
	}

