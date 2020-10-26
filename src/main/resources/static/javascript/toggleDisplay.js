// document.getElementById("choice2").addEventListener('change', function(){
//     if(document.getElementById('choice2').checked) {
//         document.getElementById('siape').removeAttribute("disabled");

//     }

//     document.getElementById("choice").addEventListener('change', () => {
//         if(document.getElementById('choice').checked) {
//             document.getElementById('siape').setAttribute("disabled", 'true');
//         }
//     })
// });


// document.getElementById("choice2").addEventListener('change', function(){
//     if(document.getElementById('choice2').checked) {
//         document.getElementById('siape').type = "text";

//     }
// });

// var radioBtn = document.getElementById('choice');

// radioBtn2.onclick = function() {
//     var getElement = document.getElementById('element');
    
//     getElement.style.display = 'flex';
// }


document.getElementById('element').style.display = 'none';
document.getElementById('subject').style.display = 'none';

document.getElementById('choice2').addEventListener('change', () => {
    if (document.getElementById('choice2').checked) {
    	
        document.getElementById('element').style.display = 'none';
        document.getElementById('subject').style.display = 'none';
        
        document.getElementById('siape').required = false;
        document.getElementById('subject').required = false;
        
        
    }
})

document.getElementById('choice').addEventListener('change', () => {
    if (document.getElementById('choice').checked){
        
    	document.getElementById('element').style.display = 'flex';
        document.getElementById('subject').style.display = 'flex';
        
        document.getElementById('siape').required = true;
        document.getElementById('subject').required = true;
    }
});


const choiceDocente  = document.getElementById("choice");
const choiceDiscente = document.getElementById("choice2");
const cursoSelect = document.getElementById("curso");
const cadeiraSelect = document.getElementById("cadeira")

choiceDocente.addEventListener("click", function() {
		cursoSelect.style.width = '290px'; 
		cadeiraSelect.style.width = '290px';
})
choiceDiscente.addEventListener("click", function() {cursoSelect.style.width = '605px'})
