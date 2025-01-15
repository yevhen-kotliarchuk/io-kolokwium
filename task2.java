public class task2 {
    public static void main(String[] args) {

        System.out.println(myFunction(7));
        System.out.println(myFunction(20));
        System.out.println(myFunction(13));
        System.out.println(myFunction(25));
    }

    static int myFunction(int x)
    {
        int result = 0;

        if(x == 2 || x == 20) {
            result = 3 * x - 1;
        }
        if(x % 3 == 0 || x % 5 == 0) {
            result = x;
        }

        return result;
    }
}