Sample app that connects to a websocket server.

To run a sample websocket server:

1. `npm install -g wscat`
2. `wscat -l 8080`  This starts wscat in server mode listening on port 8080

To test out the app:

1. Modify the myIp variable in MainActivity to hold the IP or hostname of the computer where your test websocket server is running.
1. Run the app.
1. Click "Send".
1. At this point you have an open connection and you can go to your terminal running wscat and start entering messages and you'll see them toasted on the Android.
