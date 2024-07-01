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
    let sortedValue = [];

    for (let key of keys) {
        sortedKeys.push(key);
        sortedValue.push(strInfo[key]);
    }

    if (sortedValue.filter(n => n % 2 === 1).length > 1) {
        return console.log("I'm Sorry Hansoo");
    }

    let reverseStr = '';
    sortedKeys.forEach((value, index) => {
        reverseStr += value.repeat(parseInt(sortedValue[index] / 2));
    })

    let center = '';
    let c = sortedValue.findIndex(n => n % 2 === 1);
    if (c !== -1) {
        center += sortedKeys[c];
    }
    console.log(reverseStr + center + reverseStr.split('').reverse().join(''));
}

solution();
