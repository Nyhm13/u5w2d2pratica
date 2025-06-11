package it.epicode.u5w2d2pratica.repository;

import it.epicode.u5w2d2pratica.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer>, PagingAndSortingRepository<Blog,Integer> {
}
