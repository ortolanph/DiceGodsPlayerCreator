package org.dicegods.dicegodsplayercreator.persistence;

import android.content.Context;

import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;

public class PlayerPersistence {

    private Context context;

    private static final String DATA_FILE = "players.json";

    public PlayerPersistence(Context context) {
        this.context = context;
    }

    public void savePlayer(JSONObject player) throws IOException {

        try {
            FileOutputStream writer = context.openFileOutput(DATA_FILE, Context.MODE_PRIVATE);

            writer.write(player.toString().getBytes());
            writer.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}