package fr.instic.cadeaux.business;

import javax.persistence.*;


import java.text.SimpleDateFormat;
import java.util.Date;


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
                ", date='" + date + '\'' +
                '}';
    }


    public float montantDate(Date date)  {

        Date a=this.date;
        Date b=date;
        SimpleDateFormat formater = new SimpleDateFormat("dd");

        switch (this.transactionType.getId())
        {
            case 1:
                if(a.getMonth()==b.getMonth()&&a.getYear()==b.getYear()&& formater.format(b).equals(formater.format(a)))
                {
                    return this.amount+10; }//transaction unique
                break;
            case 2:
                if(formater.format(b).equals(formater.format(a)))
                {
                    return this.amount+10; }// transaction mensuelle
                break;
            case 3:
                if(a.getMonth()==b.getMonth()&& formater.format(b).equals(formater.format(a)))
                {
                    return this.amount+10; // transaction annuelle;
                }
                break;
            default:

                return 0;
        }
        return 0;
    }

}
