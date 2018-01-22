package lintcode;

public class RoteString {
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(offset==0){
            ;
        }
        else{
          String str1=String.valueOf(str);
          String temp=str1.substring(str1.length()-offset,str1.length());
          String temp2=str1.substring(0,str1.length()-offset);
            System.out.println(temp);

            System.out.println(temp2);
          for(int i=0;i<temp.length();i++){
              str[i]=temp.charAt(i);
          }
          for(int j=temp.length(),i=0;i<temp2.length();i++,j++){
              str[j]=temp2.charAt(i);
          }
        }
        System.out.println(str);
    }


    public static void main(String[] args) {
        RoteString r=new RoteString();
        char[] str={'a','b','c','d','e','f','g'};
        r.rotateString(str,2);
    }
}
