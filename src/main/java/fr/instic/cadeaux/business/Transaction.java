package fr.instic.cadeaux.business;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDate;

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

    @OneToMany
    private TransactionType type;



    public int getId() {
        return id;
    };

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


    public float montantDate(Date date)
    {
        LocalDate  a = LocalDate.of(this.date.getYear(), this.date.getMonth(), this.date.getDay());
        LocalDate  b = LocalDate.of(date.getYear() , date.getMonth(), date.getDay());
        switch (this.type.getId())
        {
            case 1:  if(a==b)return amount; // transaction unique
                        else return 0 ;
                break;
            case 2:   if(a.getDayOfMonth()==b.getDayOfMonth())return amount; // transaction mesuel
                        else return 0 ;
                break;
            case 3:  if(a.getDayOfMonth()==b.getDayOfMonth()&& a.getMonthValue()==b.getMonthValue())return amount; // transaction annuel
                break;
            default: return 0;
        }
    }
}
