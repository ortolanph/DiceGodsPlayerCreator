package org.dicegods.dicegodsplayercreator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.dicegods.dicegodsplayercreator.beans.Player;
import org.dicegods.dicegodsplayercreator.controller.PlayerCreatorController;
import org.dicegods.dicegodsplayercreator.persistence.PlayerPersistence;
import org.json.JSONException;

import java.io.IOException;


public class PlayerCreatorActivity extends Activity {

    private PlayerCreatorController controller;

    public void clear(View view) {
        EditText playerName = (EditText)findViewById(R.id.playerName);
        Spinner choosenDeity = (Spinner)findViewById(R.id.deities);

        playerName.setText("");
        choosenDeity.setSelection(0);
    }

    public void save(View view) {
        PlayerPersistence persistence = new PlayerPersistence(getApplicationContext());

        controller = new PlayerCreatorController(persistence);

        EditText playerName = (EditText)findViewById(R.id.playerName);
        Spinner chosenDeity = (Spinner)findViewById(R.id.deities);

        String deity = chosenDeity.getSelectedItem().toString();

        Player player = controller.createPlayer(playerName.getText().toString(), deity);

        TextView message = (TextView)findViewById(R.id.msg_text);

        try {
            controller.savePlayer(player);
        } catch (IOException e) {
            message.setText(e.getMessage());
        } catch (JSONException e) {
            message.setText(e.getMessage());
        }

        message.setText("Loyal player is commited! That the battle begin!");
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
            return inflater.inflate(R.layout.fragment_player_creator, container, false);
        }
    }
}
