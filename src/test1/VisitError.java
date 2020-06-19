package test1;

import java.util.ArrayList;
import java.util.List;

public class VisitError {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		//correct
		for(int i = 0;i<strList.size();i++){
			System.out.println(strList.get(i));
		}
		//throw Exception
		for(String str:strList){
			System.out.println(str);
			if("2".equals(str) )			{
				strList.remove("2");
			}
		}
		//Error
		for(int i = 0;i<strList.size();i++){
			System.out.println(strList.get(i));
			if("2".equals(strList.get(i)) )			{
				strList.remove("2");
			}
		}
	}
}
