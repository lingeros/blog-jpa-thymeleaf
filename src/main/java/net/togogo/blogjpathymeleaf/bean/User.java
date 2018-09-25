package net.togogo.blogjpathymeleaf.bean;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author ling
 * @date 2018/9/19  14:12
 * @function:
 */
@Entity
public class User {
    /*****************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*****************************************************************************/
    @NotEmpty(message = "账号不能为空")
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20, unique = true)
    private String username;//用户账号，唯一

    /*****************************************************************************/
    @NotEmpty(message = "邮箱不能为空")
    @Size(max = 50)
    @Email(message = "邮箱格式不对")
    @Column(nullable = false, length = 50, unique = true)
    private String email;//邮箱


    /*****************************************************************************/
    @NotEmpty(message = "密码不能为空")
    @Size(max = 100)
    @Column(length = 100)
    private String password;//密码


    /*****************************************************************************/
    @Column(length = 200)
    private String avatar;//头像

    protected User() {
    }

    public User(@NotEmpty(message = "账号不能为空") @Size(min = 3, max = 20) String username, @NotEmpty(message = "邮箱不能为空") @Size(max = 50) @Email(message = "邮箱格式不对") String email, @NotEmpty(message = "密码不能为空") @Size(max = 100) String password) {

        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
