package shopping.example.models.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "category_id")
    private int cateId;
    @Column(name = "image")
    private String image;
    @Column(name = "price")
    private int price;
    @Column(name = "stock")
    private int stock;
    @Column(name = "detail")
    private String detail;
    @Column(name = "active")
    private int active;
    @Column(name = "admin_id")
    private int adminId;
}
