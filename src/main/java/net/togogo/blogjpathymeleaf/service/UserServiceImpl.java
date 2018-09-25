package net.togogo.blogjpathymeleaf.service;

import net.togogo.blogjpathymeleaf.bean.User;
import net.togogo.blogjpathymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author ling
 * @date 2018/9/20  19:48
 * @function:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }
    @Transactional
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
    @Transactional
    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> listUsersByNameLike(String username, Pageable pageable) {
        username = "%" + username + "%";
        Page<User> users = userRepository.findByUsernameLike(username,pageable);
        return users;
    }





}



















































