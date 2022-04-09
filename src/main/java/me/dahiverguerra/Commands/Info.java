package me.dahiverguerra.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

import static me.dahiverguerra.DiscordBot.prefix;

public class Info extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("🤖 Info", null);
            info.setDescription("Studious Fellow is currently a work in progress.");
            info.setColor(new Color(0x9180df)); // sets the border color of embed
            //info.addField("Embed field 1", "This is the content of field 1", false);
            //info.addField("Embed field 2", "This is the content of field 2", false);
            info.setFooter("Bot created by Logic ", event.getMember().getUser().getAvatarUrl());
            event.getChannel().sendMessageEmbeds(info.build()).queue(); //sends the message in the channel
            info.clear(); //clear embed to save system resources
        }
    }
}
