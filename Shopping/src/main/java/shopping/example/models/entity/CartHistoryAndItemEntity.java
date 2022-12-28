package shopping.example.models.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CartHistoryAndItemEntity {
	@Id
	@Column(name="item_id")
	private Long itemId;

	@Column(name="cart_id")
	private Long cartId;

	@Column(name="num")
	private int num;

	@Column(name="item_name")
	private String itemName;

	@Column(name="image")
	private String image;

	@Column(name="price")
	private Integer price;

	@Column(name="stock")
	private Integer stock;

	@Column(name="detail")
	private String detail;
}