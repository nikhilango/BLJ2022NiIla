var slidePosition = 1;
SlideShow(slidePosition);

function plusSlides(n) {
  SlideShow(slidePosition += n);
}

function currentSlide(n) {
  SlideShow(slidePosition = n);
}

function SlideShow(n) {
    var i;
    var slides = document.getElementsByClassName("containers");
    var indicator = document.getElementsByClassName("indicator");

    if (n > slides.length) {
        slidePosition = 1
    }

    if (n < 1) {
        slidePosition = slides.length
    }

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < indicator.length; i++) {
        indicator[i].className = indicator[i].className.replace(" enable", "");
    }

    slides[slidePosition-1].style.display = "block";
    indicator[slidePosition-1].className += " enable";
} 