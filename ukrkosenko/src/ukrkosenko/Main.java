package ukrkosenko;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws MyException {
		Group group = new Group();
		
		Student student1 = new Student("�������", "������", 17, Gender.MAN, 435345, 3, "��");
		Student student2 = new Student("����", "�������", 18, Gender.MAN, 678543, 3, "��");
		Student student3 = new Student("�������", "�������", 18, Gender.MAN, 5454545, 3, "��");
		Student student4 = new Student("������", "������", 18, Gender.MAN, 5454345, 3, "��");
		Student student5 = new Student("��������", "�������", 18, Gender.WOMAN, 5414345, 1, "��");
		Student student6 = new Student("��������", "����", 18, Gender.WOMAN, 54134345, 1, "��");
		Student student7 = new Student("�������", "������", 19, Gender.MAN, 54134945, 1, "��");
		Student student8 = new Student("�������", "��������", 17, Gender.MAN, 54137345, 1, "��");
		Student student9 = new Student("�������", "�������", 18, Gender.MAN, 54134345, 1, "��");
		Student student10 = new Student("��������", "�������", 18, Gender.MAN, 54331345, 1, "��");
		Student student11 = new Student("������", "��������", 18, Gender.MAN, 54311345, 1, "��");
	
             group.menu();

	
			System.out.println("������ " + group.searh("����"));

			group.del(12);

		}

	}
