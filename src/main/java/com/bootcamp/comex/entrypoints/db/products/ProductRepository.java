package com.bootcamp.comex.entrypoints.db.products;

import com.bootcamp.comex.entity.category.Category;
import com.bootcamp.comex.entity.category.ICategoryRepository;
import com.bootcamp.comex.entity.product.IProductRepository;
import com.bootcamp.comex.entity.product.Product;
import com.bootcamp.comex.entrypoints.db.category.CategoryEntity;
import com.bootcamp.comex.enums.CategoryStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private IProductsDAO iProductsDAO;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Product> listAllProducts(Pageable pageable) {
        return iProductsDAO.findAll(pageable).map(m -> modelMapper.map(m, Product.class));
    }

    @Override
    public Product searchProductByCode(Long productCode) {
        ProductEntity productEntity = iProductsDAO.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product's code %s was not found!".formatted(productCode)));
        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public Product registerProduct(Product product) {
        Category category = iCategoryRepository.searchCategory(product.getCategory().getId());

        //TODO return category inative
        //if(category.getStatus() != CategoryStatus.ACTIVE)

        product.setCategory(category);

        ProductEntity productEntity = iProductsDAO.save(modelMapper.map(product, ProductEntity.class));

        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public Product updateProduct(Long productCode, Product product) {
        ProductEntity productEntity = iProductsDAO.findById(productCode)
                .orElseThrow(() -> new RuntimeException("Product %s not found!".formatted(productCode)));

        productEntity.setName(product.getName());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setUnitPrice(productEntity.getUnitPrice());
        productEntity.setDescription(product.getDescription());
        productEntity.setDimensions(modelMapper.map(product.getDimensions(), DimensionsEntity.class));
        productEntity.setCategory(modelMapper.map(product.getCategory(), CategoryEntity.class));

        iProductsDAO.save(productEntity);

        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public void deleteProduct(Long id) {
        ProductEntity product = iProductsDAO.findById(id)
                        .orElseThrow(() -> new RuntimeException("Product %s not found!".formatted(id)));
        iProductsDAO.deleteById(product.getProductCode());
    }
}
