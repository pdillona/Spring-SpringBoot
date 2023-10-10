package kr.ch11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ch11.entity.UserEntity;

public interface Repository extends JpaRepository<UserEntity, String>{

}
