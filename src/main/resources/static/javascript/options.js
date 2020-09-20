function generateSubjects() {
	const subjectSelect = document.getElementById("cadeira")

    var subjects = ["Engenharia de Software", "POO", "Arquitetura de Software"];

    for( const subject of subjects ) {
        subjectSelect.innerHTML += ` <option th:value = "${subject}" > ${subject} </option> `
    }	
}
generateSubjects()

function generateCourses() {
	const courseSelect = document.getElementById("curso")

    var courses = ["Administração", "ADS", "MSI"];

    for( const course of courses ) {
        courseSelect.innerHTML += ` <option th:value = "${course}" > ${course} </option> `
    }
}
generateCourses()

