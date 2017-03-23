package fr.instic.cadeaux.business;

import javax.jws.soap.SOAPBinding;
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

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<Transaction> transactions;

    private float balance;

    private int rate;

    @ManyToOne
    private AccountType accountType;

    private Date creationDate;

    public Account() {
        super();
    }

    public Account(User user, int balance, String name, AccountType accountType, Date creationDate) {
        this.user = user;
        this.balance = balance;
        this.name = name;
        this.accountType = accountType;
        this.creationDate = creationDate;
    }

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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountType='" + accountType + '\'' +
                ", transactions='" + transactions + '\'' +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                ", rate=" + rate +
                '}';
    }

    public List<MontantDate> calculBudget(Date date)
    {   float balancetemp=this.balance;
        Date now=new Date();
        List<MontantDate> montantDateList = null;

        while (now.compareTo(date) == -1){
            int i=0;
            for (Transaction transaction: this.transactions )
            {
                balancetemp=balancetemp+transaction.montantDate(now);
                
            }

          montantDateList.add(new MontantDate(now,balancetemp));
            now.setDate(now.getDate()+1);
        }

        return montantDateList;

    }


}
