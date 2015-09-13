package ksmaragh.c4q.nyc.accessrobot;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LearnActivity extends AppCompatActivity {
    @Bind(R.id.btn_learn_assembly)
    Button btnAssemblyVideo;

    @Bind(R.id.btn_learn_mozi_components)
    Button btnLearnMoziComponents;

    @Bind(R.id.btn_order_parts)
    Button btnOrderParts;

    @Bind(R.id.btn_learn_blockly)
    Button btnLearnBlockly;



    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_learn_mozi_components:
                    startComponentListActivity();
                    break;

                case R.id.btn_order_parts:
                    startPartsActivity();
                    break;

                case R.id.btn_learn_assembly:
                    playMoziAssemblyVideo();
                    break;

                case R.id.btn_learn_blockly:
                    startBlocklyTutorial();
                    break;
            }

        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        ButterKnife.bind(this);

        btnLearnMoziComponents.setOnClickListener(buttonClickListener);
        btnOrderParts.setOnClickListener(buttonClickListener);
        btnLearnBlockly.setOnClickListener(buttonClickListener);


    }

    private void startComponentListActivity() {
        //TODO: link to the correct activity
        Toast.makeText(this, "Component list coming soon", Toast.LENGTH_LONG).show();

//        Intent intent = new Intent(this, ComponentListActivity.class);
//        startActivity(intent);
    }

    private void startPartsActivity() {
//        Intent intent = new Intent(this, PartsActivity.class);
//        startActivity(intent);

        // avoid the intermediate PartsActivity  and start the browser to show shopping cart
        //this will save the unnecessary extra clicks to start a purchase

        String url = "http://www.amazon.com/gp/aws/cart/add.html?" +
                "AssociateTag=your-tag-here-20&" +
                "ASIN.1=B00OBSD202&Quantity.1=1&" +
                "ASIN.2=B00P7Q86HG&Quantity.2=1&" +
                "ASIN.3=B00KTXWG9G&Quantity.3=1&" +
                "ASIN.4=B001CFUBN8&Quantity.4=2&" +
                "ASIN.5=B0089VA3AY&Quantity.5=1&" +
                "ASIN.6=B00C0Q67IQ&Quantity.6=1&" +
                "ASIN.7=B0081IC18W&Quantity.7=1&" +
                "ASIN.8=B000TGSPV6&Quantity.8=1&" +
                "ASIN.9=B00AYPEL56&Quantity.9=1";
        Intent openUrl = new Intent(Intent.ACTION_VIEW);
        openUrl.setData(Uri.parse(url));
        startActivity(openUrl);

    }

    private void playMoziAssemblyVideo() {
        String videoId = "DXpl0H1tLcU";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + videoId));
        intent.putExtra("force_fullscreen",true);
        startActivity(intent);
    }

    private void startBlocklyTutorial() {
        //TODO: link to the correct activity
        Toast.makeText(this, "Blockly tutorial coming soon", Toast.LENGTH_LONG).show();

//        Intent intent = new Intent(this, BlocklyActivity.class);
//        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
