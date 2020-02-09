package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Rep extends Remote {
	
	//The Dispatcher will notify the Repository that it has found an Elaborator which will elaborate the image
	//by calling this method and this is why this a boolean parameter called f is passed
	public void found(boolean f) throws RemoteException;

}