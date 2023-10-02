package kr.ch08.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ch08.dto.User1DTO;
import kr.ch08.entity.User1Entity;

@Repository
public interface User1Repository extends JpaRepository<User1Entity, String> {
//첫번째 파라메타로 엔티티(dto)가 들어오고 dto(entity)의 @id값의 타입이 2번째 파라메타로 들어온다.
	
	
	//JPA쿼리 메서드
	public User1Entity findUser1EntityByUid(String uid);
	public List<User1Entity> findUser1EntityByName(String name);
	public List<User1Entity> findUser1EntityByNameNot(String name);
	
	public User1Entity findUser1EntityByUidAndName(String uid, String name);
	public User1Entity findUser1EntityByUidOrName(String uid, String name);
	
	public List<User1Entity> findUser1EntityByAgeGreaterThan(int age);
	public List<User1Entity> findUser1EntityByAgeGreaterThanEqual(int age);
	public List<User1Entity> findUser1EntityByAgeLessThan(int age);
	public List<User1Entity> findUser1EntityByAgeLessThanEqual(int age);
	public List<User1Entity> findUser1EntityByAgeBetween(int low, int high);
	
	
	public List<User1Entity> findUser1EntityByOrderByName();
	public List<User1Entity> findUser1EntityByOrderByAgeAsc();
	public List<User1Entity> findUser1EntityByOrderByAgeDesc();
	public List<User1Entity> findUser1EntityByAgeGreaterThanOrderByAgeDesc(int age);
	
	
	public int countUser1EntityByUid(String uid); 
	public int countUser1EntityByName(String name);
	
	
	//JPQL
	@Query("select u1 from User1Entity where age<30")
	public List<User1Entity> selectUser1UnderAge30();
	
	@Query("select u1 from User1Entity as u1 where u1.name= ?1")
	public List<User1Entity> selectUser1ByName(String name);
	
	
	@Query("select u1 from User1Entity as u1 where u1.name=21")
	public List<User1Entity> selectUser1ByNameParam(@Param("name") String name);
	

	
	@Query("select u1.uid, u1.name, u1.age from User1Entity as u1 where u1.name=21")
	public List<Object[]>selectUser1ByUid(@Param("uid") String uid);
	//public List<String[]>selectUser1ByUid(@Param("uid") String uid);  String[]도 가능
	
}
