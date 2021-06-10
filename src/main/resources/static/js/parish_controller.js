const showBoxBtn = document.querySelector(".new-btn");
const createBtn = document.querySelector(".create-btn");
const cancelBtn = document.querySelector(".cancel-btn");

const updBtn = document.querySelector(".upd-btn");
const delBtn = document.querySelector(".del-btn");
const startBtn = document.querySelector(".start-btn");
const remBtn = document.querySelector(".rem-btn");

//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------

function reset(){
    clear();
    build();
    resetForm();
    hideBox();
}

function classSearch(element, term){
    if (element === null){
        return element;
    } else if (element === document){
        return null;
    }

    if (element.classList.contains(term)){
        return element;
    } else {
        return classSearch(element.parentNode, term);
    }
}

function clickable(ev){
    const el = ev.target;
    const fEl = classSearch(el, "clickable");

    if (fEl === null){

    } else if (fEl.classList.contains("selected")){
        deselect(fEl);
    } else if (fEl.classList.contains("par-con")){
        select(fEl);
    }
}

document.addEventListener("click", ev => clickable(ev));

showBoxBtn.addEventListener("click", showBox);
createBtn.addEventListener("click", create);
cancelBtn.addEventListener("click", hideBox);

updBtn.addEventListener("click", updateSelected);
delBtn.addEventListener("click", deleteSelected);
startBtn.addEventListener("click", addShutDownSelected);
remBtn.addEventListener("click", removeShutDownSelected);

function init(){
    build();
}

init();