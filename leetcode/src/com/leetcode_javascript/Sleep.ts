async function sleep(millis: number): Promise<void> {
    console.log('started')
    await new Promise(resolve => setTimeout(resolve, millis));
    console.log('ended')
}

console.log('starting')
sleep(100);
console.log('ending')