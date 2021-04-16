var names = []; // 새로운 배열을 생성할 때 new Array();라고 쓰지 않고 이렇게 쓰는거 추천.
names[0] = 'hong';
names[1] = 'Hwang';
names[2] = 'Park';
names[3] = 'Choi';

for (var i = 0; i < names.length; i++) {
    document.write('<h2>' + names[i] + '</h2>');
}

console.log('---------------');
// <table border='1'></table>이라고 적지않고 큰따옴표로 묶어줘야 문법상 맞게된다. 
var tableTag = '<table border="1">';
tableTag += '<tr><th>이름</th><th>나이</th></tr>'; // 기존의 tableTag에 새로운 값을 추가한다는 것

var persons = [obj, obj2, obj3];
for (var i = 0; i < persons.length; i++) {
    if (persons[i].age < 20) {
        tableTag += '<tr><td style="color: red;">' + persons[i].name + '</td><td style="color: red;">' + persons[i].age + '</td></tr>'
    } else {
        tableTag += '<tr><td>' + persons[i].name + '</td><td>' + persons[i].age + '</td></tr>'
    }

}
tableTag += '</table>'; // 테이블 닫는 태그
document.write(tableTag);
