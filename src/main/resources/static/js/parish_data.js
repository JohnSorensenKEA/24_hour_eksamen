let body1 = null;

const getRequestOptions = {
    headers: {
        "content-type": 'application/json'
    },
    method: 'GET',
    redirect: 'follow'
};

const deleteRequestOptions = {
    headers: {
        'Content-Type': 'application/json'
    },
    method: 'DELETE',
    body: body1
};

const postRequestOptions = {
    headers: {
        'Content-Type': 'application/json'
    },
    method: 'POST',
    body: body1
};

const putRequestOptions = {
    headers: {
        'Content-Type': 'application/json'
    },
    method: 'PUT',
    body: body1
};

const getAllParishesUrl = "/api/allParishes";
const createParishUrl = "/api/newParish";
const updateParishUrl = "/api/updateParish";
const newShutDownUrl = "/api/newShutDown";
const endShutDownUrl = "/api/removeShutDown";
const deleteParishUrl = "/api/deleteParish";

//-----------------------------------------------------------------------------------
let parishes = [];

//-----------------------------------------------------------------------------------

function getParishes(){
    return fetch(getAllParishesUrl, getRequestOptions)
        .then(response => response.json())
        .then(data => {parishes = data; return data});
}

function createParish(parish){
    body1 = JSON.stringify(parish);
    postRequestOptions.body = body1;

    return fetch(createParishUrl, postRequestOptions)
        .then(response => response.status)
        .then(status => {return status});
}

function updateParish(parish){
    body1 = JSON.stringify(parish);
    putRequestOptions.body = body1;

    return fetch(updateParishUrl, putRequestOptions)
        .then(response => response.status)
        .then(status => {return status});
}

function newShutDown(parish){
    body1 = JSON.stringify(parish);
    putRequestOptions.body = body1;

    return fetch(newShutDownUrl, putRequestOptions)
        .then(response => response.status)
        .then(status => {return status});
}

function endShutDown(parish){
    body1 = JSON.stringify(parish);
    putRequestOptions.body = body1;

    return fetch(endShutDownUrl, putRequestOptions)
        .then(response => response.status)
        .then(status => {return status});
}

function deleteParish(parish){
    body1 = JSON.stringify(parish);
    deleteRequestOptions.body = body1;

    return fetch(deleteParishUrl, deleteRequestOptions)
        .then(response => response.status)
        .then(status => {return status});
}