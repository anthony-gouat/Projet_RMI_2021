package client;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MagasinInterface extends Remote {
    public int connexionClient(String username, String pwd) throws RemoteException;
    public ArrayList<String[]> afficheArticle() throws RemoteException;
    public ArrayList<String[]> afficheArticlesPanier(int idpanier) throws RemoteException;
    public void setArticlePanier(int idPanier,int idArticle,int qte) throws RemoteException;
    void ajouteArticlePanier(int idPanier, int idArticle) throws RemoteException;
    public void suppressionPanier(int idPanier) throws RemoteException;
    public int passerCommande(String nom,String numero, String dateexpiration,String crypto, float total) throws RemoteException;
}
