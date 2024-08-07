package br.com.stoom.store.repository;

import br.com.stoom.store.model.Brand;
import br.com.stoom.store.model.Category;
import br.com.stoom.store.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByActive(boolean active);
    List<Product> findByCategoryAndActive(Category category, boolean active);
    List<Product> findByBrandAndActive(Brand brand, boolean active);
    Page<Brand> findByActiveAndBrandContaining(boolean active, String brand, Pageable pageable);
}