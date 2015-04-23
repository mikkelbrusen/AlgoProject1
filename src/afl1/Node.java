package afl1;

public class Node {

	private int key;
	private int sat;
	
	public Node(int key, int sat) {
		this.setKey(key);
		this.setSat(sat);
	}
	
	public boolean equals(int i) {
		return key == i;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		this.sat = sat;
	}
	
}
