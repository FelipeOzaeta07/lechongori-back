package project.lechongori.commons.constans.EndPoint.Product;

public interface IProductEndPoint {
    String URL_PRODUCT = "product";
    String CREATE_PRODUCT = "/create-product";
    String READ_PRODUCTS = "read-products";
    String READ_PRODUCT = "read-product/{productId}";
    String UPDATE_PRODUCT = "/update-product";
    String DELETE_PRODUCT = "/delete-product";
}
