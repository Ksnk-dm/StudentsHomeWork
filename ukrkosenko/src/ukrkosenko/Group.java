package ukrkosenko;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Group implements Voencom, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> stud = new ArrayList<Student>();

	public Group(List<Student> stud) {
		super();
		this.stud = stud;
	}

	public Group() {
		super();
	}

	public List<Student> getStud() {
		return stud;
	}

	public void setStud(List<Student> stud) {
		this.stud = stud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stud == null) ? 0 : stud.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (stud == null) {
			if (other.stud != null)
				return false;
		} else if (!stud.equals(other.stud))
			return false;
		return true;
	}

	public void addArray(Student st) throws MyException {
		if (stud.size() == 10) {
			throw new MyException();
		}
		stud.add(st);
		System.out.println("Студент " + st + " Добавлен");
		Interface.menu();

	}

	public void delArray(int id) {

		for (int i = 0; i < this.getStud().size(); i++) {

			if (stud.get(i).getId() == id) {
				stud.remove(i);
				System.out.println("Студент  " + id + " удален");

			}

		}
	}

	public Student searh(String surname) {
		for (int i = 0; i < stud.size(); i++) {
			if (stud.get(i) != null) {
				if (stud.get(i).getSurname().equals(surname)) {
					return stud.get(i);

				}

			}
		}
		return null;

	}

	@Override
	public String toString() {
		return "Group [stud=" + stud + "]";
	}

	public String allStudentArr() {
		String all = " ";

		for (int i = 0; i < stud.size(); i++) {
			if (stud.get(i) != null) {
				all += stud.get(i);
			}
		}
		return all;
	}

	public void createStudent() throws MyException {
		Student st = new Student();
		Interface.name(st);
		Interface.surname(st);
		Interface.age(st);
		Interface.gender(st);
		Interface.id(st);
		Interface.faculty(st);
		Interface.numberGroup(st);
		addArray(st);

	}

	/*
	 * menu() ужасная конструкция которая не соответсвует правилам оформления кода
	 */

	public void menu() {
		Interface.menu();
		Scanner scan = new Scanner(System.in);
		int number;
		number = scan.nextInt();
		while (true) {
			try {
				if (number == 1) {
					try {
						createStudent();
					} catch (MyException e) {
						System.err.println(e.getMessage());
					}

					number = scan.nextInt();
					continue;
				}
				if (number == 2) {
					System.out.print(allStudentArr());
					number = scan.nextInt();

					continue;
				}
				if (number == 3) {
					sort();
					number = scan.nextInt();
					continue;
				}
				if (number == 4) {
					sortName();
					number = scan.nextInt();
					continue;
				}
				if (number == 5) {
					System.out.println(recrut());
					number = scan.nextInt();
					continue;
				}
				if (number == 6) {
					System.out.println("Группа сохранена");
					writeFile();
					number = scan.nextInt();
					continue;
				}
				if (number == 7) {
					System.out.println("Группа считана");
					File file = new File("group.csv");
					stud = readFile(file, ":");
					number = scan.nextInt();
					continue;
				}
				if (number == 8) {
					int a;
					a = scan.nextInt();
					delArray(a);
				}
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				return;
			}
		}

	}

	public void sort() {

		// Arrays.sort(group, Comparator.nullsFirst(new StudSort()));
		Comparator<Student> comp = new StudSort();
		stud.sort(comp);
		for (int i = 0; i < stud.size(); i++) {
			System.out.println(stud.get(i));
		}
	}

	public void sortName() {
		Comparator<Student> comp = new StudNameSort();
		stud.sort(comp);
		for (int i = 0; i < stud.size(); i++) {
			System.out.println(stud.get(i));
		}
	}

	@Override
	public List<Student> recrut() {
		int count = 0;

		for (int i = 0; i < stud.size(); i++) {
			if (stud.get(i) == null) {
				continue;
			}
			if (stud.get(i).getYears() >= 18 && stud.get(i).getGender().equals(Gender.MAN)) {
				count++;
			}
		}

		List<Student> recruter = new ArrayList<Student>(count);
		for (int i = 0; i < stud.size(); i++) {
			if (stud.get(i) == null) {
				continue;
			}
			if (stud.get(i).getYears() >= 18 && stud.get(i).getGender().equals(Gender.MAN)) {
				recruter.add(stud.get(i));

			}
		}
		return recruter;
	}

	public void writeFile() {
		File file = new File("group.csv");
		try (PrintWriter pw = new PrintWriter(file)) {
			for (Student student : stud) {
				if (student != null) {
					String st = student.getName() + ":" + student.getSurname() + ":" + student.getYears() + ":"
							+ student.getGender() + ":" + student.getNumberGroup() + ":" + student.getId() + ":"
							+ student.getFaculty();
					pw.println(st);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public List<Student> readFile(File file, String def) {
		String student = "";
		try (BufferedReader f = new BufferedReader(new FileReader(file))) {
			for (; (student = f.readLine()) != null;) {
				try {
					addArray(makeStudentString(student, def));
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Файл считан используйте [2]  для просмотра группы");

			}

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return stud;
	}

	public Student makeStudentString(String st, String def) {
		Student student = new Student();
		String[] temp = st.split(def);
		student.setName(temp[0]);
		student.setSurname(temp[1]);
		student.setYears(Integer.parseInt(temp[2]));
		student.setGender(Gender.valueOf(temp[3]));
		student.setNumberGroup(Integer.parseInt(temp[4]));
		student.setId(Integer.parseInt(temp[5]));
		student.setFaculty(temp[6]);
		return student;

	}

}
