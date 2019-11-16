let searchBtn = document.getElementById('search');

searchBtn.onclick = function(){
	let input = document.getElementById('searchText').value;
	
	if(input !== ""){
		let r = document.getElementById('lnkSearch').getAttribute('href') + input;
		document.getElementById('lnkSearch').setAttribute('href', r);
	}
}