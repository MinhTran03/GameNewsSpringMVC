function createElement(type, ...className) {
   let element = document.createElement(type);
   className.forEach(classItem => {
      element.classList.add(classItem);
   });
   return element;
};

function createComment(imageSrc, name, content) {
   let media = createElement("div", "media");

   let mediaLeft = createElement("a", "media-left");
   mediaLeft.setAttribute("href", "#");
   let image = createElement("img", "rounded-circle");
   image.setAttribute("src", imageSrc);
   image.setAttribute("alt", '');
   mediaLeft.appendChild(image);

   let mediaBody = createElement("div", "media-body");
   let userName = createElement("h4", "media-heading", "user_name");
   userName.innerText = name;
   let dayCount = createElement("small");
   dayCount.innerText = "1m";
   userName.appendChild(dayCount);
   let contentParag = createElement("p");
   contentParag.innerText = content;
   let reply = createElement("a", "btn", "btn-primary", "btn-sm");
   reply.setAttribute("href", "#");
   reply.innerText = "Reply";
   mediaBody.appendChild(userName);
   mediaBody.appendChild(contentParag);
   mediaBody.appendChild(reply);

   media.appendChild(mediaLeft);
   media.appendChild(mediaBody);
   
   return media;
};

let commentsList = document.getElementsByClassName('comments-list')[0];

let submit = document.getElementsByClassName('post-comment')[0];
let commentContent = document.getElementsByClassName('comment-content')[0];
let arr = window.location.href.split('/');
let commentCount = document.getElementsByClassName('commen-count')[0];
let commentArea = document.getElementsByClassName('form-wrapper')[0];

submit.addEventListener('click', (event) => {
   console.log("comment");
   
   if(commentArea.childElementCount === 2){
	   $.ajax({
		   url: "comment",
		   dataType: "json",
		   data: {
			   postId: arr[arr.length - 1],
			   content: commentContent.value,
		   },
		   success: function (response) {
			   console.log(response);
			   if (response.valid == "1") {
				   let comment = createComment("/" + arr[3] + response.imageSrc, response.name, commentContent.value);
				   commentsList.appendChild(comment);
				   commentContent.value = '';
				   commentCount.innerText = commentsList.childElementCount + " Comments";
			   }else{
				   alert("ERROR");
			   }
		   },
	   })	   
   }else{
	   let email = document.getElementById('input-email');
	   let name = document.getElementById('input-name');
	   
	   $.ajax({
	      url: "https://app.verify-email.org/api/v1/Nr7HDGjMCznsDqL6OQNQ6gqVl3nPYEEDStB9a9IeJjbTGNHSb9/verify/" + email.value,
	      type: 'GET',
	      dataType: 'JSON',
	      success: function (response) {
	    	  // Email exist
	         if(response.smtp_code === 250){
	        	 $.ajax({
	      		   url: "commentWithoutLogin",
	      		   type: "POST",
	      		   dataType: "json",
	      		   data: {
	      			   email: email.value,
	      			   name: name.value,
	      			   postId: arr[arr.length - 1],
	      			   content: commentContent.value,
	      		   },
	      		   success: function (response) {
	      			   console.log(response);
	      			   if (response.valid == "1") {
	      				   let comment = createComment("/" + arr[3] + response.imageSrc, response.name, commentContent.value);
	      				   commentsList.appendChild(comment);
	      				   commentContent.value = '';
	      				   commentCount.innerText = commentsList.childElementCount + " Comments";
	      			   }else{
	      				   alert("ERROR");
	      			   }
	      		   },
	      	   })
	         }else{
	        	 alert("Email not exist");
	         }
	      }
	   })
   }
})

//let pageNext = document.getElementsByClassName('page-next')[0];
//
//pageNext.addEventListener('click', (event) => {
//   let nextPage = Number.parseInt(event.target.innerText);
//
//   $ajax({
//      url: nextPage,
//      type: 'GET',
////      dataType: 'JSON',
//      success: function (response) {
//         alert(response);
//      }
//   })
//})
































