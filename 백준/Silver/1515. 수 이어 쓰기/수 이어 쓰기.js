const fs = require("fs");
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

let current = 1;
let index = 0;

while (true) {
    if (index >= input.length) {
        break;
    }
    num = current.toString().split('');

    // current 안에 input의 해당 index 숫자가 있는 지 확인
    for (let i = 0; i < num.length; i++) {
        if (num[i] === input.charAt(index)) {
            index++;

            if (index >= input.length) {
                break;
            }
        }
    }
    current++;
}
console.log(current - 1);