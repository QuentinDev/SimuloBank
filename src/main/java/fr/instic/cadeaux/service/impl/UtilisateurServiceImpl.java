package fr.instic.cadeaux.service.impl;

import fr.instic.cadeaux.business.User;
import fr.instic.cadeaux.dao.UserDao;
import fr.instic.cadeaux.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<User> recupereUsers() {
		return userDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public User recupereUserById(int id) {
		return userDao.findById(id);
	}

	@Transactional
	@Override
	public User ajouterUtilisateur(User user) {
		return userDao.addUser(user);
	}

	@Transactional
	@Override
	public void changePasswordForUser(String email, String password) {
        userDao.changePassword(email, password);
	}

    @Transactional(readOnly = true)
    @Override
    public User verrifierUtilisateur(String email, String motDePasse) {
        return userDao.findByEmailAndPassword(email, motDePasse);
    }

}
