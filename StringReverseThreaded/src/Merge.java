public class Merge extends Thread {

	// initializations
	String revs;
	String s;
	String theString;
	String reversed;
	String merged;

	MergeWithMyString mer;

	Thread tm;

	//instance of MyString class
	MyString im = new MyString(1, "");
	

	// creation of method to return merged string
	public String getMerged() {
		return merged;
	}

	
	// creation of Merge method
	public Merge(MergeWithMyString merg, String rev, String str) {
		mer = merg;
		s = str;
		reversed = rev;

		tm = new Thread(this);
		tm.run();
	}

	
	// sychronization
	public void run() {
		synchronized (im) {
			synchronized (reversed) {
				try {
					mer.transform();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}

}