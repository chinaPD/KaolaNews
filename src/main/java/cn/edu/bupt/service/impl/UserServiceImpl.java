package cn.edu.bupt.service.impl;

import cn.edu.bupt.domain.User;
import cn.edu.bupt.repository.UserRepository;
import cn.edu.bupt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by PD on 2017/5/3.
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User save(final User user) {
        return repository.save(user);
    }
}
