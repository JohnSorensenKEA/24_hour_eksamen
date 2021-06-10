const communeCon = document.querySelector(".com-con");

const getRequestOptions = {
    headers: {
        "content-type": 'application/json'
    },
    method: 'GET',
    redirect: 'follow'
};

const getAllCommunesUrl = "/api/allCommunes";
const getParishesByCommuneUrl = "/api/communeParishes/";

function setInfectionNumber(commune, element){
    fetch(getParishesByCommuneUrl + commune.id, getRequestOptions)
        .then(response => response.json())
        .then(data => {
            if (data.length === 0){
                element.innerHTML = "Ingen smittetryks data";
            } else {
                let count = 0;
                let value = 0;
                data.forEach(parish => {
                    if (typeof parish.infectionPressure === 'number'){
                        count++;
                        value += parish.infectionPressure;
                    }
                });
                let avg = value/count;

                element.innerHTML = "Smittetryk: " + avg;
            }
        })
}

function setCommunes(data){
    data.forEach(commune => {
        const communeEl = document.createElement("div");
        communeEl.className = "com";

        const name = document.createElement("p");
        name.innerHTML = commune.name;
        communeEl.appendChild(name);

        const code = document.createElement("p");
        code.innerHTML = "Kommunekode: " + commune.code;
        communeEl.appendChild(code);

        const infectionMsg = document.createElement("p");
        communeEl.appendChild(infectionMsg);

        communeCon.appendChild(communeEl);
        setInfectionNumber(commune, infectionMsg)
    });
}

function getCommunes(){
    fetch(getAllCommunesUrl, getRequestOptions)
        .then(response => response.json())
        .then(data => setCommunes(data));
}

getCommunes();