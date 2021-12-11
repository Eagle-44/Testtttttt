const URL = 'http://localhost:8080/circus';

export const get = async () => {
    const response = await fetch(URL);
    if (response.ok) {
        return response.json();
    } else {
        alert(response.json());
    }
};

export const post = async (circus) => {
    try {
        const response = await fetch(URL, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(circus) });
    } catch (error) {
        return response.json();
    }
}

export const put = async (circus,id) => {
    try {
        const response = await fetch(URL + '/' + id, {
        headers: {
          'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(circus) });
    } catch (error) {
        return response.json();
    }
}

export const del = async (id) => {
    try {
        const response = await fetch(URL + '/' + id, {
        method: 'DELETE'
        });
    } catch (error) {
        return response.json();
    }
}

export function sleep(miliseconds) {
   var currentTime = new Date().getTime();

   while (currentTime + miliseconds >= new Date().getTime()) {
   }
}