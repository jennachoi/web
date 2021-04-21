//클릭버튼 속성
var buttons = document.getElementsByTagName('button');
// buttons[0].setAttribute('onclick', 'showTable()');  // 첫번째 버튼에만 속성 지정
for (var i = 0; i < buttons.length; i++) { // 모든 버튼에 속성주기
    buttons[i].setAttribute('onclick', 'showTable()');
}

// 동적테이블 만들기
var p1 = {
    name: '성진아',
    score: 80,
    gender: '여'
}
var p2 = {
    name: '김수민',
    score: 83,
    gender: '여'
}
var p3 = {
    name: '장재우',
    score: 85,
    gender: '남'
}

for (var field in p3) { // 필드개수만큼 반복
}

var persons = [p1, p2, p3];

//테이블 만들기
function showTable() {
    var tableTag = document.createElement('table');
    tableTag.setAttribute('border', '1');

    //반복
    for (var p of persons) { // 배열의 개수만큼 반복
        var tr1 = document.createElement('tr');
        for (var field in p) { // object 개수만큼 반복 
            var td1 = document.createElement('td');
            td1.innerHTML = p[field];
            tr1.appendChild(td1);
        }
        tableTag.appendChild(tr1);
    }
    document.body.appendChild(tableTag);

}