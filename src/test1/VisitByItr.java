package test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitByItr {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		Iterator<String> it = strList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		it = strList.iterator();
		while(it.hasNext()){
			String str=it.next();
			System.out.println(str);
			if("2".equals(str)) {
				//strList.remove(str);//throw exception
				it.remove(); //correct
			}
		}
	}
}
