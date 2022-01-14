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

    static public SharedPreferences marks;
    static public SharedPreferences.Editor editorMarks;
    static public SharedPreferences settings;
    static public SharedPreferences.Editor editorSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        semesterSwitch.setOnClickListener(v -> {
            String semester = "Semester ";
            if(semesterSwitch.isChecked()){
                semester += 2;
                navigationView.getMenu().findItem(R.id.nav_physic).setVisible(true);
            } else {
                semester += 1;
                navigationView.getMenu().findItem(R.id.nav_physic).setVisible(false);
            }
            semesterSwitch.setText(semester);
        });

        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}