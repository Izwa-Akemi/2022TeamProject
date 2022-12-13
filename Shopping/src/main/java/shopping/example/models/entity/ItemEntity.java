package shopping.example.models.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity {
	public ItemEntity(String itemName, int cateId, String image, int price, int stock, String detail, Integer adminId) {
		this.itemName = itemName;
		this.cateId = cateId;
		this.image = image;
		this.price = price;
		this.stock = stock;
		this.detail = detail;
		this.adminId = adminId;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long itemId;
	
	@NonNull
	@Column(name = "item_name")
	private String itemName;

	@Column(name = "category_id")
	private Integer cateId;

	@Column(name = "image")
	private String image;
	
	@NonNull
	@Column(name = "price")
	private Integer price;

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "detail")
	private String detail;

	@Column(name = "active")
	private Integer active;

	@Column(name = "admin_id")
	private Integer adminId;
}
