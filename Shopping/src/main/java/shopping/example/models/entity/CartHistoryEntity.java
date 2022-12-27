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
@Table(name="carthistory")
public class CartHistoryEntity {
	public CartHistoryEntity(Long itemId, int num, Long cartId) {
		this.itemId = itemId;
		this.num = num;
		this.cartId = cartId;
	}
	public CartHistoryEntity(Long cartHistoryId, int num) {
		this.cartHistoryId = cartHistoryId;
		this.num = num;
		
	}
	@Id
	@Column(name="carthistory_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartHistoryId;
	
	@Column(name="item_id")
	private Long itemId;
	
	@Column(name="num")
	private int num;
	
	@Column(name="cart_id")
	private Long cartId;
}

