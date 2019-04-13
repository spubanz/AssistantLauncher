package com.example.assistantlauncher;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothHeadset;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private BluetoothHeadset mBluetoothHeadset;
    private BluetoothAdapter mBluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    }

    public void onClickAssistantBtn(View view) {
        TextView outputTextView = (TextView) findViewById(R.id.outputTextView);
        outputTextView.setText(mBluetoothAdapter.getName() + "");
    }
}
