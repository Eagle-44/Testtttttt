const nameInput = document.getElementById("name");
const amountOfPlaces = document.getElementById("amount_of_places");
const addressInput = document.getElementById("address");
const performancesPerYear = document.getElementById("performances_per_year");

export const getInputValues = () => {
    return {
        name: nameInput.value,
        amountOfPlaces: amountOfPlaces.value,
        address: addressInput.value,
        performancesPerYear: performancesPerYear.value,
    };
};

export const getInputValuesEdit = () => {
    return {
        name: nameInput.value,
        amountOfPlaces: amountOfPlaces.value,
        address: addressInput.value,
        performancesPerYear: performancesPerYear.value,
    };
};

export const clearInputs = () => {
    nameInput.value = "";
    amountOfPlaces.value = "";
    addressInput.value = "";
    performancesPerYear.value = ""; 
};