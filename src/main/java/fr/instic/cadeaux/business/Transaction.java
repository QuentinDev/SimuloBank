package fr.instic.cadeaux.business;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Transaction
{
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

    public Transaction() {
        super();
    }

    public Transaction(Account account, String libelle, Date date, int amount, TransactionType transactionType) {
        this.account = account;
        this.libelle = libelle;
        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;
    }

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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }


    public float montantDate(Date date)  {
        LocalDate  a = LocalDate.of(this.date.getYear(), this.date.getMonth(), this.date.getDay());
        LocalDate  b = LocalDate.of(date.getYear() , date.getMonth(), date.getDay());
        switch (this.transactionType.getId())
        {
            case 1:
                if(a==b)
                    return amount; // transaction unique

                break;
            case 2:
                if(a.getDayOfMonth()==b.getDayOfMonth())
                    return amount; // transaction mensuelle

                break;
            case 3:
                if(a.getDayOfMonth()==b.getDayOfMonth()&& a.getMonthValue()==b.getMonthValue())
                    return amount; // transaction annuelle;
                break;
            default:
                return 0;
        }
        return 0;
    }

}
