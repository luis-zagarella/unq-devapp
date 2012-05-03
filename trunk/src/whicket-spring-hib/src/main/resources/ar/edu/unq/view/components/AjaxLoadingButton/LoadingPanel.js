function showLoadingPanel(){
	 $(".loadingPanel").addClass("loadingPanelActive");
	 $(".loadingPanel").removeClass("loadingPanelInactive");
}
function hideLoadingPanel(){
	$(".loadingPanel").addClass("loadingPanelInactive");
	 $(".loadingPanel").removeClass("loadingPanelActive");
}
$(document).ready(hideLoadingPanel);