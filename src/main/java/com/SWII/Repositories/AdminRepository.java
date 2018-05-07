package com.SWII.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.AdminEntity;

public interface AdminRepository extends CrudRepository<AdminEntity, String> {
	boolean existsByPassword(String password);
	boolean existsByUserName(String name);
}
