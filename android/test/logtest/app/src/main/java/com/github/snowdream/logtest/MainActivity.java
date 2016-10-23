package com.github.snowdream.logtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private int index = 0;
    String s="sss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //test start
        Log.i(TAG,  "这样使用，得到的LOGTAG的值就是DroidSettings，" +
                "然而并非如此，当DroidSettings这个类进行了混淆之后，类名变成了类似a,b,c这样的名称，" +
                "LOGTAG则不再是DroidSettings这个值了。这样可能造成的问题就是，内部混淆有日志的包，我们去过滤DroidSettings " +
                "却永远得不到任何信息。");

        Log.i(TAG, "这样使用，得到的LOGTAG的值就是DroidSettings，" +
                "然而并非如此，当DroidSettings这个类进行了混淆之后，类名变成了类似a,b,c这样的名称，" +
                "LOGTAG则不再是DroidSettings这个值了。这样可能造成的问题就是，内部混淆有日志的包，我们去过滤DroidSettings " +
                "却永远得不到任何信息。" + index ++);

        LogUtil.i(TAG,"这样使用，得到的LOGTAG的值就是DroidSettings，" +
                "然而并非如此，当DroidSettings这个类进行了混淆之后，类名变成了类似a,b,c这样的名称，" +
                "LOGTAG则不再是DroidSettings这个值了。这样可能造成的问题就是，内部混淆有日志的包，我们去过滤DroidSettings " +
                "却永远得不到任何信息。");

        LogUtil.i(TAG,"这样使用，得到的LOGTAG的值就是DroidSettings，" +
                "然而并非如此，当DroidSettings这个类进行了混淆之后，类名变成了类似a,b,c这样的名称，" +
                "LOGTAG则不再是DroidSettings这个值了。这样可能造成的问题就是，内部混淆有日志的包，我们去过滤DroidSettings " +
                "却永远得不到任何信息。" + index ++);

        LogUtil.i(TAG, getMessage());

        LogUtil.i(TAG, "FROM FUNCTION " + getMessage());
        //test end

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private String getMessage() {
        int i = 0 ;
        return  "测试"+ index;
    }

    private String getTag(){
        return "TAG";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
