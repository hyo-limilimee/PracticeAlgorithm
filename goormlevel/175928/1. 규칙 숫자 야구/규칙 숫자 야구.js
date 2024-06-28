// Run by Node.js
const readline = require('readline');

function checkStatus(answer, input) {
    let result = [];

    input.forEach((number, index) => {
        if (!answer.includes(number)) {
            result.push("Fail");
        } else if (answer[index] === number) {
            result.push("Strike");
        } else {
            result.push("Ball");
        }
    });
    return result;
}

function ballProcess(result, input) {
    let strikeIndex = [];
    let nonStrike = [];	// strike가 아닌 것

    result.forEach((currentNum, index) => {
        if (currentNum === "Strike") {
            strikeIndex.push(index);
        }
				// Strike가 아닌 경우 해당 인덱스의 input 값 push
				else {
            nonStrike.push(input[index]);
        }
    });

    let last = nonStrike.pop();
    nonStrike.unshift(last);

    if (strikeIndex.length > 0) {
        strikeIndex.forEach((oneIndex) => {
            nonStrike.splice(oneIndex, 0, input[oneIndex]);
        });
    }
    return nonStrike;
}

function solution(answer, input) {
    let result = checkStatus(answer, input);
    let cnt = 0;

    while (input.join('') !== answer.join('')) {
        for (let i = 0; i < 4; i++) {
            // 모두 Strike인 경우
            if (result.filter((currentNum) => currentNum === "Strike").length === 4) {
                break;
            }

            // 현재 위치에서 조사
            if (result[i] === "Strike") {
                continue;
            } else if (result[i] === "Fail") {
								input[i] = (input[i]+1) % 10;

                while (input.filter((number, index) => index !== i).includes(input[i])) {
                    input[i] = (input[i] + 1) % 10;
                }
            }
        }

        if (result.includes("Ball")) {
            input = ballProcess(result, input);
        }

        result = checkStatus(answer, input);
        cnt++;
    }
    return cnt + 1;
}

(async () => {
    let rl = readline.createInterface({ input: process.stdin });

    let answer = null;
    let input = null;

    for await (const line of rl) {
        if (!answer) {
            answer = line.trim().split('').map(Number);
        } else {
            input = line.trim().split('').map(Number); 
            rl.close();
        }
    }

    console.log(solution(answer, input));
    process.exit();
})();
