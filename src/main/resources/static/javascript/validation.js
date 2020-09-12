// const fields = document.querySelectorAll("[required]")

// console.log(fields)

// function customValidation(event){
//     const field = event.target 

//     // verificando se esxistem erros
//     function verifyErrors(){
//         let foundError = false;

//         for ( let error in field.validity ) {
            
//             if ( error != "customError" && field.validity[error] ){
//                 foundError = error
//             }
//         }

//         return foundError;
//     }

//     const error = verifyErrors()
//     console.log("Error Exists: ", error)

//     if (error) {
//         // trocando a mensagem do required
//     field.setCustomValidity("Esse campo é obrigatório")
//     } else {
//         field.setCustomValidity("")
//     }
    
// }

// for ( field of fields ) {

//     field.addEventListener("invalid", customValidation)
        
// }

var password = document.getElementById("password")
  , confirm_password = document.getElementById("confirm_password");

function validatePassword(){
  if(password.value != confirm_password.value) {
    
    confirm_password.setCustomValidity("Senhas diferentes")
    

  } else {
    confirm_password.setCustomValidity('');
  }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;















// document.querySelector("form")
// .addEventListener("submit", event => {
//     console.log("enviar o formulario")

//     event.preventDefault()
// })