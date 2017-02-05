package andy.mentaldisorders;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity
         {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] companies = new String[] { "Acute stress disorder","Adjustment disorder","Agoraphobia","Alcohol abuse","Alcohol withdrawal","Avoidant/restrictive food intake disorder","Alzheimer's disease","Amnestic disorder","Amphetamine dependence","Anorexia nervosa","Anterograde amnesia","Antisocial personality disorder","Attention deficit disorder","Attention deficit hyperactivity disorder","Autophagia","Avoidant personality disorder","Asperger syndrome","Barbiturate dependence","Benzodiazepine dependence","Benzodiazepine misuse","Benzodiazepine withdrawal","Bereavement","Bibliomania","Binge eating disorder","Bipolar disorder","Bipolar I disorder","Bipolar II disorder","Body dysmorphic disorder","Borderline intellectual functioning","Borderline personality disorder","Brief psychotic disorder","Bulimia nervosa","Caffeine-induced anxiety disorder","Caffeine-induced sleep disorder","Cannabis dependence","Catatonic disorder","Catatonic schizophrenia","Circadian rhythm sleep disorder","Claustrophobia","Cocaine dependence","Cocaine intoxication","Cognitive disorder","Communication disorder","Conduct disorder","Cotard delusion","Cyclothymia","Delirium tremens","Depersonalization disorder","Depressive disorder","Derealization disorder","Dermatillomania","Desynchronosis","Developmental coordination disorder","Diogenes Syndrome","Dispareunia","Dissociative identity disorder","Dyspraxia","Dyslexia","EDNOS","Ekbom's Syndrome (Delusional Parasitosis)","Encopresis","Epilepsy","Enuresis (not due to a general medical condition)","Erotomania","Exhibitionism","Factitious disorder","Fregoli delusion","Fugue State","Ganser syndrome","Generalized anxiety disorder","General adaptation syndrome","Grandiose delusions","Hallucinogen-related disorder","Hallucinogen persisting perception disorder","Histrionic personality disorder","Huntington's disease","Hypomanic episode","Hypochondriasis","Insomnia","Intermittent explosive disorder","Kleptomania","Korsakoff's syndrome","Lacunar amnesia","Major depressive disorder","Major depressive episode","Maladaptive Daydreaming","Male erectile disorder","Malingering","Manic episode","Mathematics disorder","Melancholia","Minor depressive disorder","Misophonia","Mixed episode","Mood disorder","Munchausen's syndrome","Narcolepsy","Narcissistic personality disorder","Neurocysticercosis","Nicotine withdrawal","Night eating syndrome","Nightmare disorder","Obsessive-compulsive disorder (OCD)","Obsessive-compulsive personality disorder (OCPD)","Oneirophrenia","Opioid dependence","Opioid-related disorder","Oppositional defiant disorder (ODD)","Orthorexia (ON)","Ondine's curse","Pain disorder","Panic disorder","Paranoid personality disorder","Parasomnia","Parkinson's Disease","Pathological gambling","Persecutory delusion","Personality disorder","Pervasive developmental disorder not otherwise specified (PDD-NOS)","Phencyclidine (or phencyclidine-like)-related disorder","Phobic disorder","Pica (disorder)","Psychosis","Phonological disorder","Physical abuse","Polysubstance-related disorder","Posttraumatic stress disorder (PTSD)","Premature ejaculation","Primary hypersomnia","Primary insomnia","Psychogenic amnesia","Psychotic disorder","Pyromania","Reactive attachment disorder of infancy or early childhood","Recurrent brief depression","Relational disorder","Residual schizophrenia","Retrograde amnesia","Rumination syndrome","Schizoaffective disorder","Schizoid personality disorder","Schizophrenia","Schizophreniform disorder","Schizotypal personality disorder","Seasonal affective disorder","Sedative-, hypnotic-, or anxiolytic-related disorder","Selective mutism","Separation anxiety disorder","Severe mental retardation","Shared psychotic disorder","Sleep disorder","Seasonal affective disorder","Sleep terror disorder","Sleepwalking disorder","Sleep paralysis","Social anxiety disorder","Social phobia","Somatization disorder","Somatoform disorder","Specific phobia","Stereotypic movement disorder","Stockholm syndrome","Stuttering","Substance-related disorder","Tardive dyskinesia","Tourette syndrome","Transient tic disorder","Transient global amnesia","Trichotillomania" };
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, companies);
        final ListView listView = (ListView) findViewById(R.id.mainListView1);
        listView.setAdapter(adapter);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);




       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.settings1);




     //  TextView tvHeader = (TextView) findViewById(R.id.tvHeader);
        String html = "</p><font color=\"red\"> Some text </font> </p> other text";
      //  tvHeader.setText(Html.fromHtml(html));


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);


        final Intent a = new Intent(MainActivity.this, andy.mentaldisorders.Page1.class);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                if ( adapterView.getItemAtPosition(position) == "Acute stress disorder" ) {

                   // String keyIdentifier = getString(R.string.text1);
                    a.putExtra("text", R.raw.page1);

                } else if ( adapterView.getItemAtPosition(position) == "Adjustment disorder") {

                    a.putExtra("text", R.raw.adjustment_disorder);


                } else if ( adapterView.getItemAtPosition(position) == "Agoraphobia") {

                    a.putExtra("text", R.raw.agoraphob);

                } else if ( adapterView.getItemAtPosition(position) == "Alcohol abuse") {

                    a.putExtra("text", R.raw.alco_abuse);

                }

                view.setSelected(true);
                startActivity(a);
            }


        });



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
