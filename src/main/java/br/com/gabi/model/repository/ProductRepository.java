package br.com.gabi.model.repository;

import br.com.gabi.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Iterable<Product> findByNameContainingIgnoreCase(String name);

    @Query("select p from Product p where p.name LIKE %:name%")
    public Iterable<Product> searchNameLike(@Param("name") String name);
}
