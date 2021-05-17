package roy.java.utilities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        sorting.sortArrays();
    }
    /*Shorting array */

    void sortArrays(){
        Integer[] intArr = new Integer[]{100,2,4,1,8,10,-3,0};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

    }


}
