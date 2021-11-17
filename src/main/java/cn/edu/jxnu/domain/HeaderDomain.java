package cn.edu.jxnu.domain;

public class HeaderDomain {
    private int headerId;
    private String img;

    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "HeaderDomain{" +
                "headerId=" + headerId +
                ", img='" + img + '\'' +
                '}';
    }
}
