package lintcode;
//question:Write a function that add two numbers A and B. You should not use + or any arithmetic operators.
public class aPlusB {
    public static void main(String[] args) {
        System.out.println(aPlusB(1,3));

    }
    static int aPlusB(int a,int b){
        if((a&b)==0){
            return a|b;
        }
        return aPlusB(a^b,(a&b)<<1);
    }
}
