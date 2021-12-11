import {getInputValues, getInputValuesEdit, clearInputs} from "./create_util.js";
import {get, post, put, del, sleep} from "./crud_http.js";

let circuses = get();
let editId = JSON.parse(localStorage.getItem('editCircus'));

const submitButton = document.getElementById("button__submit");

document.addEventListener("DOMContentLoaded", () => {
    if (localStorage.getItem('editCircus') != null) {
        document.title = "Edit Circus";
        document.getElementById("title").innerHTML = "Edit Circus";
    }
})

submitButton.addEventListener("click", event => {
    if (localStorage.getItem('editCircus') != null) {
        event.preventDefault();
        const { name, address, amountOfPlaces, performancesPerYear } = getInputValuesEdit();
        editItem(editId,{name, address, amountOfPlaces, performancesPerYear});
        localStorage.removeItem('editCircus');
        clearInputs();
        sleep(500);
        window.location.href = "index.html";
    } else{
        event.preventDefault();
        addItem(getInputValues());
        clearInput();
        sleep(500);
        window.location.href = "index.html";
    }
})

const addItem = ({id, name, address, amountOfPlaces, performancesPerYear}) => {
    const newCircus = {
        id,
        name,
        address,
        amountOfPlaces,
        performancesPerYear,
    }
    for(let i in newCircus){
        if (newCircus[i] == "") {
            alert("invalid " + i);
            return null;
        }
    }
    let response = post(newCircus);
    if(response.ok){
        alert(response.status);
    }
}

const editItem = (id,{name, address, amountOfPlaces, performancesPerYear}) => {
    const newCircus = {
        id,
        name,
        address,
        amountOfPlaces,
        performancesPerYear,
    }
    for(let i in newCircus){
        if (newCircus[i] == "") {
            alert("invalid " + i);
            return null;
        }
    }
    put(newCircus,editId);
}


