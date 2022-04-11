package me.dahiverguerra.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

import static me.dahiverguerra.DiscordBot.prefix;

public class Clear extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix + "clear")) {
            if (args.length < 2) {
                EmbedBuilder nice = new EmbedBuilder();
                nice.setTitle("Clear Command!");
                nice.setDescription("Type in !clear <#> to clear some messages");
                event.getChannel().sendMessageEmbeds(nice.build()).queue();
            }
            // if args 1 is not a number, return event message
            if (!isNumber(args[1])) {
                event.getChannel().sendMessage("!clear amount").queue();
            }
        }

        List<Message> messageList = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1]) + 1).complete();
        event.getTextChannel().deleteMessages(messageList).queue();
    }

    private boolean isNumber(String msg) {
        try {
            Integer.parseInt(msg); //try to convert message to int
            return true;
        } catch (NumberFormatException e) {
            return false; //otherwise, it'll catch error and return false
        }
    }
}