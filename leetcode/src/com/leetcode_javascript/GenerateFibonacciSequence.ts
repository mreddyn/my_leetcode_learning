function* fibGenerator(): Generator<number, any, number> {
    let previous = 0, current = 1;
    yield previous;
    yield current;
    while(true) {
        let next = previous + current;
        previous = current;
        current = next;
        yield next;
    }
};

const gen = fibGenerator();
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);