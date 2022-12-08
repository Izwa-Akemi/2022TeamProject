package shopping.example.models.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="user")
public class UserEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NonNull
	@Column(name="username")
	private String userName;
	
//	@NonNull
//	@Column(name="user_email")
//	private String userEmail;

	@NonNull
	@Column(name="password")
	private String password;
}