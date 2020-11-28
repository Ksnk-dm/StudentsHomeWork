package ukrkosenko;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Group implements Voencom {

	private Student[] group = new Student[10];

	public Group(Student[] group) {
		super();
		this.group = group;
	}

	public Group() {
		super();
	}

	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}

	public void add(Student st) throws MyException {

		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				group[i] = st;
				System.out.println("студент " + st + " добавлен");
				Interface.menu();

				return;
			}

		}

		throw new MyException();
	}

	public void del(int id) {

		for (int i = 0; i < this.getGroup().length; i++) {
			if (group[i] != null) {
				if (group[i].getId() == id) {
					group[i] = null;
					System.out.println("студент " + id + " отчислен");
				}
			}
		}
	}

	public Student searh(String surname) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].getSurname().equals(surname)) {
					return group[i];

				}

			}
		}
		return null;

	}

	@Override
	public String toString() {
		return "Group [allStudent()=" + allStudent() + "]";
	}

	public String allStudent() {
		String all = " ";

		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				all += group[i].toString();
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
		add(st);

	}

	/*
	 * menu() Максимально ужасная конструкция которая не соответсвует стандартнам
	 * оформления кода, что-то даже идей нет как её разбить был бы благодарен за
	 * идею :)
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
					System.out.print(allStudent());
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
					System.out.println(Arrays.toString(recrut()));
					number = scan.nextInt();
					continue;
				}
				if (number == 6) {
					System.out.println("Сохранение в файл");
					writeFile();
					number = scan.nextInt();
					continue;
				}
				if (number == 7) {
					System.out.println("Считать с файла");
					File file = new File("group.csv");
					group = readFile(file, ":");
					number = scan.nextInt();
					continue;
				}
				if (number == 8) {
					int a ;
					a=scan.nextInt();
					del(a);
				}
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				return;
			}
		}

	}

	public void sort() {

		Arrays.sort(group, Comparator.nullsFirst(new StudSort()));
		for (int i = 0; i < group.length; i++) {
			System.out.println(group[i]);

		}

	}

	public void sortName() {
		Arrays.sort(group, Comparator.nullsFirst(new StudNameSort()));
		for (int i = 0; i < group.length; i++) {
			System.out.println(group[i]);

		}
	}

	@Override
	public Student[] recrut() {
		int count = 0;

		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				continue;
			}
			if (group[i].getYears() >= 18 && group[i].getGender().equals(Gender.MAN)) {
				count++;
			}
		}

		Student[] recruter = new Student[count];
		int j = 0;
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				continue;
			}
			if (group[i].getYears() >= 18 && group[i].getGender().equals(Gender.MAN)) {
				recruter[j] = group[i];
				j++;
			}
		}
		return recruter;
	}

	public void writeFile() {
		File file = new File("group.csv");
		try (PrintWriter pw = new PrintWriter(file)) {
			for (Student student : group) {
				if (student != null) {
					String st = student.getName() + ":" + student.getSurname() + ":" + student.getYears() + ":"
							+ student.getGender() + ":" + student.getNumberGroup() + ":" + student.getId() + ":"
							+ student.getFaculty();
					pw.println(st);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public Student[] readFile(File file, String def) {
		String student = "";
		try (BufferedReader f = new BufferedReader(new FileReader(file))) {
			for (; (student = f.readLine()) != null;) {
				try {
					add(makeStudentString(student, def));
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Информацию считано используйте [2] для просмотра всех студентов");
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return group;
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
