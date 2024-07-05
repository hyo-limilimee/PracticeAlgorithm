const fs = require("fs");
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const N = Number(input[0]);
let gears = input.slice(1, N + 1).map(line => line.split('').map(Number));
const K = Number(input[N + 1]);
let rotations = input.slice(N + 2, N + 2 + K).map(line => line.split(' ').map(Number));

function solution() {
    for (let i = 0; i < K; i++) {
        let gearIndex = rotations[i][0] - 1;
        let direction = rotations[i][1];

        let rotateDirection = Array(N).fill(0);
        rotateDirection[gearIndex] = direction;

        // 왼쪽
        for (let j = gearIndex - 1; j >= 0; j--) {
            if (gears[j][2] !== gears[j + 1][6]) {
                rotateDirection[j] = -rotateDirection[j + 1];
            } else {
                break;
            }
        }

        // 오른쪽
        for (let j = gearIndex + 1; j < N; j++) {
            if (gears[j][6] !== gears[j - 1][2]) {
                rotateDirection[j] = -rotateDirection[j - 1];
            } else {
                break;
            }
        }

        // 회전
        for (let k = 0; k < N; k++) {
            if (rotateDirection[k] !== 0) {
                gears[k] = rotate(gears[k], rotateDirection[k]);
            }
        }

    }

    let cnt = 0;
    for (let j = 0; j < gears.length; j++) {
        if (gears[j][0] === 1) {
            cnt++;
        }
    }

    return cnt;
}

function rotate(gear, direction) {
    if (direction === 1) {
        return [gear[7], ...gear.slice(0, 7)];
    } else {
        return [...gear.slice(1, 8), gear[0]];
    }
}

console.log(solution());