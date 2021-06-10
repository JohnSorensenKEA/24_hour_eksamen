const showBoxBtn = document.querySelector(".new-btn");
const createBtn = document.querySelector(".create-btn");
const cancelBtn = document.querySelector(".cancel-btn");

//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------

function reset(){
    clear();
    build();
    //TODO: Add form reset
}

showBoxBtn.addEventListener("click", showBox);
createBtn.addEventListener("click", create);
cancelBtn.addEventListener("click", hideBox);

function init(){
    build();
}

init();