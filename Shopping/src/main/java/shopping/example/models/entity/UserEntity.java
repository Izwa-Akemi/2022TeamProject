package shopping.example.models.entity;

import java.sql.Date;

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
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NonNull
	@Column(name="user_name")
	private String userName;
	
	@NonNull
	@Column(name="user_email")
	private String userEmail;

	@NonNull
	@Column(name="password")
	private String password;
	
	
	@Column(name="pref_id")
	private Integer prefId;
	
	
	@Column(name="zip_code")
	private String zipCode;
	

	@Column(name="address")
	private String address;
	

	@Column(name="active")
	private Integer active;
	
	
	@Column(name="register_date")
	private Date register_date;
	
}