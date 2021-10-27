package projectinfo438;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGroup extends Remote{
    public void sendToAll(String msg) throws RemoteException;
    public void addClient(String id) throws RemoteException;
    public void removeClient(String id) throws RemoteException;
    public void getAllClients() throws RemoteException;
//    public void notifiere(String msg) throws RemoteException;
}