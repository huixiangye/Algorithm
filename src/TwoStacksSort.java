import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yehuixiang on 6/29/18.
 */

/*

请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
测试样例：
[1,2,3,4,5]
返回：[5,4,3,2,1]
 */
public class TwoStacksSort {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        if(numbers == null || numbers.length == 0){
            return result;
        }

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> res = new Stack<>();

        //push the array element in the temp stack
        for(int i = 0;i<numbers.length;i++){
            temp.push(numbers[i]);
        }
        //in the res stack
        while(!temp.isEmpty()){
            int num = temp.pop();
            if(res.isEmpty()){//when num is the first element
                res.push(num);
            }else{
                while(!res.isEmpty() && res.peek() >= num){//put the num in the right position
                    temp.push(res.pop());
                }

                res.push(num);
            }
        }

        while(!res.isEmpty()){
            result.add(res.pop());
        }

        return result;

    }

    public static void main(String[] args){
        TwoStacksSort test = new TwoStacksSort();
        int[] num1 = {};
        int[] num2 = {1,2,3,4,5};
        int[] num3 = {5,4,3,2,1};
        System.out.println(test.twoStacksSort(num1));
        System.out.println(test.twoStacksSort(num2));
        System.out.println(test.twoStacksSort(num3));
    }
}
