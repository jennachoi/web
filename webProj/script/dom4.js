//querySelector : 한 행만 가져옴
//querySelectorAll : 모든 행을 가져옴 
var ps = document.querySelector('div>p'); // div아래의 자식으로 있는 p태그를 모두 가져오겠다는 의미. 
ps.textContent = 'hello';
ps.style.backgroundColor = 'yellow';
// ps.forEach(function (val) {
//     console.log(val);
//     val.innerHTML = '<h1>hello</h1>'; // 이렇게 쓰면 HTML의 형태로 작성됨
//     val.innerText = '<h1>hello</h1>'; // 이렇게 쓰면 글자 그대로 텍스트형식으로 들어감
//     val.textContent = '<h1>hello</h1>'; // innerText와 똑같음. 
//     val.style.backgroundColor = 'green';
// });


// numbers => 1~10까지 변수를 선언
// filter, map, foreach를 사용해서 짝수를 걸러내서 evenVal에 담기
// evenVal => n * 3;을 리턴해주는 매핑작업 => mapVal에 담기
// mapVal을 console.log(각각 출력);

var numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

var evenVal = numbers.filter(function (val) {
    //필터라는 메소드는 콜백함수를 매개변수로 받는다. 
    return val % 2 == 0;
});
var mapVal = evenVal.map(function (val) {
    return val * 3
});
mapVal.forEach(function (val) {
    console.log(val);
});

// 위 문장을 arrow function 람다식으로 작성
// numbers.filter((val) => val % 2 == 0) .map((val) => val * 3) .forEach((val) => console.log(val));
// var sum = (a, b) => a + b;
// sum(10, 20);