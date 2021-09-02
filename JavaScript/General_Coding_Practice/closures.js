// Closures
const makeAdd = (num) => {
    return function(val) {
        return num + val;
    }
}

const addTwo = makeAdd(2);
console.log(`Expected value of addTwo(3) to be 5, actual = ${addTwo(3)}`);
const addTen = makeAdd(10);
console.log(`Expected value of addTen(30) to be 40, actual = ${addTen(30)}`);
