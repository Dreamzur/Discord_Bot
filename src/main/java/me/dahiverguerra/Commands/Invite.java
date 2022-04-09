package me.dahiverguerra.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.concurrent.ExecutionException;

import static me.dahiverguerra.DiscordBot.prefix;

public class Invite extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix + "invite")) {

            EmbedBuilder invite = new EmbedBuilder();
            invite.setTitle("🤖 Invite ");
            invite.setColor(new Color(0xc399b2));
            invite.setDescription("Invite me to your server by clicking " + "[here](" + "https://discord.com/api/oauth2/authorize?client_id="
                    + event.getJDA().getSelfUser().getId() + "&permissions=8&scope=bot" + ")");
            try {
                event.getAuthor().openPrivateChannel().submit().get().sendMessageEmbeds(invite.build()).queue();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            invite.clear();
        }
    }
}
