
class IntegerSet {
	private int[] set;

	public IntegerSet() {
		this.set = new int[100];
	}

	public void insert(int a) {

		if (a >= 0 && a < this.set.length) {
			set[a] = 1;
		} else {
			System.out.println(a + " Can not insert-Out of Range");
		}
	}

	public void delete(int a) {
		if (a >= 0 && a < this.set.length) {
			set[a] = 0;
		} else {
			System.out.println(a + " Can not Delet- out of range");
		}
	}

	public String toString() {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < this.set.length; i++) {
			if (this.set[i] == 1) {
				s.append(i + ",");
			}
		}
		return new String("{" + s.toString() + "}");
	}

	public IntegerSet union(IntegerSet a) {

		IntegerSet b = new IntegerSet();

		for (int i = 0; i < 99; i++) {

			if (this.set[i] == 1 || a.set[i] == 1)
				b.set[i] = 1;
		}
		return b;
	}

	public IntegerSet intersection(IntegerSet a) {

		IntegerSet b = new IntegerSet();

		for (int i = 0; i < 99; i++) {

			if (this.set[i] == 1 && a.set[i] == 1)
				b.set[i] = 0;
			else if (this.set[i] == 1)
				b.set[i] = 1;
			else if (a.set[i] == 1)
				b.set[i] = 1;
		}
		return b;
	}

	public IntegerSet difference(IntegerSet a) {

		IntegerSet b = new IntegerSet();

		for (int i = 0; i < 99; i++) {

			if (this.set[i] == 1 && a.set[i] == 1)
				b.set[i] = 0;
			else if (this.set[i] == 1)
				b.set[i] = 1;
		}
		return b;
	}

	public boolean equals(IntegerSet a) {
		for (int i = 0; i < 99; i++)
			if (this.set[i] == 1 && a.set[i] == 1)
				return true;

		return false;
	}
}

class Lab31 {
	public static void main(String[] args) {
		IntegerSet a1 = new IntegerSet();
		IntegerSet a2 = new IntegerSet();
		a1.insert(1);
		a1.insert(3);
		a1.insert(4);
		a1.insert(8);
		a1.insert(9);
		a2.insert(1);
		a2.insert(5);
		a2.insert(10);
		a2.insert(4);
		a2.insert(18);
		IntegerSet a3 = a1.union(a2);
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		a3 = a1.intersection(a2);
		System.out.println(a3.toString());
		a3 = a1.difference(a2);
		System.out.println(a3.toString());
		System.out.println(a3.equals(a2));

	}

}
