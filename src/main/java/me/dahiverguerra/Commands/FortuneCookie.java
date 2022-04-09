package me.dahiverguerra.Commands;

import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

import static me.dahiverguerra.DiscordBot.prefix;

public class FortuneCookie extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix + "fcookie")) {
            EmbedBuilder cookie = new EmbedBuilder();

            cookie.setTitle("Your Fortune Cookie 🥠");
            cookie.setColor(new Color(0xc1e5e9));
            cookie.addField("Your fortune cookie sprung open and reads:", new JSONObject(Unirest.get("http://www.yerkee.com/api/fortune").asString().getBody())
                    .getString("fortune"), false);

            event.getChannel().sendMessageEmbeds(cookie.build()).queue();
            cookie.clear();
        }
    }
}
