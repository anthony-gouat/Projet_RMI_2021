import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MagasinInterface extends Remote {
    public boolean connexionClient(String username, String pwd) throws RemoteException;
}
