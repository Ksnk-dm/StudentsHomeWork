package ukrkosenko;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {
	public static Scanner in = new Scanner(System.in);
	public static Group group = new Group();

	public static void name(Student st) {
		System.out.println("Введите имя: ");
		String string = in.nextLine();

		st.setName(string);
	}

	public static void surname(Student st) {
		System.out.println("Введите фамилию: ");
		String string = in.nextLine();
		st.setSurname(string);
	}

	public static void age(Student st) {

		do {
			System.out.println("Введите возраст");
			String string = in.nextLine();

			try {
				st.setYears(Integer.valueOf(string));
			} catch (NumberFormatException e) {
				System.err.println("возраст должен быть числом");
			}
		} while (st.getYears() == 0);
	}

	public static void gender(Student st) {
		do {
			System.out.println("Введите пол (MAN\\WOMAN)");
			String string = in.nextLine();

			try {
				st.setGender(Gender.valueOf(string));
			} catch (IllegalArgumentException e) {
				System.err.println("пол не найден");
			}
		} while (st.getGender() == null);
	}

	public static void faculty(Student st) {
		System.out.println("Введите название факультета ");
		String string = in.nextLine();
		st.setFaculty(string);
	}

	public static void id(Student st) {

		do {
			System.out.println("Введите номер студ. билета ");
			String string = in.nextLine();
			try {
				st.setId(Integer.valueOf(string));

			} catch (NumberFormatException e) {
				System.err.println("должно быть число");
			}
		} while (st.getId() == 0);
	}

	public static void numberGroup(Student st) {

		do {
			System.out.println("Введите номер группы ");
			String string = in.nextLine();
			try {
				st.setNumberGroup(Integer.valueOf(string));

			} catch (NumberFormatException e) {
				System.err.println("должно быть число");
			}
		} while (st.getId() == 0);
	}

	public static void menu() {
		System.out.println("\nВыберите пункт меню: " + "\n[1] - Добавление студентов в группу"
				+ "\n[2] - Вывод всех студентов" + "\n[3] - Сортировка по фамилии" + "\n[4] - Сотртровка по имени"
				+ "\n[5] - Призовники" + "\n[6] - Сохранить в файл" + "\n[7] - Считать с файла");
	}

}
