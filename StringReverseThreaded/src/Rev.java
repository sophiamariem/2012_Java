class Rev extends Thread {

	// initializations
	String s;
	int theInt;
	String theString;
	String reversed;
	ReverseMyString rv;
	int rInt;
	Thread tr;

	// instance of MyString class
	MyString im = new MyString(1, "");

	// creation of method to return reversed string
	public String getReversed() {
		return reversed;
	}

	// creation of method to return reversed integer
	public int getRevInt() {
		return rInt;
	}

	// creation of Rev method
	public Rev(ReverseMyString rever, String str) {
		rv = rever;
		s = str;
		tr = new Thread(this);
		tr.run();

	}

	// sychronization
	public void run() {
		synchronized (im) {
			reversed = rv.transform();
			im.setString(reversed);

			im.getInt();
			im.setInt(1);
			rInt = im.getInt();
		}
	}

}