package com.leaseloco.leaselocoassignment.repository;

import com.leaseloco.leaselocoassignment.models.Deal;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long>, QueryByExampleExecutor<Deal> {


}
