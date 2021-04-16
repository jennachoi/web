// function3.js

var sum = function (a, b) { // 변수 안에 function 정의 구문을 넣고 실행 가능
    var num1 = 10;
    var num2 = 20;
    console.log(a + (num1 + num2) + b);
}
sum('결과는 ', '입니다.');

// 재귀호출함수 : function 안에서 또다시 function 호출 가능
var factorial = function fac(n) {
    if (n == 1) {
        return 1;
    }
    return n * fac(n - 1);
}

var result = factorial(3);
console.log(result);

function sumVal(a, b) {
    return a + b;
}

function mulVal(a, b) {
    return a * b;
}

function executeFunc(callBack, num1, num2) {
    var result = callBack(num1, num2);
    return result;
}

result = executeFunc(mulVal, 3, 8);
console.log('결과: ' + result);