//需求：汉诺塔移盘子问题。有3根柱子A、B、C，在A上从下往上按照从小到大的顺序放着64个圆盘，以B为中介，把盘子全部移动到C上。在移动过程中，要求任意盘子的下面要么没有盘子，要么只能有
//比它大的盘子。

/**解法：
 为了将第N个盘子从A移到C，需要先将第N个盘子上面的N-1个盘子移动到B上；
 为了将第N-1个盘子从B移动到C上，需要将N-2个盘子移动到A上；
 通过递归函数实现，最少移动次数为2^n-1
*/

public class HanoiTower {
    public static void moveDish(int level, char from, char inter, char to){
        if(level ==1){
            System.out.println("从"+from+"移动盘子1号到"+to);
        }else {
            moveDish(level -1,from,to,inter);
            System.out.println("从"+from+"移动盘子"+level+"号到"+to);
            moveDish(level-1,inter,from,to);
        }
    }
    public static void main(String[] args){
        int nDisks = 3;
        moveDish(nDisks,'A','B','C');
    }
}
