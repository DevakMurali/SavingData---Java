package com.Murali.SavingData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataStorage {
	
	public void saveData(String user, String score){
		try{
			FileOutputStream saveFile = new FileOutputStream("Ducks.sav");
			
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			
			save.writeObject(user);
			save.writeObject(score);
			
			save.close();
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public ArrayList<String> loadData(){
		ArrayList<String> data = new ArrayList<String>();
		
		try {
			FileInputStream saveFile = new FileInputStream("Ducks.sav");
			
			ObjectInputStream save = new ObjectInputStream(saveFile);
			
			data.add((String) save.readObject());
			data.add((String) save.readObject());
			
			save.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
}
