package com.nse.nse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nse.nse.model.NSENiftyData;

@Repository
public interface NSERepository extends JpaRepository<NSENiftyData, Long> {

	@Query("select nse from NSENiftyData nse where nse.createdDate=?1 order by id")
	public List<NSENiftyData> findByDate(String createdDate);
}
