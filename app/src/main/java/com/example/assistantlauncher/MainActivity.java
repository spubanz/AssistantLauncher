package com.example.assistantlauncher;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private BluetoothHeadset mBluetoothHeadset;
    private BluetoothAdapter mBluetoothAdapter;
    private final static int REQUEST_ENABLE_BT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

    }

    public void onClickAssistantBtn(View view) {
        String deviceName = "";
        String deviceHardwareAddress = "";
        int count = 0;
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        TextView outputTextView = (TextView) findViewById(R.id.outputTextView);
        outputTextView.setText("# - MAC Address - Device\n");
        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                deviceName = device.getName();
                deviceHardwareAddress = device.getAddress(); // MAC address
                count++;
                outputTextView.append(count + " - " + deviceHardwareAddress + " - " + deviceName + "\n");
            }
        }



    }
}
