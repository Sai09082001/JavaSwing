package com.bin.game.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class AccountLogin {
	private List<Account> list_acc;
	public static final String PATH = "D:/baitap/DataLogin.txt";
	
	public AccountLogin() {
		list_acc = new ArrayList<>();
	}

	public List<Account> getList_acc() {
		return list_acc;
	}

	public void setList_acc(List<Account> list_acc) {
		this.list_acc = list_acc;
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
				Account acc = new Account(info[0], info[1]);
				list_acc.add(acc);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addData(String acc,String pass) {
		File file = new File(PATH);
		Account accout = new Account(acc, pass);
		list_acc.add(accout);
		try {
			FileOutputStream out = new FileOutputStream(file,true);
			String s = "\n" + acc + "-" + pass;
			byte[] buff = s.getBytes();
			out.write(buff);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
