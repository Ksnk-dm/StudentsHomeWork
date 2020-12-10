package ukrkosenko;

import java.io.Serializable;

public class Student extends Person implements Serializable {
	private int id;
	private int numberGroup;
	private String faculty;

	public Student(String name, String surname, int years, Gender gender, int id, int numberGroup, String faculty) {
		super(name, surname, years, gender);
		this.id = id;
		this.numberGroup = numberGroup;
		this.faculty = faculty;

	}

	public Student(int id, int numberGroup, String faculty) {
		super();
		this.id = id;
		this.numberGroup = numberGroup;
		this.faculty = faculty;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberGroup() {
		return numberGroup;
	}

	public void setNumberGroup(int numberGroup) {
		this.numberGroup = numberGroup;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return super.toString() + " [номер студ.билета=" + id + ", номер группы=" + numberGroup + ", факультет="
				+ faculty + "" + "]";
	}

}
