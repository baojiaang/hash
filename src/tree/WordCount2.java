package tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		long startTime=System.currentTimeMillis();
		@SuppressWarnings("resource")

		BufferedReader buffer=new BufferedReader(new FileReader("d://conversation.txt"));//读取文件
		StringBuffer sb=new StringBuffer();
		String str=null;
		while((str=buffer.readLine())!=null){
			sb.append(str);
		}

		buffer.close();
		Pattern pattern=Pattern.compile("\\w+");//  正则表达式 进行匹配
		Matcher matcher=pattern.matcher(sb.toString());
		Map<String,Integer> map=new HashMap<String,Integer>();
		String word="";
		int count;
		while(matcher.find()){
			word=matcher.group();//返回由以前匹配操作所匹配的输入子序列
			//System.out.println("sr="+word);
			if(map.containsKey(word)){//如果map中含有这个单词
				count=map.get(word);//从map中读出现在有多少个
				map.put(word, count+1);//count再加1
			}else{
				map.put(word, 1);//如果map中没有这个单词 那么count为1
			}
		}
		List<Map.Entry<String,Integer>> list=new ArrayList<Map.Entry<String,Integer>>(map.entrySet());//将map装入list中方便排序
		Collections.sort(list,new MyComparable());//进行排序

		for(int i=0;i<10;i++) {//打印次数最多的前10个word
			System.out.println("key="+list.get(i).getKey()+"        value="+list.get(i).getValue());
		}
		long endTime=System.currentTimeMillis();
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

	}
}
class MyComparable implements Comparator<Map.Entry<String,Integer>>{

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {//重写了compare方法
		// TODO Auto-generated method stub
		return o2.getValue().compareTo(o1.getValue());//将o2与o1换位 降序排列
	}



}
