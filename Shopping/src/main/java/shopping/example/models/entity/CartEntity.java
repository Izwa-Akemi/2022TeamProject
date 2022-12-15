package shopping.example.models.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart")
public class CartEntity {
	public CartEntity(Long userId, String cartDate) {
		this.userId = userId;
		this.cartDate = cartDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cart_id")
	private Long cartId;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="cart_date")
	private String cartDate;
}
