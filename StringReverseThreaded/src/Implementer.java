import java.util.concurrent.*;

//import java.util.*;

public class Implementer extends Thread {

	// create instance of MyString class
	MyString im = new MyString(1, "");

	// initialization of ThreadPool parameters
	int corepoolSize = 2;
	int maxPoolSize = 2;
	long keepAliveTime = 10;

	static ThreadPoolExecutor threadPool = null;

	final ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(
			5);

	// create new ThreadPool
	public Implementer() {
		threadPool = new ThreadPoolExecutor(corepoolSize, maxPoolSize,
				keepAliveTime, TimeUnit.SECONDS, queue);
	}

	// execute ThreadPool
	public void Prog(Runnable prog) {
		threadPool.execute(prog);
	}

	// shutdown ThreadPool
	public void shutDown() {
		threadPool.shutdown();
	}

	public static void main(String[] args) throws Exception {

		// new Implementer instance
		Implementer implem = new Implementer();

		// nre Runnable
		implem.Prog(new Runnable() {
			public void run() {
				MyString im = new MyString("", 0);
				// new instance of Generator class and set up of Int and String
				Generator g = new Generator(im, 3, "abc");
				try {
					// run Geerator thread
					g.run();
					System.out.println(im.getString()
							+ " currently in mystring");
					// create new instance of RevereMyString
					ReverseMyString rv = new ReverseMyString(im);
					// create new Rev instance
					Rev r = new Rev(rv, im.getString());
					// run Rev class
					r.tr.run();
					// set modifies integer from Rev
					im.setInt(r.getRevInt());
					im.setString(im.getString());

					System.out.println(r.reversed + " reversed");
					System.out.println(im.getInt() + "," + r.reversed
							+ "    reversed modified int");
					// set original integer so as not to affect the output of
					// the merged string
					im.setInt(g.inInt);
					// make the thread sleep for 1 sec
					Thread.sleep(1000);
					// create new MergeWithMyString instance
					MergeWithMyString mer = new MergeWithMyString(im, r
							.getReversed());
					// create new Merge instance
					Merge threadmer = new Merge(mer, "", "");
					// run Merge
					threadmer.tm.run();

					try {
						System.out.println("(" + im.getInt() + ","
								+ mer.transform() + ")" + " merged");
					} catch (Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		});

		implem.Prog(new Runnable() {
			public void run() {
				MyString im = new MyString("", 0);
				Generator g = new Generator(im, 3, "abcd");
				try {

					g.run();
					System.out.println(im.getString()
							+ " currently in mystring");

					ReverseMyString rv = new ReverseMyString(im);
					Rev r = new Rev(rv, im.getString());

					r.tr.run();

					im.setInt(r.getRevInt());
					im.setString(im.getString());

					System.out.println(r.reversed + " reversed");
					System.out.println(im.getInt() + "," + r.reversed
							+ "    reversed modified int");

					im.setInt(g.inInt);
					Thread.sleep(1000);
					MergeWithMyString mer = new MergeWithMyString(im, r
							.getReversed());
					Merge threadmer = new Merge(mer, "", "");
					threadmer.tm.run();

					try {
						System.out.println("(" + im.getInt() + ","
								+ mer.transform() + ")" + " merged");
					} catch (Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		});
		implem.Prog(new Runnable() {
			public void run() {
				MyString im = new MyString("", 0);
				Generator g = new Generator(im, 3, "abcde");
				try {
					g.run();
					System.out.println(im.getString()
							+ " currently in mystring");

					ReverseMyString rv = new ReverseMyString(im);
					Rev r = new Rev(rv, im.getString());

					r.tr.run();

					im.setInt(r.getRevInt());
					im.setString(im.getString());

					System.out.println(r.reversed + " reversed");
					System.out.println(im.getInt() + "," + r.reversed
							+ "    reversed modified int");
					Thread.sleep(1000);
					im.setInt(g.inInt);
					Thread.sleep(1000);
					MergeWithMyString mer = new MergeWithMyString(im, r
							.getReversed());
					Merge threadmer = new Merge(mer, "", "");
					threadmer.tm.run();

					try {
						System.out.println("(" + im.getInt() + ","
								+ mer.transform() + ")" + " merged");
					} catch (Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		});

		implem.Prog(new Runnable() {

			public void run() {
				MyString im = new MyString("", 0);
				Generator g = new Generator(im, 4, "abcdef");
				try {
					g.run();
					System.out.println(im.getString()
							+ " currently in mystring");

					ReverseMyString rv = new ReverseMyString(im);
					Rev r = new Rev(rv, im.getString());

					r.tr.run();

					im.setInt(r.getRevInt());
					im.setString(im.getString());

					System.out.println(r.reversed + " reversed");
					System.out.println(im.getInt() + "," + r.reversed
							+ "    reversed modified int");

					im.setInt(g.inInt);
					Thread.sleep(1000);
					MergeWithMyString mer = new MergeWithMyString(im, r
							.getReversed());
					Merge threadmer = new Merge(mer, "", "");
					threadmer.tm.run();

					try {
						System.out.println("(" + im.getInt() + ","
								+ mer.transform() + ")" + " merged");
					} catch (Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
				}

			}
		});

		implem.Prog(new Runnable() {
			public void run() {
				MyString im = new MyString("", 0);
				Generator g = new Generator(im, 1, "NOEL SEES LEON");
				try {
					g.run();
					System.out.println(im.getString()
							+ " currently in mystring");

					ReverseMyString rv = new ReverseMyString(im);
					Rev r = new Rev(rv, im.getString());

					r.tr.run();

					im.setInt(r.getRevInt());
					im.setString(im.getString());

					System.out.println(r.reversed + " reversed");
					System.out.println(im.getInt() + "," + r.reversed
							+ "    reversed modified int");

					im.setInt(g.inInt);

					MergeWithMyString mer = new MergeWithMyString(im, r
							.getReversed());
					Merge threadmer = new Merge(mer, "", "");
					threadmer.tm.run();

					try {
						System.out.println("(" + im.getInt() + ","
								+ mer.transform() + ")" + " merged");
					} catch (Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		});

	}
}