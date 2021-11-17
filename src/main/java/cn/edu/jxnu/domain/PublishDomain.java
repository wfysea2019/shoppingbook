package cn.edu.jxnu.domain;

public class PublishDomain {
    private long publishingId;
    private String publishingName;
    public String getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(String publishingName) {
        this.publishingName = publishingName;
    }

    public long getPublishingId() {
        return publishingId;
    }

    public void setPublishingId(long publishingId) {
        this.publishingId = publishingId;
    }

    @Override
    public String toString() {
        return "PublishDomain{" +
                "publishingId=" + publishingId +
                ", publishingName='" + publishingName + '\'' +
                '}';
    }
}
