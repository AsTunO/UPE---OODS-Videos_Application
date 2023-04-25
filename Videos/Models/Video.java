package Videos.Models;

import java.util.Date;

public class Video {
    private String name;
    private User publisher;
    private Date publishedDate;

    public Video(String name, User u) {
        this.name = name;
        this.publisher = u;
        this.publishedDate = new Date();
    }

    public Video(String name, User u, Date d) {
        this.name = name;
        this.publisher = u;
        this.publishedDate = d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", publisher='" + getPublisher().getName() + "'" +
                ", published date='" + getPublishedDate() + "'" +
                "}";
    }
}