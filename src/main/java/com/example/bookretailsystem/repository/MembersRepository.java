package com.example.bookretailsystem.repository;

import com.example.bookretailsystem.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author wuqianqian
 * @date 2022/3/27
 */
@Repository
public interface MembersRepository extends JpaRepository<Members,Long> {

    @Modifying
    @Query("update Members m set m.points=m.points+?2 where m.id= ?1")
    public void updatePoints(Long id,int points);
}
