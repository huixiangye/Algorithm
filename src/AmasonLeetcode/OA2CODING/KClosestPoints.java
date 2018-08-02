package AmasonLeetcode.OA2CODING;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yehuixiang on 7/27/18.
 * 这题我觉得意思是选一个点作为original点然后看数组中找出k个离这个点最近的点
 */
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}


public class KClosestPoints {
    private static double distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static Point[] closestPoint(Point[] array, final Point origin, int k) {
        if(k > array.length) return array;
        Point[] res = new Point[k];
        Arrays.sort(array, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                //小到大
                return Double.compare(distance(a, origin), distance(b, origin));
            }

        });
        for(int i = 0; i < k; i++) res[i] = array[i];
        return res;
    }


    public static Point[] closestPoint2(Point[] array, final Point origin, int k){
        if(k > array.length) return array;
        Point[] res = new Point[k];
        PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>(){
            @Override
            public int compare(Point a, Point b) {
                //大到小顺序
                return -Double.compare(distance(a, origin), distance(b, origin));
            }
        });
        for(Point p: array) queue.offer(p);
        while(queue.size() > k) queue.poll();
        for(int i = 0; i < k; i++) res[k - 1 - i] = queue.poll();
        return res;
    }

    public static void main(String[] args){
        Point[] arr = new Point[5];
        Point origin = new Point(0,0);
        arr[0] = new Point(1,1);
        arr[1] = new Point(2,2);
        arr[2] = new Point(3,3);
        arr[3] = new Point(4,4);
        arr[4] = new Point(5,5);

        System.out.print(Arrays.toString(KClosestPoints.closestPoint(arr,origin,2)));
        System.out.println();
        System.out.print(Arrays.toString(KClosestPoints.closestPoint2(arr,origin,2)));
    }

}
