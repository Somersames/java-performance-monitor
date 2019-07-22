package xyz.somersames;

import org.junit.Test;

public class CommonTest {

    @Test
    public void ArrayTest(){
        int[] a = new int[]{1,2,1};
        int[] b = a;
        sort(a);
        System.out.println(b[1]);
    }

    public void sort(int[] array){
        array[1] = 1;
        array[2] = 2;
    }
}
