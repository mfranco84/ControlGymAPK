package com.example.myfirstapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myfirstapp.ListaMiembroActivity;
import com.example.myfirstapp.Notificaciones;
import com.example.myfirstapp.R;

/**
 * Created by M.Franco on 2/19/2017.
 */

public class ControlGymBaseActivity extends AppCompatActivity {
    /** OptionMenu **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_action_perfil){
            Intent newIntent = new Intent(ControlGymBaseActivity.this, ListaMiembroActivity.class);
            startActivity(newIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
