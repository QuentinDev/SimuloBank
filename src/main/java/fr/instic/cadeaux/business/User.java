package fr.instic.cadeaux.business;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {
    private static final int INITIAL_BALANCE = 15000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;

    private String prenom;

    private int balance;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<Command> commands;

    @Column(unique = true)
    @Email
    private String email;

    @Size(min=5, message = "Merci d'utiliser au moins 5 caracteres")
    private String password;

    public User() {
        super();
    }

    public User(String firstname, String prenom, String email, String password, City city) {
        this.firstname = firstname;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.city = city;
        this.balance = INITIAL_BALANCE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", prenom='" + prenom + '\'' +
                ", balance=" + balance +
                ", commands=" + commands +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
