package ukrkosenko;

public class Person {
	private String name;
	private String surname;
	private int years;
	private Gender gender;

	public Person() {
		super();
	}

	public Person(String name, String surname, int years, Gender gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.years = years;
		this.gender = gender;

	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return "Инфо [Имя=" + name + ", Фамилия=" + surname + ", Возраст " + years + ", Пол " + gender + "]";
	}

}
