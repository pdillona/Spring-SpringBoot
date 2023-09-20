<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>annotation::param</title>
</head>
<body>
	
	<h3>@ModelAttribute 어노테이션 실습</h3>
	
	<a href="/Ch04/index">index</a>
	
	<h4>Model1 결과</h4>
	<p>
	 	uid : ${modelDTO.uid} 
	 	<!-- 자바는 카멜 표기법이라 ModelDTO가 아니라 modelDTO가 된다. 즉 첫 클자 m만 무조건 소문자이며 그후로는 대소문자를 구분 한다. -->
	</p>

	<h4>Model2 결과</h4>
	<p>
	 	uid : ${user.uid}<br>
	 	name : ${user.name}
	</p>
	
	<h4>Model3 결과</h4>
		<p>
	 	uid : ${modelDTO.uid}<br>
	 	name : ${modelDTO.name}<br>
	 	hp : ${modelDTO.hp}<br>
	 	age : ${modelDTO.age}<br>
	</p>
	
</body>
</html>