package fr.instic.cadeaux.dao;

import fr.instic.cadeaux.business.User;

import java.util.List;

/**
 * Created by mickaelvillers on 09/02/2017.
 */
public interface UserDao {
    List<User> findAll();

    User findById(int id);

    User addUser(User user);

    User findByEmailAndPassword(String email, String motDePasse);

    void changePassword(String email, String password);

    }
