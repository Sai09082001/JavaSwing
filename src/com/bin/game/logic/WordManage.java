package com.bin.game.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class WordManage {
	public static final String PATH = "D:/baitap/EnglishGame.txt";
	private List<Word> list_word;
	private List<Word> listTuDung, listTuSai;
	
	

	public WordManage() {
		list_word = new ArrayList<>();
		listTuDung = new ArrayList<>();
		listTuSai = new ArrayList<>();
	}
	
	public List<Word> getList_word() {
		return list_word;
	}
	
	public void getData() {
		File file = new File(PATH);
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			String data = "";
			while(raf.getFilePointer() < raf.length()) {
				data += raf.readLine() + "\n";
			}
			raf.close();
			if(data.equals("")) {
				return;
			}
			String[] arrUser = data.split("\n");
			for(String user: arrUser) {
				String[] info = user.split("-");
				Word acc = new Word(info[0], info[1]);
				list_word.add(acc);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addData(String word,String mean) {
		File file = new File(PATH);
		Word accout = new Word(word, mean);
		list_word.add(accout);
		try {
			FileOutputStream out = new FileOutputStream(file,true);
			String s = word + "-" + mean + "\n";
			byte[] buff = s.getBytes();
			out.write(buff);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void xoaWord(Word vocab) {
		// TODO Auto-generated method stub
		list_word.remove(vocab);
	}

	public List<Word> getListTuDung() {
		return listTuDung;
	}

	public void setListTuSai(List<Word> listTuSai) {
		this.listTuSai = listTuSai;
	}

	public List<Word> getListTuSai() {
		return listTuSai;
	}

	public void setListTuDung(List<Word> listTuDung) {
		this.listTuDung = listTuDung;
	}
	
	
}
