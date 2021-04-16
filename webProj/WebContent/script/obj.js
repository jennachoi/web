var num1, num2, result;
num1 = 25;
num2 = 2;
result = num1 / num2;
result = num1 % num2; // 25를 2로 나누고 나머지를 구한다 

var num3 = '25';
console.log(num1 == num3);  // true. 값만 비교함
console.log(num1 === num3);  // false. 타입이랑 값을 모두 비교함
console.log('결과값: ' + result);
// console.log는 실행값을 출력해주는 메소드

var obj = {}; // 오브젝트 선언. {};는 new Object();와 같은 의미
obj.name = 'hong';
obj.age = 20;
obj.showInfo = function () {
	console.log('이름: ' + obj.name + ', 나이: ' + obj.age);
}
//console.log();
obj.showInfo(); // console에 작성한 정보를 보여줌 

// 선언하고 fuction까지 정의하기
var obj2 = {
	name: 'Hwang',
	age: 22,
	showInfo: function () {
		console.log('이름: ' + this.name + ', 나이: ' + this.age);
	}
}

// 값을 이렇게 넣어줄 수도 있다.
obj2['name'] = 'Park';
obj2['age'] = 33;

obj2.showInfo();

var obj3 = {
	name: 'Kang',
	age: 15
}

