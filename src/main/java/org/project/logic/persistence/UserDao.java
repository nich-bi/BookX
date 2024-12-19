package org.project.logic.persistence;
import org.project.logic.model.User;


public interface UserDao extends Dao<String, User>{
    User create(String email);
}

