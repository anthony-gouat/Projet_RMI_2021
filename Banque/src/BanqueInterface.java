import java.rmi.RemoteException;

public interface BanqueInterface extends java.rmi.Remote {
    public boolean verifSoldeClient(String nom,String numero, String dateexpiration, String cryptogramme, float montant) throws RemoteException;
    public boolean debite(String nom,String numero, String dateexpiration, String cryptogramme, float montant,String magasin) throws RemoteException;
}