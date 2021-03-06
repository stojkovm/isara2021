let requestCount = 0;
const http = require('http');
http.createServer(function (req, res) {
    if (req.method == 'GET') {
      const html = `<!DOCTYPE html><html><head></head><body><h1>Success</h1><p>Test page</p></body></html>\n`;
      requestCount++;
      if (requestCount % 7 == 0)
        pause(250);
      if (requestCount % 11 == 0)
        pause(450);
      res.writeHead(200, {'Content-Type': 'text/html'});
      res.end(html);
    } else {
      res.writeHead(405, {'Allow': 'GET'});
      res.end('\n');
    }
}).listen(9090);


function pause(millis) {
  var date = Date.now();
  var curDate = null;
  do {
      curDate = Date.now();
  } while (curDate-date < millis);
}

