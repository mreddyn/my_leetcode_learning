type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type OnceFn = (...args: JSONValue[]) => JSONValue | undefined

function once(fn: Function): OnceFn {
    let hasBeenCalledOnce = false;
    let result: JSONValue;
    return function (...args) {
        if(!hasBeenCalledOnce) {
            result = fn(...args);
            hasBeenCalledOnce = true;
            return result;
        }
        return undefined;
    };
0}