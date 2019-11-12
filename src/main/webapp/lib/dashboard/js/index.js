let deleteLnk = document.getElementsByClassName('deleteLnk');

for (i = 0; i < deleteLnk.length; i++) {
	
	deleteLnk[i].onclick = function(event){
		console.log('click delete');
		$.ajax({
			url: "deletePost",
			data: 'postId=' + Number.parseInt(event.target.getAttribute('id')),
			success: function(response){
				if(response == 'true'){
					
					event.target.parentNode.parentNode.remove()
					
				}else{
					
				}
			}
		})		
	}
	
}