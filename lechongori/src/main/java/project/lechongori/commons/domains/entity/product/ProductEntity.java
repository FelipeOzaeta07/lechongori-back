package project.lechongori.commons.domains.entity.product;

import jakarta.persistence.*;
import lombok.*;
import project.lechongori.commons.domains.dto.product.ProductTypes;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_lechongori")
public class ProductEntity {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "product_images")
    private String[] productImages;

    @Column(name = "product_type")
    private ProductTypes productType;
}
