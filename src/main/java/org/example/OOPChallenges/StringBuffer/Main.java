package org.example.OOPChallenges.StringBuffer;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n");
        removeCharWithStringBuffer("HelloDarlingDrl l");
    }


    public static void removeCharWithStringBuffer(String p1){
        StringBuffer sb = new StringBuffer(p1);
        sb.deleteCharAt(1);
        sb.delete(4,8);

        System.out.println(sb.toString());

    }
}
