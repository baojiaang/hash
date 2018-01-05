

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Stack;

public class Check {

	public static void main(String[] args) throws IOException {
		ArrayList a=new ArrayList();
		Stack<String> s = new Stack<String>();
		File file= new File( "d:/test.txt");
		Reader reader = null;
		reader = new InputStreamReader(new FileInputStream(file));
		int tempchar;
		while (true) {
			tempchar=reader.read();
			String str=String.valueOf((char)tempchar);
			//  System.out.println(str);
			if(str.equals("{")||str.equals("(")||str.equals("["))
			{
				s.push(str);//插入前括号
			}
			else if(str.equals("}")||str.equals(")")||str.equals("]"))
			{
				if(s.isEmpty())
				{	System.out.println("wrong");
					break;
				}
				else
				{
					String str1=s.pop();
					if(matching(str1,str))
						continue;
					else {System.out.println("wrong");
						break;}
				}
			}
			if(tempchar==-1)
			{ if(s.isEmpty())
			{ System.out.println("right");
				break;}

			else
			{ System.out.println("wrong");
				break;}

			}
		}
		reader.close();


	}
	static boolean matching(String a,String b) {
		if(a.equals("{")&&b.equals("}"))
			return true;
		else if(a.equals("[")&&b.equals("]"))
			return true;
		else if(a.equals("(")&&b.equals(")"))
			return true;
		else
			return false;
	}

}
