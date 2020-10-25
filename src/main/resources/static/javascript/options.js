function changeSubjects(){
    const course   = selectCoursesTag.value;
    const subjects = courses_to_subjects[course];

    setSubjects(subjects);
}

function setSubjects(subjects){
    var innerHTML = "";

    subjects.forEach(subject => innerHTML += `<option th:value = "${subject}">${subject}</option>`);
    selectSubjectsTag.innerHTML = innerHTML;
}

courses_to_subjects = {
    "ADS":
        [
            "Empreendedorismo em Negócios de TIC",
            "Iniciação à Informática",
            "Matemática Aplicada",
            "Língua Inglesa Aplicada",
            "Introdução à Programação",
            "Ética e Responsabilidade Socioambiental",
        ],

    "MSI":
        [
            "Informática Básica",
            "Português Instrumental",
            "Inglês Instrumental",
            "Lógica de Programação",
            "Eletricidade Básica I",
            "Direitos Humanos, Ética Profissional e Cidadania",
        ],
};

selectSubjectsTag = document.getElementById("cadeira");
selectCoursesTag  = document.getElementById("curso");

changeSubjects();

