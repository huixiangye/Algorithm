package AmasonLeetcode.OA2CODING;

import com.sun.prism.impl.Disposer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yehuixiang on 7/26/18.
 */

class Record{
    int id;
    int score;

    public Record(int id, int score){
        this.id = id;
        this.score = score;
    }

}

public class Highfive {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public static Map<Integer, Double> highFive(Record[] results) {

        //base case
        if (results == null || results.length == 0) {
            return new HashMap<>();
        }

        Map<Integer,Queue<Integer>> map = new HashMap<>();
        Map<Integer, Double> res = new HashMap<>();

        //build the heap
        for(int i = 0; i<results.length;i++){
            if(map.containsKey(results[i].id)){
                map.get(results[i].id).offer(results[i].score);
                if(map.get(results[i].id).size()>5){
                    map.get(results[i].id).poll();
                }
            }else{
                Queue<Integer> heap = new PriorityQueue<>();
                heap.offer(results[i].score);
                map.put(results[i].id,heap);
            }
        }

        for(Integer index:map.keySet()){
            int temp = 0;
            Queue<Integer> pq = map.get(index);
            while(!pq.isEmpty()){
                temp = temp + pq.poll();
            }

            res.put(index,temp/5.0);
        }

        return res;

    }

    public static void main(String[] args){
        Record[] results = new Record[12];
        results[0] = new Record(1,91);
        results[1] = new Record(1,92);
        results[2] = new Record(1,61);
        results[3] = new Record(1,0);
        results[4] = new Record(1,60);
        results[5] = new Record(1,58);

        results[6] = new Record(2,93);
        results[7] = new Record(2,99);
        results[8] = new Record(2,98);
        results[9] = new Record(2,97);
        results[10] = new Record(2,100);
        results[11] = new Record(2,0);

        //records = [[1,91],[1,92],[2,93],[2,99],
        //            [2,98],[2,97],[1,60],[1,58],[2,100],[1,61]];
        System.out.print(Highfive.highFive(results));
    }
}
