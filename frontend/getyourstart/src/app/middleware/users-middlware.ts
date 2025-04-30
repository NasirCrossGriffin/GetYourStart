import { environment } from '../../environments/environment';

const BASE_URL : string = environment.BASE_URL;

export async function createUser(userRequest : any) {
    const foundUserResponse : Response = await fetch(`${BASE_URL}/api/user`, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        credentials: 'include',  
        body : JSON.stringify(userRequest)
    });

    if (foundUserResponse.ok) {
        const foundUser = foundUserResponse.json();
        return foundUser;
    } else {
        return null;
    }
}

export async function authenticateUser(userRequest : any) {
    const foundUserResponse : Response = await fetch(`${BASE_URL}/api/user/authenticate`, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        credentials: 'include',  
        body : JSON.stringify(userRequest)
    });

    if (foundUserResponse.ok) {
        const foundUser = await foundUserResponse.json();
        return foundUser;
    } else {
        return null;
    }
}

export async function logoutUser() {
    const Response : Response = await fetch(`${BASE_URL}/api/user/logout`, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        credentials: 'include',
    });

    if (Response.ok) {
        const message = await Response.text();
        console.log(message);
        return message;
    } else {
        return null;
    }
}

export async function getLoggedInUser() {
    const foundUserResponse : Response = await fetch(`${BASE_URL}/api/user/check`, {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        credentials: 'include',  
    });

    if (foundUserResponse.ok) {
        const foundUser = await foundUserResponse.json();
        return foundUser;
    } else {
        return null;
    }
}