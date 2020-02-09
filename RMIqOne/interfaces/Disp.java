package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Disp extends Remote {	
	
	//The Elaborator must register itself to the Dispatcher by this method which it will call in his own code
	//The method is void as it nothing is returned from the Dispatcher and in order for the Elaborator
	//to register it must pass itself as a parameter
	public void register (Elab elab) throws RemoteException; 
	
	//The Repository will first request from the Dispatcher that it needs an image implemented
	//The method is void as it nothing is returned from the Dispatcher and in order for the Repository
	//to request an image to be elaborated it passes itself as a parameter
    public void requestElab (Rep rep) throws RemoteException;	

    //The method that the Repository will call in order to send the image to the Dispatcher
    //Again this is void as nothing is returned and it must pass a serializable Object which is called img
	public void sendImage(Object img) throws RemoteException;

	//This method is a confirmation received from the Elaborator defining whether it will 
	//elaborate the image it received from the Dispatcher
	//This is boolean as to indicate is the image will be elaborated or not
	public boolean notification(boolean a) throws RemoteException;
	
}