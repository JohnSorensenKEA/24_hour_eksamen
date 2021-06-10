const parList = document.querySelector(".par-list");

//-----------------------------------------------------------------------------------
let parishCons = [];
let selectedCon = -1;

//-----------------------------------------------------------------------------------

function deselect(el){
    el.className = "clickable par-con";
    selectedCon = -1;
    resetForm();
}

function select(el){
    resetForm();
    selectedCon = el.getAttribute("id");
    parishCons.forEach(con => con.className = "clickable par-con");
    el.className = "clickable par-con selected";
    setForm(el.getAttribute("id"));
}

function clear(){
    parishCons = [];
    selectedCon = -1;
    parList.innerHTML = "";
}

function setParishes(parishData){
    for(let i = 0; i < parishData.length; i++){
        const con = document.createElement("div");
        con.id = i;
        con.className = "clickable par-con";

        const navn = document.createElement("p");
        navn.innerHTML = parishData[i].name + " - " + parishData[i].code;
        con.appendChild(navn);

        const commune = document.createElement("p");
        if (parishData[i].commune === null){
            commune.innerHTML = "Kommune ikke sat";
        } else {
            commune.innerHTML = parishData[i].commune.name;
        }
        con.appendChild(commune);

        const inf = document.createElement("p");
        inf.innerHTML = "Smittetryk: " + parishData[i].infectionPressure;
        con.appendChild(inf);

        const checkBox = document.createElement("p");
        checkBox.innerHTML = "status: ";

        if (parishData[i].shutDownStartDate !== null){
            checkBox.innerHTML += "Lukket ☒";
            checkBox.className = "red";
        } else {
            checkBox.innerHTML += "Åben ☐";
            checkBox.className = "green";
        }
        con.appendChild(checkBox);

        parishCons.push(con);
        parList.appendChild(con);
    }
}

function build(){
    getParishes()
        .then(parishData => setParishes(parishData));
}