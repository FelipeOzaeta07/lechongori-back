package project.lechongori.commons.domains.dto.product;

import lombok.*;
import project.lechongori.commons.domains.entity.product.ProductTypes;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Dto de un producto
public class ProductDTO implements Serializable {
    // identificación unica de un producto
    private Integer productId;
    // Titulo o nombre de un producto
    private String productTitle;
    // Descripción de un producto
    private String productDescription;
    //precio de un producto
    private Double productPrice;
    //ruta de la imagen de un producto
    private String[] productImages;
    //tipo de producto
    private ProductTypes productType;
}
