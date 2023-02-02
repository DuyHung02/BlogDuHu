package com.example.blog.repository;

import com.example.blog.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends PagingAndSortingRepository<Account, Long> {
    @Query(nativeQuery = true, value = "select * from account where gmail=:gmail and password=:password")
    Account checkLogin(@Param("gmail") String gmail, @Param("password") String password);

    @Query(nativeQuery = true, value = "select * from account where gmail=:gmail")
    Account checkGmail(@Param("gmail") String gmail);
}
