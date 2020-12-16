function validate(){
    
    var tbxName = document.getElementById("name");
    var tbxEmail = document.getElementById("email");
    var tbxComments = document.getElementById("comments");
    
    var errMsg = "";
    
    if (tbxName.value == ""){
        errMsg += "Name field is required\n";
    }
    
    if (tbxEmail.value == ""){
        errMsg += "Email field is required\n";
    }
    else if (!tbxEmail.value.includes(".edu")){
        errMsg += "Email address must end with .edu\n";
    }
    
    if (tbxComments.value == ""){
        errMsg += "Comments field is required\n";
    }
    
    if (errMsg != ""){
        alert(errMsg);
    }
    
}

function onCheckChange(){
    
    var cbxSignMeUp = document.getElementById("signMeUp");
    var btnReview = document.getElementById("submitReview");
    
    if (cbxSignMeUp.checked){
        btnReview.disabled = false;
    }else {
        btnReview.disabled = true;
    }
    
}