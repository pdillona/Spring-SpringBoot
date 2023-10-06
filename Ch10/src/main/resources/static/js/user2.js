			$(function(){
				
				// User1
				$('#BtnUser2').click(function(){
					$.ajax({
						url:'/Ch10/user2/A102',
						type: 'GET',
						data:'json',
						success: function(data){
							console.log(data)
						}
					});
				});
				$('#BtnUser2s').click(function(){
						$.ajax({
						url:'/Ch10/user2',
						type: 'GET',
						data:'json',
						success: function(data){
							console.log(data)
						}
					});
				});
				$('#BtnUser2Register').click(function(){
						
						const jsonData = {
							id: 's101',
							name: '홍길동',
							hp: '010-5555-1234',
							age:22
						};
						
						$.ajax({
						url:'/Ch10/user2',
						type: 'POST',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(data)
						}
					});
				});
				$('#BtnUser2Modify').click(function(){
						
						const jsonData = {
							id: 's101',
							name: '홍박사',
							hp: '010-5555-1234',
							age: 55
						};
						
						$.ajax({
						url:'/Ch10/user2',
						type: 'PUT',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(data)
						}
					});
					
				});
				$('#BtnUser2Delete').click(function(){
					
				
						
						$.ajax({
						url:'/Ch10/user2/s101',
						type: 'DELETE',
						data:'json',
						success: function(data){
							console.log(data)
						}
					});
					
				});
				
			});
			