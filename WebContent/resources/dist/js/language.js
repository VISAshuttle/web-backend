$(function (){
	var searchParams = new URLSearchParams(window.location.search);
	var selectedLanguage = searchParams.get("lang");
	$("#language > option[value='" + selectedLanguage + "']").prop("selected", true);
});

$("#language").change(function() {
	var params = {
		lang: this.value
	};
	var srcPage = $(location).attr("href");
	srcPage = srcPage.substring(0, srcPage.indexOf("?"));
	var destPage = srcPage.concat("?", $.param(params));
	$(location).attr("href", destPage);
});