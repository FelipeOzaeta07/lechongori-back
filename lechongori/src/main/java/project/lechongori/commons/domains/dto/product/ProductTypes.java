package project.lechongori.commons.domains.dto.product;

import lombok.Getter;

@Getter
public enum ProductTypes {
    LECHONA(1),
    TAMAL(2),
    EMPANADAS(3),
    CARNE(4),
    SANCOCHO(5),
    COSTILLAS(6);

    private final int valor;

    ProductTypes(int valor) {
        this.valor = valor;
    }

    public static ProductTypes fromValor(int valor) {
        for (ProductTypes tipo : ProductTypes.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de producto inválido: " + valor);
    }
}
