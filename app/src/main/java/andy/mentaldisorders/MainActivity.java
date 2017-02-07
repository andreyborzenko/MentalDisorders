package andy.mentaldisorders;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
         {
    Toolbar toolbar;
             ArrayAdapter<String> adapter;
             EditText editsearch;
             public static int size = 100;
        public static String language = "English";
             @Override
    protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_main);


                 String[] companies = new String[]{"Acute stress disorder", "Adjustment disorder", "Agoraphobia", "Alcohol abuse", "Alcohol withdrawal", "Alzheimer's disease", "Amnestic disorder", "Amphetamine dependence", "Anorexia nervosa", "Anterograde amnesia", "Antisocial personality disorder", "Attention deficit disorder", "Autophagia", "Avoidant personality disorder", "Asperger syndrome", "Barbiturate dependence", "Benzodiazepine dependence", "Benzodiazepine misuse", "Benzodiazepine withdrawal", "Bereavement", "Bibliomania", "Binge eating disorder", "Bipolar disorder", "Body dysmorphic disorder", "Borderline intellectual functioning", "Borderline personality disorder", "Brief psychotic disorder", "Bulimia nervosa", "Caffeine-induced anxiety disorder", "Caffeine-induced sleep disorder", "Cannabis dependence", "Circadian rhythm sleep disorder", "Claustrophobia", "Cocaine dependence", "Cognitive disorder", "Communication disorder", "Conduct disorder", "Cotard delusion", "Cyclothymia", "Delirium tremens", "Depersonalization disorder", "Depressive disorder", "Dermatillomania", "Desynchronosis", "Developmental coordination disorder", "Diogenes Syndrome", "Dispareunia", "Dissociative identity disorder", "Dyspraxia", "Dyslexia", "EDNOS", "Ekbom's Syndrome (Delusional Parasitosis)", "Encopresis", "Epilepsy", "Enuresis (not due to a general medical condition)", "Erotomania", "Exhibitionism", "Factitious disorder", "Fregoli delusion", "Fugue State", "Ganser syndrome", "Generalized anxiety disorder", "General adaptation syndrome", "Grandiose delusions", "Hallucinogen-related disorder", "Hallucinogen persisting perception disorder", "Histrionic personality disorder", "Huntington's disease", "Hypomanic episode", "Hypochondriasis", "Insomnia", "Intermittent explosive disorder", "Kleptomania", "Korsakoff's syndrome", "Lacunar amnesia", "Major depressive episode", "Maladaptive Daydreaming", "Male erectile disorder", "Malingering", "Manic episode", "Mathematics disorder", "Melancholia", "Misophonia", "Mixed episode", "Mood disorder", "Munchausen's syndrome", "Narcolepsy", "Narcissistic personality disorder", "Neurocysticercosis", "Nicotine withdrawal", "Night eating syndrome", "Nightmare disorder", "Obsessive-compulsive disorder", "Obsessive-compulsive personality disorder", "Oneirophrenia", "Opioid dependence", "Oppositional defiant disorder", "Orthorexia", "Ondine's curse", "Pain disorder", "Panic disorder", "Paranoid personality disorder", "Parasomnia", "Parkinson's Disease", "Pathological gambling", "Persecutory delusion", "Personality disorder", "Pervasive developmental disorder not otherwise specified", "Phencyclidine-related disorder", "Phobic disorder", "Pica (disorder)", "Psychosis", "Phonological disorder", "Physical abuse", "Poly drug use", "Posttraumatic stress disorder", "Premature ejaculation", "Primary hypersomnia", "Primary insomnia", "Psychogenic amnesia", "Pyromania", "Reactive attachment disorder", "Recurrent brief depression", "Relational disorder", "Retrograde amnesia", "Rumination syndrome", "Schizoaffective disorder", "Schizoid personality disorder", "Schizophrenia", "Schizophreniform disorder", "Schizotypal personality disorder", "Selective mutism", "Separation anxiety disorder", "Severe mental retardation", "Shared psychotic disorder", "Sleep disorder", "Seasonal affective disorder", "Sleep terror disorder", "Sleepwalking disorder", "Sleep paralysis", "Social anxiety disorder", "Somatization disorder", "Somatoform disorder", "Specific phobia", "Stereotypic movement disorder", "Stockholm syndrome", "Stuttering", "Substance-related disorder", "Tardive dyskinesia", "Tourette syndrome", "Transient global amnesia", "Trichotillomania"};

                 String[] chinese = new String[]{"精神失常", "廣場恐懼症", "酗酒_和藥物濫用", "酒精和藥物依賴", "失憶症", "懼高症", "焦慮症", "心因性厭食症", "反社會人格障礙", "亞斯伯格症候群", "注意力不足症", "注意力不足過動症", "自閉症", "逃避性人格障礙", "喪慟", "恋兽癖", "藏書癖", "暴食症", "躁鬱症", "軀體變形障礙", "邊緣性人格障礙", "飲食失調症", "循環性精神病", "谵妄", "妄想症", "抑鬱症", "失智症_", "解離症", "人格分裂", "性交疼痛", "失读症", "情緒障礙", "大便失禁", "遺尿症", "癲癇", "裸露癖", "模仿言語", "被爱妄想症", "女性性喚起障礙", "戀物癖", "二聯性精神病", "摩擦癖", "性別不安症", "廣泛性焦慮症", "表演型人格障礙", "過動症", "性慾減退", "歇斯底里", "亨丁顿舞蹈症_", "失眠症", "竊盜癖", "學習障礙", "躁狂症", "男性勃起障礙", "多重人格", "孟喬森症候群", "智能不足／學習障礙", "猝睡症", "精神官能症", "強迫症", "恐慌症", "偏執型人格障礙", "性慾倒錯", "病態賭博", "恋童癖", "廣泛性發展障礙", "創傷後壓力心理障礙症", "產後抑鬱症", "早洩", "學習障礙", "類精神分裂人格異常", "精神分裂症", "分裂性人格障礙", "季节性情绪失调", "睡眠障礙", "夜驚", "夢遊症", "社交恐懼症", "特殊性發育障礙", "口吃", "斯德哥爾摩症候群", "妥瑞症", "拔毛癖", "阴道痉挛",};


                 Spinner spinner = (Spinner) findViewById(R.id.spinner);

                 String language = spinner.getSelectedItem().toString();


                 final ListView listView = (ListView) findViewById(R.id.mainListView1);
                 listView.setAdapter(adapter);
                 toolbar = (Toolbar) findViewById(R.id.toolbar);
                 setSupportActionBar(toolbar);

                 Button buttonMinus = (Button) findViewById(R.id.button_minus);
                 Button buttonPlus = (Button) findViewById(R.id.button_plus);
                 final TextView sizeText = (TextView) findViewById(R.id.size);
                 adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, companies);

                 buttonMinus.setOnClickListener(new View.OnClickListener() {

                                                    @Override
                                                    public void onClick(View v) {

                                                        size = size - 10;
                                                        sizeText.setText("Text size: " + size + "%");

                                                        if (size == 40) {

                                                            size = 50;
                                                        }


                                                    }
                                                }
                 );

                 buttonPlus.setOnClickListener(new View.OnClickListener() {

                                                   @Override
                                                   public void onClick(View v) {
                                                       size = size + 10;
                                                       sizeText.setText("Text size: " + size + "%");

                                                       if (size == 160) {

                                                           size = 150;
                                                       }

                                                   }
                                               }
                 );


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


                 //       String html = "</p><font color=\"red\"> Some text </font> </p> other text";


                 NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);


                 final Intent a = new Intent(MainActivity.this, andy.mentaldisorders.Page1.class);

                 editsearch = (EditText) findViewById(R.id.editText);

                 editsearch.addTextChangedListener(new TextWatcher() {

                     public void afterTextChanged(Editable arg0) {
                         // TODO Auto-generated method stub

                     }

                     public void beforeTextChanged(CharSequence arg0, int arg1,
                                                   int arg2, int arg3) {
                         // TODO Auto-generated method stub
                         MainActivity.this.adapter.getFilter().filter(arg0);
                     }

                     public void onTextChanged(CharSequence cs, int arg1, int arg2,
                                               int arg3) {
                         // TODO Auto-generated method stub


                     }

                 });

                 if (language == "English") {


                     adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, companies);


                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                         public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                             if (adapterView.getItemAtPosition(position) == "Acute stress disorder") {

                                 // String keyIdentifier = getString(R.string.text1);
                                 a.putExtra("text", R.raw.page1);


                             } else if (adapterView.getItemAtPosition(position) == "Adjustment disorder") {

                                 a.putExtra("text", R.raw.adjustment_disorder);


                             } else if (adapterView.getItemAtPosition(position) == "Agoraphobia") {

                                 a.putExtra("text", R.raw.agoraphob);

                             } else if (adapterView.getItemAtPosition(position) == "Alcohol abuse") {

                                 a.putExtra("text", R.raw.alco_abuse);

                             } else if (adapterView.getItemAtPosition(position) == "Alcohol withdrawal") {

                                 a.putExtra("text", R.raw.alcohol_withdrawal_syndrome);

                             } else if (adapterView.getItemAtPosition(position) == "Alzheimer's disease") {
                                 a.putExtra("text", R.raw.alzheimers_disease
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Amnesia") {
                                 a.putExtra("text", R.raw.amnesia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Amphetamine dependence") {
                                 a.putExtra("text", R.raw.amphetamine_dependence
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Anorexia nervosa") {
                                 a.putExtra("text", R.raw.anorexia_nervosa
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Anterograde amnesia") {
                                 a.putExtra("text", R.raw.anterograde_amnesia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Antisocial personality disorder") {
                                 a.putExtra("text", R.raw.antisocial_personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Attention deficit disorder") {
                                 a.putExtra("text", R.raw.attention_deficit_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Autophagia") {
                                 a.putExtra("text", R.raw.autophagia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Avoidant personality disorder") {
                                 a.putExtra("text", R.raw.avoidant_personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Atelophobia") {
                                 a.putExtra("text", R.raw.atelophobia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Asperger syndrome") {
                                 a.putExtra("text", R.raw.asperger_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Barbiturate dependence") {
                                 a.putExtra("text", R.raw.barbiturate_dependence
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Benzodiazepine dependence") {
                                 a.putExtra("text", R.raw.benzodiazepine_dependence
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Benzodiazepine misuse") {
                                 a.putExtra("text", R.raw.benzodiazepine_misuse
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Benzodiazepine withdrawal") {
                                 a.putExtra("text", R.raw.benzodiazepine_withdrawal
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Bereavement") {
                                 a.putExtra("text", R.raw.bereavement
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Bibliomania") {
                                 a.putExtra("text", R.raw.bibliomania
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Binge eating disorder") {
                                 a.putExtra("text", R.raw.binge_eating_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Bipolar disorder") {
                                 a.putExtra("text", R.raw.bipolar_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Body dysmorphic disorder") {
                                 a.putExtra("text", R.raw.body_dysmorphic_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Borderline intellectual functioning") {
                                 a.putExtra("text", R.raw.borderline_intellectual_functioning
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Borderline personality disorder") {
                                 a.putExtra("text", R.raw.borderline_personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Brief psychotic disorder") {
                                 a.putExtra("text", R.raw.brief_psychotic_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Bulimia nervosa") {
                                 a.putExtra("text", R.raw.bulimia_nervosa
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Caffeine-induced anxiety disorder") {
                                 a.putExtra("text", R.raw.caffeine_induced_anxiety_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Caffeine-induced sleep disorder") {
                                 a.putExtra("text", R.raw.caffeine_induced_sleep_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Cannabis dependence") {
                                 a.putExtra("text", R.raw.cannabis_dependence
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Catatonia") {
                                 a.putExtra("text", R.raw.catatonia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Circadian rhythm sleep disorder") {
                                 a.putExtra("text", R.raw.circadian_rhythm_sleep_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Claustrophobia") {
                                 a.putExtra("text", R.raw.claustrophobia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Cocaine dependence") {
                                 a.putExtra("text", R.raw.cocaine_dependence
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Cocaine intoxicatio") {
                                 a.putExtra("text", R.raw.cocaine_intoxication
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Cognitive disorder") {
                                 a.putExtra("text", R.raw.cognitive_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Communication disorder") {
                                 a.putExtra("text", R.raw.communication_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Conduct disorder") {
                                 a.putExtra("text", R.raw.conduct_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Cotard delusio") {
                                 a.putExtra("text", R.raw.cotard_delusion
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Cyclothymia") {
                                 a.putExtra("text", R.raw.cyclothymia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Delirium tremens") {
                                 a.putExtra("text", R.raw.delirium_tremens
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Depersonalization disorder") {
                                 a.putExtra("text", R.raw.depersonalization_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Depressive disorder") {
                                 a.putExtra("text", R.raw.depressive_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Derealizatio") {
                                 a.putExtra("text", R.raw.derealization
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Dermatillomania") {
                                 a.putExtra("text", R.raw.dermatillomania
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Desynchronosis") {
                                 a.putExtra("text", R.raw.desynchronosis
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Developmental coordination disorder") {
                                 a.putExtra("text", R.raw.developmental_coordination_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Diogenes Syndrome") {
                                 a.putExtra("text", R.raw.diogenes_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Dispareunia") {
                                 a.putExtra("text", R.raw.dispareunia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Dissociative identity disorder") {
                                 a.putExtra("text", R.raw.dissociative_identity_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Dyspraxia") {
                                 a.putExtra("text", R.raw.dyspraxia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Dyslexia") {
                                 a.putExtra("text", R.raw.dyslexia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "EDNOS") {
                                 a.putExtra("text", R.raw.ednos
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Encopresis") {
                                 a.putExtra("text", R.raw.encopresis
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Epilepsy") {
                                 a.putExtra("text", R.raw.epilepsy
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Enuresis") {
                                 a.putExtra("text", R.raw.enuresis
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Erotomania") {
                                 a.putExtra("text", R.raw.erotomania
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Exhibitionism") {
                                 a.putExtra("text", R.raw.exhibitionism
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Factitious disorder") {
                                 a.putExtra("text", R.raw.factitious_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Fregoli delusio") {
                                 a.putExtra("text", R.raw.fregoli_delusion
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Fugue State") {
                                 a.putExtra("text", R.raw.fugue_state
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Ganser syndrome") {
                                 a.putExtra("text", R.raw.ganser_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Generalized anxiety disorder") {
                                 a.putExtra("text", R.raw.generalized_anxiety_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "General adaptation syndrome") {
                                 a.putExtra("text", R.raw.general_adaptation_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Grandiose delusions") {
                                 a.putExtra("text", R.raw.grandiose_delusions
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Hallucinogen-related disorder") {
                                 a.putExtra("text", R.raw.hallucinogen
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Hallucinogen persisting perception disorder") {
                                 a.putExtra("text", R.raw.hallucinogen_persisting_perception_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Histrionic personality disorder") {
                                 a.putExtra("text", R.raw.histrionic_personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Huntington's disease") {
                                 a.putExtra("text", R.raw.huntingtons_disease
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Hypomanic episode") {
                                 a.putExtra("text", R.raw.hypomanic_episode
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Hypochondriasis") {
                                 a.putExtra("text", R.raw.hypochondriasis
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Hysteria") {
                                 a.putExtra("text", R.raw.hysteria
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Insomnia") {
                                 a.putExtra("text", R.raw.insomnia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Intermittent explosive disorder") {
                                 a.putExtra("text", R.raw.intermittent_explosive_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Kleptomania") {
                                 a.putExtra("text", R.raw.kleptomania
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Korsakoff's syndrome") {
                                 a.putExtra("text", R.raw.korsakoffs_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Lacunar amnesia") {
                                 a.putExtra("text", R.raw.lacunar_amnesia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Major depressive episode") {
                                 a.putExtra("text", R.raw.major_depressive_episode
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Maladaptive Daydreaming") {
                                 a.putExtra("text", R.raw.maladaptive_daydreaming
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Male erectile disorder") {
                                 a.putExtra("text", R.raw.male_erectile_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Malingering") {
                                 a.putExtra("text", R.raw.malingering
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Manic episode") {
                                 a.putExtra("text", R.raw.manic_episode
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Mathematics disorder") {
                                 a.putExtra("text", R.raw.mathematics_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Melancholia") {
                                 a.putExtra("text", R.raw.melancholia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Misophonia") {
                                 a.putExtra("text", R.raw.misophonia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Mixed episode") {
                                 a.putExtra("text", R.raw.mixed_episode
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Mood disorder") {
                                 a.putExtra("text", R.raw.mood_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Munchausen's syndrome") {
                                 a.putExtra("text", R.raw.munchausens_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Narcolepsy") {
                                 a.putExtra("text", R.raw.narcolepsy
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Narcissistic personality disorder") {
                                 a.putExtra("text", R.raw.narcissistic_personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Neurocysticercosis") {
                                 a.putExtra("text", R.raw.neurocysticercosis
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Nicotine withdrawal") {
                                 a.putExtra("text", R.raw.nicotine_withdrawal
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Night eating syndrome") {
                                 a.putExtra("text", R.raw.night_eating_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Nightmare disorder") {
                                 a.putExtra("text", R.raw.nightmare_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Obsessive-compulsive disorder") {
                                 a.putExtra("text", R.raw.obsessive_compulsive_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Obsessive-compulsive personality disorder") {
                                 a.putExtra("text", R.raw.obsessive_compulsive_personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Oneirophrenia") {
                                 a.putExtra("text", R.raw.oneirophrenia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Opioid dependence") {
                                 a.putExtra("text", R.raw.opioid_dependence
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Oppositional defiant disorder") {
                                 a.putExtra("text", R.raw.oppositional_defiant_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Orthorexia") {
                                 a.putExtra("text", R.raw.orthorexia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Ondine's curse") {
                                 a.putExtra("text", R.raw.ondines_curse
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Pain disorder") {
                                 a.putExtra("text", R.raw.pain_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Panic disorder") {
                                 a.putExtra("text", R.raw.panic_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Paranoid personality disorder") {
                                 a.putExtra("text", R.raw.paranoid_personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Parasomnia") {
                                 a.putExtra("text", R.raw.parasomnia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Parkinson's Disease") {
                                 a.putExtra("text", R.raw.parkinsons_disease
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Pathological gambling") {
                                 a.putExtra("text", R.raw.pathological_gambling
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Persecutory delusion") {
                                 a.putExtra("text", R.raw.persecutory_delusion
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Personality disorder") {
                                 a.putExtra("text", R.raw.personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Pervasive developmental disorder not otherwise specified") {
                                 a.putExtra("text", R.raw.pervasive_developmental_disorder_not_otherwise_specified
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Phencyclidine-related disorder") {
                                 a.putExtra("text", R.raw.phencyclidine
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Phobic disorder") {
                                 a.putExtra("text", R.raw.phobic_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Pica (disorder)") {
                                 a.putExtra("text", R.raw.pica_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Psychosis") {
                                 a.putExtra("text", R.raw.psychosis
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Phonological disorder") {
                                 a.putExtra("text", R.raw.phonological_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Physical abuse") {
                                 a.putExtra("text", R.raw.physical_abuse
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Poly drug use") {
                                 a.putExtra("text", R.raw.poly_drug_use
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Posttraumatic stress disorder") {
                                 a.putExtra("text", R.raw.posttraumatic_stress_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Premature ejaculation") {
                                 a.putExtra("text", R.raw.premature_ejaculation
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Primary hypersomnia") {
                                 a.putExtra("text", R.raw.primary_hypersomnia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Primary insomnia") {
                                 a.putExtra("text", R.raw.primary_insomnia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Psychogenic amnesia") {
                                 a.putExtra("text", R.raw.psychogenic_amnesia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Pyromania") {
                                 a.putExtra("text", R.raw.pyromania
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Reactive attachment disorder") {
                                 a.putExtra("text", R.raw.reactive_attachment_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Recurrent brief depression") {
                                 a.putExtra("text", R.raw.recurrent_brief_depression
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Relational disorder") {
                                 a.putExtra("text", R.raw.relational_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Retrograde amnesia") {
                                 a.putExtra("text", R.raw.retrograde_amnesia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Rumination syndrome") {
                                 a.putExtra("text", R.raw.rumination_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Schizoaffective disorder") {
                                 a.putExtra("text", R.raw.schizoaffective_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Schizoid personality disorder") {
                                 a.putExtra("text", R.raw.schizoid_personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Schizophrenia") {
                                 a.putExtra("text", R.raw.schizophrenia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Schizophreniform disorder") {
                                 a.putExtra("text", R.raw.schizophreniform_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Schizotypal personality disorder") {
                                 a.putExtra("text", R.raw.schizotypal_personality_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Seasonal affective disorder") {
                                 a.putExtra("text", R.raw.seasonal_affective_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Selective mutism") {
                                 a.putExtra("text", R.raw.selective_mutism
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Separation anxiety disorder") {
                                 a.putExtra("text", R.raw.separation_anxiety_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Severe mental retardation") {
                                 a.putExtra("text", R.raw.severe_mental_retardation
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Shared psychotic disorder") {
                                 a.putExtra("text", R.raw.shared_psychotic_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Sleep disorder") {
                                 a.putExtra("text", R.raw.sleep_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Seasonal affective disorder") {
                                 a.putExtra("text", R.raw.seasonal_affective_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Sleep terror disorder") {
                                 a.putExtra("text", R.raw.sleep_terror_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Sleepwalking disorder") {
                                 a.putExtra("text", R.raw.sleepwalking_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Sleep paralysis") {
                                 a.putExtra("text", R.raw.sleep_paralysis
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Social anxiety disorder") {
                                 a.putExtra("text", R.raw.social_anxiety_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Somatization disorder") {
                                 a.putExtra("text", R.raw.somatization_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Somatoform disorder") {
                                 a.putExtra("text", R.raw.somatoform_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Specific phobia") {
                                 a.putExtra("text", R.raw.specific_phobia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Stereotypic movement disorder") {
                                 a.putExtra("text", R.raw.stereotypic_movement_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Stockholm syndrome") {
                                 a.putExtra("text", R.raw.stockholm_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Stuttering") {
                                 a.putExtra("text", R.raw.stuttering
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Substance-related disorder") {
                                 a.putExtra("text", R.raw.substance_related_disorder
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Tardive dyskinesia") {
                                 a.putExtra("text", R.raw.tardive_dyskinesia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Tourette syndrome") {
                                 a.putExtra("text", R.raw.tourette_syndrome
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Transient global amnesia") {
                                 a.putExtra("text", R.raw.transient_global_amnesia
                                 );
                             } else if (adapterView.getItemAtPosition(position) == "Trichotillomania") {
                                 a.putExtra("text", R.raw.trichotillomania);

                             }


                             a.putExtra("size", size);
                             view.setSelected(true);
                             startActivity(a);
                         }


                     });


                 } else

                 if (language == "中文") {


                     adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chinese);


                     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                         public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                             if (adapterView.getItemAtPosition(position) == "精神失常") {

                                 // String keyIdentifier = getString(R.string.text1);

                                 a.putExtra("text", R.raw.waberration);

                             }

                             a.putExtra("size", size);
                             view.setSelected(true);
                             startActivity(a);
                         }


                     });


                 }
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
