package fr.instic.cadeaux.business;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Quentin on 20/03/2017.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    private float balance;

    @ManyToOne
    private Type type;

    private Date creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactionbank() {
        return transactions;
    }

    public void setTransactionbank(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", type='" + type + '\'' +
                ", transactions='" + transactions + '\'' +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                '}';
    }

    
}
