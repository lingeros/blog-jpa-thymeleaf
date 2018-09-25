package net.togogo.blogjpathymeleaf.repository;



import net.togogo.blogjpathymeleaf.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


/**
 * @author ling
 * @date 2018/9/19  14:20
 * @function:
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 根据用户姓名分页查询用户列表
     * @param username
     * @param pageable
     * @return
     */
    Page<User> findByUsernameLike(String username,Pageable pageable);


    /**
     * 根据用户账号查询用户
     * @param username
     * @return
     */
    User findByUsername(String username);

}
