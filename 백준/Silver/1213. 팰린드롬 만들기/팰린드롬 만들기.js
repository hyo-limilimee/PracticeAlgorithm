/*
* 문자의 개수 카운트 했을 때, 개수인 홀수인 경우가 없거나 1개인 경우만 가능
* 딕셔너리를 통해 문자와 그 개수를 저장 (저장 후 정렬 필요)
* 홀수가 없는 경우: 절반 개수만큼만 문자열에 더해주고 반대로 그 이후에 더해줌
* 홀수가 1개인 경우: 절반 개수만큼 문자열에 더해주고 그 홀수인 개수인 문자를 넣어주고, 나머지 반대로
* */

const fs = require("fs");
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim();

function solution() {
    let strInfo = {};

    // 문자별로 개수 저장
    for (let i = 0; i < input.length; i++) {
        if (strInfo[input[i]] === undefined) {
            strInfo[input[i]] = 1;
        } else {
            strInfo[input[i]] += 1;
        }
    }

    const keys = Object.keys(strInfo).sort();
    let sortedKeys = [];
    let sortedValues = [];

    for (let key of keys) {
        sortedKeys.push(key);
        sortedValues.push(strInfo[key]);
    }

    let reverseStr = '';
    // 개수의 절반만큼 value를 더해줌
    sortedKeys.forEach((char, index) => {
        reverseStr += char.repeat(parseInt(sortedValues[index] / 2));
    })

    // 홀수인 개수가 존재하는 경우 -> 가운데에 넣어줌
    let center = '';
    let c = sortedValues.findIndex(n => n % 2 === 1);

    // 홀수 개수가 2개 이상인 경우
    if (sortedValues.filter(n => n % 2 === 1).length > 1) {
        return console.log("I'm Sorry Hansoo");
    }

    if (c !== -1) {
        center += sortedKeys[c];
    }

    console.log(reverseStr + center + reverseStr.split('').reverse().join(''));
}

solution();
