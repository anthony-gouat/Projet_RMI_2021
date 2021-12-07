public class Article {

    //attributs privé
    private int id, type_article_id, stock;
    private String nom, lien_image, description;
    private double prix;

    public Article(int idA, String lien_imageA, String nomA, double prixA, String descriptionA, int type_article_idA, int stockA) {
        this.id = idA;
        this.lien_image = lien_imageA;
        this.nom = nomA;
        this.prix = prixA;
        this.description = descriptionA;
        this.type_article_id = type_article_idA;
        this.stock = stockA;
    }

    public int getId() {
        return id;
    }
}
