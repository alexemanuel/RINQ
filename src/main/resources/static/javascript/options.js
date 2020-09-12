function generateSubjects() {
    const subjectSelect = document.querySelector("select[name=cadeira]")

    var subjects = ["Engenharia de Software", "POO", "Arq de Software"];

    for( const subject of subjects ) {
        subjectSelect.innerHTML += ` <option value = "" > "${subject}" </option> `
    }
}
generateSubjects()

function generateCourses() {
    const courseSelect = document.querySelector("select[name=curso]")

    var courses = ["Administração", "ADS", "Msi"];

    for( const course of courses ) {
        courseSelect.innerHTML += ` <option value = "" > "${course}" </option> `
    }
}
generateCourses()

