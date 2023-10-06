package kr.ch10.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import kr.ch10.entity.User1Entity;

@Repository
public interface User1Repository extends JpaRepository<User1Entity, String>{

}
