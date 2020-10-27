public class Main {


    public static void main(String[] args) {
        System.out.println(Main.test());
    }

    static int test(){


        int x = 1 ;
        try{
            return x ;
        }finally {
            System.out.println("finally");
            ++x ;
        }
    }
   }
