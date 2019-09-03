
let map = {
    add: function(a, b) {
        return a + b;
    }
}

function invoke(fn, a, b) {
    return map[fn] && map[fn](a,b);
}

console.log(invoke("addd",3.4,5.6));