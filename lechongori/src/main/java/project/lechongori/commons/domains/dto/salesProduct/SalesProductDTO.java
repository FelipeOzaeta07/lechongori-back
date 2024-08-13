package project.lechongori.commons.domains.dto.salesProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.lechongori.commons.domains.entity.product.ProductEntity;
import project.lechongori.commons.domains.entity.sales.SalesEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesProductDTO  implements Serializable {
    private Integer id;
    private SalesEntity salesEntity;
    private ProductEntity productEntity;
    private int amount;
}
