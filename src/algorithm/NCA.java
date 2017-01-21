package algorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * 
* @ClassName: NCA(new clustering algorithm)
* @Description: TODO(能够克服传统k均值算法在处理具有不同形状、不同大小、不同密度簇集时的缺陷)
* @author Jayshawn
* @date 2016年4月24日 下午7:13:16
* 
* @param <T>
 */
public class NCA<T> extends ME_Kmeans<T>{

	/**
	 * 标签，用于指明该点所属簇集
	 */
	private int[] L_q=new int[getData().size()];
	
	public NCA(List<T> list,int k_n){
		super(list, k_n);
		
	}
	
	public List<T>[] label(){
		String s=getData().get(0).getClass().getName().substring(5).toUpperCase();
		int k=1;
		int n=getData().size();
		for(int i=0;i<n;i++)
			L_q[i]=-1;
		int d=getFieldNames().size();
		int[] G=getG();
		int[][] pm=getPm();
		List<Integer> P=new ArrayList<Integer>();
		P.add(G[0]);
		L_q[G[0]]=1;
		int[] N_p=getN_p();		
		for(int i=0;i<n;i++){
			if(N_p[G[i]]==1){
				for(int m=0;m<k;m++){
					if(pm[G[i]][P.get(m)]==1){
						L_q[G[i]]=m;
						break;
					}
				}
				if(L_q[G[i]]==-1){
					P.add(G[i]);
					k++;
					L_q[G[i]]=k;
				}
			}
		}
		

		System.out.println("NCA "+s+" 分类数 "+k);
		List<T>[] lists=new ArrayList[k];
		for(int i=0;i<k;i++)
			lists[i]=new ArrayList<T>();
		for(int i=0;i<L_q.length;i++){
			int x=L_q[i];
			if(x==-1||x>(k-1)) continue;
				lists[x].add(getData().get(i));
		}
			
		return lists;


	}
}
