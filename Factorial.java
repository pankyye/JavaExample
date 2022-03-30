public class Factorial {
    public static long factorial(long n){
        if (n < 0){
            throw new RuntimeException("underflow error in factorial");
        }else if( n>20){
            throw new RuntimeException("overflow error in factorial");
        }else if (n==1){
            return 1;
        }else {
            return n * factorial(n-1);
        }
    }
    public static void main(String[] args){
        long n = 7;
        System.out.println("The factorial number is:"+factorial(n));
    }
}

