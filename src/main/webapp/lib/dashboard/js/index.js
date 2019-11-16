let deleteLnk = document.getElementsByClassName('deleteLnk');

for (i = 0; i < deleteLnk.length; i++) {
	
	deleteLnk[i].onclick = function(event){
		console.log('click delete');
		var result = confirm("Want to delete?");
		if (result) {
		    //Logic to delete the item
			$.ajax({
				url: "deletePost",
				data: 'postId=' + Number.parseInt(event.target.getAttribute('id')),
				success: function(response){
					if(response == 'true'){
						event.target.parentNode.parentNode.remove()
					}else{
						alert("Delete error");
					}
				}
			})		
		}
	}
}

let acceptPost = document.getElementsByClassName('acceptPost');

for (i = 0; i < acceptPost.length; i++) {
	
	acceptPost[i].onclick = function(event){
		console.log('click accept');
		console.log(event.target.parentElement.parentElement.firstElementChild.innerText);
		$.ajax({
			url: "acceptPost",
			data: {
				postId: Number.parseInt(event.target.parentElement.parentElement.firstElementChild.innerText),
				authorId: Number.parseInt(event.target.getAttribute('id'))
			},
			success: function(response){
				if(response == 'true'){
					event.target.parentNode.parentNode.remove()
				}else{
					alert("Accept error");
				}
			}
		})		
	}
}