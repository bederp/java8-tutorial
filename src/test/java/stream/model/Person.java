package stream.model;

public class Person {

    private String name;
    
    private int age;
    
    private Gender gender;
    
    public Person(){}
    
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = Gender.get(gender);
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String toString() {
        return "Person [" + this.name + ", " + this.age + ", "+this.gender.name()+"]";
    }

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
    
    
}
