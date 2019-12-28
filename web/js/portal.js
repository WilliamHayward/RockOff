var client;
document.getElementById('btnJoin').onclick = function() {
    const code = document.getElementById('txtCode').value;
    let location = 'ws';
    if (window.location.protocol === 'https') {
        location += 's';
    }
    host = window.location.hostname;
    host = 'localhost';
    location += '://' + host + ':8080';
    client = Lipwig.join(location, code);
    client.on('joined', joined);
    client.on('Hello', hello);
}

function joined(id, name) {
    client.send("Hello", 0);
}

function hello(count) {
    console.log(count);
    client.send("Hello", count + 1);
}