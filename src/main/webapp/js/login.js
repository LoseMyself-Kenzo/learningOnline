function popBox(){
    var popBox = document.getElementById('popBox');
    var popLayer = document.getElementById('popLayer');
    popLayer.style.width = document.body.scrollWidth + "px";
    popLayer.style.height = document.body.scrollHeight + "px";
    popLayer.style.display = "block";
    popBox.style.display = "block";
}
function closeBox(){
    var popBox = document.getElementById('popBox');
    var popLayer = document.getElementById('popLayer');
    popLayer.style.display = "none";
    popBox.style.display = "none";
}