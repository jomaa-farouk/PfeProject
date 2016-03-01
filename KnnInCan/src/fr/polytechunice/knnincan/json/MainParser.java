package fr.polytechunice.knnincan.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.gson.Gson;

public class MainParser {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		DataSet[] arr = null;
		try {
			InputStreamReader inputStram = new InputStreamReader(new FileInputStream("./files/ratp.json"), "UTF-8");
			arr = gson.fromJson(inputStram, DataSet[].class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		

		File file  = new File ("./files/S_Antennes.txt");
		
		for (int i=0; i<arr.length; i++){
		String s = "arret"+arr[i].getFields().getStop_id()+"("+
		arr[i].getFields().getStop_lat()+","+ arr[i].getFields().getStop_lon()+")";
		//System.out.println(s);

		try {
			PrintWriter out = new PrintWriter(new FileWriter(file, true));
		    if (i!=arr.length-1)
			out.append(s+"\n");
		    else
		    {
			out.append(s);
		    System.out.println("done");
		    }
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	}

}
