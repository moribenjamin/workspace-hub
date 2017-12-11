var spaceTypeImages = document.querySelectorAll('.spacetype-image img');

for (var i = 0; i < spaceTypeImages.length; i++) {
	spaceTypeImages[i].addEventListener('mouseover', function() {
		this.style.height = '300px';
		this.style.width = '400px';
	});
	spaceTypeImages[i].addEventListener('mouseout', function() {
		this.style.height = '200px';
		this.style.width = '330px';
	});
}

window.onscroll = function(){
	myFunction()
};

var navbar = document.querySelector("nav");
var sticky = navbar.offsetTop;

function myFunction(){
	if (window.pageYOffset >= sticky) {
		navbar.classList.add("sticky")
	}else{
		navbar.classList.remove("sticky");
	}
}