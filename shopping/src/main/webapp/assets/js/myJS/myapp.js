$(function(){
	console.log("--->",menu);
	switch (menu) {
	case "About":
		$("#about").addClass("active");
		break;
	case "Contact":
		$("#contact").addClass("active");
		break;
	case "All Products":
		$("#listProduct").addClass("active");
		break;	
	default:
		$("#listProduct").addClass("active");
		$('#a_'+menu).addClass("active");
		break;
	}
});