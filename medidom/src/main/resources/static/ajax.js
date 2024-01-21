
    function Try(){
    const xhttp = new XMLHttpRequest()
    xhttp.open("GET", "http://localhost:8080/patient/requests")

    let htmlText = '';
    xhttp.onload = function(){
      if(this.status == 200){
         let requests = JSON.parse(xhttp.responseText)
         htmlText += createCard(requests);
         document.getElementById("requests").innerHTML = htmlText;
         }
      }

      xhttp.send()
   }



function createCard(tasks) {
const months = ["Jan.", "Feb.", "March", "April", "May", "June", "July", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."];
let htmlText = '<div class="row row-cols-5 g-5 ms-1" style="width: 98%;">'
   let thisDate
   for (let i in tasks) {
   thisDate = new Date(tasks[i].requestDate)
   htmlText +=' <div class="col">'
      + ' <div class="card border-0 bg-basic text-center" style="width: 14rem;'

         htmlText += '<button class="cardbtn border-0 m-0 p-0" data-bs-toggle="modal" data-bs-target="#showDetails" value='+tasks[i].request_id+' onclick="console.log(this.value);"> <div class="card-header p-0 text-light">'

               // + '<img src="first-break.jpg" class="card-img" alt="..." >'
               // switch (tasks[i].service){
               // case 'first' : htmlText+= '<img src="images/rest.jpg" class="card-img" alt="restCategoryImg">'
               // break
               // case 'second' : htmlText+= '<img src="images/professional.jpg" class="card-img" alt="professionalCategoryImg">'
               // break

               // default: break
               // }

               htmlText+= ' <div class="card-img-overlay">'
                  + ' <h1 class="card-title display-2 fw-semibold">' + thisDate.getDate()
                  + '</h1><h3>' + months[thisDate.getMonth()]
                  + ' ' + thisDate.getFullYear() + ' </h3></div> '

               htmlText+= '</div></button> '
         + '<div class="card-body">'
            + ' <h5 class="card-title">' + tasks[i].service + '</h5>'

            + ' </div> '
         + ' <div class="card-footer btn-group p-0 border-0" style="width: 14rem;">'
            + '<button class="btn btn-dark border-0" style="border-top-left-radius: 0;" value=' + tasks[i].request_id
               + ' onclick="validateTask(this.value)">Done</button>'
            + '<button class="btn btn-dark border-0" data-bs-toggle="modal" data-bs-target="#feedback" value='+ tasks[i].request_id
               + ' onclick="addfeedback(this.value)">feedback</button>'
            + '<button class="btn btn-dark border-0" style="border-top-right-radius: 0;" value=' + tasks[i].request_id
               + ' onclick="deleteRequest(this.value)">Delete</button>'
            + '</div>'
         + '</div>'
      + '</div>'
   }
   htmlText += '</div>';
return htmlText;
}




function addRequest (){


        let Rdate = document.getElementById("RDate").value


      //   let tservice = document.getElementById("service").value

      //   if(difTime(Date.parse(Rdate)) >= -1){
            const xhttp = new XMLHttpRequest()

            xhttp.open("POST", "http://localhost:8080/patient/affectation", true)
            xhttp.setRequestHeader("Content-type", "application/json")
            xhttp.onload = function(){
                if(this.status == 200){
                    Try()
                }else console.log("error")
            }

            let param = JSON.stringify({requestDate : Rdate, service : 3})
            console.log(param)
            xhttp.send(param)
      //   }

    }

function deleteRequest(theId){
    const xhttp = new XMLHttpRequest()
    xhttp.open("DELETE", "http://localhost:8080/patient/delete/" + theId, true)
    xhttp.onload = function(){
        Try()
    }
    xhttp.send()
}

function addFeedback(id){

            let QualitéService = document.getElementById("QS").value

            let Punctualité = document.getElementById("PS").value
            console.log(Punctualité)

            const xhttp = new XMLHttpRequest()

            xhttp.open("POST", "http://localhost:8080/patient/feedback/" + id, true)
            xhttp.setRequestHeader("Content-type", "application/json")
            xhttp.onload = function(){
                 if(this.status == 200){
                     Try()
                     console.log(QualitéService)
                 }else console.log("error")
            }
            console.log(Punctualité)
            let param = JSON.stringify({qualityOfServices : QualitéService , punctualityOfServices : Punctualité })
            xhttp.send(param)

         }

var currenRequestId;
function addfeedback (requestid){
       currenRequestId = requestid;
          var addFeedback = new bootstrap.Modal(document.getElementById('addfeedback'));
          addFeedback.show();

}
var button = document.getElementById("SubmitF");


button.addEventListener("click", function() {


   addFeedback(currenRequestId);
});