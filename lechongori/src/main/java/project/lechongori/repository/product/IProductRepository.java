package project.lechongori.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.lechongori.commons.domains.entity.product.ProductEntity;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query(value = "SELECT MAX(product_id) AS end_id FROM product_lechongori;", nativeQuery = true)
    Integer lastProductId();
}
