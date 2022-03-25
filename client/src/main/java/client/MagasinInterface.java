package client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MagasinInterface extends Remote {
    public int connexionClient(String username, String pwd) throws RemoteException; // Connexion au magasin retourne l'id du panier du client
    public ArrayList<String[]> afficheArticle() throws RemoteException; // renvoie la liste des articles du magasin
    public ArrayList<String[]> afficheArticlesPanier(int idpanier) throws RemoteException; // renvoie la liste des articles du panier
    public void setArticlePanier(int idPanier,int idArticle,int qte) throws RemoteException; // Met un article dans le panier pour un quantité donné
    void ajouteArticlePanier(int idPanier, int idArticle) throws RemoteException; // ajoute l'article dans le panier
    public void suppressionPanier(int idPanier) throws RemoteException; // vide le panier
    public int passerCommande(String nom,String numero, String dateexpiration,String crypto, float total) throws RemoteException; // Passe la commande
}
