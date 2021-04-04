package com.bin.game.ui.panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import com.bin.game.ui.ActionClick;


public class MainPanel extends BasePanel implements ActionClick{
	public MainPanel() {
	}
	private PanelLearn learn;
	private PanelEnglish english;
	private PanelDangNhap dangnhap;
	private PanelDangKy dangki;
	private JLabel lb_tentk;
	
	@Override
	public void initUI() {
		setBackground(Color.WHITE);
		setLayout(new CardLayout());
	}
	
	@Override
	public void addEvent() {
		
	}
	
	@Override
	public void addComp() {
		
		dangnhap = new PanelDangNhap();
		dangnhap.setAcc(this);
		add(dangnhap);
		english = new PanelEnglish();
		english.setAcc(this);
		learn = new PanelLearn();
		dangki = new PanelDangKy();
		dangki.setAcclick(this);
		add(dangki);
	}

	@Override
	public void actionClick() {
		// TODO Auto-generated method stub
		Font f2 = new Font("Tahoma", Font.BOLD, 20);
		lb_tentk = creatLabel(dangnhap.tendangnhap, english.getLbTenDangNhap().getX() + english.getLbTenDangNhap().getWidth()+5,
				english.getLbTenDangNhap().getY(), f2,Color.RED,Color.WHITE);
		JLabel lb_tentk_learn = creatLabel(dangnhap.tendangnhap, english.getLbTenDangNhap().getX() + english.getLbTenDangNhap().getWidth()+5,
				english.getLbTenDangNhap().getY(), f2,Color.RED,Color.WHITE);
		english.add(lb_tentk);		
		add(english);
		learn.add(lb_tentk_learn);
		add(learn);
		english.setVisible(true);
		dangnhap.setVisible(false);
	}

	@Override
	public void dangKidangNhap() {
		// TODO Auto-generated method stub
		dangki.setVisible(true);
		dangnhap.setVisible(false);
	}

	@Override
	public void comeBack() {
		// TODO Auto-generated method stub
		dangki.setVisible(false);
		dangnhap.setVisible(true);
	}

	@Override
	public void translate() {
		// TODO Auto-generated method stub
		english.setVisible(false);
		learn.setVisible(true);
	}

	
}
