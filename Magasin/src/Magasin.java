import client.MagasinInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;

public class Magasin extends UnicastRemoteObject implements MagasinInterface {

    private Connection conn = null;
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/";
    private String nommag = "";
    //  Database credentials
    static final String USER = "agouat2";
    static final String PASS = "";

    //attribut
    ArrayList<Article> lesArticles;
    ArrayList<Article> panier;

    BanqueInterface banque=null;

    public Magasin(String db,String nommag) throws RemoteException, MalformedURLException, NotBoundException {
        super();
        this.nommag=nommag;
        lesArticles = new ArrayList<Article>();
        panier = new ArrayList<Article>();
        int port = 8810;
        banque = (BanqueInterface) Naming.lookup("rmi://127.0.0.1:" + port + "/banque");
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
//            Class.forName("org.mariadb.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(
                    DB_URL+ db, USER, PASS);
            System.out.println("Connected database successfully...");
        } catch (Exception se) {
            se.printStackTrace();
        }
        recupereArticle();
    }

    /**
     * Vérifie l'identifiant et le mot de passe saisie par l'utilisateur
     * @param username
     * @param pwd
     * @return true si les champs saisie correspondent
     */
    @Override
    public int connexionClient(String username, String pwd) {
        PreparedStatement stmt = null;

        try {
            System.out.println("Connexion de : "+username);

            String req = "SELECT identifiant, password ,panier_id FROM utilisateur where identifiant = ? AND password = ?";
            stmt = conn.prepareStatement(req);
            stmt.setString(1, username);
            stmt.setString(2, pwd);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                String nomUtil = result.getString("identifiant");
                String mdp = result.getString("password");
                int id = result.getInt("panier_id");
                if (nomUtil.equals(username) && mdp.equals(pwd)) {
                    return id;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<String[]> afficheArticle() throws RemoteException {
        Statement stmt = null;

        try {
            //STEP 4 : Execute a query
            System.out.println("SELECT * ARTICLE MAGASIN");
            stmt = conn.createStatement();

            String req = "SELECT * FROM article";

            ResultSet result = stmt.executeQuery(req);
            ArrayList<String[]> listart = new ArrayList<>();
            while (result.next()) {
                String id = String.valueOf(result.getInt("id"));
                String lien_image = result.getString("lien_image");
                String nom = result.getString("nom");
                String prix = String.valueOf(result.getDouble("prix"));
                String description = result.getString("description");
                String type_article_id = String.valueOf(result.getInt("type_article_id"));
                String stock  = String.valueOf(result.getInt("stock"));
                String[] article = {id,lien_image,nom,prix,description,type_article_id,stock};
                listart.add(article);
            }
            return listart;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<String[]> afficheArticlesPanier(int idpanier) throws RemoteException {
        PreparedStatement stmt = null;

        try {
            System.out.println("SELECT * ARTICLE panier");
            String req = "SELECT *,ligne_panier.quantite as quantite FROM article " +
                    "JOIN ligne_panier ON ligne_panier.article_id=article.id " +
                    "WHERE ligne_panier.panier_id=?";
            stmt = conn.prepareStatement(req);
            stmt.setInt(1,idpanier);
            ResultSet result = stmt.executeQuery();
            ArrayList<String[]> listart = new ArrayList<>();
            while (result.next()) {
                String id = String.valueOf(result.getInt("id"));
                String lien_image = result.getString("lien_image");
                String nom = result.getString("nom");
                String prix = String.valueOf(result.getDouble("prix"));
                String description = result.getString("description");
                String type_article_id = String.valueOf(result.getInt("type_article_id"));
                String stock  = String.valueOf(result.getInt("stock"));
                String quantite  = String.valueOf(result.getInt("quantite"));
                String[] article = {id,lien_image,nom,prix,description,type_article_id,stock,quantite};
                listart.add(article);
            }
            return listart;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setArticlePanier(int idPanier, int idArticle, int qte) throws RemoteException {
        PreparedStatement stmt = null;
        PreparedStatement set = null;
        try {
            System.out.println("Regarde si dans panier");
            String reqArtDansPanier = "SELECT * FROM ligne_panier WHERE panier_id=? AND article_id=?";
            stmt = conn.prepareStatement(reqArtDansPanier);
            stmt.setInt(1,idPanier);
            stmt.setInt(2,idArticle);
            ResultSet result = stmt.executeQuery();
            int diffstock=-qte;
            if(result.next()){
                diffstock+= result.getInt("quantite");
                if(qte>0){
                    System.out.println("Update article dans panier");
                    String reqArtupdate = "UPDATE ligne_panier SET quantite=? WHERE panier_id=? AND article_id=?";
                    set = conn.prepareStatement(reqArtupdate);
                    set.setInt(1,qte);
                    set.setInt(2,idPanier);
                    set.setInt(3,idArticle);
                    set.executeUpdate();
                }else{
                    System.out.println("Delete article dans panier");
                    String reqArtdelet = "DELETE FROM ligne_panier WHERE panier_id=? AND article_id=?";
                    set = conn.prepareStatement(reqArtdelet);
                    set.setInt(1,idPanier);
                    set.setInt(2,idArticle);
                    set.executeUpdate();
                }

            }else if(qte>0){
                System.out.println("Insert article: "+ idArticle+" dans le panier : "+idPanier+ " qte : "+qte);
                String reqArtInsert = "INSERT INTO ligne_panier(quantite,article_id,panier_id) VALUES(?, ?, ?)";
                set = conn.prepareStatement(reqArtInsert);
                set.setInt(1,qte);
                set.setInt(2,idArticle);
                set.setInt(3,idPanier);
                set.executeUpdate();
            }
            PreparedStatement getstock = null;
            System.out.println("Update stock article");
            String reqArtStock = "SELECT * FROM article WHERE id=?";
            getstock = conn.prepareStatement(reqArtStock);
            getstock.setInt(1,idArticle);
            ResultSet res = getstock.executeQuery();

            if(res.next()){
                int stock = res.getInt("stock");
                stock+=diffstock;
                PreparedStatement majstock = null;
                System.out.println("Update stock article");
                String reqArtStockUpdate = "UPDATE article SET stock=? WHERE id=?";
                majstock = conn.prepareStatement(reqArtStockUpdate);
                majstock.setInt(1,stock);
                majstock.setInt(2,idArticle);
                majstock.executeUpdate();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouteArticlePanier(int idPanier, int idArticle) throws RemoteException {
        PreparedStatement stmt = null;
        PreparedStatement set = null;
        try {
            System.out.println("Regarde si dans panier");
            String reqArtDansPanier = "SELECT * FROM ligne_panier WHERE panier_id=? AND article_id=?";
            stmt = conn.prepareStatement(reqArtDansPanier);
            stmt.setInt(1,idPanier);
            stmt.setInt(2,idArticle);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                    System.out.println("Update article dans panier");
                    String reqArtupdate = "UPDATE ligne_panier SET quantite=(quantite+1) WHERE panier_id=? AND article_id=?";
                    set = conn.prepareStatement(reqArtupdate);
                    set.setInt(1,idPanier);
                    set.setInt(2,idArticle);
                    set.executeUpdate();

            }else{
                System.out.println("Insert article: "+ idArticle+" dans le panier : "+idPanier);
                String reqArtInsert = "INSERT INTO ligne_panier(quantite,article_id,panier_id) VALUES(?, ?, ?)";
                set = conn.prepareStatement(reqArtInsert);
                set.setInt(1,1);
                set.setInt(2,idArticle);
                set.setInt(3,idPanier);
                set.executeUpdate();
            }

            PreparedStatement majstock = null;
            System.out.println("Update stock article");
            String reqArtStockUpdate = "UPDATE article SET stock=(stock-1) WHERE id=?";
            majstock = conn.prepareStatement(reqArtStockUpdate);
            majstock.setInt(1,idArticle);
            majstock.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suppressionPanier(int idPanier) throws RemoteException {
        PreparedStatement stmt = null;
        try {
            System.out.println("Supprime le panier");
            String reqArtDansPanier = "DELETE FROM ligne_panier WHERE panier_id=?";
            stmt = conn.prepareStatement(reqArtDansPanier);
            stmt.setInt(1, idPanier);
            stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
    public int passerCommande(String nom,String numero, String dateexpiration, String crypto, float total) throws RemoteException {
        if(!banque.verifSoldeClient(nom,numero,dateexpiration,crypto,total)){
            return 1;
        }else if(!banque.debite(nom,numero,dateexpiration,crypto,total,this.nommag)){
            return 2;
        }
        return 0;
    }

    /**
     * Récupère tout les articles connus dans la BDD pour 1 magasin
     * @return liste de tout les articles du magasin
     * @throws RemoteException
     */
    public ArrayList<Article> recupereArticle() throws RemoteException {
        Statement stmt = null;

        try {
            //STEP 4 : Execute a query
            System.out.println("SELECT ARTICLE MAGASIN");
            stmt = conn.createStatement();

            String req = "SELECT * FROM article";

            ResultSet result = stmt.executeQuery(req);

            while (result.next()) {
                int id = result.getInt("id");
                String lien_image = result.getString("lien_image");
                String nom = result.getString("nom");
                double prix = result.getDouble("prix");
                String description = result.getString("description");
                int type_article_id = result.getInt("type_article_id");
                int stock  = result.getInt("stock");

                Article a = new Article(id, lien_image, nom, prix, description, type_article_id, stock);
                lesArticles.add(a);

            }
            return lesArticles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
