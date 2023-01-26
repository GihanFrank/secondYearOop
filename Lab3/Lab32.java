class CA {
	private boolean[] cell;
	private int size;
	private int rule;
	private boolean[] ttable;

	public CA(int size, int rule) {
		this.size = size;
		this.rule = rule;
		ttable = new boolean[8];
		cell = new boolean[size];
		cell[size / 2] = true;
		int x = this.rule;
		for (int i = 0; i < 8; i++) {
			if (x % 2 == 0) {
				this.ttable[i] = false;
				x = (x / 2);
			} else {
				this.ttable[i] = true;
				x = ((x - 1) / 2);
			}
		}
	}

	public boolean[] getState() {
		for (int n = 0; n < 20; n++) {
			int count = 0;
			boolean[] temp = new boolean[this.size];

			for (int b = 0; b < this.cell.length; b++) {
				temp[b] = cell[b];

			}
			for (int b = 0; b < this.cell.length; b++) {
				if (cell[b]) {
					System.out.print("X");
				} else
					System.out.print(" ");
				cell[b] = false;
			}
			System.out.println(" ");
			for (int i = 1; i < (this.size - 1); i++) {
				for (int k = 0; k < 8; k++) {

					if (ttable[0] && !temp[i - 1] && !temp[i] && !temp[i + 1]) {
						cell[i] = false;
					} else if (ttable[1] && !temp[i - 1] && !temp[i] && temp[i + 1]) {
						cell[i] = true;
					} else if (ttable[2] && !temp[i - 1] && temp[i] && !temp[i + 1]) {
						cell[i] = true;
					} else if (ttable[3] && !temp[i - 1] && temp[i] && temp[i + 1]) {
						cell[i] = true;
					} else if (ttable[4] && temp[i - 1] && !temp[i] && !temp[i + 1]) {
						cell[i] = true;
					} else if (ttable[5] && temp[i - 1] && !temp[i] && temp[i + 1]) {
						cell[i] = true;
					} else if (ttable[6] && temp[i - 1] && temp[i] && !temp[i + 1]) {
						cell[i] = true;
					} else if (ttable[7] && temp[i - 1] && temp[i] && temp[i + 1]) {
						cell[i] = true;
					}
				}
			}
		}
		return cell;
	}
}

class Lab32 {
	public static void main(String[] args) {
		CA a = new CA(50, 150);
		toPrint(a.getState());
	}

	public static void toPrint(boolean[] a) {
		for (int g = 0; g < a.length; g++) {
			if (a[g]) {
				System.out.print("X");
			} else
				System.out.print(" ");
		}
	}
}
