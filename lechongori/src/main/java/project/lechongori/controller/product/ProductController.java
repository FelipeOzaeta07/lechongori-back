package project.lechongori.controller.product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.lechongori.commons.constans.EndPoint.Product.IProductEndPoint;
import project.lechongori.commons.constans.response.IGeneralResponse;
import project.lechongori.commons.domains.dto.product.ProductDTO;
import project.lechongori.commons.domains.responseDTO.GenericResponseDTO;
import project.lechongori.service.product.ProductService;

@RestController
@RequestMapping(IProductEndPoint.URL_PRODUCT)
@Tag(name = "Sistema de Gestión de Producto", description = "Crear, visualizar, eliminar y actualizar Producto")
@Log4j2
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @Operation(summary = "Crear un nuevo Producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IGeneralResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IGeneralResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = IGeneralResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = IGeneralResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IProductEndPoint.CREATE_PRODUCT)
    public ResponseEntity<GenericResponseDTO> createProducts(@RequestBody ProductDTO productDTO) {
        return this.productService.createProducts(productDTO);
    }

    @Operation(summary = "Leer un Producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IGeneralResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IGeneralResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = IGeneralResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = IGeneralResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IProductEndPoint.READ_PRODUCTS)
    public ResponseEntity<GenericResponseDTO> readProducts() {
        return this.productService.readProducts();
    }
}
