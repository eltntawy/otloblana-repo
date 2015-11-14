package eg.com.otloblana.model.test.mapping;


import eg.com.otloblana.model.dto.CategoryDto;
import eg.com.otloblana.model.dto.ProductDto;
import eg.com.otloblana.model.entity.CategoryEntity;
import eg.com.otloblana.model.entity.ProductEntity;
import eg.com.otloblana.model.util.MappingUtil;
import junit.framework.Assert;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed_2 on 11/13/2015.
 */
public class EntityMappingTest {


    private Mapper mapper;
//    private static Context context;
//    private static EJBContainer ejbContainer;

    private MappingUtil mappingUtil;

    @BeforeClass
    public static void initContext () {
//        ejbContainer = EJBContainer.createEJBContainer();
//        context = ejbContainer.getContext();
    }


    @Before
    public void init() throws NamingException {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        List<String> configFileList = new ArrayList<String>();
        configFileList.add("dozer-mapping.xml");

        dozerBeanMapper.setMappingFiles(configFileList);

        mapper = (Mapper) dozerBeanMapper;

//        mappingUtil = (MappingUtil) context.lookup("java:global/classes/MappingUtil");

    }

    @Test
    public void ProductEntityShouldMappedToProductDto() {

        ProductEntity productEntity = new ProductEntity();
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setNameAr("Category Name");

        productEntity.setCategoryEntity(categoryEntity);

        ProductDto productDto = mapper.map(productEntity, ProductDto.class);
//        ProductDto productDto = mappingUtil.getDto(productEntity,ProductDto.class);

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

    @AfterClass
    public static void destoryContext() throws NamingException {
//        context.close();
//        ejbContainer.close();
    }

}
