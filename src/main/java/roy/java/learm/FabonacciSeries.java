package roy.java.learm;

public class FabonacciSeries {

    public static void main(String[] args) {
        int N =10;
        int value=0;
        for(int i =0;i<N;i++) {
            int result = fab(i);
            if  (value != result || value ==0) {
                System.out.println(result);
                value = result;
            }
        }
    }


    static int  fab(int N){
        if(N<=1){
            return N;
        }else{
            return fab(N-1)+fab(N-2);
        }
    }
}
