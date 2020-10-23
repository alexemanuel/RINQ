function generateSubjects() {
	const subjectSelect = document.getElementById("cadeira")

    var subjects = ["Engenharia de Software", "Arquitetura de Software", "POO"];

    for( const subject of subjects ) {
        subjectSelect.innerHTML += ` <option th:value = "${subject}" selected>${subject}</option> `
    }	
}
generateSubjects()

function generateCourses() {
	const courseSelect = document.getElementById("curso")

    var courses = ["Administração", "MSI", "ADS", ];

    for( const course of courses ) {
        courseSelect.innerHTML += ` <option th:value = "${course}" selected>${course}</option> `
    }
}
generateCourses()

