class Employee {
	protected double salary;
	protected String name;
	protected int id;

	public Employee(double salary, String name, int id) {
		this.salary = salary;
		this.name = name;
		this.id = id;
	}

	public String toString2() {

		return new String("Employee detail = \n" + this.name + "," + this.salary + ", " + this.id);
	}
}

class Salesperson extends Employee {

	protected Policy p1;

	public Salesperson(double salary, String name, int id) {
		super(salary, name, id);
		this.p1 = new Policy("beneficiary1", 10000, 1212);
	}

	public String toString() {

		return new String("Policy = " + p1.beneficiary + ", " + p1.amount + "," + p1.pId);
	}

}

class Policy {
	protected String beneficiary;
	protected double amount;
	protected int pId;

	public Policy(String beneficiary, double amount, int pId) {
		this.beneficiary = beneficiary;
		this.amount = amount;
		this.pId = pId;
	}

}

class Lab41 {
	public static void main(String[] arges) {
		Employee[] ea = new Employee[2];
		Employee e1 = new Salesperson(5000, "Mario", 1007);
		Employee e2 = new Salesperson(6000, "Luigi", 1008);

		ea[0] = e1;
		ea[1] = e2;

		for (int i = 0; i < ea.length; i++) {
			System.out.println(ea[i].toString());
			System.out.println(ea[i].toString2());

		}
	}
}