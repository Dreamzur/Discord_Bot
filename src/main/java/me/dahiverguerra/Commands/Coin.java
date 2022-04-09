package me.dahiverguerra.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static me.dahiverguerra.DiscordBot.prefix;

public class Coin extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix + "fc")) {

            EmbedBuilder coin = new EmbedBuilder();

            coin.setTitle("Flipping a coin!");
            coin.setImage("https://i.kym-cdn.com/photos/images/original/000/930/666/b7e.gif");
            event.getChannel().sendMessageEmbeds(coin.build()).queue(message -> message.delete().queueAfter(1, TimeUnit.SECONDS));
            coin.clear();

            coin.setTitle("Coin flip results:");
            coin.setDescription("Coin flip resulted in " + (ThreadLocalRandom.current().nextBoolean() ? "**Heads**" : "**Tails**"));
            event.getChannel().sendMessageEmbeds(coin.build()).queueAfter(2, TimeUnit.SECONDS);
            coin.clear();
        }
    }
}
