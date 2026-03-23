package org.example.W3Schools.LamdasW3Schools.LamdE1;

public class Main {
    public static void main(String[] args) {
        SumCacl sum = (x,y)-> x+y;
        System.out.println(sum.sum(7, 6));

        SumCacl sumFromMethod = sumInts(7,8);
        System.out.println(sumFromMethod.sum(0,0));
    }

    private static SumCacl sumInts(int a, int b){

        return (x,n) -> a + b;
    }
}
