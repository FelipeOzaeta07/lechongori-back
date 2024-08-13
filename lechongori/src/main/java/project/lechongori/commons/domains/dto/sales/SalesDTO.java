package project.lechongori.commons.domains.dto.sales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.lechongori.commons.domains.entity.product.ProductEntity;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesDTO implements Serializable {
    private Integer saleId;
    private ProductEntity SaleProduct;
    private Integer amountForProduct;
    private LocalDate SaleDate;
    private Double SaleTotalValue;
}


