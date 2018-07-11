package acm;

import java.util.HashMap;
import java.util.Scanner;

public class AnEasyProblem {
    public static void main(String[] args) {
        HashMap<String,Integer> h=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        h.put("A",1);
        h.put("a",-1);
        h.put("B",2);
        h.put("b",-2);
        h.put("C",3);
        h.put("c",-3);
        h.put("D",4);
        h.put("d",-4);
        h.put("E",5);
        h.put("e",-5);
        h.put("F",6);
        h.put("f",-6);
        h.put("G",7);
        h.put("g",-7);
        h.put("H",8);
        h.put("h",-8);
        h.put("I",9);
        h.put("i",-9);
        h.put("J",10);
        h.put("j",-10);
        h.put("K",11);
        h.put("k",-11);
        h.put("L",12);
        h.put("l",-12);
        h.put("M",13);
        h.put("m",-13);
        h.put("N",14);
        h.put("n",-14);
        h.put("O",15);
        h.put("o",-15);
        h.put("P",16);
        h.put("p",-16);
        h.put("Q",17);
        h.put("q",-17);
        h.put("R",18);
        h.put("r",-18);
        h.put("S",19);
        h.put("s",-19);
        h.put("T",20);
        h.put("t",-20);
        h.put("U",21);
        h.put("u",-21);
        h.put("V",22);
        h.put("v",-22);
        h.put("W",23);
        h.put("w",-23);
        h.put("X",24);
        h.put("x",-24);
        h.put("Y",25);
        h.put("Z",26);
        h.put("z",-26);
        int count=sc.nextInt();
        for(int i=0;i<count;i++){
            String s=sc.next();
            int temp=sc.nextInt();
            int sum=h.get(s)+temp;
            System.out.println(sum);
        }
    }
}
