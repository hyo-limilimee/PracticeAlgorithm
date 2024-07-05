const fs = require("fs");
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const T = Number(input[0]);
let gears = input.slice(1, T + 1).map(line => line.split('').map(Number));
const K = Number(input[T + 1]);
let rotations = input.slice(T + 2, T + 2 + K).map(line => line.split(' ').map(Number));

function rotateGear(gear, direction) {
    if (direction === 1) {
        return [gear[7], ...gear.slice(0, 7)];
    } else {
        return [...gear.slice(1, 8), gear[0]];
    }
}

function solution() {
    for (let i = 0; i < K; i++) {
        let gearIndex = rotations[i][0] - 1;
        let direction = rotations[i][1];
        
        let rotateDirs = Array(T).fill(0);
        rotateDirs[gearIndex] = direction;
        
        // Check left side
        for (let j = gearIndex - 1; j >= 0; j--) {
            if (gears[j][2] !== gears[j + 1][6]) {
                rotateDirs[j] = -rotateDirs[j + 1];
            } else {
                break;
            }
        }
        
        // Check right side
        for (let j = gearIndex + 1; j < T; j++) {
            if (gears[j][6] !== gears[j - 1][2]) {
                rotateDirs[j] = -rotateDirs[j - 1];
            } else {
                break;
            }
        }
        
        // Apply rotations
        for (let j = 0; j < T; j++) {
            if (rotateDirs[j] !== 0) {
                gears[j] = rotateGear(gears[j], rotateDirs[j]);
            }
        }
    }
    
    let count = 0;
    for (let j = 0; j < T; j++) {
        if (gears[j][0] === 1) {
            count++;
        }
    }
    
    console.log(count);
}

solution();
