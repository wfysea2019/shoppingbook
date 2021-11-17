package cn.edu.jxnu.domain;

import java.util.Date;

public class ProductDomain {

    private long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookImage;
//    private long bookTypeId;
//    private String bookTypeName;
    private ProductTypeDomain productTypeDomain;
    private float price;
    private float discount;
    private Date bookPublishTime;
    private String bookIntroduction;
//    private long publishingId;
//    private String publishingName;
    private PublishDomain publishDomain;
    private String bookIsbn;


    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public ProductTypeDomain getProductTypeDomain() {
        return productTypeDomain;
    }

    public void setProductTypeDomain(ProductTypeDomain productTypeDomain) {
        this.productTypeDomain = productTypeDomain;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Date getBookPublishTime() {
        return bookPublishTime;
    }

    public void setBookPublishTime(Date bookPublishTime) {
        this.bookPublishTime = bookPublishTime;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }

    public PublishDomain getPublishDomain() {
        return publishDomain;
    }

    public void setPublishDomain(PublishDomain publishDomain) {
        this.publishDomain = publishDomain;
    }

    @Override
    public String toString() {
        return "ProductDomain{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", productTypeDomain=" + productTypeDomain +
                ", price=" + price +
                ", discount=" + discount +
                ", bookPublishTime='" + bookPublishTime + '\'' +
                ", bookIntroduction='" + bookIntroduction + '\'' +
                ", publishDomain=" + publishDomain +
                '}';
    }
}
