//let toolbarOption = [
//   // [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
//   // [{ 'font': [] }],
//   [{ 'size': ['small', false, 'large', 'huge'] }],
//   ['bold', 'italic', 'underline', 'strike'],
//   [{ 'color': [] }, { 'background': [] }],
//   [{ 'list': 'ordered' }, { 'list': 'bullet' }],
//   [{ align: '' }, { align: 'center' }, { align: 'right' }, { align: 'justify' }],
//   [{ 'indent': '-1' }, { 'indent': '+1' }],
//   [{ 'direction': 'rtl' }],
//   ['link', 'image', 'video'],
//   ['blockquote'],
//];
let toolbarOption = [
   // [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
   // [{ 'font': [] }],
   [{ 'size': ['small', false, 'large', 'huge'] }],
   ['bold', 'italic', 'underline', 'strike'],
   [{ 'color': [] }, { 'background': [] }],
   [{ 'list': 'ordered' }, { 'list': 'bullet' }],
   [{ align: '' }, { align: 'center' }, { align: 'right' }, { align: 'justify' }],
   [{ 'indent': '-1' }, { 'indent': '+1' }],
   [{ 'direction': 'rtl' }],
   ['link', 'image'],
   ['blockquote'],
];

let options = {
   debug: 'info',
   modules: {
      toolbar: toolbarOption
   },
   placeholder: 'Enter content here...',
   theme: 'snow'
};

let quill = new Quill('#editor', options);
quill.root.spellcheck = false;

let justHtmlContent = document.getElementById('justHtml');
let titleContent = document.getElementsByClassName('title-content');

let btnSaveContent = document.getElementById('save');
btnSaveContent.addEventListener('click', () => {
	// get content
    document.getElementById('content').value = quill.root.innerHTML;
    
    // get tags
    // split by ','
    let tagsNameExist = document.getElementsByClassName('chip');
    let tags = tagsNameExist[0].innerText;
    for (let i = 1; i < tagsNameExist.length; i++) {
       tags += "," + tagsNameExist[i].innerText;
    }
    console.log(tags);
    document.getElementById('tags').value = tags;
});

//chặn enter submit form bất kì input nào
$(document).ready(function() {
  $(window).keydown(function(event){
    if(event.keyCode == 13) {
      event.preventDefault();
      return false;
    }
  });
});