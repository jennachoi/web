
/* <div>Hello</div>
   <div><a href="www.daum.net">다음페이지</a></div>
                  element노드  텍스트노드 
 이렇게 되어있으면 a태그는 div의 자식태그. 감싸고 있으면 자식임 -->
*/

var h1Tag = document.createElement('h1');
h1Tag.innerHTML = 'hello';
console.log(h1Tag);

var aTag = document.createElement('a'); // createElement : A태그를 만든다. 
aTag.setAttribute('href', 'https://www.daum.net'); //setAttribute : aTag라는 변수에 속성을 지정해주는 태그
// aTag.innerHTML = '다음 페이지'; // innerHTML으로 html안에 들어갈 내용을 작성 가능

var text = document.createTextNode('다음 사이트');
aTag.appendChild(text) // aTag 하위에 자식으로 text라는 변수를 추가하겠다.   
console.log(aTag);

// document.body.appendChild(h1Tag);
// document.body.appendChild(aTag);

var show = document.getElementById('show'); // ID값으로도 불러올 수 있다.
show.setAttribute('style', 'background-color: red');
//<div style='background-color: red;'>; 해주는거랑 같음 ! 
show.appendChild(h1Tag);
show.appendChild(aTag);