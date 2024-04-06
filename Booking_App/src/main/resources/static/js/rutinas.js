document.addEventListener('DOMContentLoaded', function () {






    //javaScript para los componentes de fechas cacula numero de noches

    // Conseguir las refereencias de start y end de los datepickers
    const startDateInput = document.getElementById('startDate');
    const endDateInput = document.getElementById('endDate');
    const numberOfNightsInput = document.getElementById('numberOfNights');

    // Annadir event listeners a los componentes de fechas
    //startDateInput.addEventListener('change', calculateNumberOfNights);
    endDateInput.addEventListener('change', calculateNumberOfNights);

    // Funcion para cacular el numero de noches
    function calculateNumberOfNights() {
        // Conseguir la fecha inicial y final seleccionadas
        const startDate = new Date(startDateInput.value);
        const endDate = new Date(endDateInput.value);

        // Calculate la diferencia en milisegundos entre las fechas
        const timeDifference = endDate.getTime() - startDate.getTime();

        // Convertir el tiempo de diferencia a dias y redondear al numero entero mas cercano
        const numberOfNights = Math.round(timeDifference / (1000 * 60 * 60 * 24));

        // Mostrar el numero de noches y precio total
        const numberOfNightsElement = document.getElementById('numberOfNights');
        const precioTotal = document.getElementById('preciototal');
        const precioNocheString = document.getElementById('precioNoche').innerText;
        const precioNocheNumber = parseFloat(precioNocheString); // Convert string to integer
        numberOfNightsInput.value = numberOfNights;

        precioTotal.value = numberOfNights * precioNocheNumber;
    }


    //javaScript para el componente de aumento y decremento de counters de ninnos y adultos
    let counterAdult = 0;
    let counterNinno = 0;
    let sumaTotal = 0;
    let counter = 0;

    //los controles para el contador de adultos
    const counterValueAdult = document.getElementById('counter-value-Adulto');
    const incrementBtnAdult = document.getElementById('increment-btn-Adulto');
    const decrementBtnAdult = document.getElementById('decrement-btn-Adulto');

    //los controles para el contador de ninnos
    const counterValueNinno = document.getElementById('counter-value-Ninno');
    const incrementBtnNinno = document.getElementById('increment-btn-Ninno');
    const decrementBtnNinno = document.getElementById('decrement-btn-Ninno');

    //los controles para el contador de personas para filtros en lista de destinos
    const counterValue = document.getElementById('counter-value');
    const incrementBtn = document.getElementById('increment-btn');
    const decrementBtn = document.getElementById('decrement-btn');


    const maxValueElement = document.getElementById('max_value');
    const maxValue = parseInt(maxValueElement.innerText);

    //objeto input html que lleva la sumatoria total
    const sumPersonas = document.getElementById('sum_person');
    const sumatoria = parseInt(sumPersonas.value);


    // para incrementar los valores del contador de adultos
    incrementBtnAdult.addEventListener('click', () => {
        if (sumaTotal < maxValue) {
            counterAdult++;
            sumaTotal++;
            counterValueAdult.value = counterAdult;
            sumPersonas.value = sumaTotal;
        }
    });

    // para decrementar los valores del contador de adultos
    decrementBtnAdult.addEventListener('click', () => {
        if (counterAdult == 0) {

        } else {

            counterAdult--;
            sumaTotal--;
            counterValueAdult.value = counterAdult;
            sumPersonas.value = sumaTotal;
        }

    });


    // para incrementar los valores del contador de ninnos
    incrementBtnNinno.addEventListener('click', () => {
        if (sumaTotal < maxValue) {
            counterNinno++;
            sumaTotal++;
            counterValueNinno.value = counterNinno;
            sumPersonas.value = sumaTotal;
        }
    });

    // para decrementar los valores del contador de ninnos
    decrementBtnNinno.addEventListener('click', () => {
        if (counterNinno == 0) {

        } else {

            counterNinno--;
            sumaTotal--;
            counterValueNinno.value = counterNinno;
            sumPersonas.value = sumaTotal;
        }

    });

    // para incrementar los valores del contador de personas en filtro en la lista de destinos
    incrementBtn.addEventListener('click', () => {
        if (counter < 20) {
            counter++;
            counterValue.value = counter;
        }
    });

    // para decrementar los valores del contador de personas en filtro en la lista de destinos
    decrementBtn.addEventListener('click', () => {
        if (counter == 0) {

        } else {

            counter--;
            counterValue.value = counter;
        }

    });

    const resetBtn = document.querySelector('#reset');

    // para resetear el contador a cero
    resetBtn.addEventListener('click', reset);

    function reset() {
        counterAdult = 0;
        counterNinno = 0;
        sumaTotal = 0;
        counterValueAdult.value = counterAdult;
        counterValueNinno.value = counterNinno;
        counterValue.value = counter;
        sumPersonas.value = sumaTotal;
    }

    //componente rango de precio mostrar bubble con etiqueta del precio seleccionado
    const rangeInput = document.getElementById('price_range_slider');
    const bubble = document.querySelector('.bubble');

    rangeInput.addEventListener('input', () => {
        const value = rangeInput.value;
        const rangeWidth = rangeInput.offsetWidth;
        const bubbleWidth = bubble.offsetWidth;
        const maxLeftPosition = rangeWidth - bubbleWidth;
        const leftPosition = (value / 500) * maxLeftPosition * 2;


        bubble.textContent = "0-" + value + "$";
        bubble.style.left = `${leftPosition}px`;
    });

});




