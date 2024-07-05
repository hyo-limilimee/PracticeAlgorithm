const fs = require("fs");
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = Number(input[0]);
const num = Number(input[1]);
let arr = [];

for (let i = 0; i < N; i++) {
    arr.push(new Array(N).fill(0));
}

const direction = [[1, 0], [0, 1], [-1, 0], [0, -1]];

function solution() {
    let x = 0;
    let y = 0;

    let findX = 0;
    let findY = 0;

    let dir = 0;

    for (let i = N * N; i > 0; i--) {
        arr[x][y] = i;

        if (i === num) {
            findX = x + 1;
            findY = y + 1;
        }

        let dx = x + direction[dir][0];
        let dy = y + direction[dir][1];

        if (dx < 0 || dx >= N || dy < 0 || dy >= N || arr[dx][dy] !== 0) {
            dir = (dir + 1) % 4;
            dx = x + direction[dir][0];
            dy = y + direction[dir][1];
        }

        x = dx;
        y = dy;
    }

    for (let i = 0; i < N; i++) {
        console.log(arr[i].join(' '));
    }

    console.log(findX, findY);
}

solution();