import java.rmi.RemoteException;
import java.sql.*;

public class Magasin {

    private Connection conn = null;
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3307/";
    static final String DB = "projet_rmi_magasin_1";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public Magasin() throws RemoteException {
        super();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
//            Class.forName("org.mariadb.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(
                    DB_URL+DB, USER, PASS);
            System.out.println("Connected database successfully...");
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    /*
    Vérifie les identifiant utilisateur
    @param username : Le nom d'utilisateur saisi
    @param pwd : Le mot de passe de l'utilisateur
    @return true si les identifiants sont correct
    @return false si les identifiants sont incorrect
     */
    public boolean connexionClient(String username, String pwd) {
        PreparedStatement stmt = null;

        try {
            //STEP 4 : Execute a query
            System.out.println("SELECT USER");

            String req = "SELECT identifiant, password FROM utilisateur where identifiant = ? AND password = ?";
            stmt = conn.prepareStatement(req);
            stmt.setString(1, username);
            stmt.setString(2, pwd);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                String nomUtil = result.getString("identifiant");
                String mdp = result.getString("password");
                if (nomUtil.equals(username) && mdp.equals(pwd)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
