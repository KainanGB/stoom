package br.com.stoom.store.controller;

import br.com.stoom.store.business.BrandBO;
import br.com.stoom.store.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private static final Logger LOGGER = Logger.getLogger(BrandController.class.getName());

    @Autowired
    private BrandBO brandService;

    @GetMapping
    public ResponseEntity<Page<Brand>> getAllBrands(@RequestParam(defaultValue = "true") boolean active,
                                                    @RequestParam(required = false) String name,
                                                    @PageableDefault(size = 10) Pageable pageable) {
        LOGGER.info("Get all brands called with active: " + active + ", name: " + name + ", page: " + pageable.getPageNumber() + ", size: " + pageable.getPageSize());
        Page<Brand> brands = brandService.getAllBrands(active, name, pageable);
        if (!brands.isEmpty())
            return new ResponseEntity<>(brands, HttpStatus.OK);
        else
            return new ResponseEntity<>(brands, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        LOGGER.info("Get brand by ID called with id: " + id);
        Brand brand = brandService.getBrandById(id);
        if (brand != null)
            return new ResponseEntity<>(brand, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        LOGGER.info("Create brand called with brand: " + brand);
        Brand createdBrand = brandService.createBrand(brand);
        return new ResponseEntity<>(createdBrand, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        LOGGER.info("Update brand called with id: " + id + " and brand: " + brand);
        Brand updatedBrand = brandService.updateBrand(id, brand);
        if (updatedBrand != null)
            return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        LOGGER.info("Delete brand called with id: " + id);
        brandService.deleteBrand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
