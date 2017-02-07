package andy.mentaldisorders;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by chach on 2017-02-01.
 */
public class Page1 extends Activity
{

    /** Called when the activity is first created. */
    private int page;
    private static int sizeWeb;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Get the bundle
        setContentView(R.layout.page1);

     //   TextView tvFooter = (TextView) findViewById(R.id.tvFooter);
     //   tvFooter.setText("Sourse - wikipedia.org");

        page = getIntent().getIntExtra("text",0);
        sizeWeb = getIntent().getIntExtra("size",100);


        if(page!=0) {
            StringBuilder sb = new StringBuilder();
            InputStream s = getResources().openRawResource(page);
            try {
                InputStreamReader rdr = new InputStreamReader(s, "UTF-8");
                char[] buff = new char[1024];
                int len = 0;
                while ((len = rdr.read(buff)) > 0) {
                    sb.append(buff, 0, len);
                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    s.close();
                } catch (IOException e) {
                }

            }


        String value = sb.toString();

//       TextView textView = (TextView) findViewById(R.id.textViewer);
//            textView.setText(Html.fromHtml(value));

        WebView vwData= (WebView) findViewById(R.id.vwData);

        WebSettings webSettings = vwData.getSettings();
        webSettings.setJavaScriptEnabled(true);
            webSettings.setTextZoom(sizeWeb);
        vwData.loadData(value,"text/html","utf-8");
        }

    }

}