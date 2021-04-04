package com.bin.game.ui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bin.game.logic.Word;
import com.bin.game.logic.WordManage;
import com.bin.game.ui.GUI;


public class PanelLearn extends BasePanel{
	private static final String BT_DOAN = "BT_DOAN";
	private static final String[] COLUMN_NAME= {"Tu vung"};
	private JLabel lb_title, lb_chontu, lb_nhapnghia,lb_tendangnhap;
	private JTextField tf_nhapnghia;
	private JButton bt_doan;
	private JTable tb_dung, tb_sai;
	private JComboBox<Word> cbbWord;
	private WordManage wordMgr;
	
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
		wordMgr = new WordManage();
		// TODO Auto-generated method stub
		Font f = new Font("Tahoma", Font.BOLD, 45);
		Font f1 = new Font("Tahoma", Font.BOLD, 20);
		Font f2 = new Font("Tahoma", Font.BOLD, 15);
		lb_title = creatLabel("Study English", 50, 20, f, Color.RED, Color.WHITE);
		add(lb_title);
		lb_chontu = creatLabel("Chon tu", lb_title.getX(), lb_title.getY()+lb_title.getHeight()+20, f1, Color.BLACK, Color.WHITE);
		add(lb_chontu);
		cbbWord = new JComboBox<Word>();
		cbbWord.setLocation(lb_chontu.getX()+getWidth()+150, lb_chontu.getY());
		cbbWord.setFont(f1);
		cbbWord.setSize(200, 30);
		cbbWord.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					Word vocab = (Word)cbbWord.getSelectedItem();
				}
			}
		});
		initWordCbb();
		add(cbbWord);
		lb_nhapnghia = creatLabel("Nhap nghia", 50, lb_chontu.getY()+lb_chontu.getHeight()+20, f1, Color.BLACK, Color.WHITE);
		add(lb_nhapnghia);
		tf_nhapnghia = createTextField(lb_nhapnghia.getX()+lb_nhapnghia.getWidth()+20, lb_nhapnghia.getY(), 300, f1, Color.BLACK);
		add(tf_nhapnghia);
		bt_doan = creatButton("Doan", tf_nhapnghia.getX()+tf_nhapnghia.getWidth()+30, lb_chontu.getY(), f1, Color.BLACK, BT_DOAN);
		bt_doan.setSize(bt_doan.getWidth(), tf_nhapnghia.getHeight()*2+20);
		add(bt_doan);
		//
		lb_tendangnhap = creatLabel("Ten dang nhap: ", 0,0, f1, Color.RED, Color.WHITE);
		lb_tendangnhap.setLocation(GUI.W_SIZE - 300, 20);
		add(lb_tendangnhap);
		//
		tb_dung = new JTable();
		tb_dung.setFont(f1);
		tb_dung.setRowHeight(50);
		tb_dung.getTableHeader().setFont(f1);
		JScrollPane scr_dung = new JScrollPane(tb_dung);
		scr_dung.setLocation(50, tf_nhapnghia.getY()+tf_nhapnghia.getHeight()+20);
		scr_dung.setSize(GUI.W_SIZE/2-60, 300);
		scr_dung.setBackground(Color.LIGHT_GRAY);
		TitledBorder tborder_dung = new TitledBorder("Tu dung");
		tborder_dung.setTitleColor(Color.RED);
		tborder_dung.setTitleFont(f1);
		scr_dung.setBorder(tborder_dung);
		add(scr_dung);
		//
		tb_sai = new JTable();
		tb_sai.setFont(f1);
		tb_sai.setRowHeight(50);
		tb_sai.getTableHeader().setFont(f1);
		JScrollPane scr_sai = new JScrollPane(tb_sai);
		scr_sai.setLocation(scr_dung.getX()+scr_dung.getWidth()+20, scr_dung.getY());
		scr_sai.setSize(GUI.W_SIZE/2-60, 300);
		scr_sai.setBackground(Color.LIGHT_GRAY);
		TitledBorder tborder_sai = new TitledBorder("Tu sai");
		tborder_sai.setTitleColor(Color.RED);
		tborder_sai.setTitleFont(f1);
		scr_sai.setBorder(tborder_sai);
		add(scr_sai);
	}

	private void initWordCbb() {
		// TODO Auto-generated method stub
		DefaultComboBoxModel<Word> model = new DefaultComboBoxModel<>();
		wordMgr.getData();
		for (int i = 0; i < wordMgr.getList_word().size(); i++) {
			model.addElement(wordMgr.getList_word().get(i));
		}
		cbbWord.setModel(model);
	}
	
	@Override
	protected void handleClick(String name) {
		// TODO Auto-generated method stub
		if(name.equals(BT_DOAN)) {
			tuDungTuSai();
		}
	}

	private void tuDungTuSai() {
		// TODO Auto-generated method stub
		Word vocab = (Word)cbbWord.getSelectedItem();
		String a = vocab.getMean();
		String b = tf_nhapnghia.getText();
		if(a.equals(b)) {
			wordMgr.getListTuDung().add(vocab);
			
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
					return wordMgr.getListTuDung().size();
				}
				@Override
				public Object getValueAt(int row, int column) {
					// TODO Auto-generated method stub
					Word vocab=wordMgr.getListTuDung().get(row);
					return column==0?vocab.getWord():vocab.getMean();
					
				}
			};
			tb_dung.setModel(model);
			((DefaultTableModel) tb_dung.getModel()).fireTableDataChanged();
			}
			else {
				wordMgr.getListTuSai().add(vocab);
				DefaultTableModel model_sai =new DefaultTableModel() {
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
						return wordMgr.getListTuSai().size();
					}
					@Override
					public Object getValueAt(int row, int column) {
						// TODO Auto-generated method stub
						Word vocab=wordMgr.getListTuSai().get(row);
						return column==0?vocab.getWord():vocab.getMean();
						
					}
				};
				tb_sai.setModel(model_sai);
				((DefaultTableModel) tb_sai.getModel()).fireTableDataChanged();
		}
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
}
