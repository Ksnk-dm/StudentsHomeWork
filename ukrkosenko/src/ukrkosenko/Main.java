package ukrkosenko;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws MyException {
		Group group = new Group();
		
		Student student1 = new Student("Василий", "Пупкин", 17, Gender.MAN, 435345, 3, "ОК");
		Student student2 = new Student("Петр", "Никонов", 18, Gender.MAN, 678543, 3, "ОК");
		Student student3 = new Student("Николай", "Паленко", 18, Gender.MAN, 5454545, 3, "ОК");
		Student student4 = new Student("Виктор", "Рыбкин", 18, Gender.MAN, 5454345, 3, "ОК");
		Student student5 = new Student("Виктория", "Рыбкина", 18, Gender.WOMAN, 5414345, 1, "ЕП");
		Student student6 = new Student("Виктория", "Рыбк", 18, Gender.WOMAN, 54134345, 1, "ЕП");
		Student student7 = new Student("Виталий", "Костюк", 19, Gender.MAN, 54134945, 1, "ОК");
		Student student8 = new Student("Дмитрий", "Костишко", 17, Gender.MAN, 54137345, 1, "ОК");
		Student student9 = new Student("Николай", "Якимчук", 18, Gender.MAN, 54134345, 1, "ЕП");
		Student student10 = new Student("Валентин", "Грибник", 18, Gender.MAN, 54331345, 1, "ЕП");
		Student student11 = new Student("Андрей", "Дождевик", 18, Gender.MAN, 54311345, 1, "ЕП");
	
             group.menu();

	
			System.out.println("найден " + group.searh("Рыбк"));

			group.del(12);

		}

	}
