package com.soapgu.testlaserpointer;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tvMessage;

    private Map<Integer,String> keyMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        keyMap = Map.of( 19,"上翻页",//KEYCODE_DPAD_UP
                20,"下翻页",//KEYCODE_DPAD_DOWN
                24,"音量加",//KEYCODE_VOLUME_UP
                25,"音量减",//KEYCODE_VOLUME_DOWN
                61,"功能——短按",//KEYCODE_TAB
                66,"功能键——双击",//KEYCODE_ENTER
                4,"功能键——长按(状态0)",//KEYCODE_BACK
                135,"功能键——长按(状态1)");//KEYCODE_F5
        this.tvMessage = findViewById(R.id.tv_msg);
        this.getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                //tvMessage.setText( "回退按键触发" );
            }
        });
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        String keyName = "未定义";
        if( keyMap.containsKey( keyCode ) ){
            keyName = keyMap.get(keyCode);
        }
        this.tvMessage.setText( String.format("key press name: %s code:%d",keyName,keyCode) );
        return super.onKeyUp(keyCode, event);
        //return true;
        //KeyEvent.KEYCODE_BACK
    }


}