package project.lechongori.commons.domains.entity.salesProduct;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.lechongori.commons.domains.entity.product.ProductEntity;
import project.lechongori.commons.domains.entity.sales.SalesEntity;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sales_product_lechongori")
public class SalesProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private SalesEntity salesEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @Column(name = "amount_sales_product")
    private int amount;
}
