package org.project.logic.Control;

import org.project.logic.Bean.LoginBean;
import org.project.logic.Model.Fornitore;
import org.project.logic.Model.User;
import org.project.logic.Model.Utente;
import org.project.logic.persistence.DaoFactory;
import org.project.logic.persistence.UserDao;


public class LoginController {

    private static LoginController instance;

    private User currentUser;

    private LoginController() {}

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    // Login Fallito -> 0; Utente -> 1; Fornitore -> 2
    public int validateLogin(LoginBean lb) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();

        if(userDao.exists(lb.getEmail())) {

            User user = userDao.load(lb.getEmail());

            if (user != null && user.getPassword().equals(lb.getPassword())) {
                currentUser = user;
                if(user instanceof Utente) {
                    return 1;
                } else if (user instanceof Fornitore) {
                    return 2;
                }
            }
        }
        return 0;
    }


    public boolean register(LoginBean lb) {

        UserDao userDao = DaoFactory.getInstance().getUserDao();

        if(!userDao.exists(lb.getEmail())){

            User user = userDao.create(lb.getEmail());

            if(lb.getRole() == 0){ // Utente

                Utente u = new Utente(user);

                u.setNome(lb.getNome());
                u.setCognome(lb.getCognome());
                u.setPassword(lb.getPassword());
                u.setTelefono(lb.getTelefono());

                userDao.store(u);
                return true;
            } else if(lb.getRole() == 1) { // Fornitore

                Fornitore f = new Fornitore(user);

                f.setNome(lb.getNome());
                f.setCognome(lb.getCognome());
                f.setPassword(lb.getPassword());
                f.setTelefono(lb.getTelefono());

                userDao.store(f);
                return true;
            }

        }
        return false;
    }
}
