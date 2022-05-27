package processing;

public class residents {
	private String name;
	private String homeAddress;
	private int age;
	private Degree educationLevel;
	private boolean hasCommittedCrime;
	
	public residents (String name, String homeAddress, int age, Degree level, boolean committedCrime) {
		this.name = name;
		this.homeAddress = homeAddress;
		this.age = age;
		this.educationLevel = level;
		this.hasCommittedCrime = committedCrime;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String homeAddress() {
		return this.homeAddress;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public Degree getEducationLevel () {
		return this.educationLevel;
	}
	
	public boolean getCrimeHistory () {
		return this.hasCommittedCrime;
	}
	
}
