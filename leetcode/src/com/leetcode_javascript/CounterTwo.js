function createCounter(init) {
    var presentCount = init;
    return {
        increment: function () {
            return ++presentCount;
        },
        decrement: function () {
            return --presentCount;
        },
        reset: function () {
            presentCount = init;
            return presentCount;
        }
    };
}
;
var counter = createCounter(5);
console.log(counter.increment());
console.log(counter.decrement());
console.log(counter.reset());
