import http from 'k6/http';
import { check, sleep } from 'k6';

export default function () {
    const data = JSON.stringify({ "name": "Gabriel Paula", "age": 29, "admitionDate": "2021-05-02T10:54:05.591", "gender": "M" });
    var params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };
    let res = http.post('http://localhost:8080/employee', data, params);
    // console.log(`response log: ${JSON.stringify(res)}`);
    check(res, { 'created employee': (r) => r.status === 201 });
    // sleep(0.3);
}
