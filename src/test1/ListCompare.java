package test1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListCompare {

	static void testAddatTail(List list, String type) {
		int size = 1000000;

		long start = System.currentTimeMillis();

		for (int i = 0; i < size; i++) {
			list.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("testAddatTail for " + type);
		System.out.println(end - start);
	}

	static void testRandomSearch(List list, String type) {
		Random rand = new Random();

		long start = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			list.indexOf(rand.nextInt(100000));
		}
		long end = System.currentTimeMillis();
		System.out.println("testRandomSearch for " + type);
		System.out.println(end - start);
	}

	static void testAddatRandom(List list, String type) {
		Random rand = new Random();

		long start = System.currentTimeMillis();

		for (int i = 0; i < 1000; i++) {
			list.add(rand.nextInt(100000), "0");
		}
		long end = System.currentTimeMillis();
		System.out.println("testAddatRandom for " + type);
		System.out.println(end - start);
	}

	public static void main(String[] args) {

		List arrayList = new ArrayList();
		List linkedList = new LinkedList();

		testAddatTail(arrayList, "ArrayList");
		testAddatTail(linkedList, "LinketList");

		testRandomSearch(arrayList, "ArrayList");
		testRandomSearch(linkedList, "LinketList");

		testAddatRandom(arrayList, "ArrayList");
		testAddatRandom(linkedList, "LinketList");

	}

}
