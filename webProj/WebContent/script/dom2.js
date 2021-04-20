       
    // 예제
    // <form action="login.jsp" method="get">
    // id:<input type='text' name='id'><br>
    // passwd:<input type='password' name='passwd'><br>
    //     <input type='submit' value="Send">
    //     <input type='reset' value="Cancel">
    // </form></input>
       
       
       //form 생성
       var formTag = document.createElement('form');
       formTag.setAttribute('action', 'login.jsp');
       formTag.setAttribute('method', 'get');
       
       // label => id:, password:
       var id = document.createTextNode('id:');
       var passwd = document.createTextNode('passwd:');

       // input => id, passwd
       var inputId = document.createElement('input');
       inputId.setAttribute('type', 'text');
       inputId.setAttribute('name','id');
       var inputPw = document.createElement('input');
       inputPw.setAttribute('type', 'name')
       inputPw.setAttribute('password', 'passwd');

       // input => Send, Cancel
       var send = document.createElement('input');
       send.setAttribute('type','submit');
       send.setAttribute('value','Send');
       var cancel = document.createElement('input');
       cancel.setAttribute('type','reset');
       cancel.setAttribute('value','Cancel');

       document.body.appendChild(formTag);
       formTag.setAttribute('style', 'display: block');
       formTag.appendChild(id);
       formTag.appendChild(inputId);
       formTag.appendChild(passwd);
       formTag.appendChild(inputPw);
       formTag.appendChild(send);
       formTag.appendChild(cancel);

       var show = document.getElementById('show');
       show.appendChild(formTag);
