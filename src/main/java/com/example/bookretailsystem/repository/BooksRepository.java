package com.example.bookretailsystem.repository;

import com.example.bookretailsystem.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */
@Repository
public abstract interface BooksRepository extends JpaRepository<Books,Long> {

    @Query("select b from Books  b where b.bookName=?1")
    public List<Books> findByBookSName(String name);

    @Modifying
    @Query("UPDATE Books b set b.count= b.count- ?2 where b.id = ?1")
    public void updateBooksCount(Long id,int count);

}
