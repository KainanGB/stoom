package br.com.stoom.store.repository;

import br.com.stoom.store.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Page<Brand> findByActive(boolean active, Pageable pageable);

    Page<Brand> findByActiveAndBrandContaining(boolean active, String brand, Pageable pageable);

}