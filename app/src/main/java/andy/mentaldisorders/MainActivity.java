package andy.mentaldisorders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
         {
    Toolbar toolbar;
             ArrayAdapter<String> adapter;
             EditText editsearch;
             JSONArray result;
             String[] disorders;
             public static String locale;
             public static int size = 100;
             private AdView adView;
            public static int pos;
             ArrayList<SupportedLocale> locales = new ArrayList<>();
             public  String assetJson =  String.format("%s.json", LocaleHelper.getLanguage(MainActivity.this)).toLowerCase();
            public SharedPreferences p;


             public  ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
             String disordersArrayFull[];
             @Override
    protected void onCreate(Bundle savedInstanceState) {
                 LocaleHelper.applyLocale(this);
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_main);


       //          pos = p.getInt("position", 0);
       //         size = p.getInt("size", 100);

      //            assetJson = p.getString("assetJson","en.json");
      //           adapter.notifyDataSetChanged();


                 final RelativeLayout reLay = (RelativeLayout) findViewById(R.id.reLay);

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
               //  adViewParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);


                 // reLay.addView(adView, adViewParams);
                 adView.setAdUnitId("ca-app-pub-2783112053927174/9499143242");
                 adView.setAdSize(AdSize.BANNER);
                 adView.loadAd(adRequest);
                 adView.setAdListener(new AdListener() {


                     @Override
                     public void onAdLoaded() {
                         super.onAdLoaded();
                         if(adView.getParent()==null) {
                             reLay.addView(adView, adViewParams);
                         }
                     }
                 });
                 adView.setBackgroundColor(Color.BLACK);
                 adView.setBackgroundColor(0);


            /*     ArrayList<String> languages = new ArrayList<String>();
                 languages.add("Language");
                 languages.add("English");
                 languages.add("Русский");
                 languages.add("Deutsche");
                 languages.add("Française");*/
                final Spinner spinner = (Spinner) findViewById(R.id.spinner);

                 spinner.setAdapter(new ArrayAdapter<SupportedLocale>(this,android.R.layout.simple_spinner_dropdown_item, SupportedLocale.values()));


                 for(SupportedLocale loc:SupportedLocale.values()) {
                     locales.add (loc);
                 }
                 spinner.setSelection( locales.indexOf(LocaleHelper.getCurrentLocale()));

                 spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                     @Override
                     public void onItemSelected(AdapterView<?> arg0, View arg1,
                                                int pos, long arg3) {
                         // TODO Auto-generated method stub


                         Intent intent1 = getIntent();
                         SupportedLocale loc = SupportedLocale.values()[pos];
                         if(loc!=LocaleHelper.getCurrentLocale()) {
                             LocaleHelper.setLocale(MainActivity.this, loc);
                             assetJson = String.format("%s.json",loc.getLangCode()).toLowerCase();
                             finish();

                             startActivity(intent1);
                         }
/*

                         switch (pos) {
                             case 1:

                                 setLocale("en");

                                 assetJson = "en.json";

                                 finish();
                                 startActivity(intent1);
                                 break;

                             case 2:
                                 setLocale("ru");
                                 assetJson = "ru.json";

                                 finish();
                                 startActivity(intent1);

                                 break;



                             case 3:
                                 setLocale("de");
                                 assetJson = "de.json";
                                 finish();
                                 startActivity(intent1);

                                 break;



                             case 4:
                                 setLocale("fr");
                                 assetJson = "fr.json";
                                 finish();
                                 startActivity(intent1);

                                 break;
                         }



                         SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                         p.edit().putString("selected_locale", locale).commit();

                         p.edit().putString("assetJson", assetJson).commit();

                         p.edit().putInt("position", pos).commit();


                         adapter.notifyDataSetChanged();
*/


                     }

                     @Override
                     public void onNothingSelected(AdapterView<?> arg0) {
                         // TODO Auto-generated method stub

                     }
                 });


                 try {


                     JSONArray json = new JSONArray(loadJSONFromAsset());

                     HashMap<String, String> map;

                     int index = 0;

                     for (int i = 0; i < json.length(); i++) {
                         JSONObject jo_inside = json.getJSONObject(i);
                         Log.d("Details-->", jo_inside.getString("h1"));
                         String name = jo_inside.getString("h1");
                         String file = jo_inside.getString("file");

                         //Add your values in your `ArrayList` as below:
                         map = new HashMap<String, String>();
                         map.put("h1", name);
                         map.put("file", file);

                         formList.add(map);

                     }

                 } catch (JSONException e) {
                     e.printStackTrace();
                 }

                 disordersArrayFull= new String[formList.size()];
                 for (int j = 0; j < formList.size(); j++) {
                     disordersArrayFull[j] = formList.get(j).get("h1");
                 }


               //  disordersArrayFull = new HashSet<String>(Arrays.asList(disordersArrayFull)).toArray(new String[0]);

        //         Collections.sort(Arrays.asList(disordersArrayFull), String.CASE_INSENSITIVE_ORDER);


Collections.sort(Arrays.asList(disordersArrayFull), new Comparator<String>() {
    @Override
    public int compare(String s, String t1) {
        return -s.compareToIgnoreCase(t1);
    }
});


                 adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, disordersArrayFull){

                 /*    private Filter customFilter = new Filter(){

                         @Override
                         protected FilterResults performFiltering(CharSequence charSequence) {
                             ArrayList<String> filtered = new ArrayList<>();
                             FilterResults fResults= new FilterResults();
                             for(String s:disordersArrayFull){
                                 if(s.startsWith(charSequence.toString())){
                                     filtered.add(s);
                                 }
                             }
                             fResults.count=filtered.size();
                             fResults.values=filtered;
                             return fResults;
                         }

                         @Override
                         protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                             ArrayList<String> filtered = (ArrayList<String>) filterResults.values;
                             while(!adapter.isEmpty())
                             adapter.remove(adapter.getItem(0));
                             adapter.addAll(filtered);
                             adapter.notifyDataSetChanged();
                         }
                     };
                     @NonNull
                     @Override
                     public Filter getFilter() {
                         return customFilter;
                     }*/
                 };




                 final ListView listView = (ListView) findViewById(R.id.mainListView1);
                 listView.setAdapter(adapter);
                 toolbar = (Toolbar) findViewById(R.id.toolbar);
                 setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayShowTitleEnabled(true);
                 getSupportActionBar().setTitle(getString(R.string.disorders));







                 ImageButton like = (ImageButton) findViewById(R.id.button_like);
                 ImageButton like2 = (ImageButton) findViewById(R.id.button_like2);
                 ImageButton like3 = (ImageButton) findViewById(R.id.button_like3);
                 ImageButton like4 = (ImageButton) findViewById(R.id.button_like4);
                 ImageButton like5 = (ImageButton) findViewById(R.id.button_like5);

                 like.setOnClickListener(new View.OnClickListener(){

                     @Override
                     public void onClick(View v) {

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=andy.mentaldisorders"));
                         startActivity(intent);
                     }
                 });

                 like2.setOnClickListener(new View.OnClickListener(){

                     @Override
                     public void onClick(View v) {

                         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=andy.mentaldisorders"));
                         startActivity(intent);
                     }
                 });

                 like3.setOnClickListener(new View.OnClickListener(){

                     @Override
                     public void onClick(View v) {

                         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=andy.mentaldisorders"));
                         startActivity(intent);
                     }
                 });


                 like4.setOnClickListener(new View.OnClickListener(){

                     @Override
                     public void onClick(View v) {

                         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=andy.mentaldisorders"));
                         startActivity(intent);
                     }
                 });

                 like5.setOnClickListener(new View.OnClickListener(){

                     @Override
                     public void onClick(View v) {

                         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=andy.mentaldisorders"));
                         startActivity(intent);
                     }
                 });


                 getSupportActionBar().setDisplayUseLogoEnabled(false);
              //   getSupportActionBar().setDisplayShowTitleEnabled(false);


                 // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                 // setSupportActionBar(toolbar);

                 DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                 ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                         this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                 drawer.setDrawerListener(toggle);
                 toggle.syncState();

                 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                 toolbar.setNavigationIcon(R.drawable.settings52);
              //   toolbar.setLogo(R.drawable.disorder);


                 //       String html = "</p><font color=\"red\"> Some text </font> </p> other text";


                 NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);


                 final Intent a = new Intent(MainActivity.this, andy.mentaldisorders.Page1.class);

                 editsearch = (EditText) findViewById(R.id.editText);

                 editsearch.addTextChangedListener(new TextWatcher() {

                     public void afterTextChanged(Editable arg0) {
                         // TODO Auto-generated method stub
                         MainActivity.this.adapter.getFilter().filter(arg0);
                     }

                     public void beforeTextChanged(CharSequence arg0, int arg1,
                                                   int arg2, int arg3) {
                         // TODO Auto-generated method stub

                     }

                     public void onTextChanged(CharSequence cs, int arg1, int arg2,
                                               int arg3) {



                     }

                 });










                 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                     public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                         String item = (String) listView.getItemAtPosition(position);


                         int index = getIndexOFValue(item, formList);


                         String path = formList.get(index).get("file");



                                int fileId = getResources().getIdentifier(path, "raw", getPackageName());
                             a.putExtra("text", fileId);

            //             p.edit().putInt("size", size).commit();

                             a.putExtra("size", size);
                             view.setSelected(true);
                             startActivity(a);
                         }


                     });


                 }


       @Override
       protected void onResume() {
           super.onResume();

        //  pos = p.getInt("position", 0);
        //  assetJson = p.getString("assetJson", null);
           adapter.notifyDataSetChanged();

       }

             public String loadJSONFromAsset(){
                 String json = null;



                 try {
                     InputStream is = getAssets().open(assetJson);
                     int size = is.available();
                     byte[] buffer = new byte[size];
                     is.read(buffer);
                     is.close();
                     json = new String(buffer, "UTF-8");
                 } catch (IOException ex) {
                     ex.printStackTrace();
                     return null;
                 }
                 return json;
             }


             public static int getIndexOFValue(String value, ArrayList<HashMap<String, String>> formList) {

                 int k = 0;
                 for (HashMap<String, String> map : formList) {
                     if (map.containsValue(value)) {
                         return k;
                     }
                     k++;
                 }
                 return -1;
             }




             public void setLocale(String localeCode){
                 Locale locale = new Locale(localeCode);
                 Locale.setDefault(locale);
                 Configuration config = new Configuration();
                 config.locale = locale;
                 getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
          //       Intent intent=new Intent();
         //        intent.setClass(act, act.getClass());
       //          act.startActivity(intent);
        //         act.finish();

             }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);



        return true;
    }


}
