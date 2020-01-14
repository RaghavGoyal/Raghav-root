const promiseModule = {};

promiseModule.promise1 = (length, width) =>{
  return new Promise((resolve, reject) => {
    //do some async action
    console.log("Promise 1");
    resolve();
  });
};

promiseModule.promise2 = (length, width) =>{
  return new Promise((resolve, reject) => {
    //do some async action
    console.log("promise 2");
    resolve();
  });
};



module.exports = promiseModule;
