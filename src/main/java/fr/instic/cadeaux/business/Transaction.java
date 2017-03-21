package fr.instic.cadeaux.business;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Quentin on 20/03/2017.
 */
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Account account;

    private String libelle;

    private Date date;

    private float amount;

    @ManyToOne
    private TransactionType transactionType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", libelle='" + libelle + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
