//// ECMAscript(ES) - ECMA's standard
//// JavaScript - programing language
//// js runtime 1 chorme - run XMLHttpRequest
//// 
function loadCourses() {
    /// send request 
    let xhr = new XMLHttpRequest();
    /// 回调函数, used to check the status of xhr 
    /// 传函数引用
    xhr.onreadystatechange = handleStateChange;
    /// async true sync false
    /// "" == ''
    /// "GET" == 'get'
    xhr.open("GET", "https://bba2652e-da95-4d56-9a93-28de4c427108.mock.pstmn.io/courses",true);
    /// xhr.send(null) == xhr.send()
    xhr.send(/*request body*/);
    //// 
    console.log("after xhr.send() called");
}

function handleStateChange() {
    //// this point to xhr object
    //// http code 
    /// 400, 401, 403, 404 
    /// 500 
    //// we only care about get the result 
    console.log(" state changed to " + this.readyState);
    //// everytime the state change, the onreadystatechange will change 

    if (this.readyState === 4 && this.status === 200) {
        /// print response body
        console.log(" get response body: " + this.responseText);
        const courses = JSON.parse(this.responseText);
        renderCourses(courses);
    }
}

function renderCourses(courses){
    // debugger;
    /// convert course into html (tbody)
    /// the same 
    // const courseRows = courses.map(convertToHtmlString)
    //     .reduce((r1, r2) => r1 + r2);
    //  change a list object of course into a list of html string row
    const courseRows = courses.map(course => convertToHtmlString(course))
    //// change list into a string
        .reduce((r1, r2) => r1 + r2);
    
    ////for loop version 
    // let courseRows = "";
    // for (const course of courses) {
    //     courseRows += convertToHtmlString(course); 
    // }
    //////
    document.getElementById("course-content").innerHTML = courseRows;
}

function convertToHtmlString(course) {
    let row = '<tr>';
    row += `<td>${course.courseName}</td>`;
    row += `<td>${course.courseContent}</td>`;
    row += `<td>${course.courseLocation}</td>`;
    row += `<td>${course.courseContent}</td>`;
    row += '</tr>';
    return row;
}