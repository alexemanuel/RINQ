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

document.getElementById('choice').addEventListener('change', () => {
    if (document.getElementById('choice').checked) {
        document.getElementById('element').style.display = 'none';
        document.getElementById('siape').disabled = true;
    }
})

document.getElementById('choice2').addEventListener('change', () => {
    if (document.getElementById('choice2').checked){
        document.getElementById('element').style.display = 'flex';
        document.getElementById('siape').disabled = false;

    
    }
});