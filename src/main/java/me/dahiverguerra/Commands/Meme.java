package me.dahiverguerra.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import static me.dahiverguerra.DiscordBot.prefix;

public class Meme extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix + "meme")) {
            JSONParser parser = new JSONParser();

            String postLink = "";
            String title = "";
            String url = "";
            String author = "";

            try {
                URL memeURL = new URL("https://meme-api.herokuapp.com/gimme"); //meme api used
                BufferedReader reader = new BufferedReader(new InputStreamReader(memeURL.openConnection().getInputStream()));

                String lines;
                // formats the meme in JSON format
                while ((lines = reader.readLine()) != null) {
                    JSONArray arr = new JSONArray();
                    arr.add(parser.parse(lines));
                    for (Object o : arr) {
                        JSONObject obj = (JSONObject) o;
                        postLink = (String) obj.get("postLink");
                        title = (String) obj.get("title");
                        url = (String) obj.get("url");
                        author = (String) obj.get("author");
                    }
                }
                reader.close();

                EmbedBuilder meme = new EmbedBuilder();
                meme.setTitle(title, postLink); //embeds the title for the discord message
                meme.setImage(url); //embeds the url
                meme.setColor(new Color(0xA3FFF1)); //color of the embed
                meme.setFooter("Posted by: " + author); //sets the footer of embed
                event.getChannel().sendMessageEmbeds(meme.build()).queue(); //queues the embed
                meme.clear();

            } catch (Exception e) {
                event.getChannel().sendMessage(":no_entry: **My artificial brain seems to have imploded, try again later.**").queue(); //notifies user if something goes wrong
                e.printStackTrace();
            }

        }
    }
}
