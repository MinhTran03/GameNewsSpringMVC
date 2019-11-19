let searchBtn = document.getElementById('lnkSearch');

searchBtn.onclick = function(){
	let input = document.getElementById('searchText').value;
	
	if(input !== ""){
		let r = document.getElementById('lnkSearch').getAttribute('href') + input;
		document.getElementById('lnkSearch').setAttribute('href', r);
	}
}

$("a[data-lang]").click(function(){
	let lang = $(this).attr("data-lang");
	$.get("/GameNews/?language="+lang, function(){
		location.reload();
	})
	return false;
})