package br.com.stoom.store.business;

import br.com.stoom.store.business.interfaces.IBrandBO;
import br.com.stoom.store.exceptions.ResourceNotFoundException;
import br.com.stoom.store.model.Brand;
import br.com.stoom.store.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandBO implements IBrandBO {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Page<Brand> getAllBrands(boolean active, String name, Pageable pageable) {
        if (name == null || name.isEmpty()) {
            return brandRepository.findByActive(active, pageable);
        } else {
            return brandRepository.findByActiveAndBrandContaining(active, name, pageable);
        }
    }


    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Long id, Brand brand) {
        Brand existingBrand = brandRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));

        existingBrand.setBrand(brand.getBrand());
        existingBrand.setActive(brand.isActive());

        return brandRepository.save(existingBrand);
    }

    @Override
    public void deleteBrand(Long id) {
        Brand brand = brandRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));

        brandRepository.delete(brand);
    }

    public void deactivateBrand(Long brandId) {
        Brand brand = brandRepository.findById(brandId)
            .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
        brand.setActive(false);
        brandRepository.save(brand);
    }

    public void activateBrand(Long brandId) {
        Brand brand = brandRepository.findById(brandId)
            .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
        brand.setActive(true);
        brandRepository.save(brand);
    }
}

