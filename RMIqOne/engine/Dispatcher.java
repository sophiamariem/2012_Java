package engine;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfaces.Disp;
import interfaces.Elab;
import interfaces.Rep;

/**
 * @author smm54
 * 
 */

//Class which implements the Disp interface
//I have not extended UnicastRemoteObject as it is extended in the main 
// at this line:  Disp stub = (Disp) UnicastRemoteObject.exportObject(dis, 0);
public class Dispatcher implements Disp {

//class throws remote exception 	
	public Dispatcher() throws RemoteException  {
		super();
	}

	//Declarations:
	
	//boolean that shows the status of the Elaborator
	static Elab activeOne;
	//array that will store the Elaborators (fixed size)
	static Elab[] mylist;
	//boolean that correspond to if the Elaborator has elaborated the Image
	static boolean transaction;
	//ArrayList that will store the Elaborators (dynamic)
	private static ArrayList<Elab> list;

	//calling the Elab and Rep interfaces
	private Elab elab;
	private Rep rep;
	
	
	//Method implementation for Elaborator to register to the Dispatcher
	//will add the Elaborator to the dynamic list
	public void register(interfaces.Elab elab) throws RemoteException {
		this.elab = elab;
		list.add(elab);
	}

	//Method where the Repository requests from the Dispatcher that it needs an image to be elaborated
	public void requestElab(interfaces.Rep rep) throws RemoteException {
		//fixed size array that will add the elaborators (as now we can manipulate the dynamic array based on .size()
		//before we did not know how many elaborators would register and so it was dynamic
		mylist = new Elab[list.size()];
		this.rep = rep;
		//for loop that will check the status of the elaborators and add them to the fixed array
		for (int x = 0; x <= mylist.length; x++) {
			if (mylist[x].getStatus()) {
				activeOne = mylist[x];
			}
		}
	}

	// declaration of the image object
	private Object im;

	//sendImage method that the Repository will call in order to send the image to the Dispatcher
	public void sendImage(Object img) throws java.rmi.RemoteException {
		this.im = img;
		//If statement that will check the status of the Elaborator (passive or active) in order to check if it is available
		//so it can send the image
		if (activeOne.elaborateImage(im)) {
			transaction = true;
		} else {
			transaction = false;
		}

	}

	//here we return a boolean value that indicates if the image will be elaborated or not based on the calling of the remote 
	//method .elaborateImage above and the status returned
	public boolean notification(boolean a) throws java.rmi.RemoteException {
		return transaction;
	}

	//main program
	public static void main(String[] args) {
		//create and install a security manager
		//check if a security manager run on the machine and if not we create one
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			//assign name to the Remote Object
			String name = "Disp";
			//creation of the Remote Object
			Disp dis = new Dispatcher();
			//create stub and extend UNicastRemoteObject and then export the Object
			Disp stub = (Disp) UnicastRemoteObject.exportObject(dis, 0);
			//create and use our registry
			Registry registry = LocateRegistry.getRegistry();
			//bind Dispatcher to the registry (object to a name)
			//this can be used later to look up references to the Dispatcher which is needed by the Elaborator and the
			//Repository.(so it allows them to find it)
			//have rebind because if it was already bind we would get an exception
			registry.rebind(name, stub);
			//print message that it has been bound correctly
			System.out.println("Dispatch bound");
			//create the arraylist (dynamic)
			list = new ArrayList<Elab>();
			//print message
			System.out.println("Send to ImageElab");
			//catch Exceptions
		} catch (Exception e) {
			System.err.println("Dispatch exception:");
			e.printStackTrace();
		}
	}
}
