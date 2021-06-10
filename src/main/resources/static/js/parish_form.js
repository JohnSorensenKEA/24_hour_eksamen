const formBtns = document.querySelectorAll(".form-btn");
const formInps = document.querySelectorAll(".form-inp");

const idInp = document.querySelector(".id-inp");
const nameInp = document.querySelector(".name-inp");
const codeInp = document.querySelector(".code-inp");
const infInp = document.querySelector(".inf-inp");

const dateInp = document.querySelector(".date-inp");

//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------

function resetForm(){
    formInps.forEach(i => {i.value = ""; i.disabled = true});
    formBtns.forEach(b => b.disabled = true);
}

function setForm(id){
    const parish = parishes[id];

    //Base
    idInp.value = parish.id;

    nameInp.value = parish.name;
    nameInp.disabled = false;

    codeInp.value = parish.code;
    codeInp.disabled = false;

    infInp.value = parish.infectionPressure;
    infInp.disabled = false;

    //Controller spaghetti
    updBtn.disabled = false;
    delBtn.disabled = false;

    //ShutDown
    if (parish.shutDownStartDate === null){
        dateInp.disabled = false;
        startBtn.disabled = false;
    } else {
        remBtn.disabled = false;
    }
}

function updateSelected(){
    const parish = parishes(selectedCon);
    parish.name = nameInp.value;
    parish.code = codeInp.value;
    parish.infectionPressure = infInp.value;
    updateParish(parish);
}

function deleteSelected(){
    const parish = parishes(selectedCon);
    deleteParish(parish);
}

function removeShutDownSelected(){
    const parish = parishes(selectedCon);
    endShutDown(parish);
}

function addShutDownSelected(){
    const parish = parishes(selectedCon);
    parish.shutDownEndDate = dateInp.value;
    newShutDown(parish);
}