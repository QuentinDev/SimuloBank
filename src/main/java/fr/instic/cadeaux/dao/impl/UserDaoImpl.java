package fr.instic.cadeaux.dao.impl;

import fr.instic.cadeaux.business.User;
import fr.instic.cadeaux.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<User> findAll() {
		return sf.getCurrentSession().createQuery("from User", User.class).getResultList();
	}

	@Override
	public User findById(int id) {
		return sf.getCurrentSession().byId(User.class).load(id);
	}

	@Override
	public User addUser(User user){
		sf.getCurrentSession().save(user);

		return user;
	}

	@Override
	public void changePassword(String email, String password){
        sf.getCurrentSession().createQuery("update User set password = :password where email=:email")
                .setParameter("email", email)
                .setParameter("password", password)
                .executeUpdate();
	}

	@Override
	public User findByEmailAndPassword(String email, String motDePasse) {
		List<User> user = sf.getCurrentSession().createQuery("from User WHERE email=:email AND password=:password", User.class)
				.setParameter("email", email)
				.setParameter("password", motDePasse)
				.getResultList();

		if (user.isEmpty()) {
			return null;
		} else {
			return user.get(0);
		}

	}
}
