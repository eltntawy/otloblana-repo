package eg.com.otloblana.service.test.mapping;

import eg.com.otloblana.service.dto.*;
import eg.com.otloblana.service.entity.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed_2 on 11/13/2015.
 */
public class EntityMappingTest {


    private Mapper mapper;

    ProductEntity productEntity;
    AddonEntity addonEntity;
    CategoryEntity categoryEntity;
    GroupEntity groupEntity;
    MemberEntity memberEntity;
    OrderEntity orderEntity;
    OrderDetailEntity orderDetailEntity;
    PriceListEntity priceListEntity;
    SizeEntity sizeEntity;
    StoreEntity storeEntity;
    UserEntity userEntity;

    public EntityMappingTest () {
         productEntity = new ProductEntity();
         addonEntity = new AddonEntity();
         categoryEntity = new CategoryEntity();
         groupEntity = new GroupEntity();
         memberEntity = new MemberEntity();
         orderEntity = new OrderEntity();
         orderDetailEntity = new OrderDetailEntity();
         priceListEntity = new PriceListEntity();
         sizeEntity = new SizeEntity();
         storeEntity = new StoreEntity();
         userEntity = new UserEntity();
    }


    @Before
    public void init() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        List<String> configFileList = new ArrayList<String>();
        configFileList.add("dozer-mapping.xml");

        dozerBeanMapper.setMappingFiles(configFileList);

        mapper = (Mapper) dozerBeanMapper;
    }

    @Test
    public void ProductEntityShouldMappedToProductDto() {

        ProductEntity productEntity = new ProductEntity();
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setNameAr("Category Name");

        productEntity.setCategoryEntity(categoryEntity);

        ProductDto productDto = mapper.map(productEntity, ProductDto.class);

        Assert.assertNotNull(productDto);

        Assert.assertNotNull(productDto.getCategoryDto());
        Assert.assertEquals(categoryEntity.getNameAr(),productDto.getCategoryDto().getNameAr());

    }

    @Test
    public void ProductDtoShouldMappedToProductEntity() {

        ProductDto productDto = new ProductDto();
        CategoryDto categoryDto = new CategoryDto();

        productDto.setCategoryDto(categoryDto);

        ProductEntity productEntity = mapper.map(productDto, ProductEntity.class);

        Assert.assertNotNull(productEntity);
    }

}
