package Entity;

public class Book {
    private int isbn;
    private String title;
    private String author;
    private double price;
    private String publishDate;
    private String cover;
    private String details;
    private int cid;

    private Categories categories;


    public Book(){}

    public Book(String title, String author, double price, String publishDate, String cover, String details, int cid) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
        this.cover = cover;
        this.details = details;
        this.cid=cid;
    }


    public Book(int isbn, String title, String author, double price, String publishDate, String cover, String details, int cid) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
        this.cover = cover;
        this.details = details;
        this.cid=cid;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publishDate='" + publishDate + '\'' +
                ", cover='" + cover + '\'' +
                ", details='" + details + '\'' +
                ", cid=" + cid +
                ", categoriescid=" + categories.getCid() +
                ", categoriescname=" + categories.getCname() +
                '}';
    }
}
