package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class TestHashMap {

	@Test
	public void test() {
		Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 3);
        map.put("b", 2);
        map.put("c", 1);
        map.put("d", 4);

        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //…˝–Ú≈≈–Ú
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
            	//if(flag==0)return o1.getValue().compareTo(o2.getValue());
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        

        for(Map.Entry<String,Integer> mapping:list){ 
               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
          } 
	}

}
