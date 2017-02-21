#WebSocket test for myAbilia

This project contains a small example app that submits WebSockets messages every 2 seconds. It was useful for developing WS on backend and could probably be usable on frontend as well since it mirrors the myAbilia solution without all other overhead.

###Usage
* Run app
* Goto http://localhost:8080/
* Press 'Connect' to start receiving events


###Technical
The js client (app.js) connect a STOMP client to '/ws-stomp'.

That client can later on subscribe to changes on different users on url '/data/{ownerId}'.

The client will receive events that looks like this
```json
{
  "type": "sortable",
  "owner": 1,
  "revision": 35
}
```

* type - The kind of data that changed. Currently one of "calendar", "sortable", "file".
* owner - The owner of the data. Usable if the logged in user listens to multiple data source.
* revision - The new revision for the data. Usable to separate changes originating from the logged in user and others.