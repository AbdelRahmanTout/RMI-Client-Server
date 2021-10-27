package projectinfo438;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote{
    public void notifier(String msg) throws RemoteException;
}