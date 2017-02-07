package me.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class testConstant {
	
	private List<String> list1 = new ArrayList<String>();
	private List<String> list2 = new ArrayList<String>();
	
	@Test
	public void testConstantProcess() {
		list1.add("111");
		list1.add("222");
		list1.add("333");
		list2 = list1;
		processList(list1);
		System.out.println("list 1 value ============");
		try(Stream<String> stream = list1.stream()) {
			stream.forEach(System.out::println);
		}
		System.out.println("list 2 value ===========");
		try(Stream<String> stream = list2.stream()) {
			stream.forEach(System.out::println);
		}
		System.out.println("null boolean : " + "string".equals(null));
	}
	
	private void processList(List<String> list) {
		// list.remove(0);
		Iterator<String> it = list.iterator();
		boolean a = true; 
		while(it.hasNext()){
			it.next();
			if(a) {
				it.remove();
				break;
			}
		}
		list1 = list;
	}

}
