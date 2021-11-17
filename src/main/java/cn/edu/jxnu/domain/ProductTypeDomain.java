package cn.edu.jxnu.domain;

public class ProductTypeDomain {
    private int bookTypeId;
    private String bookTypeName;
    private int bookTypeSaleNum;  //销售数量



    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public int getBookTypeSaleNum() {
        return bookTypeSaleNum;
    }

    public void setBookTypeSaleNum(int bookTypeSaleNum) {
        this.bookTypeSaleNum = bookTypeSaleNum;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    @Override
    public String toString() {
        return "ProductTypeDomain{" +
                "bookTypeId=" + bookTypeId +
                ", bookTypeName='" + bookTypeName + '\'' +
                ", bookTypeSaleNum=" + bookTypeSaleNum +
                '}';
    }
}
