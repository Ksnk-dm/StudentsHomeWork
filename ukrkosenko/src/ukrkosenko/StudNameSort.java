package ukrkosenko;

import java.util.Comparator;

public class StudNameSort implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		Student st1 = o1;
		Student st2 = o2;

		String name1 = st1.getName();
		String name2 = st2.getName();

		if (name1.compareTo(name2) > 0) {
			return 1;
		}
		if (name1.compareTo(name2) < 0) {
			return -1;
		}
		return 0;
	}
}
