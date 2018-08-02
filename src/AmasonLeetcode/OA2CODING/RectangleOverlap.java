package AmasonLeetcode.OA2CODING;

/**
 * Created by yehuixiang on 7/27/18.
 *
 * Rectangular Overlap
 */
class Node{

    int x;
    int y;

    Node(int x ,int y){
        this.x = x;
        this.y = y;
    }
}

public class RectangleOverlap {

    public static boolean hasOverlap(Node A, Node B, Node C, Node D){
        //第一个正方形
        int bottomleft1_x = Math.min(A.x, B.x);
        int bottomleft1_y = Math.min(A.y, B.y);
        int topright1_x = Math.max(A.x, B.x);
        int topright1_y = Math.max(A.y, B.y);

        //第二个正方形
        int bottomleft2_x = Math.min(C.x, D.x);
        int bottomleft2_y = Math.min(C.y, D.y);
        int topright2_x = Math.max(C.x, D.x);
        int topright2_y = Math.max(C.y, D.y);

        //判断是否重叠
                //在2的右边方
        if(bottomleft1_x >= topright2_x
                // 在2的左边
                ||topright1_x <= bottomleft2_x
                // 在2的上边
                || bottomleft1_y >= topright2_y
                // 在2的下边
                ||  topright1_y<=bottomleft2_y )
            //只要我第一个正方形的最右边的x比第二个的最左边x还要小,说明在左边
            //我第一个正方形的最左边边的x比第二个的最右边x还要大,说明在右边
            //上边下边一样,这样就是不会相交的所以return false
            return false;

        //其他情况我就当他是相交的
        return true;
    }

    public static void main(String[] args){

        Node A = new Node(0, 0), B = new Node(2, 2),
                C = new Node(1, 0), D = new Node(4, 4);

        System.out.println(hasOverlap(A, B, C, D));
    }
}


