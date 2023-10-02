package kr.Test.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.Test.dto.User6DTO;

@Mapper
public interface User6Mapper {
	public void insertUser6(User6DTO dto);
	public User6DTO selectUser6(String uid);
	public List<User6DTO> selectUser6s();
	public void updateUser6(User6DTO dto);
	public void deleteUser6(String uid);
}
