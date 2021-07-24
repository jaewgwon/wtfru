import service from "./service/service";

function getSession(hostData) {
    return service ({
        url: "api/seesion?password=true",
        method: "get",
        hostData
    });
};

function postSession(hostData) {
    return service ({
        url: "api/session?password=true",
        method: "post", 
        hostData
    });
};

function deleteSession(hostData) {
    return service ({
        url: "api/session?password=true",
        method: "delete",
        hostData
    });
};

function getLocation(clientData) {
    return service ({
        url: ("api/session" + {uid} + "/location/" + {locationId}),
        method: "get",
        clientData
    });
};

function postLocation(clientData) {
    return service ({
        url: ("api/session/" + {uid} + "/location/" + {locationId}),
        method: "post", 
        clientData
    });
};

function patchLocation(clientData) {
    return service ({
        url: ("api/session/" + {uid} + "/location/" + {locationId}),
        method: "patch",
        clientData
    });
};

function getStatus(clientData) {
    return service ({
        url: ("api/session/" + {uid} + "/status"),
        method: "get",    
        clientData
    });
};

function putStatus(clientData) {
    return service ({
        url: ("api/session/" + {uid} + "/status"),
        method: "put",
        clientData
    });
};


export { 
    getSession,
    postSession,
    deleteSession,
    getLocation,
    postLocation,
    patchLocation,
    getStatus,
    putStatus
};