type Fn = (...params: number[]) => number

function memoize(fn: Fn): Fn {
    const cache = new Map();
    return function(...args) {
        const key = JSON.stringify(args);
        console.log(cache);
        if(cache.has(key)) {
            return cache.get(key);
        }
        const functionOutput = fn(...args);
        cache.set(key, functionOutput);
        return functionOutput;
    }
}

let callCount = 0;
const memoizedFn = memoize(function (a,b){
    callCount++;
    return a+b;
})
memoizedFn(2,3);
memoizedFn(2,3);
console.log(callCount);