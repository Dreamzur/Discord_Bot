package me.dahiverguerra;

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
import java.util.concurrent.ExecutionException;

public class Commands extends ListenerAdapter {

    public String prefix = "!"; //sets prefix for commands

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" "); // gets raw message and splits by every space in array.


        if (args[0].equalsIgnoreCase(prefix + "test")) { // reads user response
            event.getMessage().reply("test response!").queue(); // replies to users message
        } else if (args[0].equalsIgnoreCase(prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("🤖 Info", null);
            info.setDescription("Studious Fellow is currently a work in progress.");
            info.setColor(new Color(0x9180df)); // sets the border color of embed
            //info.addField("Embed field 1", "This is the content of field 1", false);
            //info.addField("Embed field 2", "This is the content of field 2", false);
            info.setFooter("Bot created by Logic ", event.getMember().getUser().getAvatarUrl());
            event.getChannel().sendMessageEmbeds(info.build()).queue(); //sends the message in the channel
            info.clear(); //clear embed to save system resources

        } else if (args[0].equalsIgnoreCase(prefix + "help")) {
            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("🤖 Help", null);
            help.setDescription("Commands for the Studious Fellow bot.");
            help.setColor(new Color(0xE3FFA3));
            help.addField("!info", "Gives information about the Studious Fellow bot.", false);
            help.addField("!help", "List of commands for the bot.", false);
            help.addField("!meme", "Drops some fresh memes from reddit.", false);
            help.addField("!invite", "Allows Studious Fellow to pass out some croissants (invites) to your server", false);
            event.getChannel().sendMessageEmbeds(help.build()).queue();
            help.clear();

        } else if (args[0].equalsIgnoreCase(prefix + "meme")) {
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

            } catch (Exception e) {
                event.getChannel().sendMessage(":no_entry: **My artificial brain seems to have imploded, try again later.**").queue(); //notifies user if something goes wrong
                e.printStackTrace();
            }

        } else if (args[0].equalsIgnoreCase(prefix + "invite")){
            EmbedBuilder invite = new EmbedBuilder();
            invite.setTitle("🤖 Invite: ");
            invite.setColor(new Color(0xc399b2));
            invite.setDescription("Invite me to your server by clicking " + "[here](" + "https://discord.com/api/oauth2/authorize?client_id="
                    + event.getJDA().getSelfUser().getId() + "&permissions=8&scope=bot" + ")");
            try {
                event.getAuthor().openPrivateChannel().submit().get().sendMessageEmbeds(invite.build()).queue();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


    }

}
