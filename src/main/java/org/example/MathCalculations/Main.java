package org.example.MathCalculations;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Main {
    //https://www.geeksforgeeks.org/java/bigdecimal-class-java/
    public static void main(String[] args) {
        leibnizPI();
        System.out.println("-".repeat(500));
        nilakanthaPI();
        System.out.println("-".repeat(500));
        baselTypeIdentity();
        System.out.println("-".repeat(500));
        ramanujan();
        System.out.println("-".repeat(500));
        machinSeries();
    }

    public static void leibnizPI(){
        MathContext precisionDigits = new MathContext(20); //https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/MathContext.html
        BigDecimal pi = BigDecimal.ZERO;
        BigDecimal four = new BigDecimal("4");

        long iterations = 10000000;

        long startT = System.currentTimeMillis();

        for(long n = 0; n < iterations; n++){
            BigDecimal num = new BigDecimal((n%2==0) ? 1 : -1); //(-1) ^ 2
            BigDecimal d = new BigDecimal(2 * n + 1); //2*n + 1
            BigDecimal temp = num.divide(d,precisionDigits);
            pi = pi.add(temp);

        }
        pi = pi.multiply(four, precisionDigits);
        long endT = System.currentTimeMillis();
        System.out.println("Leibniz PI: " + pi);
        System.out.println("Time spent: " + (endT - startT) + " ms ");
    }

    public static void nilakanthaPI(){
        MathContext mathContext = new MathContext(20);
        BigDecimal pi = BigDecimal.ZERO;

        BigDecimal three = new BigDecimal("3");
        BigDecimal four = new BigDecimal("4");

        long iterations = 10000000;

        long startT = System.currentTimeMillis();

        for(long n = 1; n < iterations; n++){
            BigDecimal num = new BigDecimal((n%2!=0) ? 1 : -1); //(-1) ^ 2
            BigDecimal d = new BigDecimal((2 * n) * (2*n + 1) * (2*n + 2)); //2*n + 1
            BigDecimal temp = num.divide(d,mathContext);
            pi = pi.add(temp);

        }
        pi = three.add(four.multiply(pi, mathContext));
        long endT = System.currentTimeMillis();
        System.out.println("nilakantha PI: " + pi);
        System.out.println("Time spent: " + (endT - startT) + " ms ");


    }
    public static void baselTypeIdentity(){
        MathContext mC = new MathContext(20);
        BigDecimal pi = BigDecimal.ZERO;
        long iterations = 10000000;
        long startT = System.currentTimeMillis();
        for(long n = 1; n < iterations; n++){
            BigDecimal num = BigDecimal.valueOf(n);
            BigDecimal nSq = num.multiply(num,mC);

            BigDecimal temp = BigDecimal.ONE.divide(nSq,mC);

            pi = pi.add(temp,mC);
        }

        BigDecimal piSq = pi.multiply(new BigDecimal("6"),mC);
        BigDecimal piSquared = piSq.sqrt(mC);
        long endT = System.currentTimeMillis();
        System.out.println("baselTypeIdentity PI: " + piSquared);
        System.out.println("Time spent: " + (endT - startT) + " ms ");
    }

    public static void ramanujan(){
        MathContext mc = new MathContext(20);
        BigDecimal pi = BigDecimal.ZERO;
        BigDecimal sqrt = new BigDecimal("2").sqrt(mc);
        BigDecimal cp = new BigDecimal("2").multiply(sqrt).divide(new BigDecimal("9801"),mc);
        //
        long iterations = 1000;
        long startT = System.currentTimeMillis();
        for(long n = 0; n < iterations; n++){
            BigInteger facto4 = factorialN((int)(4 * n));
            BigDecimal term1 = new BigDecimal(facto4);
            BigDecimal term2 = new BigDecimal(1103).add(new BigDecimal(26390).multiply(new BigDecimal(n)));
            BigDecimal nu = term1.multiply(term2, mc);

            // Παρονομαστης: (n!)^4 * 396^(4n)
            BigInteger factN = factorialN((int) n);
            BigDecimal factN4 = new BigDecimal(factN).pow(4,mc);
            int n4times = (int) (4 * n);
            BigDecimal pow396 = new BigDecimal(396).pow(n4times, mc);
            BigDecimal denominator = factN4.multiply(pow396, mc);
            BigDecimal term = nu.divide(denominator, mc);
            pi = pi.add(term,mc);
        }

        BigDecimal oneDivPi = cp.multiply(pi,mc);
        pi = BigDecimal.ONE.divide(oneDivPi,mc);

        long endT = System.currentTimeMillis();
        System.out.println("ramanujan PI: " + pi);
        System.out.println("Time spent: " + (endT - startT) + " ms ");
    }

    public static BigInteger factorialN(int num){
        if (num <= 1) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(num).multiply(factorialN(num - 1));
    }

    public static void machinSeries(){ //https://stackoverflow.com/questions/75202004/how-to-implement-arctan-function-in-java
        MathContext mc = new MathContext(25);
        long startT = System.currentTimeMillis();

        BigDecimal oneFifth = BigDecimal.ONE.divide(new BigDecimal("5"), mc);
        BigDecimal oneOver239 = BigDecimal.ONE.divide(new BigDecimal("239"), mc);

        // π = 16 * arctan(1/5) - 4 * arctan(1/239)
        BigDecimal term1 = new BigDecimal("16").multiply(arctan(oneFifth, mc), mc);
        BigDecimal term2 = new BigDecimal("4").multiply(arctan(oneOver239, mc), mc);
        BigDecimal pi = term1.subtract(term2, mc);

        long endT = System.currentTimeMillis();

        // Μετατροπή σε ms
        double timeTakenMs = (endT - startT) / 1000000.0;
        System.out.println("Calculated PI machinSeries: " + pi);
        System.out.println("Time spent: " + timeTakenMs + " ms");

    }



    public static BigDecimal arctan(BigDecimal x, MathContext mc) { //την πηρα απο εδω //https://stackoverflow.com/questions/75202004/how-to-implement-arctan-function-in-java απλα μετετρεψα σε BigDecimal
        BigDecimal sum = BigDecimal.ZERO;
        for (int k = 0; k < 100; k++) {
            BigDecimal sign = new BigDecimal((k % 2 == 0) ? 1 : -1);

            BigDecimal power = x.pow(2 * k + 1, mc);

            BigDecimal divisor = new BigDecimal(2 * k + 1);

            BigDecimal term = sign.multiply(power, mc).divide(divisor, mc);

            sum = sum.add(term, mc);
        }
        return sum;
    }
}
