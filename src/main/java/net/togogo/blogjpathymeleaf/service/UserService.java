package net.togogo.blogjpathymeleaf.service;

import net.togogo.blogjpathymeleaf.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author ling
 * @date 2018/9/20  19:44
 * @function:
 */
public interface UserService {

    /**
     * 新增，编辑，保存用户
     * @param user
     * @return
     */
    User saveOrUpdate(User user);


    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);


    /**
     * 删除用户
     * @param id
     */
    void removeUser(Long id);

    /**
     *根据id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);


    /**
     * 根据用户名进行分页模糊查询
     * @param username
     * @param pageable
     * @return
     */
    Page<User> listUsersByNameLike(String username,Pageable pageable);


















}
