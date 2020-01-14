function ChangeText() {
    var firstSection = document.getElementById('first-section');
    var secondSection = document.getElementById('second-section');

    secondSection.innerHTML = firstSection.innerHTML;
}

function ChangeAttribute() {
    var cricket = document.getElementById('cricket');
    var football = document.getElementById('football');

    // To get/set standard properties, use dot notation.
    football.value = cricket.value;

    // To get/set custom attributes, use .getAttribute()/.setAttribute().
    football.setAttribute('score', cricket.getAttribute('score'));

    console.log('New score: ' + football.getAttribute('score'));
}

function ChangeAppearance() {
    var firstSection = document.getElementById('first-section');
    var secondSection = document.getElementById('second-section');

    secondSection.style.backgroundColor = firstSection.style.backgroundColor;
}
