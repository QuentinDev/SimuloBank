package fr.instic.cadeaux.business;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Quentin on 08/02/2017.
 */
@Entity
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Article article;

    private int quantity;

    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", user=" + user +
                ", article=" + article +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
