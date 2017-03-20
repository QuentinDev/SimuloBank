package fr.instic.cadeaux.service;

import fr.instic.cadeaux.business.User;

import java.util.List;

/**
 * Created by Quentin on 09/02/2017.
 */
public interface UtilisateurService {
    List<User> recupereUsers();

    User recupereUserById(int id);

    User ajouterUtilisateur(User user);

    User verrifierUtilisateur(String email, String motDePasse);

    void changePasswordForUser(String email, String password);
}
