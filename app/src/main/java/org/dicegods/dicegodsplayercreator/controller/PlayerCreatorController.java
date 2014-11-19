package org.dicegods.dicegodsplayercreator.controller;

import android.content.Context;

import org.dicegods.dicegodsplayercreator.beans.Attribute;
import org.dicegods.dicegodsplayercreator.beans.GodsEnum;
import org.dicegods.dicegodsplayercreator.beans.ItemBelt;
import org.dicegods.dicegodsplayercreator.beans.Player;
import org.dicegods.dicegodsplayercreator.persistence.PlayerPersistence;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerCreatorController {

    private static final Integer MAX_ITEMS = 5;
    private static final Logger LOGGER = Logger.getLogger(PlayerCreatorController.class
            .getName());

    private PlayerPersistence playerPersistence;

    private static final String NOT_SUMMONED = "Mortal champion %s has not been summoned.";

    public Player createPlayer(String name, String deity) {
        Player player = new Player();

        player.setName(name);

        GodsEnum god = GodsEnum.retrieveByName(deity);

        player.setDeity(god.getName());

        Attribute life = new Attribute(god.getLife());
        Attribute mana = new Attribute(god.getMana());

        player.setLife(life);
        player.setMana(mana);

        ItemBelt potions = new ItemBelt(MAX_ITEMS);
        ItemBelt elixirs = new ItemBelt(MAX_ITEMS);

        player.setPotions(potions);
        player.setElixirs(elixirs);

        player.setShield(0);

        return player;
    }

    public void savePlayer(Context context, Player player) throws IOException, JSONException {
        try {
            JSONObject jsonLife = new JSONObject()
                    .put("initial", player.getLife().getInitial())
                    .put("current", player.getLife().getCurrent());

            JSONObject jsonMana = new JSONObject()
                    .put("initial", player.getMana().getInitial())
                    .put("current", player.getMana().getCurrent());

            JSONObject jsonPotions = new JSONObject()
                    .put("maxItems", player.getPotions().getMaxItems())
                    .put("currentItems", player.getPotions().getCurrentItems());

            JSONObject jsonElixirs = new JSONObject()
                    .put("maxItems", player.getElixirs().getMaxItems())
                    .put("currentItems", player.getElixirs().getCurrentItems());

            JSONObject jsonPlayer = new JSONObject()
                    .put("name", player.getName())
                    .put("deity", player.getDeity())
                    .put("life", jsonLife)
                    .put("mana", jsonMana)
                    .put("potions", jsonPotions)
                    .put("elixirs", jsonElixirs)
                    .put("shield", player.getShield());

            System.out.println(jsonPlayer.toString());

            playerPersistence = new PlayerPersistence(context);
            playerPersistence.savePlayer(jsonPlayer);

        } catch(IOException e) {
            LOGGER.log(Level.WARNING, String.format(NOT_SUMMONED, player.getName()), e);
            throw new JSONException(String.format(NOT_SUMMONED, player.getName()));
        } catch (JSONException e) {
            LOGGER.log(Level.WARNING, String.format(NOT_SUMMONED, player.getName()), e);
            throw new JSONException(String.format(NOT_SUMMONED, player.getName()));
        }
    }

}
