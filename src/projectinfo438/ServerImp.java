package projectinfo438;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import sun.print.resources.serviceui;

public class ServerImp extends UnicastRemoteObject implements IServer{
    HashMap<String,IClient> listConnect = new HashMap();
    HashMap<String,String> offline = new HashMap();
    HashMap<String,IClient> subscibded = new HashMap();
    HashMap<String,String> create = new HashMap();
    HashMap<String,IGroup> groupConnected = new HashMap();

    public ServerImp() throws RemoteException{
        
    }

    @Override
    public void reconnect(String id, IClient client) throws RemoteException {
        listConnect.put(id,client);
        System.out.println("connect " + id);
        String msg = offline.get(id);
        if(msg != null){
            client.notifier(msg);
            offline.put(id,null);
        }
    }

    @Override
    public void disconnect(String id) throws RemoteException {
        listConnect.remove(id);
    }

    @Override
    public void send(String msg, String id) throws RemoteException {
        IClient cl = listConnect.get(id);
        if(cl != null)
            cl.notifier(msg);
        else{
            String oldMsg = offline.get(id);
            if(oldMsg == null){
                oldMsg += "" + msg;
                offline.put(id,oldMsg);
            }
        }
    }

    @Override
    public String listConnected() throws RemoteException {
        return listConnect.keySet().toString();
    }

    @Override
    public void connect(String id, IClient client) throws RemoteException {
        listConnect.put(id,client);
        System.out.println("connect " + id);
    }

    @Override
    public void Subscribe(String id) throws RemoteException {
        subscibded.get(id);
        IClient client = null;
        String msg = "";
        int i = 0;
        send(msg, id);
        i++;
        client.notifier("" + i);
    }

    @Override
    public void createGroup(String idGroup, String idAdmin) throws RemoteException {
        if(create.containsKey(idAdmin))
            throw new RemoteException("client already existe");
        create.put(idGroup, idAdmin);
    }

    @Override
    public void sendToClient(String id, String msg) throws RemoteException {
        IClient cl = listConnect.get(id);
        if(cl != null)
            cl.notifier(msg);
        else{
            String oldMsg = offline.get(id);
            if(oldMsg == null){
                oldMsg += "" + msg;
                offline.put(id,oldMsg);
            }
        }
    }

    @Override
    public void sendToGroup(String idGroup, String msg) throws RemoteException {
        IGroup cl = groupConnected.get(idGroup);
        if(cl != null)
//            cl.(msg);
            System.out.println("");
        else{
            String oldMsg = offline.get(idGroup);
            if(oldMsg == null){
                oldMsg += "" + msg;
                offline.put(idGroup,oldMsg);
            }
        }
    }

    @Override
    public void Broadcast(String msg) throws RemoteException {
        IGroup g  = (IGroup)listConnect.keySet();
        g.sendToAll(msg);
    }

    @Override
    public void getAllClients() throws RemoteException {
        listConnect.keySet().toString();
    }
}