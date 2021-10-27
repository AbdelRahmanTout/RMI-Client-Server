package projectinfo438;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainServer {
    public static void main(String[] args) {
        try {
            IServer ser = new ServerImp();
            Naming.rebind("rmi://127.0.0.1:2000/ser",ser);
        } catch (RemoteException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}