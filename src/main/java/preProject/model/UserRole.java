package preProject.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class UserRole implements GrantedAuthority  {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToMany
    @JoinTable(name="users_roles",
            joinColumns=@JoinColumn(name="roles_id"),
            inverseJoinColumns=@JoinColumn(name="users_id"))
    private List<User> users;


    public UserRole() {
    }

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }

    public void setAuthority(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUser() {
        return users;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }


}
