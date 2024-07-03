const fs = require("fs");
const filePath = process.platform === 'linux' ? '/dev/stdin' : 'D:\\algorithm-js\\algorithm-js\\.idea\\BOJ\\Implementation\\input.txt';
const input = fs.readFileSync(filePath).toString().split('\n');

function solution(input) {
    const N = parseInt(input[0].trim());
    const votes = input.slice(1).map(line => parseInt(line.trim()));

    // 다솜이의 초기 득표수
    let dasomVotes = votes[0];

    // 다솜이가 매수해야 하는 사람 수
    let bought = 0;

    // 다른 후보들의 득표수를 관리하기 위해 정렬
    let others = votes.slice(1).sort((a, b) => b - a);

    while (others.length > 0 && dasomVotes <= others[0]) {
        // 가장 득표수가 많은 후보에게서 표 하나를 매수
        others[0]--;
        dasomVotes++;
        bought++;

        // 매수 후 다시 정렬
        others.sort((a, b) => b - a);
    }

    console.log(bought);
}

solution(input);
