package algorithm;  
  
import java.lang.annotation.Annotation;  
import java.lang.reflect.Field;  
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.KmeanField;

  

public class Kmeans<T> {  
    
	/** 
     * 所有数据列表 
     */  

    private List<T> data = new ArrayList<T>();  
  
    /** 
     * 数据类别 
     */  
    private Class<T> classT;  
  
    /** 
     * 初始化K个中心
     *
     */  
    private List<T> initCenter;  
  
    /** 
     * 需要纳入kmeans算法的属性名称 
     */  
    private List<String> fieldNames = new ArrayList<String>();  
  
    /** 
     * 分类数 
     */  
    private int k = 1;  
    
    private List<T> data_new;
    private List<T> data_old;
  
    
    public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Class<T> getClassT() {
		return classT;
	}

	public void setClassT(Class<T> classT) {
		this.classT = classT;
	}

	public List<T> getInitCenter() {
		return initCenter;
	}

	public void setInitCenter(List<T> initCenter) {
		this.initCenter = initCenter;
	}

	public List<String> getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(List<String> fieldNames) {
		this.fieldNames = fieldNames;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public List<T> getData_new() {
		return data_new;
	}

	public void setData_new(List<T> data_new) {
		this.data_new = data_new;
	}

	public List<T> getData_old() {
		return data_old;
	}

	public void setData_old(List<T> data_old) {
		this.data_old = data_old;
	}

	public Kmeans() {  
  
    }  
  
    /** 
     * 初始化列表 
     *  
     * @param list 
     * @param k 
     */  
    public Kmeans(List<T> list, int k) {  
        this.data = list;  
        this.k = k;  
        T t = list.get(0);  
        this.classT = (Class<T>) t.getClass();  
        Field[] fields = this.classT.getDeclaredFields();  
        for (int i = 0; i < fields.length; i++) {  
            Annotation kmeansAnnotation = fields[i]  
                    .getAnnotation(KmeanField.class);  
            if (kmeansAnnotation != null) {  
                fieldNames.add(fields[i].getName());  
            }  
  
        }  
  
        initCenter = new ArrayList<T>();  
        for(int i=0;i<k;i++){
        	int max=data.size()-1;
            int min=0;
            Random random = new Random();
            int s = random.nextInt(max)%(max-min+1) + min;
            initCenter.add(data.get(s));
        }
 
        
    }  
    /**
     * 
    * <p>Title: </p>
    * <p>Description: 无需指定初始聚类数的构造函数</p>
    * @param list
     */
    public Kmeans(List<T> list){
    	 
            this.data = list;   
            T t = list.get(0);  
            this.classT = (Class<T>) t.getClass();  
            Field[] fields = this.classT.getDeclaredFields();  
            for (int i = 0; i < fields.length; i++) {  
                Annotation kmeansAnnotation = fields[i]  
                        .getAnnotation(KmeanField.class);  
                if (kmeansAnnotation != null) {  
                    fieldNames.add(fields[i].getName());  
                }  
      
            }  
        
    }
  
    public List<T>[] comput() {  
        List<T>[] results = new ArrayList[k];  
        boolean centerchange = true;  
        
        this.data_new=new ArrayList<T>();
        this.data_old=new ArrayList<T>();
        for(int i=0;i<k;i++){
        	
        	try {
				data_new.add(classT.newInstance());
				data_old.add(classT.newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        while (centerchange) {  
            centerchange = false;  
            
            
            for (int i = 0; i < k; i++) {  
                results[i] = new ArrayList<T>();  
            }  
            for (int i = 0; i < data.size(); i++) {  
                T p = data.get(i);  
                double[] dists = new double[k];  
                for (int j = 0; j < initCenter.size(); j++) {  
                    T initP = initCenter.get(j);  
                    /* 计算距离 */  
                    double dist = distance(initP, p);  
                    dists[j] = dist;  
                }  
  
                int dist_index = computOrder(dists);  
                results[dist_index].add(p);  
            }  
  
            for (int i = 0; i < k; i++) {  
                 data_new.set(i,findNewCenter(results[i]));  
                 data_old.set(i,initCenter.get(i));  
                 if (!IsDataEqual(data_new.get(i), data_old.get(i))) {  
                     centerchange = true;  
                     initCenter.set(i, data_new.get(i));  
                 }
  
            } 
         
  
        }  
  
        return results;  
    } 
    
    public List<T>[] computOne() {  
        List<T>[] results = new ArrayList[k];  
        boolean centerchange = true;  
        this.data_new=new ArrayList<T>();
        this.data_old=new ArrayList<T>();
        for(int i=0;i<k;i++){
        	
        	try {
				data_new.add(classT.newInstance());
				data_old.add(classT.newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
         
             
            for (int i = 0; i < k; i++) {  
                results[i] = new ArrayList<T>();  
            }  
            for (int i = 0; i < data.size(); i++) {  
                T p = data.get(i);  
                double[] dists = new double[k];  
                for (int j = 0; j < initCenter.size(); j++) {  
                    T initP = initCenter.get(j);  
                    /* 计算距离 */  
                    double dist = distance(initP, p);  
                    dists[j] = dist;  
                }  
  
                int dist_index = computOrder(dists);  
                results[dist_index].add(p);  
            }  
  
             
  
          
  
        return results;  
    } 
  
    /** 
     * 比较是否两个对象是否属性一致 
     *  
     * @param p1 
     * @param p2 
     * @return 
     */  
    public boolean IsDataEqual(T p1, T p2) {  
        if (p1 == p2) {  
            return true;  
        }  
        if (p1 == null || p2 == null) {  
            return false;  
        }  
  
          
  
        boolean flag = true;  
        try {  
            for (int i = 0; i < fieldNames.size(); i++) {  
                String fieldName=fieldNames.get(i);  
                String getName = "get"  
                        + fieldName.substring(0, 1).toUpperCase()  
                        + fieldName.substring(1);                 
                Object value1 = invokeMethod(p1,getName,null);  
                Object value2 = invokeMethod(p2,getName,null);  
                if (!value1.equals(value2)) {  
                    flag = false;  
                    break;  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            flag = false;  
        }  
  
        return flag;  
    }  
  
    /** 
     * 得到新聚类中心对象 
     *  
     * @param ps 
     * @return 
     */  
    public T findNewCenter(List<T> ps) {  
        try {  
            T t = classT.newInstance();  
            if (ps == null || ps.size() == 0) {  
                return t;  
            }  
  
            double[] ds = new double[fieldNames.size()];  
            for (T vo : ps) {  
                for (int i = 0; i < fieldNames.size(); i++) {  
                    String fieldName=fieldNames.get(i);  
                    String getName = "get"  
                            + fieldName.substring(0, 1).toUpperCase()  
                            + fieldName.substring(1);  
                    Object obj=invokeMethod(vo,getName,null);  
                    Double fv=(obj==null?0:Double.parseDouble(obj+""));  
                    ds[i] += fv;  
                }  
  
            }  
  
            for (int i = 0; i < fieldNames.size(); i++) {  
                ds[i] = ds[i] / ps.size();  
                String fieldName = fieldNames.get(i);  
                  
                
                /* 给对象设值 */  
                String setName = "set"  
                        + fieldName.substring(0, 1).toUpperCase()  
                        + fieldName.substring(1);  
  
                invokeMethod(t,setName,new Class[]{double.class},ds[i]);  
  
            }  
  
            double[] dis=new double[ps.size()];
            for(int i=0;i<ps.size();i++)
            	dis[i]=distance(t, ps.get(i));
            int flag=0;
            for(int i=0;i<ps.size();i++)
            	if(dis[i]<dis[flag]) flag=i;
            return ps.get(flag);
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
        return null;  
  
    } 
  
    /** 
     * 得到最短距离，并返回最短距离索引 
     *  
     * @param dists 
     * @return 
     */  
    public int computOrder(double[] dists) {  
        double min = 0;  
        int index = 0;  
        for (int i = 0; i < dists.length - 1; i++) {  
            double dist0 = dists[i];  
            if (i == 0) {  
                min = dist0;  
                index = 0;  
            }  
            double dist1 = dists[i + 1];  
            if (min > dist1) {  
                min = dist1;  
                index = i + 1;  
            }  
        }  
  
        return index;  
    }  
  
    /** 
     * 计算距离（相似性） 采用欧几里得算法 
     *  
     * @param p0 
     * @param p1 
     * @return 
     */  
    public double distance(T p0, T p1) {  
        double dis = 0;  
        try {  
  
            for (int i = 0; i < fieldNames.size(); i++) {  
                String fieldName = fieldNames.get(i);  
                String getName = "get"  
                        + fieldName.substring(0, 1).toUpperCase()  
                        + fieldName.substring(1);  
                  
                Double field0Value=Double.parseDouble(invokeMethod(p0,getName,null)+"");  
                Double field1Value=Double.parseDouble(invokeMethod(p1,getName,null)+"");  
                dis += Math.pow(field0Value - field1Value, 2);   
            }  
          
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
        return Math.sqrt(dis);  
  
    }  
      
    /*------公共方法-----*/  
    public Object invokeMethod(Object owner, String methodName,Class[] argsClass,  
            Object... args) {  
        Class ownerClass = owner.getClass();  
        try {  
            Method method=ownerClass.getDeclaredMethod(methodName,argsClass);  
            return method.invoke(owner, args);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
  
        return null;  
    }  
//    /**
//     * 
//    * @Title: GetK 
//    * @Description: TODO(获得最优的聚类数K) 
//    * @param @return    
//    * @return int    返回类型 
//    * @throws
//     */
//    public int GetK(){
//    	double[] VArray=new double[10];
//    	int resultK=2;
//    	for(int j=2;j<10;j++){
//    		this.k=j;
//    		initCenter = new ArrayList<T>();  
//            int step=(int)(data.size()/k);
//            for(int i=0;i<k;i++)
//            initCenter.add(data.get((int)Math.random()*step+step*i));
//
//            List<T>[] results=comput();
//            
//            double MIntra=0,MInter=999;
//            
//            for(int m=0;m<k;m++){
//            	for(int n=0;n<results[m].size();n++){
//            		MIntra+=distance(data_new.get(m), results[m].get(n))*distance(data_new.get(m), results[m].get(n));
//            	}
//            }
//            MIntra=MIntra/data.size();
//
//            for(int r=0;r<k-1;r++){
//            	for(int s=r+1;s<k;s++){
//            		if(distance(data_new.get(r), data_new.get(s))<MInter) MInter=distance(data_new.get(r), data_new.get(s));
//            	}
//            }
//            
//            VArray[j]=MIntra/MInter;
//    	}
//    	for(int i=2;i<VArray.length;i++){
//    		if(VArray[i]<VArray[resultK]) resultK=i;
//    	}
//    	for(int i=2;i<VArray.length;i++)
//    		System.out.println(VArray[i]);
//    	System.out.println(resultK);
//    	return resultK;
//    	
//    	
//    }
 
}  

