/**
 * 
 */

// javascript 문법
		document.write("<h1 style='background-color: yellow; '>Hello World</h1>");
		console.log('Hellow World');
		
		// 새로운 변수 생성은 var로 한다. 
		var ulTag = '<ul><li>Apple</li><li>Banana</li><li>Cherry</li></ul>';
		console.log(typeof ulTag);	 // 변수의 타입을 보여줌
		
		ulTag = 10;
		ulTag = true; 
		ulTag = null;  // null값을 넣을 수도 있다. 
		
		ulTag = 10 + 20;
		console.log(typeof ulTag);   // 자바스크립트에서는 변수안에 넣는(선언하는) 값에 따라 타입이 바꿔진다.  
		document.write(ulTag);