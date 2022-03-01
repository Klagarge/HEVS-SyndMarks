package hes.wallis.mark;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Switch;
import android.widget.TextView;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import hes.wallis.mark.databinding.ActivityMainRankBinding;

public class MainActivityRank extends AppCompatActivity {

    protected AppBarConfiguration mAppBarConfiguration;
    protected ActivityMainRankBinding binding;
    protected NavigationView navigationView;

    public static MainActivityRank mainActivityRank;
    public boolean Semester2 = true;

    static public SharedPreferences marks;
    static public SharedPreferences.Editor editorMarks;
    static public SharedPreferences settings;
    static public SharedPreferences.Editor editorSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityRank = this;

        // Set memories
        marks = getSharedPreferences("marks", 0);
        editorMarks = marks.edit();
        settings = getSharedPreferences("settings", 0);
        editorSettings = settings.edit();

        binding = ActivityMainRankBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMainActivityRank.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.Year1)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_activity_rank);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_rank, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_activity_rank);

        // Set version name
        TextView textVersion = findViewById(R.id.textVersion);
        textVersion.setText(BuildConfig.VERSION_NAME);

        // Get Semester
        Switch semesterSwitch = navigationView.getMenu().findItem(R.id.switchSemester).getActionView().findViewById(R.id.SwitchFromSwitchItem);
        updateSemester(semesterSwitch);
        semesterSwitch.setOnClickListener(v -> {
                    updateSemester(semesterSwitch);
                });

        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    private void updateSemester(Switch semesterSwitch){
        String semester = "Semester ";
        if(semesterSwitch.isChecked()){
            semester += 2;
            Semester2 = true;
            navigationView.getMenu().findItem(R.id.nav_german_S1).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_german_S2).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_mathematics_S1).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_mathematics_S2).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_it_S1).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_it_S2).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_physic_S2).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_eln_S1).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_ela_S2).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_tem_S1).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_static_S2).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_cco_S1).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_cco_S2).setVisible(true);
        } else {
            semester += 1;
            Semester2 = false;
            navigationView.getMenu().findItem(R.id.nav_german_S1).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_german_S2).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_mathematics_S1).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_mathematics_S2).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_it_S1).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_it_S2).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_physic_S2).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_eln_S1).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_ela_S2).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_tem_S1).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_static_S2).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_cco_S1).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_cco_S2).setVisible(false);
        }
        semesterSwitch.setText(semester);
    }
}