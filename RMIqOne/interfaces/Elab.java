package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
//import java.util.List;

public interface Elab extends Remote {

	//this is the method which is called by the Dispatcher to send the image to the Elaborator
    //This method is boolean as the Elaborator notifies that it has in fact received the image and will
	//elaborate it and of course an Object which is called img is passed as for the Elaborator to receive the Image
	public boolean elaborateImage(Object img) throws RemoteException;

	//this method here notifies the Dispatcher the status of the Elaborator as the Dispatcher needs to know if 
	//the Elaborator is active or passive by a boolean value indicating accordingly it's status
	public boolean getStatus();

}