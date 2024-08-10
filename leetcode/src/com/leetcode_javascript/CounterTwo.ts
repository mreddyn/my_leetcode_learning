type Counter = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): Counter {
    let presentCount = init;
    return {
        increment: (): number => {
            return ++presentCount;
        },
        decrement: (): number => {
            return --presentCount;
        },
        reset: (): number => {
            presentCount = init;
            return presentCount;
        }
    }
};

const counter = createCounter(5);
console.log(counter.increment());
console.log(counter.decrement());
console.log(counter.reset());