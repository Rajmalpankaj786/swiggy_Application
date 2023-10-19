// function registerEmployee(){
//     var EfirstName = document.getElementById("firstName").value;
//     var ElastName = document.getElementById("lastName").value;
//     var Eemail = document.getElementById("email").value;
//     var Eposition = document.getElementById("position").value;

//     fetch("localhost:8080/employees" , {
//         method : "POST",
//         headers : {
//             "content-type" : "application/json"
//         },
//         body : JSON.stringify({
//             "firstName" : EfirstName,
//             "lastName" : ElastName,
//             "email"   : Eemail,
//             "position" : Eposition
//         }) 
//     }).then(res => {
//         if(res.status==201 | res.status==200){
//             res.json.then(data =>  {
//            alert("Employee registered Successfully" , data.roll)
//             })
//         }
//         else{
//             res.json.then(data => alert("invalid data"))
//         }
//     })
// }