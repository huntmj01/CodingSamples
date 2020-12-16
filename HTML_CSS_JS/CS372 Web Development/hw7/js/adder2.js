function calculate(opperation){
    
    var ADD = 1;
    var SUB = 2;
    var MUL = 3;
    var DIV = 4;
    
    var tbxNum1 = document.getElementById("num1");
    var tbxNum2 = document.getElementById("num2");
    var tbxResult = document.getElementById("result");
    
    var num1 = parseInt(tbxNum1.value);
    var num2 = parseInt(tbxNum2.value);
    var result = 0;
    
    if (opperation == ADD){
        result = num1 + num2;
    }else if (opperation == SUB){
        result = num1 - num2;
    }else if (opperation == MUL){
        result = num1 * num2;
    }else if (opperation == DIV){
        result = num1 / num2;
    }
    
    tbxResult.value = result;
    
}