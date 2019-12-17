package com.example.demo.repository;

import com.example.demo.pojo.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/

    //List<Like> findByAuthor(Long idPost);

    @Query("SELECT b FROM Like b WHERE b.post LIKE %:post%")
    List<Like> findByPost(Long post);

    List<Like> findAll();
}
