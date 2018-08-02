package AmasonLeetcode.OA2CODING.oa2面试题;

import java.util.*;

/**
 * Created by yehuixiang on 7/28/18.
 * 题目大概意思就给你一个arrayList然后返回一个map,里面是每个id 对应的前五个成绩的平均值
 * //records = [[1,91],[1,92],[2,93],[2,99],
            [2,98],[2,97],[1,60],[1,58],[2,100],[1,61]];

 * return a list of <student_id, score>
 * @return find the average of 5 highest scores for each person
 * Map<Integer, Double> (student_id, average_score)
**/

class Record{
    int id;
    double score;

    public Record(int id, double score){
        this.id = id;
        this.score = score;
    }

}

public class firstFiveAverage {

    public static Map<Integer, Double> highFive(int numOfPairs, ArrayList<Record> input) {

        if(input == null || input.size() == 0){
            return new HashMap<>();
        }

        Map<Integer,Queue<Double>> map = new HashMap<>();
        Map<Integer,Double> res = new HashMap<>();

        //build the heap
        for(int i = 0; i<input.size();i++){
            if(map.containsKey(input.get(i).id)){
                map.get(input.get(i).id).offer(input.get(i).score);

                if(map.get(input.get(i).id).size()>5){
                    map.get(input.get(i).id).poll();
                }
            }else{
                Queue<Double> heap = new PriorityQueue<>();
                heap.offer(input.get(i).score);
                map.put(input.get(i).id,heap);
            }
        }

        for(Integer index: map.keySet() ){
            double temp = 0;
            Queue<Double> pq = map.get(index);
            while(!pq.isEmpty()){
                temp += pq.poll();
            }

            res.put(index,temp/5.0);
        }

        return res;
    }

    //records = [[1,91],[1,92],[2,93],[2,99],
    //[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]];
    public static void main(String[] args){
        ArrayList<Record> test = new ArrayList<>();
        test.add(new Record(1,91));
        test.add(new Record(1,92));
        test.add(new Record(2,93));
        test.add(new Record(2,99));
        test.add(new Record(2,98));
        test.add(new Record(2,97));
        test.add(new Record(1,60));
        test.add(new Record(1,58));
        test.add(new Record(2,100));
        test.add(new Record(1,61));

        System.out.print(firstFiveAverage.highFive(10,test));
    }
}
