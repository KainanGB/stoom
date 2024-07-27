package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandBO {
    Page<Brand> getAllBrands(boolean active, String name, Pageable pageable);
    Brand getBrandById(Long id);
    Brand createBrand(Brand brand);
    Brand updateBrand(Long id, Brand brand);
    void deleteBrand(Long id);
    void deactivateBrand(Long brandId);
    void activateBrand(Long brandId);
}
