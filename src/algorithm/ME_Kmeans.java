package algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.Test1;
import util.Gamma;
import util.HashMapSort;

/**
 * 
* @ClassName: ME_Kmeans (more effective K-means)
* @Description: TODO(�Զ��ó��ؼ������ܺܺ�Ӧ�Թ����������)
* @author Jayshawn
* @date 2016��4��24�� ����7:12:26
* 
* @param <T>
 */
public class ME_Kmeans<T> extends Kmeans<T>{
	/**
	 * proximity matrix �ڽӾ���
	 */
	private int[][] pm=new int[getData().size()][getData().size()];
	/**
	 * �����ܶ����򣬴洢ֵΪdata�±�
	 */
	private int [] G=new int[getData().size()];
	/**
	 * ���ڴ�ų�ʼԭ��
	 */
	private List<Integer> P=new ArrayList<Integer>();

	
	private int k_n;
	/**
	 * ���ڼ����ڽӾ����Լ��ų�����
	 */
	private double e;
	/**
	 * Ϊ1���������� Ϊ0������
	 */
	private int[] N_p=new int[getData().size()];

	public int[][] getPm() {
		return pm;
	}

	public void setPm(int[][] pm) {
		this.pm = pm;
	}

	public int[] getG() {
		return G;
	}

	public void setG(int[] g) {
		G = g;
	}

	public List<Integer> getP() {
		return P;
	}

	public void setP(List<Integer> p) {
		P = p;
	}

	public int getK_n() {
		return k_n;
	}

	public void setK_n(int k_n) {
		this.k_n = k_n;
	}

	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}
	
	

	public int[] getN_p() {
		return N_p;
	}

	public void setN_p(int[] n_p) {
		N_p = n_p;
	}

	public ME_Kmeans(List<T> list,int k_n){
		super(list);
		this.k_n=k_n;	
		E();
		PM();
		density();
	}
	/**
	 * 
	* @Title: density 
	* @Description: TODO(�����ݼ������е㰴���ܶ��������򣬲������±�洢��G��) 
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
	public void density(){
		int n=getData().size();
		int d=getFieldNames().size();
		Map<Integer, Double> den=new HashMap<Integer,Double>();
		for(int j=0;j<n;j++){
			Map<Integer,Double> disArray = new HashMap<Integer,Double>();
			for(int i=0;i<n;i++)
				disArray.put(i, distance(getData().get(j), getData().get(i)));
			List<Map.Entry<Integer,Double>> listDisArray=HashMapSort.hashMapSort(disArray,0);
			double radius=listDisArray.get(k_n-1).getValue();
			if(radius>e) N_p[j]=0;
			else N_p[j]=1;
			int temp=k_n;
			while(listDisArray.get(temp-1).getValue()==listDisArray.get(temp).getValue()) 
				temp++;
			int N_t=temp;
			double sumDis=0;
			for(int p=0;p<k_n;p++)
				sumDis+=listDisArray.get(p).getValue();
			double v=2*Math.pow(Math.PI, d/2.0)*Math.pow(radius, d)/d/Gamma.getValue(d/2.0);
			den.put(j, N_t/(n*v*sumDis));
	    }
		
		//��������ж�����
//		for(int i=0;i<N_p.length;i++)
//			System.out.println(N_p[i]);
		
		List<Map.Entry<Integer,Double>> listDen=HashMapSort.hashMapSort(den,1);
		for(int i=0;i<n;i++)
			G[i]=listDen.get(i).getKey();
	
	}
	
	public List<T>[] cluster(){
		String s=getData().get(0).getClass().getName().substring(5).toUpperCase();
		int n=getData().size();
		P.add(G[0]);		
		for(int i=1;i<n;i++){
			if(N_p[G[i]]==1){
				int flag=1;
				for(int j=0;j<P.size();j++)
					if(pm[G[i]][P.get(j)]==1) flag=0;
				if(flag==1) P.add(G[i]);
			}
		}
		System.out.println("ME_Kmeans "+s+" ������ "+P.size());
		setK(P.size());
		List<T> init=new ArrayList<T>();
		for(int i=0;i<P.size();i++)
			init.add(getData().get(P.get(i)));
		setInitCenter(init);
		//�����ʼ�۵�
//		for(int i=0;i<P.size();i++)
//			System.out.println(getData().get(P.get(i)));
		
		return comput();
	}

	/**
	 * 
	* @Title: E 
	* @Description: TODO(����eֵ) 
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
	public void E(){
		int n=getData().size();
		int d=getFieldNames().size();
		double[][] dataArray=new double[d][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<d;j++)
				dataArray[j][i]=(double) invokeMethod(getData().get(i), "getAtt"+(j+1),null);
		double prod=1;
		for(int i=0;i<d;i++){
			Arrays.sort(dataArray[i]);
			prod*=dataArray[i][n-1]-dataArray[i][0];
		}
		e=Math.pow(prod*k_n*Gamma.getValue(0.5*d+1)/(n*Math.sqrt(Math.pow(Math.PI, d))), 1.0/d);	
		
	}
	/**
	 * 
	* @Title: PM 
	* @Description: TODO(����ڽӾ���) 
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
	public void PM(){
		int n=getData().size();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(distance(getData().get(i), getData().get(j))<=e) pm[i][j]=1;
				else pm[i][j]=0;
			}
		}	
	}

	
}
