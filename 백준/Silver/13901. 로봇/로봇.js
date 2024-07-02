/*
* 로봇은 사용자가 지정한 방향을 일직선으로 움직임
* 벽, 방문한 지역, 장애물 -> 사용자 지정한 다음 방향으로 움직임
* 지정한 방향이 없다면 맨 처음 방향으로 돌아가서 반복
* */

const fs = require("fs");
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

function solution(input) {
    idx = 0;
    const [R, C] = input[idx++].split(' ').map(Number);
    const k = Number(input[idx++]);

    const obstacles = [];
    for (let i = 0; i < k; i++) {
        obstacles.push(input[idx++].split(' ').map(Number));
    }

    const [sr, sc] = input[idx++].split(' ').map(Number);
    const directions = input[idx++].split(' ').map(Number)

    // room 만들고 장애물 위치 표시
    const room = Array.from({length: R}, () => Array(C).fill('*'));
    obstacles.forEach(([br, bc]) => {
        room[br][bc] = 'x';
    })

    // 이동방향 순서(1: 위, 2: 아래, 3: 왼쪽, 4: 오른쪽)
    const moves = {
        1: [-1, 0],
        2: [1, 0],
        3: [0, -1],
        4: [0, 1]
    };

    let directionIndex = 0;
    let row = sr;
    let col = sc;

    // 처음 시작 위치에 방문 표시
    let order = 0;
    room[row][col] = order;

    while (true) {
        let moved = false;

        for (let i = 0; i < 4; i++) {
            const [dr, dc] = moves[directions[directionIndex]];
            const nextRow = row + dr;
            const nextCol = col + dc;

            if (nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < C &&
                room[nextRow][nextCol] === '*') {
                // 이동할 수 있는 경우
                row = nextRow;
                col = nextCol;
                order++;
                room[row][col] = order; // 방문 순서 표시
                moved = true;
                break;
            } else {
                // 다음 방향으로 전환
                directionIndex = (directionIndex + 1) % 4;
            }
        }

        if (!moved) {
            // 모든 방향으로 이동할 수 없는 경우 종료
            break;
        }
    }

    console.log(row, col);
}

solution(input);