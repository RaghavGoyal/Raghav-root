const demoModule = require("./demoModule");
const rectangle = require("./rectangle")
const promiseModule = require("./promiseModule")

demoModule.demoFuntion();
const area = rectangle.calculateArea(12, 34);
console.log(area);

promiseModule.promise1()
  .then(() => {
    console.log("promise 1 completed")
    promiseModule.promise2().then(() => {
      console.log("whole process is completed");
    })
  })


