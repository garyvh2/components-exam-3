package com.cenfotec.exam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cenfotec.exam.domain.Package;

public interface PackageRepository extends MongoRepository<Package, String> {
	@Query(value="{'invoice': null}")
	public List<Package> findWaiting();
	
	@Query(value="{'consignee.account': ?0}")
	public List<Package> findByAccount(String Account);
	
	@Query(value="{'departureFlight': ?0}")
	public List<Package> findByNextFlight(String Date);
}