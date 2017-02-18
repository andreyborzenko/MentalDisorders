package andy.mentaldisorders;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import static android.graphics.Color.WHITE;

/**
 * Created by chach on 2017-02-01.
 */
public class Page1 extends Activity {

    /**
     * Called when the activity is first created.
     */
    private int page;
    private static int sizeWeb;
    private AdView adView;
    public int size2 = 100;
    public WebSettings webSettings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        LocaleHelper.applyLocale(this);
        super.onCreate(savedInstanceState);
        //Get the bundle
        setContentView(R.layout.page1);

        final WebView vwData = (WebView) findViewById(R.id.vwData);

        //   TextView tvFooter = (TextView) findViewById(R.id.tvFooter);
        //   tvFooter.setText("Sourse - wikipedia.org");

        final RelativeLayout reLay1 = (RelativeLayout) findViewById(R.id.reLay1);


        ImageButton back = (ImageButton) findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        final ImageButton invert = (ImageButton) findViewById(R.id.button_invert);




        ImageButton plus2 = (ImageButton) findViewById(R.id.button_plus2);

        ImageButton minus2 = (ImageButton) findViewById(R.id.button_minus2);




        final TextView sizeText2 = (TextView) findViewById(R.id.size2);

        page = getIntent().getIntExtra("text", 0);
        sizeWeb = getIntent().getIntExtra("size", 100);

        minus2.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View v) {

                                          size2 = size2 - 10;
                                          sizeText2.setText(getString(R.string.textsize) + size2 + "%");

                                          if (size2 == 40) {

                                              size2 = 50;
                                          }

                                          sizeWeb = size2;
                                          webSettings.setTextZoom(sizeWeb);
                                      }
                                  }
        );

        plus2.setOnClickListener(new View.OnClickListener() {

                                     @Override
                                     public void onClick(View v) {

                                         size2 = size2 + 10;
                                         sizeText2.setText(getString(R.string.textsize) + size2 + "%");

                                         if (size2 == 160) {

                                             size2 = 150;
                                         }
                                         sizeWeb = size2;
                                         webSettings.setTextZoom(sizeWeb);

                                     }
                                 }
        );


        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        //adRequest.

        adView = new AdView(this);

        final RelativeLayout.LayoutParams adViewParams = new RelativeLayout.LayoutParams(
                AdView.LayoutParams.WRAP_CONTENT,
                AdView.LayoutParams.WRAP_CONTENT);
        // align bottom
        adViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        // align center
        adViewParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);


        // reLay.addView(adView, adViewParams);
        adView.setAdUnitId("ca-app-pub-2783112053927174/9499143242");
        adView.setAdSize(AdSize.BANNER);
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener() {


            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (adView.getParent() == null) {
                    reLay1.addView(adView, adViewParams);
                }
            }
        });
        adView.setBackgroundColor(Color.BLACK);
        adView.setBackgroundColor(0);


        page = getIntent().getIntExtra("text", 0);
        sizeWeb = getIntent().getIntExtra("size", 100);






        if (page != 0) {
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


            final String value = sb.toString();

            final String text = "<html><head>"
                    + "<style type=\"text/css\">body{color: #ccc; background-color: #000;}"
                    + "</style></head>"
                    + "<body>"
                    + value
                    + "</body></html>";


//       TextView textView = (TextView) findViewById(R.id.textViewer);
//            textView.setText(Html.fromHtml(value));

            reLay1.setBackgroundColor(WHITE);

            webSettings = vwData.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setTextZoom(sizeWeb);
            webSettings.setAllowFileAccess(true);
            if (Build.VERSION.SDK_INT >= 16) {
                webSettings.setAllowFileAccessFromFileURLs(true);
                webSettings.setAllowUniversalAccessFromFileURLs(true);
            }
            webSettings.setAllowContentAccess(true);
            webSettings.setBlockNetworkLoads(false);
            webSettings.setBlockNetworkImage(false);


            //webSettings.setA
            //         webSettings.setLoadWithOverviewMode(true);
            //        webSettings.setUseWideViewPort(true);
            vwData.loadData(value, "text/html", "utf-8");





     //      vwData.setWebViewClient(new WebViewClient() {
     //          @Override
     //          public boolean shouldOverrideUrlLoading(WebView view, String url) {
     ////              String urlBase = url.replace("http://", "file:///");

     //              int fIndex = url.lastIndexOf('/');
     //              String filename = url.substring(fIndex + 1);
     //              int resourceId = getResources().getIdentifier(filename,
     //                      "raw", getPackageName());

     //              StringBuilder sb = new StringBuilder();
     //              InputStream s = getResources().openRawResource(resourceId);
     //              try {

     //                  InputStreamReader rdr = new InputStreamReader(s, "UTF-8");
     //                  char[] buff = new char[1024];
     //                  int len = 0;
     //                  while ((len = rdr.read(buff)) > 0) {
     //                      sb.append(buff, 0, len);
     //                  }

     //              } catch (UnsupportedEncodingException e) {
     //                  e.printStackTrace();
     //              } catch (IOException e) {
     //                  e.printStackTrace();
     //              } finally {
     //                  if (s != null)
     //                      try {
     //                          s.close();
     //                      } catch (IOException e) {
     //                      }

     //              }

     //               final String value = sb.toString();


     //               final String text = "<html><head>"
     //                      + "<style type=\"text/css\">body{color: #ccc; background-color: #000;}"
     //                      + "</style></head>"
     //                      + "<body>"
     //                      + value
     //                      + "</body></html>";

     //              ColorDrawable viewColor1 = (ColorDrawable) reLay1.getBackground();
     //              final int colorId1 = viewColor1.getColor();
     //              if (colorId1 == WHITE) {

     //                  vwData.loadData(value, "text/html", "utf-8");
     //                  reLay1.setBackgroundColor(Color.WHITE);

     //                  invert.setOnClickListener(new View.OnClickListener() {
     //                      @Override
     //                      public void onClick(View view) {
     //                          vwData.loadData(text, "text/html", "utf-8");
     //                          reLay1.setBackgroundColor(Color.BLACK);
     //                      }
     //                  });

     //              } else if (colorId1 == BLACK) {

     //                  vwData.loadData(text, "text/html", "utf-8");
     //                  reLay1.setBackgroundColor(Color.BLACK);
     //                  invert.setOnClickListener(new View.OnClickListener() {
     //                      @Override
     //                      public void onClick(View view) {
     //                          vwData.loadData(value, "text/html", "utf-8");
     //                          reLay1.setBackgroundColor(Color.WHITE);
     //                      }
     //                  });
     //              }

     //              return false;






     //          }
     //      });

            invert.setOnClickListener(new View.OnClickListener() {

                                          @Override
                                          public void onClick(View v) {

                                              ColorDrawable viewColor = (ColorDrawable) reLay1.getBackground();
                                              int colorId = viewColor.getColor();


                                              if (colorId == WHITE) {
                                                  vwData.loadData(text, "text/html", "utf-8");
                                                  reLay1.setBackgroundColor(Color.BLACK);
                                              } else {
                                                  vwData.loadData(value, "text/html", "utf-8");
                                                  reLay1.setBackgroundColor(WHITE);

                                              }


                                          }
                                      }
            );



        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Page1.this, MainActivity.class));
        finish();

    }

}