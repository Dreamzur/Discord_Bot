package me.dahiverguerra.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

import static me.dahiverguerra.DiscordBot.prefix;

public class Pomodoro extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(prefix + "start")){
            EmbedBuilder start = new EmbedBuilder();
            start.addField("🍎Pomodoro Timer🍎", "You have started the timer!", false );
            start.addField("Minutes", "0", true );
            start.addField(" ", " : " ,true );
            start.addField("Seconds", "5", true );

            event.getChannel().sendMessageEmbeds(start.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
            start.clear();

//            int countdownMin = 1;
//            while(countdownMin >=0){
//                countdownMin--;
//                try{
//                    Thread.sleep(60000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if(countdownMin == 0){
//                    event.getChannel().sendMessage("1 minute has passed").queue();
//                }
//            }
            int countdownSecs = 5;
            while(countdownSecs >= 0) {
                countdownSecs--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (countdownSecs == 0) {
                    start.addField("🍎Pomodoro Timer🍎", "You have started the timer!", false );
                    start.addField("Minutes", "0", true );
                    start.addField(" ", " : " ,true );
                    start.addField("Seconds", "0", true );
                    event.getChannel().sendMessageEmbeds(start.build()).queue();
                    event.getChannel().sendMessage("Take a Break!").queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                }
            }
        }
    }
}
