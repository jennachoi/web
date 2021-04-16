class Student {
    constructor(name, age, score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    showAge() {
        return this.age;
    }
    showInfo() {
        return '이름은 ' + this.name + ', 점수는 ' + this.score;
    }
}

var Students = [];
Students[0] = new Student('정동영', 25, 80);
Students[1] = new Student('김이담', 24, 83);
Students[2] = new Student('석정원', 22, 75);
Students[3] = new Student('공도현', 35, 67);

console.log(Students);


function createTr(obj) {
    var tr = '';
    tr += '<tr>';
    tr += '     <td>' + obj.name + '</td>';
    tr += '     <td>' + obj.age + '</td>';
    tr += '     <td>' + obj.score + '</td>';
    tr += '</tr>';
    return tr;
}
var table = '<table>';
for(var i=0; i<Students.length; i++) {
    table += createTr(Students[i]);
}
table += '</table>';

document.write(table);