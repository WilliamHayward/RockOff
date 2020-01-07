var client;
document.getElementById('btnJoin').onclick = function() {
    const code = document.getElementById('txtCode').value;
    const name = document.getElementById('txtName').value;
    let location = 'ws';
    if (window.location.protocol === 'https') {
        location += 's';
    }
    host = window.location.hostname;
    host = 'localhost';
    location += '://' + host + ':8080';
    client = Lipwig.join(location, code, {
        'name' : name
    });
    client.on('joined', joined);
    client.on('Hello', hello);
}

function joined(id, name) {
    client.send("start");
}

function hello(count) {
    console.log(count);
    client.send("Hello", count + 1);
}