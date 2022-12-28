array = [1, 56, 123, 87, 12, 0, 76, 23, -43, 5, -2];

 console.log("values in array: " + array);
 max1(array);
 max2(array);
 max3(array);

 strArr = ['hi', 'hi', 'hello', 'world', 'hello', 'hi', 'greetings', 'World'];
 countingWords(strArr);

mixedArr = [5, 2, 'a', 4, '7', true, 'b', 'c', 7, '8', false];
getTotalSumArray(mixedArr);

function max1(array) {
    maximumValue = array[0];
    for (let i = 1; i < array.length; i++) {
        if (array[i] > maximumValue) {
            maximumValue = array[i];
        }
    }
    console.log("Maximum value from max1() method: " + maximumValue);
}

function max2(array) {
    maximumValue = Number.MIN_VALUE;
    array.forEach(function (element) {
        if (element > maximumValue) {
            maximumValue = element;
        }
    });
    console.log("Maximum value from max2() method: " + maximumValue);
}

function max3(array) {
    const getMax = (a, b) => Math.max(a, b);
    console.log("Maximum value from max3() method: " + array.reduce(getMax, Number.MIN_VALUE));
}

function countingWords(array){
    counter = 0;
    var word = "world";

    for (let i = 0; i < array.length; i++) {
        if (array[i] == word) {
            counter++;
        }
    }

    console.log(word + " appears " + counter + " times in the array");
}

function getTotalSumArray(array){

    sum = 0;
    array.forEach(element => {
        if(Number.isInteger(element) == true){
            sum += element;
        }
    })

    console.log("Sum of array: " + sum);

}