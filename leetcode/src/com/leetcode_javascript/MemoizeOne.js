function memoize(fn) {
    var cache = new Map();
    return function () {
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        var key = JSON.stringify(args);
        console.log(cache);
        if (cache.has(key)) {
            return cache.get(key);
        }
        var functionOutput = fn.apply(void 0, args);
        cache.set(key, functionOutput);
        return functionOutput;
    };
}
var callCount = 0;
var memoizedFn = memoize(function (a, b) {
    callCount++;
    return a + b;
});
memoizedFn(2, 3);
memoizedFn(2, 3);
console.log(callCount);
