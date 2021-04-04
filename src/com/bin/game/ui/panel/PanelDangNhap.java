package com.bin.game.ui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bin.game.logic.Account;
import com.bin.game.logic.AccountLogin;
import com.bin.game.ui.ActionClick;
import com.bin.game.ui.GUI;
import com.sun.jdi.InterfaceType;


public class PanelDangNhap extends BasePanel{
	private static final String BT_DANG_NHAP = "BT_DANG_NHAP";
	private static final String BT_DANG_KY = "BT_DANG_KY";
	private JButton bt_dangnhap;
	private JButton bt_dangki;
	private JTextField tf_account;
	private JPasswordField pw;
	private JLabel lb_acc;
	private JLabel lb_pass;
	private AccountLogin account;
	public static String tendangnhap = "";
	@Override
	public void initUI() {
		// TODO Auto-generated method stub
		setLayout(null);
		setVisible(true);
		setBackground(Color.PINK);
	}

	@Override
	public void addEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComp() {
		// TODO Auto-generated method stub
		Font f = new Font("Tahoma", Font.BOLD, 25);
		Font f1 = new Font("Tahoma", Font.BOLD, 20);
		tf_account = createTextField(50, 50, 200, f, Color.BLACK);
		int x_Tf = GUI.W_SIZE/2 - tf_account.getWidth()/2;
		tf_account.setLocation(x_Tf,tf_account.getY());
		add(tf_account);
		lb_acc = creatLabel("account", tf_account.getX() - 90, tf_account.getY(), f1, Color.BLACK,Color.PINK);
		add(lb_acc);
		pw = new JPasswordField();
		pw.setFont(f1);
		pw.setSize(tf_account.getWidth(), tf_account.getHeight());
		pw.setLocation(tf_account.getX(), tf_account.getY() + tf_account.getHeight() + 20);
		add(pw);
		lb_pass = creatLabel("password", pw.getX() - 100, pw.getY(), f1, Color.BLACK,Color.PINK);
		add(lb_pass);
		bt_dangnhap = creatButton("Dang Nhap", 200, pw.getY()+pw.getHeight()+20,f, Color.BLACK,BT_DANG_NHAP);
		add(bt_dangnhap);
		bt_dangki = creatButton("Dang Ky", bt_dangnhap.getX()+bt_dangnhap.getWidth()+20, bt_dangnhap.getY(), f, Color.BLACK, 
				BT_DANG_KY);
		add(bt_dangki);
		}
	
	@Override
	protected void handleClick(String name) {
		// TODO Auto-generated method stub
		if(name.equals(BT_DANG_NHAP)) {
			AccountLogin acclog = new AccountLogin();
			acclog.getData();
			String a = tf_account.getText();
			String b = pw.getText();

			for(int i = 0; i < acclog.getList_acc().size();i++) {
				if(acclog.getList_acc().get(i).getTendangnhap().equals(a) && acclog.getList_acc().get(i).getMatkhau().equals(b)) {
					this.tendangnhap = acclog.getList_acc().get(i).getTendangnhap();
					JOptionPane.showMessageDialog(this, "Login Successful");
					acc.actionClick();
					return;
				}
				
			}
			JOptionPane.showMessageDialog(this, "Login Failed \n< You should create an account? >");
			System.out.println(name);
		}
		if(name.equals(BT_DANG_KY)) {
			acc.dangKidangNhap();
		}
	}
	
	
	private ActionClick acc;

	public ActionClick getAcc() {
		return acc;
	}

	public void setAcc(ActionClick acc) {
		this.acc = acc;
	}
	
}
