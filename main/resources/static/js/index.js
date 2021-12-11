import {addItemToPage, renderCircus, calcAmountOfPerformances} from "./index_util.js";
import {get, post, put, del, sleep} from "./crud_http.js";

const searchInput = document.getElementById("search__input");
const searchButton = document.getElementById("search__button");
const clearButton = document.getElementById("clear__button");
const switchButton = document.getElementById("switch");
const countButton = document.getElementById("count__button");
const countVal = document.getElementById("count__value");

export let circuses;

document.addEventListener("DOMContentLoaded",() => {
    circuses = get();
    circuses.then(function(result) {
        if(result.length === 0){
            circuses = [
                {
                    id: 0,
                    name: "Shapito",
                    amountOfPlaces: 1111,
                    address: "Str.Lion 10",
                    performancesPerYear: 111,
                },
                {
                    id: 1,
                    name: "Reper",
                    amountOfPlaces: 123,
                    address: "Str.qwerty 1",
                    performancesPerYear: 122,
                },
                {
                    id: 2,
                    name: "Res",
                    amountOfPlaces: 9999,
                    address: "13 Av.New",
                    performancesPerYear: 34,
                }
            ];
            for (const circus of circuses) {
                post(circus);
            }
        }
        renderCircus(result);
    });
});

searchButton.addEventListener("click", () =>{
    circuses = get();
    circuses.then(function(result) {
        const searchCircus = result.filter(circus => circus.name.search(searchInput.value) !== -1);
        renderCircus(searchCircus);
    });
});

clearButton.addEventListener("click", () =>{
    searchInput.value = "";
    circuses.then(function(result) {
       renderFarms(result);
    });
    renderCircus(circuses);
});

switchButton.addEventListener("change", () => {
    circuses.then(function(result) {
        let sortedCircuses = Array.from(result);
        if (switchButton.checked) {
            sortedCircuses.sort((circus1, circus2) => circus1.amountOfPlaces - circus2.amountOfPlaces);
        }
        renderCircus(sortedCircuses);
    });
});

countButton.addEventListener("click", () => {
    circuses.then(function(result) {
       countVal.innerHTML = calcAmountOfPerformances(result);
    });
});

window.removeCircus = (id) => {
    del(id);
    sleep(500);
    location.reload();
}

window.editCircus = (id) => {
    localStorage.setItem('editCircus', JSON.stringify(id));
    window.location.href = "create.html";
}

