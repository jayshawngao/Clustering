package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapSort {

	public static List<Map.Entry<Integer, Double>> hashMapSort(Map<Integer,Double> map,int flag){
		 List<Map.Entry<Integer,Double>> list = new ArrayList<Map.Entry<Integer,Double>>(map.entrySet());
	        Collections.sort(list,new Comparator<Map.Entry<Integer,Double>>() {
	            public int compare(Entry<Integer,Double> o1,
	                    Entry<Integer,Double> o2) {
	                /**
	                 * flag==0;value值正序排列 flag！=0；value值逆序排列
	                 */
	            	if(flag==0)return o1.getValue().compareTo(o2.getValue());
	                return o2.getValue().compareTo(o1.getValue());
	            }

	        });
	     return list;
	}
}
