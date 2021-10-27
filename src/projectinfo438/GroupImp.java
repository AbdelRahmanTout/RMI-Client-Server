package projectinfo438;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JTextArea;

public class GroupImp extends UnicastRemoteObject implements IGroup{
    HashMap<String,IClient> listC =  new HashMap();
    IServer s;
    IClient cl;

    public GroupImp() throws RemoteException{
        
    }

    @Override
    public void sendToAll(String msg) throws RemoteException {
        Set<String> sl = listC.keySet();
        for (String st : sl) {
            IClient cl = listC.get(st);
            cl.notifier(msg);
            s.send(msg, st);
            System.out.println("sendToAll " + st);
        }
    }

    @Override
    public void addClient(String id) throws RemoteException {
        if( cl != null)
            listC.put(id, cl);
    }

    @Override
    public void removeClient(String id) throws RemoteException {
        listC.remove(id);
    }

    @Override
    public void getAllClients() throws RemoteException {
        listC.keySet().toString();
    }
}