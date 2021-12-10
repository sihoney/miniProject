package miniProject;

public class Person {
	
	private String name;
	private String hp;
	private String cn;
	
	public Person() {
		
	}
	
	public Person(String name, String hp, String cn) {
		super();
		this.name = name;
		this.hp = hp;
		this.cn = cn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}
	
	@Override
	public String toString() {
		return name + "," + hp + "," + cn;
	}
	
	public void print() {
		System.out.println(name + "   " +hp + "  " + cn);
	}
}
