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
            // sets the border color of embed
            info.setColor(new Color(0x9180df));
            info.setFooter("Bot created by Logic ", event.getMember().getUser().getAvatarUrl());
            //sends the message in the channel
            event.getChannel().sendMessageEmbeds(info.build()).queue();
            //clear embed to save system resources
            info.clear();
        }
    }
}
