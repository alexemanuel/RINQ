const grade1Semester1  = document.getElementById("primeira-nota-semestre1");
const grade2Semester1  = document.getElementById("segunda-nota-semestre1");
const recuperacaoGradeSemester1 = document.getElementById("recuperacao-semestre1");

const grade1Semester2  = document.getElementById("primeira-nota-semestre2");
const grade2Semester2  = document.getElementById("segunda-nota-semestre2");
const recuperacaoGradeSemester2 = document.getElementById("recuperacao-semestre2"); 

const averageSemester1TagId = "media-semestre1";
const averageSemester2TagId = "media-semestre2";
const bimestralAverageTagId = "media-bimestral";


// Check Input Grade Validty
function isNumber (e) {
    const charCode = e.charCode ? e.charCode : e.keyCode;
	return (charCode >= 48 && charCode <= 57) || charCode == 46; //charcode 46 = "."
}

function inRange(e) {
	const srcElement = e.srcElement;
	const newGrade = parseFloat(srcElement.value + event.key);

	return newGrade <= 10 && newGrade >= 0; 	
}

function isValidGrade(e){
	return isNumber(e) && inRange(e);
}


//Average Calculation
function calculeAverage(grade1, grade2){
	return (grade1 + grade2) / 2;
}

function getFloatValueFromValueAttr(tagId){
	return parseFloat(document.getElementById(tagId).value);
}

function getFloatValueFromTextContent(tagId){
	return parseFloat(document.getElementById(tagId).textContent);
}

function writeSemesterAverage(average, averageTag){
	averageTag.innerHTML = average;
	
	
	// Set the average in thymleaf mediaSemestre value
	var thymeleafField;
	
	if(averageTag.id.search("bimestral") != -1){
		thymeleafField = document.getElementById("mediaFinal");
	
	}else{
		const semester = getSemesterFromId(averageTag.id);
		thymeleafField = document.getElementById("mediaSemestre" + semester);
	}	
	thymeleafField.value = average;
}	

function getSemesterFromId(tagId){
	return tagId.slice(-1);
}

function calculeSemesterAverage(e){
	const semester = getSemesterFromId(e.srcElement.id);
	
	const grade1 = getFloatValueFromValueAttr("primeira-nota-semestre" + semester);
	const grade2 = getFloatValueFromValueAttr("segunda-nota-semestre" + semester);

	return calculeAverage(grade1, grade2);
}

function calculeSemesterRecuperacaoAverage(e){
	const semester = getSemesterFromId(e.srcElement.id);	
	
	const gradeRecuperacao = parseFloat(e.srcElement.value);
	const semesterAverage  = calculeSemesterAverage(e); 
		
	return calculeAverage(gradeRecuperacao, semesterAverage);
}

function calculeBimestralAverage(e){
	const semester1Average = getFloatValueFromTextContent(averageSemester1TagId);
	const semester2Average = getFloatValueFromTextContent(averageSemester2TagId);

	return calculeAverage(semester1Average, semester2Average);
}

function setAverage(calculeAverageFunc, averageTagId, e){
	const averageTag = document.getElementById(averageTagId);
	const average = calculeAverageFunc(e);

	if(!isNaN(average)){
		writeSemesterAverage(average, averageTag)
		
	}else{
		if(calculeAverageFunc != calculeSemesterRecuperacaoAverage){
			writeSemesterAverage("", averageTag);
			
		}else{
			const average = calculeSemesterAverage(e);
			writeSemesterAverage(average, averageTag);
		}
	}
}

function setAverageCurried(calculeAverageFunc){
	return function(averageTagId){
		return function(e){
			setAverage(calculeAverageFunc, averageTagId, e); 
		}
	}
}

const setSemesterAverage = setAverageCurried(calculeSemesterAverage);
const setRecuperacaoAverage = setAverageCurried(calculeSemesterRecuperacaoAverage);
const setBimestralAverage = setAverageCurried(calculeBimestralAverage)(bimestralAverageTagId);

const setSemesterAverageFirstSemester = setSemesterAverage(averageSemester1TagId);
const setRecuperacaoAverageFirstSemester = setRecuperacaoAverage(averageSemester1TagId);

const setSemesterAverageSecondSemester = setSemesterAverage(averageSemester2TagId);
const setRecuperacaoAverageSecondSemester = setRecuperacaoAverage(averageSemester2TagId);

grade1Semester1.addEventListener("blur", setSemesterAverageFirstSemester);
grade2Semester1.addEventListener("blur", setSemesterAverageFirstSemester);
recuperacaoGradeSemester1.addEventListener("blur", setRecuperacaoAverageFirstSemester);

grade1Semester2.addEventListener("blur", setSemesterAverageSecondSemester); 
grade2Semester2.addEventListener("blur", setSemesterAverageSecondSemester); 
recuperacaoGradeSemester2.addEventListener("blur", setRecuperacaoAverageSecondSemester);

grade1Semester1.addEventListener("blur", setBimestralAverage);
grade2Semester1.addEventListener("blur", setBimestralAverage);
recuperacaoGradeSemester1.addEventListener("blur", setBimestralAverage);

grade1Semester2.addEventListener("blur", setBimestralAverage);
grade2Semester2.addEventListener("blur", setBimestralAverage);
recuperacaoGradeSemester2.addEventListener("blur", setBimestralAverage);


// Unlock Recuperação Field
function isLessThanAverage(grade, average){
	return grade < average;
}
		 
function changeRecuperacaoFieldAvailability(recuperacaoField, grade){	
	recuperacaoField.disabled = !isLessThanAverage(grade, 7); 
	
	if(recuperacaoField.disabled){
		recuperacaoField.value = "";
	}
}

function checkAverageValue(e){
	const semester = getSemesterFromId(e.srcElement.id);

	const average  = getFloatValueFromTextContent("media-semestre" + semester);	
	const recuperacaoField = document.getElementById("recuperacao-semestre" + semester);	
	
	changeRecuperacaoFieldAvailability(recuperacaoField, average);
}

grade1Semester1.addEventListener("blur", checkAverageValue);
grade2Semester1.addEventListener("blur", checkAverageValue);

grade1Semester2.addEventListener("blur", checkAverageValue);
grade2Semester2.addEventListener("blur", checkAverageValue);


function unlockRecuperacaoFieldInInitialization(semester){
	const recuperacaoField = document.getElementById("recuperacao-semestre" + semester);
	const grade1 = getFloatValueFromValueAttr("primeira-nota-semestre" + semester);
	const grade2 = getFloatValueFromValueAttr("segunda-nota-semestre" + semester);

	const average = calculeAverage(grade1, grade2);
	
	changeRecuperacaoFieldAvailability(recuperacaoField, average);
}

unlockRecuperacaoFieldInInitialization("1")
unlockRecuperacaoFieldInInitialization("2")


