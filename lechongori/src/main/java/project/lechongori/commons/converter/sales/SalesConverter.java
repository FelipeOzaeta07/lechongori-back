package project.lechongori.commons.converter.sales;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import project.lechongori.commons.constans.response.IGeneralResponse;
import project.lechongori.commons.domains.dto.sales.SalesDTO;
import project.lechongori.commons.domains.entity.sales.SalesEntity;
import project.lechongori.commons.helpers.HelperMapper;

@Component
@Log4j2
public class SalesConverter {
    public SalesDTO convertProductEntityToProductDTO(SalesEntity productEntity) {
        SalesDTO salesDTO = new SalesDTO();
        try {
            salesDTO = HelperMapper.modelMapper().map(productEntity,SalesDTO.class);
        } catch (Exception e) {
            log.error(IGeneralResponse.DOCUMENT_FAIL + e);
        }
        return salesDTO;
    }

    public SalesEntity convertProductDTOToProductEntity(SalesDTO productDTO) {
        SalesEntity salesEntity = new SalesEntity();
        try {
            salesEntity = HelperMapper.modelMapper().map(productDTO, SalesEntity.class);
        } catch (Exception e) {
            log.error(IGeneralResponse.DOCUMENT_FAIL + e);
        }
        return salesEntity;
    }
}