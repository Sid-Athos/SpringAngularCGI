package com.example.demo.repository;

import com.example.demo.pojo.Likes;
import com.example.demo.pojo.LikesJSON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long>{
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/

    //List<Like> findByAuthor(Long idPost);

    @Query("SELECT l FROM Likes l WHERE post = :post")
    List<Likes> findByPost(long post);
    @Query("SELECT COUNT(l) as compteur FROM Likes l GROUP BY l.post")
    List<Likes> findAll();

}
