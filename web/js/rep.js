/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function change(value) {
    var inner = "";
    var label = "";
    var element = document.getElementById("parentDiv");
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
    for (var i = 1; i <= value; i++) {
        inner = document.createElement("input");
        label = document.createElement("label");
        label.innerHTML = "Answer" + i + "* ";
        inner.type = "text";
        inner.name = "Answer" + i;
        inner.required = true;
        element.appendChild(label);
        element.appendChild(inner);
    }
}
