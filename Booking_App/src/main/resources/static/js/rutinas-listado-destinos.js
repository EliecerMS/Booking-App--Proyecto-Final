//javaScript para el componente de aumento y decremento de counters de ninnos y adultos
    
    let counter = 1;
    
 

    //los controles para el contador de personas para filtros en lista de destinos
    const counterValue = document.getElementById('counter-value');
    const incrementBtn = document.getElementById('increment-btn');
    const decrementBtn = document.getElementById('decrement-btn');



    const resetBtn = document.querySelector('#reset');
    
    
    //componente rango de precio mostrar bubble con etiqueta del precio seleccionado
    const rangeInput = document.getElementById('price_range_slider');
    const bubble = document.querySelector('.bubble');
    
    
    
    
    function reset() {
        counter = 1;
        counterValue.value = counter;
        
    }
    
document.addEventListener('DOMContentLoaded', function () {



    rangeInput.addEventListener('input', () => {
        const value = rangeInput.value;
        const rangeWidth = rangeInput.offsetWidth;
        const bubbleWidth = bubble.offsetWidth;
        const maxLeftPosition = rangeWidth - bubbleWidth;
        const leftPosition = (value / 500) * maxLeftPosition * 2;


        bubble.textContent = "0-" + value + "$";
        bubble.style.left = `${leftPosition}px`;
    });
    
    // para resetear el contador a cero
    resetBtn.addEventListener('click', reset);
    
    // para incrementar los valores del contador de personas en filtro en la lista de destinos
    incrementBtn.addEventListener('click', () => {
        if (counter < 20) {
            counter++;
            counterValue.value = counter;
        }
    });

    // para decrementar los valores del contador de personas en filtro en la lista de destinos
    decrementBtn.addEventListener('click', () => {
        if (counter == 1) {

        } else {

            counter--;
            counterValue.value = counter;
        }

    });

});