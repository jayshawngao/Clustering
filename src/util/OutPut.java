package util;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import data.*;

public class OutPut {
	public static void write1(List<Test1>[] lists) {
		  FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("C:/Users/Jayshawn/workspace/Clustering/src/result1.txt");

			 for(int i=0;i<lists.length;i++){
				 for(Test1 t1:lists[i])
					 fileWriter.write(String.valueOf(t1.getAtt1()+","+t1.getAtt2()+","+(i+1)+"\n"));
			 }
			  fileWriter.flush();
			  fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	
	public static void write2(List<Test2>[] lists) {
		  FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("C:/Users/Jayshawn/workspace/Clustering/src/result2.txt");

			 for(int i=0;i<lists.length;i++){
				 for(Test2 t2:lists[i])
					 fileWriter.write(String.valueOf(t2.getAtt1()+","+t2.getAtt2()+","+(i+1)+"\n"));
			 }
			  fileWriter.flush();
			  fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	  
	}
	
	public static void write3(List<Test3>[] lists) {
		  FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("C:/Users/Jayshawn/workspace/Clustering/src/result3.txt");

			 for(int i=0;i<lists.length;i++){
				 for(Test3 t3:lists[i])
					 fileWriter.write(String.valueOf(t3.getAtt1()+","+t3.getAtt2()+","+(i+1)+"\n"));
			 }
			  fileWriter.flush();
			  fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	  
	}
	
		  

}
