const createCon = document.querySelector(".create-con");

const newNameInp = document.querySelector(".new-name-inp");
const newCodeInp = document.querySelector(".new-code-inp");
const newInfInp = document.querySelector(".new-inf-inp");

const newInps = document.querySelectorAll(".new-inp");

const createError = document.querySelector(".create-error");

//-----------------------------------------------------------------------------------


//-----------------------------------------------------------------------------------

function showBox(){
    createCon.hidden = false;
}

function hideBox(){
    createCon.hidden = true;
    newInps.forEach(i => i.value = "");
}

function create(){
    const parish = {
        name: newNameInp.value,
        code: newCodeInp.value,
        infectionPressure: newInfInp.value
    };

    createParish(parish)
        .then(status => {if (status === 200){
            reset();
        } else {
            createError.innerHTML = "Noget gik galt, prøv igen";
        }
        })
}