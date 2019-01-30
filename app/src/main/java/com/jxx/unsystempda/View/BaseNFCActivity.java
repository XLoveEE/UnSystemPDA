package com.jxx.unsystempda.View;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BaseNFCActivity extends AppCompatActivity {

    private NfcAdapter nfcAdapter = null;
    private PendingIntent mPendingIntent;
    private IntentFilter[] mFilters;
    private String[][] mTechLists;
    protected Intent nfcIntent;
    private Tag tag;
    protected MifareClassic mfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter == null){
            Toast.makeText(this,"Device not support NFC",Toast.LENGTH_LONG).show();
            return;
        }else {
            if(!nfcAdapter.isEnabled()){
                Toast.makeText(this,"Your NFC not enable!",Toast.LENGTH_LONG).show();
                return;
            }
        }
        mPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,getClass())
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED);
        try {
            ndef.addDataType("*/*");
        } catch (IntentFilter.MalformedMimeTypeException e) {
            throw new RuntimeException("fail", e);
        }
        mFilters = new IntentFilter[] { ndef, };
        mTechLists = new String[][] { new String[] { MifareClassic.class
                .getName() } };
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        nfcIntent = intent;
        String action = intent.getAction();
        if(NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)){
            this.tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

            this.mfc = MifareClassic.get(tag);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        nfcAdapter.enableForegroundDispatch(this, mPendingIntent, mFilters,
                mTechLists);
    }


    @Override
    public void onPause() {
        super.onPause();
        nfcAdapter.disableForegroundDispatch(this);
    }
}
