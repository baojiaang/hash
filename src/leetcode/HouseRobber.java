package leetcode;

public class HouseRobber {
    public int rob(int[] num){
        int rob=0;//  max money if rob this house
        int notrob=0;// max monty if do not rob this house
        for(int i=0;i<num.length;i++){
            int currob=notrob+num[i];
            notrob=Math.max(rob,notrob);
            rob=currob;
        }
        return Math.max(rob,notrob);
    }
}
