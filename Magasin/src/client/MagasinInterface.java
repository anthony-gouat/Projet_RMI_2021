package client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MagasinInterface extends Remote {
    public boolean connexionClient(String username, String pwd) throws RemoteException;
    public ArrayList<String[]> afficheArticle() throws RemoteException;
}
