package cn.com.artd.tools;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DictComparator implements Comparator<Map<String, Object>> {
	public static final int ASC = 1;
	public static final int DESC = -1;

	public static final String FIELD = "field";
	public static final String MOVETOP = "movetop";
	public static final String DIRECTION = "direction";

	private ArrayList<HashMap<String, Object>> SORTBY = null;

	public DictComparator(ArrayList<HashMap<String, Object>> r) {
		this.SORTBY = r;
	}

	@Override
	public int compare(Map<String, Object> o1, Map<String, Object> o2) {
		// TODO Auto-generated method stub
		int c = 0;
		for (HashMap<String, Object> i : this.SORTBY)
			if ((c = this.compareField(o1, o2,
					(String) i.get(DictComparator.FIELD),
					(HashSet<Object>) i.get(DictComparator.MOVETOP),
					(Integer) i.get(DictComparator.DIRECTION))) != 0)
				return c;
		Set<String> fields = new HashSet<String>();
		for (String k : o1.keySet())
			fields.add(k);
		for (String k : o2.keySet())
			fields.add(k);
		ArrayList<String> fieldslist = new ArrayList<String>();
		for (String k : fieldslist)
			fieldslist.add(k);
		String[] fieldsarray = new String[fieldslist.size()];
		for (int i = 0; i < fieldsarray.length; ++i)
			fieldsarray[i] = fieldslist.get(i);
		Arrays.sort(fieldsarray);
		for (String i : fields)
			if ((c = compareItem(o1.get(i), o2.get(i))) != 0)
				return c;
		return 0;
	}

	public int compareField(Map<String, Object> o1, Map<String, Object> o2,
			String field, HashSet<Object> movetop, int direction) {
		Object v1 = null, v2 = null;
		try {
			v1 = o1.get(field);
		} catch (Exception e) {
			v1 = null;
		}
		try {
			v2 = o2.get(field);
		} catch (Exception e) {
			v2 = null;
		}
		if (v1 == null) {
			if (v2 == null) {
				return 0;
			} else {
				return (direction > 0) ? (-1) : (direction < 0 ? 1 : 0);
			}
		}
		if (v2 == null) {
			return (direction > 0) ? (1) : (direction < 0 ? -1 : 0);
		}
		if (movetop != null && movetop.size() > 0) {
			if (movetop.contains(v1)) {
				if (movetop.contains(v2)) {
					return compareItem(v1, v2) * direction;
				} else {
					return ((direction > 0) ? (-1) : (direction < 0 ? 1 : 0))
							* direction;
				}
			}
			if (movetop.contains(v2)) {
				return ((direction > 0) ? (1) : (direction < 0 ? -1 : 0))
						* direction;
			}
		}
		return compareItem(v1, v2) * direction;
	}

	public int compareItem(Object v1, Object v2) {
		if (v1 instanceof Byte) {
			Byte v11 = (Byte) v1, v22 = (Byte) v2;
			return v11 == v22 ? 0 : (v11 > v22 ? 1 : -1);
		}
		if (v1 instanceof Short) {
			Short v11 = (Short) v1, v22 = (Short) v2;
			return v11 == v22 ? 0 : (v11 > v22 ? 1 : -1);
		}
		if (v1 instanceof Integer) {
			Integer v11 = (Integer) v1, v22 = (Integer) v2;
			return v11 == v22 ? 0 : (v11 > v22 ? 1 : -1);
		}
		if (v1 instanceof Long) {
			Long v11 = (Long) v1, v22 = (Long) v2;
			return v11 == v22 ? 0 : (v11 > v22 ? 1 : -1);
		}
		if (v1 instanceof Float) {
			Float v11 = (Float) v1, v22 = (Float) v2;
			return v11 == v22 ? 0 : (v11 > v22 ? 1 : -1);
		}
		if (v1 instanceof Double) {
			Double v11 = (Double) v1, v22 = (Double) v2;
			return v11 == v22 ? 0 : (v11 > v22 ? 1 : -1);
		}
		if (v1 instanceof Character) {
			Character v11 = (Character) v1, v22 = (Character) v2;
			return v11 == v22 ? 0 : (v11 > v22 ? 1 : -1);
		}
		if (v1 instanceof String) {
			String v11 = (String) v1, v22 = (String) v2;
			return v11.compareTo(v22);
		}
		return 0;
	}

}
