import http from 'k6/http';
import { check, sleep } from 'k6';

export default function () {
    var params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };
    let res = http.get('http://localhost:8080/employee/1', params);
    // console.log(`response log: ${JSON.stringify(res)}`);
    check(res, { 'get employee by id': (r) => r.status === 200 });
    // sleep(0);
}
