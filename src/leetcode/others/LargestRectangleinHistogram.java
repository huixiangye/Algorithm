package leetcode.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yehuixiang on 8/13/18.
 */
public class LargestRectangleinHistogram {

    static HashMap<Integer,Integer> map = new HashMap<>();

    public int largestRectangleArea(int[] heights) {

        int maxarea = 0;

        for (int i = 0; i < heights.length; i++) {
            int tempMax = 0;
            for (int j = i; j < heights.length; j++) {
                int minheight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    minheight = Math.min(minheight, heights[k]);

                tempMax = Math.max(tempMax, minheight * (j - i + 1));
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }


            map.put(i,tempMax);
        }
            return maxarea;
    }

    public List<Integer> findIndex(HashMap<Integer,Integer> map){
        int maxarea = 0;
        for(Integer max: map.values()){
            if(max > maxarea){
                maxarea = max;
            }
        }

        return getKey(maxarea,map);
    }

    public List<Integer> getKey(Integer value, HashMap<Integer,Integer> map){
        List<Integer> res = new ArrayList<>();

        if(!isRepeat(value,map)) {
            for (Integer key : map.keySet()) {
                if (map.get(key).equals(value)) {
                    res.add(key);
                    return res; //return the first found
                }
            }

        }else{
            for (Integer key : map.keySet()) {
                if (map.get(key).equals(value)) {
                    res.add(key);
                }
            }

            return res;
        }

        return null;

    }

    public boolean isRepeat(Integer value,HashMap<Integer,Integer> map){
        for(Integer max : map.values()){
            if(max == value){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        int[] heigths1 = {2,1,5,6,2,3};
        int[] heigths2 = {5,6,1,5,6};

        LargestRectangleinHistogram largestRectangleinHistogram = new LargestRectangleinHistogram();

        System.out.println("max area is: " + largestRectangleinHistogram.largestRectangleArea(heigths1));
        System.out.println("the locations for the rectangle is: "+ largestRectangleinHistogram.findIndex(map));


        System.out.println("max area is: " + largestRectangleinHistogram.largestRectangleArea(heigths2));
        System.out.println("the locations for the rectangle is: "+ largestRectangleinHistogram.findIndex(map));

    }

}
