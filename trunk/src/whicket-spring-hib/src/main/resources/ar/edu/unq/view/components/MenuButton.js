function mouseMoveButton(button) {
	$(button).animate({
		backgroundColor : "#aa0000",
		color : "white",
		width : 200
	}, 180);
}

function mouseOutButton(button) {
	$(button).animate({
		backgroundColor : "#eeffff",
		color : "black",
		width : 180
	}, 180);
}

$(document).ready(function() {
	$(".menuButton a").animate({
		color : "black",
		width : 180
	}, 180);
});