package project.lechongori.commons.converter.product;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import project.lechongori.commons.constans.response.IGeneralResponse;
import project.lechongori.commons.domains.dto.product.ProductDTO;
import project.lechongori.commons.domains.entity.product.ProductEntity;
import project.lechongori.commons.helpers.HelperMapper;

@Component
@Log4j2
public class ProductConverter {
    public ProductDTO convertProductEntityToProductDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        try {
            productDTO = HelperMapper.modelMapper().map(productEntity, ProductDTO.class);
        } catch (Exception e) {
            log.error(IGeneralResponse.DOCUMENT_FAIL + e);
        }
        return productDTO;
    }

    public ProductEntity convertProductDTOToProductEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        try {
            productEntity = HelperMapper.modelMapper().map(productDTO, ProductEntity.class);
        } catch (Exception e) {
            log.error(IGeneralResponse.DOCUMENT_FAIL + e);
        }
        return productEntity;
    }
}
