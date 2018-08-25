package pat;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateaa {
    public static void main(String[] args) {
        Date d=new Date();
        Timestamp t=new Timestamp(d.getTime());
        System.out.println(t.getTime());
        System.out.println(d.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(d);
        System.out.println(dateStr);
        String[] get=p(7);
        for (String a:get
             ) {
            System.out.println(a);
        }
        System.out.println(get());
        Integer a=5;

    }

    public static String[] p(int m){
        String []t=new String[m];
      //  StringBuffer sb=new StringBuffer();
        String in=""+new String();
        for(int i=0;i<t.length;i++){
            t[i]=in;
            in="0"+new String(in);

        }
        return t;
    }
    public static int get(){
        String []a={"1","0"};
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<a.length;i++){
                sb.append(a[i]);
        }
        int result= Integer.parseInt(sb.toString());
        return  result;
    }
}
