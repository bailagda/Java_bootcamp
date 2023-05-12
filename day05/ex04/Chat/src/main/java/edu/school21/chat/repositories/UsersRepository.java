package edu.school21.chat.repositories;

import edu.school21.chat.models.User;

import java.util.List;

public interface UsersRepository {
//    SINGLE
    List<User> findAll(int page, int size);
}
