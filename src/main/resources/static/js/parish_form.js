const formBtns = document.querySelectorAll(".form-btn");
const formInps = document.querySelectorAll(".form-inp");

const idInp = document.querySelector(".id-inp");
const nameInp = document.querySelector(".name-inp");
const codeInp = document.querySelector(".code-inp");
const infInp = document.querySelector(".inf-inp");

const dateInp = document.querySelector(".date-inp");

const comSel = document.querySelector(".com-sel");

//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------

function setComSel() {
    getCommunes()
        .then(data => {
            for (let i = 0; i < data.length; i++){
                const opt = document.createElement("option");
                opt.value = i;
                opt.innerHTML = data[i].name;
                comSel.appendChild(opt);
            }
        })
}

function resetForm(){
    formInps.forEach(i => {i.value = ""; i.disabled = true});
    formBtns.forEach(b => b.disabled = true);
    comSel.disabled = true;
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

    //Commune
    if (parish.commune === null){
        comSel.disabled = false;
        comSaveBtn.disabled = false;
    } else {
        comRemBtn.disabled = false;
    }
}

function updateSelected(){
    const parish = parishes[selectedCon];
    parish.name = nameInp.value;
    parish.code = codeInp.value;
    parish.infectionPressure = infInp.value;
    updateParish(parish)
        .then(status => {reset()});
}

function deleteSelected(){
    const parish = parishes[selectedCon];
    console.log(selectedCon, parish);
    deleteParish(parish)
        .then(status => {reset()});
}

function removeShutDownSelected(){
    const parish = parishes[selectedCon];
    endShutDown(parish)
        .then(status => {reset()});
}

function addShutDownSelected(){
    const parish = parishes[selectedCon];
    parish.shutDownEndDate = dateInp.value;
    newShutDown(parish)
        .then(status => {reset()});
}

function saveCom(){
    const parish = parishes[selectedCon];
    parish.commune = communes[comSel.value];
    updateParish(parish)
        .then(status => {reset()});
}

function remCom(){
    const parish = parishes[selectedCon];
    parish.commune = null;
    updateParish(parish)
        .then(status => {reset()});
}