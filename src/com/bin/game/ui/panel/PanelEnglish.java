package com.bin.game.ui.panel;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.DoubleSummaryStatistics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bin.game.logic.Word;
import com.bin.game.logic.WordManage;
import com.bin.game.ui.ActionClick;
import com.bin.game.ui.GUI;


public class PanelEnglish extends BasePanel{
	private static final String BT_TONG = "BT_TONG";
	private static final String BT_NHAP_LAI = "BT_NHAP_LAI";
	private static final String BT_NAP = "BT_NAP";
	private static final String BT_THEM = "BT_THEM";
	private static final String BT_THUOC = "BT_THUOC";
	private static final String BT_HOC = "BT_HOC";
	private JLabel lbTitle, lb_duongdan,lb_tuvung,lb_nghia,lb_tendangnhap;
	private JTextField tf_link,tf_tuvung,tf_nghia;
	private JButton bt_nap,bt_them,bt_thuoc,bt_hoc;
	private JTable tb_word;
	private WordManage wordMgr;
	private static final String[] COLUMN_NAME= {"Tu vung"};

	@Override
	public void initUI() {
		// TODO Auto-generated method stub
		setBackground(Color.WHITE);
		setLayout(null);
	}

	@Override
	public void addEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComp() {
		// TODO Auto-generated method stub
		wordMgr = new WordManage();
		
		Font f = new Font("Tahoma", Font.BOLD, 45);
		Font f1 = new Font("Tahoma", Font.BOLD, 20);
		Font f2 = new Font("Tahoma", Font.BOLD, 15);
		lbTitle = creatLabel("English Game", 50, 20, f, Color.RED,Color.white);
		add(lbTitle);
		lb_duongdan = creatLabel("Duong dan", 50, lbTitle.getHeight() + lbTitle.getY() + 30, f1, Color.PINK,Color.WHITE);
		add(lb_duongdan);
		tf_link = createTextField(lb_duongdan.getX() + lb_duongdan.getWidth() + 20, lb_duongdan.getY(), 430, f1, Color.BLACK);
		tf_link.setText(WordManage.PATH);
		tf_link.setEditable(false);
		add(tf_link);
		bt_nap = creatButton("Nap", tf_link.getX()+tf_link.getWidth()+20, tf_link.getY(), f1, Color.BLACK, BT_NAP);
		add(bt_nap);
		tb_word = new JTable();
		tb_word.setFont(f1);
		tb_word.setRowHeight(50);
		tb_word.getTableHeader().setFont(f1);
		JScrollPane scr = new JScrollPane(tb_word);
		scr.setLocation(50, tf_link.getY()+tf_link.getHeight()+20);
		scr.setSize(650, 300);
		scr.setBackground(Color.LIGHT_GRAY);
		TitledBorder tborder = new TitledBorder("vocab");
		tborder.setTitleFont(f1);
		tborder.setTitleColor(Color.RED);
		scr.setBorder(tborder);
		initModelWord(tb_word);
		add(scr);
		lb_tuvung = creatLabel("Tu Vung",scr.getX(), scr.getY()+scr.getHeight()+20, f1, Color.BLACK,Color.WHITE);
		add(lb_tuvung);
		tf_tuvung = createTextField(lb_tuvung.getX()+lb_tuvung.getWidth()+20, lb_tuvung.getY(), 200, f1, Color.BLACK);
		add(tf_tuvung);
		lb_nghia = creatLabel("Nghia",scr.getX(), lb_tuvung.getY()+lb_tuvung.getHeight()+20, f1, Color.BLACK,Color.WHITE);
		add(lb_nghia);
		tf_nghia = createTextField(tf_tuvung.getX(), lb_nghia.getY(), 200, f1, Color.BLACK);
		add(tf_nghia);
		bt_them = creatButton("Them", tf_nghia.getX()+tf_nghia.getWidth()+20, lb_tuvung.getY(), f1, Color.BLACK, BT_THEM);
		bt_them.setSize(100, tf_nghia.getHeight()*2 + 20);
		add(bt_them);
		bt_thuoc = creatButton("Thuoc", bt_them.getX()+bt_them.getWidth()+20, lb_tuvung.getY(), f1, Color.BLACK, BT_THUOC);
		bt_thuoc.setSize(100, tf_nghia.getHeight()*2 + 20);
		add(bt_thuoc);
		bt_hoc = creatButton("Hoc", bt_thuoc.getX()+bt_thuoc.getWidth()+20, lb_tuvung.getY(), f1, Color.BLACK, BT_HOC);
		bt_hoc.setSize(100, tf_nghia.getHeight()*2 + 20);
		add(bt_hoc);
		lb_tendangnhap = creatLabel("Ten dang nhap: ", lbTitle.getX()+lbTitle.getWidth()+200, lbTitle.getHeight(), f1, Color.RED, Color.WHITE);
		lb_tendangnhap.setLocation(GUI.W_SIZE - 300, 20);
		add(lb_tendangnhap);
		
	}

	private void initModelWord(JTable tb) {
		// TODO Auto-generated method stub
		DefaultTableModel model=new DefaultTableModel() {
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return COLUMN_NAME.length;
			}
			@Override
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return COLUMN_NAME[column];
			}
			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return wordMgr.getList_word().size();
			}
			@Override
			public Object getValueAt(int row, int column) {
				// TODO Auto-generated method stub
				Word vocab=wordMgr.getList_word().get(row);
				return column==0?vocab.getWord():vocab.getMean();
				
			}
		};
		tb.setModel(model);
	}

	@Override
	protected void handleClick(String name) {
		// TODO Auto-generated method stub
		if(name.equals(BT_HOC)) {
			acc.translate();
		}
		if(name.equals(BT_NAP)) {
			napWord();
		}
		if(name.equals(BT_THEM)) {
			themWord();
		}
		if(name.equals(BT_THUOC)) {
			resetData();
		}
	}
	private void resetData() {
		// TODO Auto-generated method stub
		int sr = tb_word.getSelectedRow();
		Word vocab = wordMgr.getList_word().get(sr);
		int rs = JOptionPane.showConfirmDialog(this, "Delete word {" + vocab.getWord() + "-"+vocab.getMean()+"}","xac nhan",JOptionPane.YES_NO_OPTION);
		if(rs == JOptionPane.YES_OPTION) {
			wordMgr.xoaWord(vocab);
			((DefaultTableModel)tb_word.getModel()).fireTableDataChanged();
		}
	}

	private void themWord() {
		// TODO Auto-generated method stub
		String a = tf_tuvung.getText();
		String b = tf_nghia.getText();
		wordMgr.addData(a, b);
		((DefaultTableModel)tb_word.getModel()).fireTableDataChanged();
	}

	private void napWord() {
		// TODO Auto-generated method stub
		initDummyData();
		((DefaultTableModel)tb_word.getModel()).fireTableDataChanged();
	}

	public JLabel getLbTenDangNhap() {
		return lb_tendangnhap;
	}
	
	private void initDummyData() {
		wordMgr.getData();
	}
	
	private ActionClick acc;

	public ActionClick getAcc() {
		return acc;
	}

	public void setAcc(ActionClick acc) {
		this.acc = acc;
	}
	
	
}
