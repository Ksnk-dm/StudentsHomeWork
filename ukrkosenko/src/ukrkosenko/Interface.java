package ukrkosenko;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {
	public static Scanner in = new Scanner(System.in);
	public static Group group = new Group();

	public static void name(Student st) {
		System.out.println("������� ���: ");
		String string = in.nextLine();

		st.setName(string);
	}

	public static void surname(Student st) {
		System.out.println("������� �������: ");
		String string = in.nextLine();
		st.setSurname(string);
	}

	public static void age(Student st) {

		do {
			System.out.println("������� �������");
			String string = in.nextLine();

			try {
				st.setYears(Integer.valueOf(string));
			} catch (NumberFormatException e) {
				System.err.println("������� ������ ���� ������");
			}
		} while (st.getYears() == 0);
	}

	public static void gender(Student st) {
		do {
			System.out.println("������� ��� (MAN\\WOMAN)");
			String string = in.nextLine();

			try {
				st.setGender(Gender.valueOf(string));
			} catch (IllegalArgumentException e) {
				System.err.println("��� �� ������");
			}
		} while (st.getGender() == null);
	}

	public static void faculty(Student st) {
		System.out.println("������� �������� ���������� ");
		String string = in.nextLine();
		st.setFaculty(string);
	}

	public static void id(Student st) {

		do {
			System.out.println("������� ����� ����. ������ ");
			String string = in.nextLine();
			try {
				st.setId(Integer.valueOf(string));

			} catch (NumberFormatException e) {
				System.err.println("������ ���� �����");
			}
		} while (st.getId() == 0);
	}

	public static void numberGroup(Student st) {

		do {
			System.out.println("������� ����� ������ ");
			String string = in.nextLine();
			try {
				st.setNumberGroup(Integer.valueOf(string));

			} catch (NumberFormatException e) {
				System.err.println("������ ���� �����");
			}
		} while (st.getId() == 0);
	}

	public static void menu() {
		System.out.println("\n�������� ����� ����: " + "\n[1] - ���������� ��������� � ������"
				+ "\n[2] - ����� ���� ���������" + "\n[3] - ���������� �� �������" + "\n[4] - ���������� �� �����"
				+ "\n[5] - ����������" + "\n[6] - ��������� � ����" + "\n[7] - ������� � �����");
	}

}
