import {circuses} from "./index.js";
const itemContainer = document.getElementById("items__container");

export const renderCircus = (items) => {
    itemContainer.innerHTML = "";
    for ( const circus of items) {
        addItemToPage(circus);
    }
};

export const addItemToPage = ({ id, name, amountOfPlaces, address, performancesPerYear }) => {
    itemContainer.insertAdjacentHTML(
      "afterbegin",
      itemTemplate({ id, name, address, amountOfPlaces, performancesPerYear })
    );
}

const itemTemplate = ({ id, name, address, amountOfPlaces, performancesPerYear }) => `
<li>
    <img class="item__photo" src="img/circus.svg" alt="circus">
    <div class="item">
        <h3 class="item__name">Circus Name: ${name}</h3>
        <h4 class="item__amountOfPlaces">Amount Of Places: ${amountOfPlaces}</h4>
        <h4 class="item__address">Address: ${address}</h4>
        <h4 class="item__performancesPerYear">Performance Per Year: ${performancesPerYear}</h4>
        <div class="button__item">
            <button class="button__remove" onClick='editCircus(${id})'>Edit</button>
            <button class="button__remove" onClick='removeCircus(${id})'>Remove</button>
        </div>
    </div>
</li>`;

export const calcAmountOfPerformances = (arr) => {
    const generalAmountOfPerformances = arr.map(circus => circus.performancesPerYear);
    return generalAmountOfPerformances.reduce((sum, current) => +sum + +current);
}