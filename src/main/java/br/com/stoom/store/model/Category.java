package br.com.stoom.store.model;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;


@Entity
@Table(name = "t_categories")
public class Category  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @SequenceGenerator(name = "category_sequence", sequenceName = "CATEGORY_SEQ")
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category", nullable = false)
    private String category;


    @Column(name = "active", nullable = false)
    private Boolean active = true;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
