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
@Table(name="orders")
public class OrderEntity {
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="order_date")
	private String orderDate;
}

