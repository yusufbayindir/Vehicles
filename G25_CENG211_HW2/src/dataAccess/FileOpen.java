package dataAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileOpen {
	public static ArrayList<ArrayList<String>> getTwoDim(String fileName) throws IOException{
		ArrayList<ArrayList<String>> fileTo2Dm;
		try (BufferedReader buff = new BufferedReader(new FileReader(fileName))) {
			ArrayList<String>  fileTo=new ArrayList<>();
			fileTo2Dm=new ArrayList<>();
			while(buff.ready()) {
				fileTo.add(buff.readLine());
			}
			for(String a:fileTo) {
			StringTokenizer token=new StringTokenizer(a,",");
			ArrayList<String> temp=new ArrayList<>();
			while(token.hasMoreElements()) {
				temp.add(token.nextToken());
			}
				fileTo2Dm.add(temp);			
			}
		}
		return fileTo2Dm;
	}
}
