import service from "./service/service";

export default function session() {
    const password = this.status(true)

    service.post("api/session?password=" + {password})

}