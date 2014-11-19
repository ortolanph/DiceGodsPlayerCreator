package org.dicegods.dicegodsplayercreator;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.Spinner;

import org.dicegods.dicegodsplayercreator.beans.Player;
import org.dicegods.dicegodsplayercreator.controller.PlayerCreatorController;


public class PlayerCreator extends Activity {

    private PlayerCreatorController controller;

    public void clear(View view) {
        EditText playerName = (EditText)findViewById(R.id.playerName);
        Spinner choosenDeity = (Spinner)findViewById(R.id.deities);

        playerName.setText("");
        choosenDeity.setSelection(0);
    }

    public void save(View view) {
        controller = new PlayerCreatorController();

        EditText playerName = (EditText)findViewById(R.id.playerName);
        Spinner choosenDeity = (Spinner)findViewById(R.id.deities);

        String deity = choosenDeity.getSelectedItem().toString();

        Player player = controller.createPlayer(playerName.getText().toString(), deity);

        System.out.println(player.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_creator);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player_creator, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_player_creator, container, false);
            return rootView;
        }
    }
}
