class Generator extends Thread {

	// initializations
	int theInt;
	String theString;
	int inInt;

	MyString im;
	Thread t;

	// creation of method to return initial integer
	public int getInt() {
		return inInt;
	}

	// creation of Generator method
	public Generator(MyString mystr, int in, String str) {
		im = mystr;
		theInt = in;
		theString = str;

		t = new Thread(this);
		t.run();

		System.out.println(str);
	}

	// sychronization
	public void run() {
		synchronized (im) {
			im.setInt(theInt);
			im.setString(theString);

			inInt = im.getInt();
		}

	}
}
