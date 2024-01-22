var currentId

function loadRequests(){
   const xhttp = new XMLHttpRequest()
   xhttp.open("GET", "http://localhost:8080/patient/requests")

   let htmlText = '';
   xhttp.onload = function(){
   if(this.status == 200){
      let requests = JSON.parse(xhttp.responseText)
      htmlText = cards(requests);
      document.getElementById("requests").innerHTML = htmlText;
      }
   }
   xhttp.send()
}

function cards(requests) {
const months = ["Jan.", "Feb.", "March", "April", "May", "June", "July", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."];
let htmlText = '<div class="container position-absolute start-50 translate-middle-x py-5"><div class="row row-cols-3 g-5" style="width: 98%; margin-left: 6px;">'
   let thisDate
   for (let i in requests) {
   thisDate = new Date(requests[i].requestDate)
   htmlText +='<div class="col mx-auto">'
      + '<div class="card shadow-lg border-0 border-black bg-basic text-center" style="width: 20rem;">'
      + '<div class="card-header p-0 text-light">'

         switch (requests[i].service){
         case 'NURSING' : htmlText+= '<img src="appImages/nursing.jpg" class="card-img" alt="...">'
         break
         case 'ALLERGY' : htmlText+= '<img src="appImages/allergy0.jpg" class="card-img" alt="...">'
         break
         case 'DERMATOLOGY' : htmlText+= '<img src="appImages/dermatology.jpg" class="card-img" alt="...">'
         break
         case 'OPHTHALMOLOGY' : htmlText+= '<img src="appImages/oohthalmology.jpg" class="card-img" alt="...">'
         break
         case 'PEDIATRICS' : htmlText+='<img src="appImages/pediatre0.jpg" class="card-img" alt="...">'
         break
         case 'PSYCHIATRY' : htmlText+= '<img src="appImages/psychiatry.jpg" class="card-img" alt="...">'
         break
         case 'REHABILIATION' : htmlText+= '<img src="appImages/rehabilitation.jpg" class="card-img" alt="...">'
         break
         case 'GENERALIST' : htmlText+= '<img src="appImages/doctor.jpg" class="card-img" alt="...">'
         break
         default: break
         }

         htmlText+= '<div class="card-img-overlay">'
            + '<button class="text-decoration-none text-reset border-0 m-0 p-0 w-100" onclick="showRequest(this.value)" data-bs-toggle="modal" data-bs-target="#showDetails" style="background-color: transparent;" value='+ requests[i].request_id +'>'
            + '<h1 class="card-title display-1 fw-semibold m-0">' + thisDate.getDate()
            + '</h1><h3>' + months[thisDate.getMonth()]
            + ' ' + thisDate.getFullYear() + '</h3></button> <div class="position-absolute end-0 bottom-0 pb-2 px-2">'
            + '<button value=' + requests[i].request_id +' onclick="currentId=this.value" data-bs-toggle="modal" data-bs-target="#deleteConfirmationModal" class="btn btn-danger mx-1"><i class="fa-solid fa-trash-can"></i></button>'
            + '<button value='+ requests[i].request_id +' onclick="currentId=this.value" data-bs-toggle="modal" data-bs-target="#feedback" class="btn btn-primary">Feedback</button>'
            + '</div></div></div></div></div>'
   }
   htmlText += '</div></div>';
return htmlText;
}

function addRequest (){
   let Rdate = document.getElementById("RDate").value
   let tservice = document.getElementById("aService").value
//   if(difTime(Date.parse(Rdate)) >= -1){
      const xhttp = new XMLHttpRequest()
      xhttp.open("POST", "http://localhost:8080/patient/affectation", true)
      xhttp.setRequestHeader("Content-type", "application/json")
      xhttp.onload = function(){
            if(this.status == 200){
               let request = JSON.parse(this.responseText)
               currentId = request.request_id
               confirmRequest(request)
            }else console.log("error")
      }
      let param = JSON.stringify({requestDate : Rdate, service : tservice})
      console.log(param)
      xhttp.send(param)
//   }
}

function confirmRequest(request){
   var confirmationModal = new bootstrap.Modal(document.getElementById('confirmRequest'));
   document.getElementById("cDate").value = request.requestDate
   document.getElementById("cService").value = request.service
   document.getElementById("cDoctor").value = request.employeeId
   confirmationModal.show();
}

function showRequest(theId){
   const xhttp = new XMLHttpRequest()
   xhttp.open("GET", "http://localhost:8080/patient/requests/" + theId, true)
   xhttp.onload = function(){
      if(this.status == 200){
         let request = JSON.parse(this.responseText)
         document.getElementById("sDate").value = request.requestDate
         document.getElementById("sService").value = request.service
         document.getElementById("sDoctor").value = request.employeeId
      }
   }
   xhttp.send()
}

function deleteRequest(){
    const xhttp = new XMLHttpRequest()
    xhttp.open("DELETE", "http://localhost:8080/patient/delete/" + currentId, true)
    xhttp.onload = function(){
        loadRequests()
    }
    xhttp.send()
}

function addFeedback(){
   let Qs = document.getElementById("QS").value
   let Ps = document.getElementById("PS").value
   
   const xhttp = new XMLHttpRequest()

   xhttp.open("POST", "http://localhost:8080/patient/feedback/" + currentId, true)
   xhttp.setRequestHeader("Content-type", "application/json")
   xhttp.onload = function(){
         if(this.status == 200){
            loadRequests()
         }else console.log("error")
   }
   let param = JSON.stringify({qualityOfServices : Qs , punctualityOfServices : Ps })
   xhttp.send(param)
}
