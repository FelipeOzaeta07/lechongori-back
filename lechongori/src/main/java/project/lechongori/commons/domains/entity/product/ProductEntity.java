package project.lechongori.commons.domains.entity.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "product_image")
    private List<String> productImages;

    @Enumerated
    @Column(name = "product_type")
    private ProductTypes productType;
}