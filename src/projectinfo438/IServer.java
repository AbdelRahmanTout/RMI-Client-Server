package projectinfo438;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote{
    public void connect(String id,IClient client) throws RemoteException;
    public void disconnect(String id) throws RemoteException;
    public void reconnect(String id,IClient client) throws RemoteException;
    public void send(String msg,String id) throws RemoteException;
    public void Subscribe(String id) throws RemoteException;
    public void createGroup(String idGroup,String idAdmin) throws RemoteException;
    public void sendToClient(String id,String msg) throws RemoteException;
    public void sendToGroup(String idGroup,String msg) throws RemoteException;
    public void Broadcast(String msg) throws RemoteException;
    public void getAllClients() throws RemoteException;
    public String listConnected() throws RemoteException;
}