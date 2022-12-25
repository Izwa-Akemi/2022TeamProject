package shopping.example.models.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class AdminAccountEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private int id;
    @Column(name = "admin_name")

    private String username;
    @Column(name = "password")
    private String password;

    public AdminAccountEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AdminAccountEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

