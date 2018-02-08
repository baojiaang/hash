package lintcode;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        /*
                    可以看出，其实只有两种方式来递推，一种是选取s1的字符作为s3新加进来的字符，另一种是选s2的字符作为新进字符。
                    而要看看能不能选取，就是判断s1(s2)的第i(j)个字符是否与s3的i+j个字符相等。
                    如果可以选取并且对应的res[i-1][j](res[i][j-1])也为真，就说明s3的i+j个字符可以被表示。
                    这两种情况只要有一种成立，就说明res[i][j]为真，是一个或的关系。 ==优先级高于&&
                */
        if (s3 == null || (s1 == null && s2 == null) || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean path[][]=new boolean[s1.length()+1][s2.length()+1];
        path[0][0]=true;
        for(int i=1;i<=s1.length();i++){
            path[i][0]=path[i-1][0]&&(s3.charAt(i-1)==s1.charAt(i-1));
        }
        for(int j=1;j<=s2.length();j++){
            path[0][j]=path[0][j-1]&&(s3.charAt(j-1)==s2.charAt(j-1));
        }
        for(int i=1;i<=s1.length();i++){
            for (int j=1;j<=s2.length();j++){
                path[i][j]=(path[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1))||
                        (path[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1));
            }
        }
            return path[s1.length()][s2.length()];
    }
}
