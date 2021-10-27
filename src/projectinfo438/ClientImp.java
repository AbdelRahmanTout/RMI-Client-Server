package projectinfo438;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JTextArea;

public class ClientImp extends UnicastRemoteObject implements IClient{
    JTextArea area;

    public ClientImp(JTextArea area) throws RemoteException{
        this.area = area;
    }

    @Override
    public void notifier(String msg) throws RemoteException {
        area.append("\n"+msg);
    }
}