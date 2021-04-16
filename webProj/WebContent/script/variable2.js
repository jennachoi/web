
var tOn = document.getElementById('turnOn');
tOn.onmouseover = function() {
	document.getElementById('show').src = 'https://www.w3schools.com/js/pic_bulbon.gif';
}
var tOff = document.getElementById('turnOff');
tOff.onclick = function() {
	document.getElementById('show').src = 'https://www.w3schools.com/js/pic_bulboff.gif';	
}

var bulb = document.getElementById('show');
bulb.onmouseover = function() {
	document.getElementById('show').src = 'https://www.w3schools.com/js/pic_bulbon.gif';
}
bulb.onmouseout = function() {
	document.getElementById('show').src = 'https://www.w3schools.com/js/pic_bulboff.gif';
}

