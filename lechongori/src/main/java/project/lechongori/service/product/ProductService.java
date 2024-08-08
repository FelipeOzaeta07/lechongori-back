package project.lechongori.service.product;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import project.lechongori.commons.constans.response.IGeneralResponse;
import project.lechongori.commons.constans.response.product.IProductResponse;
import project.lechongori.commons.converter.product.ProductConverter;
import project.lechongori.commons.domains.dto.product.ProductDTO;
import project.lechongori.commons.domains.entity.product.ProductEntity;
import project.lechongori.commons.domains.responseDTO.GenericResponseDTO;
import project.lechongori.repository.product.IProductRepository;

import java.util.List;
import java.util.Optional;

@Component
@Log4j2
public class ProductService {
    private final IProductRepository iProductRepository;
    private final ProductConverter productConverter;

    public ProductService(IProductRepository iProductRepository, ProductConverter productConverter) {
        this.iProductRepository = iProductRepository;
        this.productConverter = productConverter;
    }

    @Transactional
    public ResponseEntity<GenericResponseDTO> createProducts(ProductDTO productDTO) {
        try {
            Optional<ProductEntity> productExist = this.iProductRepository
                    .findById(productDTO.getProductId());
            if (productExist.isEmpty()){
                ProductEntity productEntity = this.productConverter.convertProductDTOToProductEntity(productDTO);
                this.iProductRepository.save(productEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IGeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IGeneralResponse.CREATE_SUCCESS)
                        .objectId(this.iProductRepository.lastProductId())
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IGeneralResponse.OPERATION_FAIL)
                        .objectResponse(IProductResponse.PRODUCT_SUCCESS)
                        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(IGeneralResponse.INTERNAL_SERVER, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IGeneralResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    public ResponseEntity<GenericResponseDTO> readProducts() {
        try {
            List<ProductEntity> listProductsEntity =this.iProductRepository.findAll();
            if (!listProductsEntity.isEmpty()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IGeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(listProductsEntity)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
            else {
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IGeneralResponse.OPERATION_FAIL)
                        .objectResponse(IProductResponse.PRODUCT_FAIL)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(IGeneralResponse.INTERNAL_SERVER, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IGeneralResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    public ResponseEntity<GenericResponseDTO> readProductId(Integer productId) {
        try {
            Optional<ProductEntity> productExist = this.iProductRepository
                    .findById(productId);
            if (productExist.isPresent()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IGeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(this.iProductRepository.findById(productId))
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message(IProductResponse.PRODUCT_FAIL)
                        .objectResponse(null)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        }catch (Exception e) {
            log.error(IGeneralResponse.INTERNAL_SERVER, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message(IGeneralResponse.INTERNAL_SERVER)
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }
}
