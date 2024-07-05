const fs = require("fs");
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().split('\n');

const bingo = input.slice(0, 5).map(line => line.split(' ').map(Number));
const called = input.slice(5, 10).map(line => line.split(' ').map(Number));

let x = [0, 0, 0, 0, 0];
let y = [0, 0, 0, 0, 0];
let xy = [0, 0];

function solution() {
    let cnt = 0;

    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            // bingo의 숫자 지우기
            delBingo(called[i][j]);
            cnt++;

            if (checkBingo()) {
                return cnt;
            }
        }
    }
}

function delBingo(targetNum) {
    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            if (targetNum === bingo[i][j]) {
                bingo[i][j] = -1;
                x[i]++;
                y[j]++;
                checkXY(i, j);
                return;
            }

        }
    }
}

function checkXY(i, j) {
    for (let a = 0; a < 5; a++) {
        if (i === a && j === a) {
            xy[0]++;
        }
    }

    for (let b = 0; b < 5; b++) {
        if (i === b && j === 4 - b) {
            xy[1]++;
        }
    }
}

function checkBingo() {
    let bingoCnt = 0;
    for (let i = 0; i < 5; i++) {
        if (x[i] >= 5) {
            bingoCnt++;

        }

        if (y[i] === 5) {
            bingoCnt++;

        }

        if (bingoCnt >= 3) {
            return true;
        }
    }

    for (let j = 0; j < 2; j++) {
        if (xy[j] === 5) {
            bingoCnt++;
            if (bingoCnt >= 3) {
                return true;
            }
        }
    }
}

console.log(solution());