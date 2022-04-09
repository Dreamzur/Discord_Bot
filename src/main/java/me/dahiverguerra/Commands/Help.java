package me.dahiverguerra.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

import static me.dahiverguerra.DiscordBot.prefix;

public class Help extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix + "help")) {
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
        }

    }
}
