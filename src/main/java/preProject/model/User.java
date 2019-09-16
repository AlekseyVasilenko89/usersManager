package preProject.model;

import javax.persistence.*;

@Entity
@Table(name = "spring_users")
public class User {

    @Id
    @Column(table = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(table = "name")
    private String name;

    @Column(table = "age")
    private Integer age;

    @Column(table = "password")
    private String password;

    @Column(table = "role")
    private String role;

    public User() {
    }

    public User(String name, Integer age, String password, String role) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    public User(Integer id, String name, Integer age, String password, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                getName().equals(user.getName()) &&
                getPassword().equals(user.getPassword())&&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
