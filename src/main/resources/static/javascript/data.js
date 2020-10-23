
var today = new Date();
var dy = today.getDate();
var mt = today.getMonth()+1;
var yr = today.getFullYear();
if(dy<10){
	dy="0"+dy
}
if(mt<10){
	mt="0"+mt
}

document.getElementById('date').value= yr+"-"+mt+"-"+dy;
 