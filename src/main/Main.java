package main;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;

import algorithm.*;
import data.*;
import util.OutPut;

public class Main {
	public static final int IRIS=3;
	public static final int GLASS=6;
	public static final int TEST1=5;
	public static final int TEST2=3;
	public static final int TEST3=5;
	public static final int TEST4=2;
	
	public static List<Iris> I=new ArrayList<Iris>();
	public static List<Iris>[] irisTrue=new ArrayList[IRIS];
	public static String[] irisTypeName={"Iris-setosa","Iris-versicolor","Iris-virginica"};
	
	public static List<Glass> G=new ArrayList<>();
	public static List<Glass>[] glassTrue=new ArrayList[GLASS];
	public static String[] glassTypeName={"1","2","3","5","6","7"};
	
	public static List<Test1> T1=new ArrayList<>();
	public static List<Test1>[] test1True=new ArrayList[TEST1];
	public static String[] test1TypeName={"1","2","3","4","5"};
	
	public static List<Test2> T2=new ArrayList<>();
	public static List<Test2>[] test2True=new ArrayList[TEST2];
	public static String[] test2TypeName={"1","2","3"};
	
	public static List<Test3> T3=new ArrayList<>();
	public static List<Test3>[] test3True=new ArrayList[TEST3];
	public static String[] test3TypeName={"1","2","3","4","5"};
	

	/**
	 * 
	* @Title: assignIris 
	* @Description: TODO(初始化Iris) 
	* @param     bezdekIris.txt 
	* @return void    返回类型 
	* @throws
	 */
	public static void assignIris(){
		for(int i=0;i<IRIS;i++)
			irisTrue[i]=new ArrayList<Iris>();
		File file=new File("D:/workspace/Clustering/src/bezdekIris.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String lineTxt =null;
			while((lineTxt = br.readLine()) != null){
				String temp[]=lineTxt.split(",");
				Iris iTemp=new Iris(Double.valueOf(temp[0]), Double.valueOf(temp[1]), 
						Double.valueOf(temp[2]), Double.valueOf(temp[3]));
				I.add(iTemp);
				for(int i=0;i<IRIS;i++)
					if(temp[4].equals(irisTypeName[i])) irisTrue[i].add(iTemp);
								
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	* @Title: assignGlass 
	* @Description: TODO(初始化glass) 
	* @param     glass.txt 
	* @return void    返回类型 
	* @throws
	 */
	public static void assignGlass(){
		for(int i=0;i<GLASS;i++)
			glassTrue[i]=new ArrayList<Glass>();
		File file=new File("D:/workspace/Clustering/src/glass.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String lineTxt =null;
			while((lineTxt = br.readLine()) != null){
				String temp[]=lineTxt.split(",");
				Glass gTemp=new Glass(Double.valueOf(temp[1]),Double.valueOf(temp[2]), Double.valueOf(temp[3]),
						Double.valueOf(temp[4]),Double.valueOf(temp[5]),Double.valueOf(temp[6]),
						Double.valueOf(temp[7]),Double.valueOf(temp[8]),Double.valueOf(temp[9]));
				G.add(gTemp);
				for(int i=0;i<GLASS;i++)
					if(temp[10].equals(glassTypeName[i])) glassTrue[i].add(gTemp);
								
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public static void assignTest1(){
		for(int i=0;i<TEST1;i++)
			test1True[i]=new ArrayList<Test1>();
		File file=new File("D:/workspace/Clustering/src/Test1.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String lineTxt =null;
			while((lineTxt = br.readLine()) != null){
				String temp[]=lineTxt.split(",");
				Test1 gTemp=new Test1(Double.valueOf(temp[0]),Double.valueOf(temp[1]));
				T1.add(gTemp);
				for(int i=0;i<TEST1;i++)
					if(temp[2].equals(test1TypeName[i])) test1True[i].add(gTemp);
								
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void assignTest2(){
		for(int i=0;i<TEST2;i++)
			test2True[i]=new ArrayList<Test2>();
		File file=new File("D:/workspace/Clustering/src/Test2.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String lineTxt =null;
			while((lineTxt = br.readLine()) != null){
				String temp[]=lineTxt.split(",");
				Test2 gTemp=new Test2(Double.valueOf(temp[0]),Double.valueOf(temp[1]));
				T2.add(gTemp);
				for(int i=0;i<TEST2;i++)
					if(temp[2].equals(test2TypeName[i])) test2True[i].add(gTemp);
								
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void assignTest3(){
		for(int i=0;i<TEST3;i++)
			test3True[i]=new ArrayList<Test3>();
		File file=new File("D:/workspace/Clustering/src/Test3.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String lineTxt =null;
			while((lineTxt = br.readLine()) != null){
				String temp[]=lineTxt.split(",");
				Test3 gTemp=new Test3(Double.valueOf(temp[0]),Double.valueOf(temp[1]));
				T3.add(gTemp);
				for(int i=0;i<TEST3;i++)
					if(temp[2].equals(test3TypeName[i])) test3True[i].add(gTemp);
								
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static<T> void accuracy(List<T>[] results){	
		double r=0;
		try {
			String s1=results[0].get(0).getClass().getName().substring(5).toUpperCase();
			
			String s2=s1.toLowerCase()+"True";
			List<T>[] True=(List<T>[]) Main.class.getDeclaredField(s2).get(new Main());
			int N=(int) Main.class.getDeclaredField(s1).get(new Main());
			int[][] count =new int[results.length][N];
			for(int i=0;i<results.length;i++)
				for(int j=0;j<results[i].size();j++)
					for(int k=0;k<N;k++)
						if(True[k].contains(results[i].get(j))) count[i][k]++;
			int sum=0;
			int[] rs=new int[results.length];
			for(int i=0;i<results.length;i++){
				Arrays.sort(count[i]);
				rs[i]=count[i][N-1];
			}
			Arrays.sort(rs);
			if(results.length<N){
				for(int i=0;i<results.length;i++)
					sum+=rs[i];
			}
			else{
				for(int i=0;i<N;i++)
					sum+=rs[results.length-1-i];
			}
			if(s1.equals("IRIS")) r= sum/150.0;
			else if(s1.equals("GLASS")) r=sum/214.0;
			else if(s1.equals("TEST1")) r=sum/335.0;
			else if(s1.equals("TEST2")) r=sum/300.0;
			else if(s1.equals("TEST3")) r=sum/513.0;
			System.out.println(s1+" "+r);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	public static void main(String[] args) {
		assignIris();
		assignGlass();
		assignTest1();
		assignTest2();
		assignTest3();
		
		
		/**
		 * Iris测试
		 */
		
		for(int i=0;i<10;i++){
			Kmeans<Iris> kmeansI=new Kmeans<Iris>(I,3);
			accuracy(kmeansI.comput());
	    }
	    System.out.println("*****************************************");
		
//		E_Kmeans<Iris> eI=new E_Kmeans<Iris>(I, 3,50);
//		accuracy(eI.cluster());
//		System.out.println("*****************************************");
		
//		ME_Kmeans<Iris> meI=new ME_Kmeans<Iris>(I, 50);
//		List<Iris>[] resultsI=meI.cluster();
//		accuracy(resultsI);
//		System.out.println("*****************************************");		
		
//		NCA<Iris> nI=new NCA<Iris>(I,50);
//		List<Iris>[] resultsI=nI.label();
//		accuracy(resultsI);
//		System.out.println("*****************************************");	
		
		
		/**
		 * Glass测试
		 */
		
//		for(int i=0;i<10;i++){
//			Kmeans<Glass> kmeansG=new Kmeans<Glass>(G,6);
//			accuracy(kmeansG.comput());
//	    }
//	    System.out.println("*****************************************");
//		
//		E_Kmeans<Glass> eG=new E_Kmeans<Glass>(G, 6,13);
//		accuracy(eG.cluster());
//	    System.out.println("*****************************************");
//		
//		ME_Kmeans<Glass> meG=new ME_Kmeans<Glass>(G, 13);
//		List<Glass>[] resultsG=meG.cluster();
//		accuracy(resultsG);
//	    System.out.println("*****************************************");
//		
//		NCA<Glass> nG=new NCA<Glass>(G,13);
//		List<Glass>[] resultsG=nG.label();
//		accuracy(resultsG);
//		System.out.println("*****************************************");	
		
		
		/**
		 * Test1测试
		 */
		
//		for(int i=0;i<10;i++){
//			Kmeans<Test1> kmeansT1=new Kmeans<Test1>(T1,5);
//			accuracy(kmeansT1.comput());
//	    }
//	    System.out.println("*****************************************");
//		
//		E_Kmeans<Test1> eT1=new E_Kmeans<Test1>(T1,5,50);
//		accuracy(eT1.cluster());
//	    System.out.println("*****************************************");
//		
//		ME_Kmeans<Test1> meT1=new ME_Kmeans<Test1>(T1,50);
//		List<Test1>[] resultsT1=meT1.cluster();
//		accuracy(resultsT1);
//		OutPut.write1(resultsT1);
//	    System.out.println("*****************************************");
//		
//		NCA<Test1> nT1=new NCA<Test1>(T1,50);
//		List<Test1>[] resultsT1=nT1.label();
//		accuracy(resultsT1);
//		OutPut.write1(resultsT1);
//		System.out.println("*****************************************");	
		
		
		/**
		 * Test2测试
		 */
		
//		for(int i=0;i<10;i++){
//			Kmeans<Test2> kmeansT2=new Kmeans<Test2>(T2,3);
//			accuracy(kmeansT2.comput());
//	    }
//	    System.out.println("*****************************************");
//		
//		E_Kmeans<Test2> eT2=new E_Kmeans<Test2>(T2,3,27);
//		accuracy(eT2.cluster());
//	    System.out.println("*****************************************");
//		
//		ME_Kmeans<Test2> meT2=new ME_Kmeans<Test2>(T2,27);
//		List<Test2>[] resultsT2=meT2.cluster();
//		accuracy(resultsT2);
//		OutPut.write2(resultsT2);
//	    System.out.println("*****************************************");
//		
//		NCA<Test2> nT2=new NCA<Test2>(T2,27);
//		List<Test2>[] resultsT2=nT2.label();
//		accuracy(resultsT2);
//		OutPut.write2(resultsT2);
//		System.out.println("*****************************************");
		
		
		/**
		 * Test3测试
		 */
		
//		for(int i=0;i<10;i++){
//			Kmeans<Test3> kmeansT3=new Kmeans<Test3>(T3,5);
//			accuracy(kmeansT3.comput());
//	    }
//	    System.out.println("*****************************************");
//		
//		E_Kmeans<Test3> eT3=new E_Kmeans<Test3>(T3,5,55);
//		accuracy(eT3.cluster());
//	    System.out.println("*****************************************");
//		
//		ME_Kmeans<Test3> meT3=new ME_Kmeans<Test3>(T3,55);
//		List<Test3>[] resultsT3=meT3.cluster();
//		accuracy(resultsT3);
//		OutPut.write3(resultsT3);
//	    System.out.println("*****************************************");
//		
//		NCA<Test3> nT3=new NCA<Test3>(T3,55);
//		List<Test3>[] resultsT3=nT3.label();
//		accuracy(resultsT3);
//		OutPut.write3(resultsT3);
//		System.out.println("*****************************************");
		
	
	}
}
