//function.js
function sum(num3, num4) {
    var num1 = 10;
    var num2 = 20;
    console.log(num1 + num2 + num3 + num4);
    return (num1 + num2 + num3 + num4);
}
// var result = sum(30, 40, 50);

var numAry = [3, 5, 1, 8, 9];

function arySum(ary) {
    var sum = 0;
    for (var i = 0; i < ary.length; i++) {
        if (ary[i] % 2 == 1)
            sum += ary[i];
    }
    return sum;
}

var sum = arySum(numAry);
document.write('결과값은: ' + sum);

function multi(grade) {
    var tbl = '<table border="1">';
    for (var i = 1; i < 10; i++) {
        tbl += '<tr>'; 
        tbl += '    <td>' + grade + ' * ' + i + '</td>';
        tbl += '    <td>=</td>';
        tbl += '    <td>' + (grade * i) + '</td>';
        tbl += '</tr>';
    }
    tbl += '</table>';
    document.write(tbl);

    // for (var j = 1; j < 10; j++) {
    //     tableTag += '<tr>';
    //     for (var i = 2; i < 10; i++) {
    //         tableTag += '<td>' + i + '*' + j + '=' + i * j + '</td>'
    //     }
    //     tableTag += '</tr>';
}
multi(5);