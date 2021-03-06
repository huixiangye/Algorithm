package 网易OA真题;

import java.util.Scanner;

/**
 * Created by yehuixiang on 9/6/18.
 * 又到了周末，小易的房间乱得一团糟。
 他希望将地上的杂物稍微整理下，使每团杂物看起来都紧凑一些，没有那么乱。
 地上一共有n团杂物，每团杂物都包含4个物品。第i物品的坐标用(ai,bi)表示，小易每次都可以将它绕着(xi,yi)逆时针旋转，这将消耗他的一次移动次数。如果一团杂物的4个点构成了一个面积不为0的正方形，我们说它是紧凑的。
 因为小易很懒，所以他希望你帮助他计算一下每团杂物最少需要多少步移动能使它变得紧凑。

 输入描述:
 第一行一个数n(1 <= n <= 100)，表示杂物的团数。
 接下来4n行，每4行表示一团杂物，每行4个数ai, bi，xi, yi, (-104 <= xi, yi, ai, bi <= 104)，表示第i个物品旋转的它本身的坐标和中心点坐标。


 输出描述:
 n行，每行1个数，表示最少移动次数。

 输入例子1:
 4
 1 1 0 0
 -1 1 0 0
 -1 1 0 0
 1 -1 0 0
 1 1 0 0
 -2 1 0 0
 -1 1 0 0
 1 -1 0 0
 1 1 0 0
 -1 1 0 0
 -1 1 0 0
 -1 1 0 0
 2 2 0 1
 -1 0 0 -2
 3 0 0 -2
 -1 1 -2 0

 输出例子1:
 1
 -1
 3
 3

 例子说明1:
 对于第一团杂物，我们可以旋转第二个或者第三个物品1次。
 */
public class 整理房间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[4][4];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    nums[j][k] = sc.nextInt();
                }
            }
            int result = findMinMoveTimes(nums);
            if (result == Integer.MAX_VALUE)
                result = -1;
            System.out.println(result);
        }
    }

    private static int findMinMoveTimes(int[][] nums) {
        int i = 0;
        int j = 0;
        int k = 0;
        int z = 0;
        int minTimes = Integer.MAX_VALUE;
        boolean flag = false;
        for (i = 0; i < 4; i++){
            if (flag){
                rotate(nums, 0);
            }
            for (j = 0; j < 4; j++){
                if (flag){
                    rotate(nums, 1);
                }
                for (k = 0; k < 4; k++){
                    if (flag){
                        rotate(nums, 2);
                    }
                    for (z = 0; z < 4; z++){
                        if (flag){
                            rotate(nums, 3);
                        }else {
                            flag = true;
                        }
                        if (isSquare(nums[0], nums[1], nums[2], nums[3])){
                            int times = i + j + k + z;
                            if (times < minTimes){
                                minTimes = times;
                            }
                        }
                    }

                }
            }
        }
        return minTimes;
    }

    private static void rotate(int[][] nums, int index) {
        int[] num = nums[index];
        int oldx = num[0];
        int oldy = num[1];
        int centerx = num[2];
        int centery = num[3];
        nums[index][0] = centerx + centery - oldy;
        nums[index][1] = centery - centerx + oldx;
    }

    private static boolean isSquare(int[] neePoint1, int[] neePoint2, int[] neePoint3, int[] neePoint4){
        long[] dis = new long[6];
        dis[0] = dis(neePoint1, neePoint2);
        dis[1] = dis(neePoint1, neePoint3);
        dis[2] = dis(neePoint1, neePoint4);
        dis[3] = dis(neePoint2, neePoint3);
        dis[4] = dis(neePoint2, neePoint4);
        dis[5] = dis(neePoint3, neePoint4);
        int count = 0;
        long minDis = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++){
            if (dis[i] < minDis){
                minDis = dis[i];
            }
        }
        for (int i = 0; i < 6; i++){
            if (dis[i] == minDis){
                count++;
            }
        }
        return count == 4;
    }

    private static long dis(int[] neePoint1, int[] neePoint2) {
        long x = neePoint1[0] - neePoint2[0];
        long y = neePoint1[1] - neePoint2[1];
        return (x * x + y * y);
    }


}
