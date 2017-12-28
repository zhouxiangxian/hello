
function esecBoard(n) 
{ 
    for(i=1;i<5;i++) 
    { 
        eval("document.getElementById('el0"+i+"').className='e102'"); 
        eval("ebx0"+i+".style.display='none'"); 
    } 
    eval("document.getElementById('el0"+n+"').className='e101'"); 
    eval("ebx0"+n+".style.display='block'"); 
} 

function csecBoard(n) 
{ 
    for(i=1;i<4;i++) 
    { 
        eval("document.getElementById('cl0"+i+"').className='c102'"); 
        eval("cbx0"+i+".style.display='none'"); 
    } 
    eval("document.getElementById('cl0"+n+"').className='c101'"); 
    eval("cbx0"+n+".style.display='block'"); 
} 
function js_close_div(divname){
  //document.getElementById(divname).style.visibility = "hidden";
  document.getElementById(divname).style.display = "none";
}