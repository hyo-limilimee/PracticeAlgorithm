const fs = require("fs");
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().split('\n');

const inputs = input.map((nums) => nums.split(' ').map((num) => Number(num)));
const bingo = inputs.slice(0, 5); // 빙고판
const target = inputs.slice(5, 10); // target 요소

let x = [0, 0, 0, 0, 0];
let y = [0, 0, 0, 0, 0];
let xy = [0, 0];

console.log(solution());

function solution() {
    let cnt = 0;

    // target 순회
    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            // target 순회하며 bingo판 숫자 지우기
            del(target[i][j]);
            cnt++;  // 숫자 카운트 증가
            if (checkBingo()) {
                return cnt;
            }
        }
    }
}

function checkBingo() {
    let bingoCnt = 0;
    for (let i = 0; i < 5; i++) {
        if (x[i] === -5) {
            bingoCnt++;

            if (bingoCnt >= 3) {
                return true;
            }
        }

        if (y[i] === -5) {
            bingoCnt++;

            if (bingoCnt >= 3) {
                return true;
            }
        }
    }

    for (let i = 0; i < 2; i++) {
        if (xy[i] <= -5) {
            bingoCnt++;
            if (bingoCnt >= 3) {
                return true;
            }
        }
    }
}

// 빙고판 숫자 지내기
function del(delNum) {
    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            if (bingo[i][j] == delNum) {
                bingo[i][j] = -1;   // 빙고판 지우기
                // 해당 줄에 -1씩 
                x[i] += -1;
                y[j] += -1;
                checkXY(i, j);
                return;
            }
        }
    }
}

function checkXY(i, j) {
    for (let a = 0; a < 5; a++) {
        if (i === a && j === a) {
            xy[0] += -1;
        }
    }
    for (let b = 0; b < 5; b++) {
        if (i === b && j === 4 - b) {
            xy[1] += -1;
        }
    }
}
