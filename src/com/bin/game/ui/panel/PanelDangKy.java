package com.bin.game.ui.panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bin.game.logic.AccountLogin;
import com.bin.game.ui.ActionClick;
import com.bin.game.ui.GUI;

public class PanelDangKy extends BasePanel{
	private static final String BT_XAC_NHAN = "BT_XAC_NHAN";
	private JTextField tf_ten,tf_tuoi,tf_tendangki;
	private JPasswordField pf_matkhau, pf_xacnhanmk;
	private JLabel lb_ten,lb_tuoi,lb_tendangki,lb_matkhaudk,lb_xacnhanmk;
	private JButton bt_xacnhandk;
	
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
		Font f1 = new Font("Tahoma",Font.BOLD,20);
		lb_ten = creatLabel("Ten",150, 50, f1, Color.BLACK,Color.PINK);
		add(lb_ten);
		tf_ten = createTextField(350, lb_ten.getY(), 240, f, Color.BLACK);
		add(tf_ten);
		lb_tuoi = creatLabel("Tuoi", lb_ten.getX(), lb_ten.getY()+lb_ten.getHeight()+20, f1, Color.BLACK,Color.PINK);
		add(lb_tuoi);
		tf_tuoi = createTextField(tf_ten.getX(), lb_tuoi.getY(), 240, f, Color.BLACK);
		add(tf_tuoi);
		lb_tendangki = creatLabel("Ten dang ki",lb_ten.getX(), lb_tuoi.getY()+lb_tuoi.getHeight()+20, f1, Color.BLACK,Color.PINK);
		add(lb_tendangki);
		tf_tendangki = createTextField(tf_ten.getX(), lb_tendangki.getY(), 240, f, Color.BLACK);
		add(tf_tendangki);
		lb_matkhaudk = creatLabel("mat khau dang ki",lb_ten.getX(), lb_tendangki.getY()+lb_tendangki.getHeight()+20, f1, Color.BLACK,Color.PINK);
		add(lb_matkhaudk);
		pf_matkhau = new JPasswordField();
		pf_matkhau.setFont(f1);
		pf_matkhau.setSize(tf_ten.getWidth(), tf_ten.getHeight());
		pf_matkhau.setLocation(tf_ten.getX(), lb_matkhaudk.getY());
		add(pf_matkhau);
		lb_xacnhanmk = creatLabel("xac nhan mat khau",lb_ten.getX(), lb_matkhaudk.getY()+lb_matkhaudk.getHeight()+20, f1, Color.BLACK,Color.PINK);
		add(lb_xacnhanmk);
		pf_xacnhanmk = new JPasswordField();
		pf_xacnhanmk.setFont(f1);
		pf_xacnhanmk.setSize(tf_ten.getWidth(), tf_ten.getHeight());
		pf_xacnhanmk.setLocation(tf_ten.getX(), lb_xacnhanmk.getY());
		add(pf_xacnhanmk);
		bt_xacnhandk = creatButton("Xac nhan", 250, pf_xacnhanmk.getY()+pf_xacnhanmk.getHeight()+20, f1, Color.BLACK, BT_XAC_NHAN);
		bt_xacnhandk.setLocation(GUI.W_SIZE/2 - bt_xacnhandk.getWidth()/2, bt_xacnhandk.getY());
		add(bt_xacnhandk);
		}

	@Override
	protected void handleClick(String name) {
		// TODO Auto-generated method stub
		if(name.equals(BT_XAC_NHAN)) {
			AccountLogin acc = new AccountLogin();
			String a = tf_tendangki.getText();
			String b = pf_matkhau.getText();
			if(b.equals(pf_xacnhanmk.getText())) {
			acc.addData(a, b);
			acc.getData();
			JOptionPane.showMessageDialog(this, "dang ki thanh cong");
			acclick.comeBack();
			}else {
				JOptionPane.showMessageDialog(this, "Mat khau xac nhan khong dung, vui long nhap lai!!");
			}
		}
	}	
	
	private ActionClick acclick;

	public ActionClick getAcclick() {
		return acclick;
	}
	public void setAcclick(ActionClick acclick) {
		this.acclick = acclick;
	}
	
}

	

