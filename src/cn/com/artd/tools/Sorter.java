package cn.com.artd.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Sorter{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> r = new ArrayList<Map<String, Object>>();
		ArrayList<HashMap<String, Object>> sortby = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> s = null;
		
		s = new HashMap<String, Object>();
		s.put(DictComparator.FIELD, "E");
		HashSet<Object> h = new HashSet<Object>(); h.add('b');h.add('d');
		s.put(DictComparator.MOVETOP, h);
		s.put(DictComparator.DIRECTION, DictComparator.DESC);
		sortby.add(s);
		
		s = new HashMap<String, Object>();
		s.put(DictComparator.FIELD, "D");
		HashSet<Object> h2 = new HashSet<Object>(); h2.add(77);h2.add(4);
		s.put(DictComparator.MOVETOP, h2);
		s.put(DictComparator.DIRECTION, DictComparator.ASC);
		sortby.add(s);
		
		s = new HashMap<String, Object>();
		s.put(DictComparator.FIELD, "x");
		HashSet<Object> h3 = new HashSet<Object>(); h3.add("Messi");
		s.put(DictComparator.MOVETOP, h3);
		s.put(DictComparator.DIRECTION, DictComparator.ASC);
		sortby.add(s);
		
		System.out.println("Sort By:");
		for(HashMap<String, Object> i : sortby) {
			System.out.println(i);
		}
		System.out.println();
		
		Map<String, Object> t = null;
		
		t = new HashMap<String, Object>();
		t.put("A", "Rock");
		t.put("B", "Kobe");
		t.put("C", 77);
		t.put("D", 4.099);
		t.put("E", 'a');
		t.put("F", "Evil");
		t.put("G", 100);
		r.add(t);
		
		t = new HashMap<String, Object>();
		t.put("A", "Rock");
		t.put("B", "Messi");
		t.put("C", 77);
		t.put("D", 8.34);
		t.put("E", 'b');
		t.put("F", "Evil");
		t.put("G", 100);
		r.add(t);
		
		t = new HashMap<String, Object>();
		t.put("A", "Rock");
		t.put("B", "Rose");
		t.put("C", 77);
		t.put("D", 4.099);
		t.put("E", 'c');
		t.put("F", "Pool");
		t.put("G", 1235);
		r.add(t);
		
		t = new HashMap<String, Object>();
		t.put("A", "Rock");
		t.put("B", "NB");
		t.put("C", 77);
		t.put("D", 6.1);
		t.put("E", 'd');
		t.put("F", "QQ");
		t.put("G", 56);
		r.add(t);
		
		t = new HashMap<String, Object>();
		t.put("A", "Rock");
		t.put("B", "NB");
		t.put("C", 77);
		t.put("D", 6.1);
		t.put("E", 'e');
		t.put("F", "QQ");
		t.put("G", 56);
		r.add(t);
		
		
		t = new HashMap<String, Object>();
		t.put("A", "Rock");
		t.put("B", "NB");
		t.put("C", 77);
		t.put("D", 6.1);
		t.put("E", 'b');
		t.put("F", "QQ");
		t.put("G", 56);
		r.add(t);
		
		t = new HashMap<String, Object>();
		t.put("A", "Rock");
		t.put("B", "NB");
		t.put("C", 77);
		t.put("D", 6.1);
		t.put("E", 'd');
		t.put("F", "QQ");
		t.put("G", 56);
		r.add(t);
		
		
		System.out.println("Before:");
		for (Map<String, Object> kv : r) {
			System.out.println(kv);
		}
		System.out.println();
		Collections.sort(r, new DictComparator(sortby));	
		System.out.println("After:");
		for (Map<String, Object> kv : r) {
			System.out.println(kv);
		}
	}
}
