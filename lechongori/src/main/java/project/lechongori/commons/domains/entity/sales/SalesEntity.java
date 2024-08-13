package project.lechongori.commons.domains.entity.sales;

import jakarta.persistence.*;
import lombok.*;
import project.lechongori.commons.domains.entity.product.ProductEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "sales_product",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> productEntityList = new ArrayList<>();

    @Column(name = "sale_date")
    private LocalDate saleDate;

    @Column(name = "sale_total_value")
    private Double SaleTotalValue;
}