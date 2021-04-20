var names = [];
names[0] = '유정모';
names.push('구자혁'); // 배열의 제일 마지막 위치에 인덱스 값을 추가한다는 명령어 push
names.push('석정원');
names.pop(); // 배열을 뒤에서부터 하나씩 지워준다.
delete names[0]; // delete는 지정된 요소값만 지우고 자리는 남아있다.
names.shift(); // 첫번째위치부터 하나씩 지워준다. 자리도 지워준다.
names.unshift('김이담'); // 배열의 제일 앞에 인덱스 값을 추가한다. 

names.push('공도현');
names.push('소국진');
names.push('전형민');

// var show = document.getElementById('show');
// var ulTag = document.createElement('ul');
// show.appendChild(ulTag);

// forEach() : 배열 안 각각의 element에 대해 같은 코드를 수행하게 한다.
// names.forEach(function (val, idx, ary) {  
//     // 배열함수의 callback 요소의 첫번째 값은 배열의 첫번째 값, 두번째값은 인덱스값, 세번째는 배열 그자체
//      console.log(`names 요소: ${val}, ${idx}, ${ary}`); // i라는 변수를 읽어올때는 ${i}
//     // console.log('names 요소: ' + i); 이렇게도 가능
//     var liTag = document.createElement('li');
//     liTag.innerHTML = val; // 배열의 첫번째 값을 넣겠다. = <li>김이담</li>
//     ulTag.appendChild(liTag);
// });

//map() : function을 수행하고 새로운 배열을 return한다. 
var returnVal = names.map(function(val, idx, ary) {
    var person = {};    // {}; 뜻 : "오브젝트입니다"
    person.name = val;
    person.num = idx;
    return person;
});

// filter() :  function을 수행하고 조건을 만족하는 새로운 배열을 return한다.
console.log(returnVal);
console.log('-------------');
var returnFil = returnVal.filter(function(val, idx, ary) { // 참, 거짓을 리턴해줌
    return idx % 2 == 0;  // 짝수의 인덱스 값만 출력해본다. 
});  
console.log(returnFil);
