package andy.mentaldisorders;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.ViewGroup;
import android.widget.Button;
import android.graphics.drawable.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] companies = new String[] { "1. Держать себя в руках", "2. Быть не таким, как все", "3. Изучить все ее сильные и слабые стороны",
                "4. Научиться видеть ее глазами", "5. Уметь льстить", "6. Не давать ей почувствовать всей силы", "7. Поставить себя существом высшего порядка",
                "8. Берегись чувства принуждения", "9. Умей создать ситуацию и обстановку", "10. Умей ждать случай - и пользоваться им", "11. Никогда ничего не проси",
                "12. Делай меньше подарков", "13. Никогда не отказывайся ни от чего", "14. Основной рычаг - самолюбие, основное средство - боль", "15. Умей сказать нет и уйти",
                "16. Старайся не придумывать и не лгать", "17. Добейся всего, но не смей травмировать ее душу", "18. Обрети культуру секса", "19. Давай поводы для ревности",
                "20. Умей показать ей свое презрение", "21. Не торопи события", "22. Выжми все из внешности, одежды, речи" };
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, companies);
        ListView listView = (ListView) findViewById(R.id.mainListView1);
        listView.setAdapter(adapter);

		
		final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(
            R.layout.action_bar,
            null);

		// Set up your ActionBar
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionBarLayout);

		// You customization
		final int actionBarColor = getResources().getColor(R.color.action_bar);
		actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));

		final Button actionBarTitle = (Button) findViewById(R.id.action_bar_title);
		actionBarTitle.setText("Index(2)");

		final Button actionBarSent = (Button) findViewById(R.id.action_bar_sent);
		actionBarSent.setText("Sent");

		final Button actionBarStaff = (Button) findViewById(R.id.action_bar_staff);
		actionBarStaff.setText("Staff");

		final Button actionBarLocations = (Button) findViewById(R.id.action_bar_locations);
		actionBarLocations.setText("HIPPA Locations");
		
		
		
		
		
		
		
		
		
		
		
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
