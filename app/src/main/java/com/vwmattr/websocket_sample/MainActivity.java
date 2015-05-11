package com.vwmattr.websocket_sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;


public class MainActivity extends ActionBarActivity {

    String myIp = "<Enter WS host server IP>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button sendIt = (Button) findViewById(R.id.send);
        sendIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncHttpClient.getDefaultInstance().websocket("ws://" + myIp +":8080",
                        null, new AsyncHttpClient.WebSocketConnectCallback() {
                            @Override
                            public void onCompleted(Exception ex, WebSocket webSocket) {
                                if (ex != null) {
                                    System.out.println("I got an error");
                                    ex.printStackTrace();
                                    return;
                                }

                                webSocket.setStringCallback(new WebSocket.StringCallback() {
                                    public void onStringAvailable(final String s) {
                                        System.out.println("I got: " + s);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(MainActivity.this, "Received: " + s, Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                        });
            }
        });
    }

}
