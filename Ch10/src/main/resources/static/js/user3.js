			$(function(){
				
				// User1
				$('#BtnUser3').click(function(){
					$.ajax({
						url:'/Ch10/user3/A102',
						type: 'GET',
						data:'json',
						success: function(data){
							console.log(data)
						}
					});
				});
				$('#BtnUser3s').click(function(){
						$.ajax({
						url:'/Ch10/user3',
						type: 'GET',
						data:'json',
						success: function(data){
							console.log(data)
						}
					});
				});
				$('#BtnUser3Register').click(function(){
						
						const jsonData = {
							id: 'S101',
							name: '홍길동',
							hp: '010-5555-1234',
							age:22
						};
						
						$.ajax({
						url:'/Ch10/user3',
						type: 'POST',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(1)
						}
					});
				});
				$('#BtnUser3Modify').click(function(){
						
						const jsonData = {
							id: 's103',
							name: '홍박사',
							hp: '010-5555-1238',
							age: 55
						};
						
						$.ajax({
						url:'/Ch10/user3',
						type: 'PUT',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(1)
						}
					});
					
				});
				$('#BtnUser3Delete').click(function(){
					
				
						
						$.ajax({
						url:'/Ch10/user3/s101',
						type: 'DELETE',
						data:'json',
						success: function(data){
							console.log(1)
						}
					});
					
				});
				
			});
			