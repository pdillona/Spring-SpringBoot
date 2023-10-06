			$(function(){
				
				// User1
				$('#BtnUser1').click(function(){
					$.ajax({
						url:'/Ch10/user1/A102',
						type: 'GET',
						data:'json',
						success: function(data){
							console.log(data)
						}
					});
				});
				$('#BtnUser1s').click(function(){
						$.ajax({
						url:'/Ch10/user1',
						type: 'GET',
						data:'json',
						success: function(data){
							console.log(data)
						}
					});
				});
				$('#BtnUser1Register').click(function(){
						
						const jsonData = {
							id: 's101',
							name: '홍길동',
							hp: '010-5555-1234',
							age:22
						};
						
						$.ajax({
						url:'/Ch10/user1',
						type: 'POST',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(data)
						}
					});
				});
				$('#BtnUser1Modify').click(function(){
						
						const jsonData = {
							id: 's101',
							name: '홍박사',
							hp: '010-5555-1234',
							age: 55
						};
						
						$.ajax({
						url:'/Ch10/user1',
						type: 'PUT',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(data)
						}
					});
					
				});
				$('#BtnUser1Delete').click(function(){
					
				
						
						$.ajax({
						url:'/Ch10/user1/s101',
						type: 'DELETE',
						data:'json',
						success: function(data){
							console.log(data)
						}
					});
					
				});
				
			});
			