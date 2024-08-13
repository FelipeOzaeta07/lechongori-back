package project.lechongori.commons.domains.entity.sales;

import jakarta.persistence.*;
import lombok.*;
import project.lechongori.commons.domains.entity.product.ProductEntity;

import java.time.LocalDate;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sales_lechongori")
public class SalesEntity {
    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleId;

    /*
    @ElementCollection
    @CollectionTable(name = "product_lechongori", joinColumns = @JoinColumn(name = "sale_id"))
    @Column(name = "sale_product")
    private ProductEntity saleProduct;
*/
    @Column(name = "sale_amount")
    private Integer saleAmountForProduct;

    @Column(name = "sale_date")
    private LocalDate saleDate;

    @Column(name = "sale_total_value")
    private Double SaleTotalValue;
}