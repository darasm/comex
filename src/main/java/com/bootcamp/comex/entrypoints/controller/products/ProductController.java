package com.bootcamp.comex.entrypoints.controller.products;

import com.bootcamp.comex.entity.category.ICategoryRepository;
import com.bootcamp.comex.entity.product.IProductRepository;
import com.bootcamp.comex.entity.product.Product;
import com.bootcamp.comex.entrypoints.controller.products.dto.ProductDto;
import com.bootcamp.comex.entrypoints.controller.products.forms.ProductForm;
import com.bootcamp.comex.entrypoints.controller.products.forms.UpdateProductForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Page<ProductDto>> listAllProducts(@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "name"));
        Page<Product> products = productRepository.listAllProducts(pageable);
        Page<ProductDto> productDtos = products.map(m -> modelMapper.map(m, ProductDto.class));
        return ResponseEntity.ok(productDtos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductDto> registerProduct(@RequestBody @Valid ProductForm productForm,
                                                      UriComponentsBuilder uriComponentsBuilder){
        Product product = productForm.toProduct();
        Product registeredProduct = productRepository.registerProduct(product);

        URI uri = uriComponentsBuilder.path("/api/v1/products/{id}").buildAndExpand(registeredProduct.getProductCode()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(registeredProduct, ProductDto.class));
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDto> searchProductById(@PathVariable Long productCode){
        Product product = productRepository.searchProductByCode(productCode);
        return ResponseEntity.ok(modelMapper.map(product, ProductDto.class));
    }

    @DeleteMapping("/{productCode}")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable Long productCode){
        productRepository.deleteProduct(productCode);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{productCode}")
    @Transactional
    public ResponseEntity<ProductDto> updatedProduct(@PathVariable Long productCode,
                                                     @RequestBody @Valid UpdateProductForm updateProductForm){
        Product product = productRepository.updateProduct(productCode, modelMapper.map(updateProductForm, Product.class));
        return ResponseEntity.ok(modelMapper.map(product, ProductDto.class));
    }
}
