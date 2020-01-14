function AppendSection() {
    var node,
        textNode;

    node = document.createElement("div");
    node.id = 'seconddiv';
    node.style.border = '2px solid green';

    textNode = document.createTextNode("<span>DIV 2</span>");
    node.appendChild(textNode); 

    document.body.appendChild(node);
}

function RemoveSection() {
    var node = document.getElementById('seconddiv');

    if (node) {
        document.body.removeChild(node);
    }
}
