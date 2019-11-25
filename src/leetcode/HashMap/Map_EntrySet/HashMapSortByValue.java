package leetcode.HashMap.Map_EntrySet;

import java.util.*;

public class HashMapSortByValue {
    public static void main(String[] args){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("a",10);
        map.put("b",1);
        map.put("c",22);
        map.put("d",2);
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
                //降序
                return (o2.getValue()-o1.getValue());
            }
        });
        for(Map.Entry<String,Integer> mapping : list){
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }
    }
}
