package me.dahiverguerra.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static me.dahiverguerra.DiscordBot.prefix;

public class Pomodoro extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix + "start")) {
            EmbedBuilder start = new EmbedBuilder();

//            // default timer for 25 minutes
//            start.addField("🍎Pomodoro Timer🍎", "You have started the timer!", false);
//            start.addField("Minutes", "25", true);
//            start.addField(" ", " : ", true);
//            start.addField("Seconds", "00", true);
//
//            event.getChannel().sendMessageEmbeds(start.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
//            start.clear();
//
//            TimerTask ping = new TimerTask() {
//                @Override
//                public void run() {
//                    start.setTitle("Pomodoro Timer🍎");
//                    start.setDescription("Timer has stopped!");
//                    start.addField("Minutes", "00", true);
//                    start.addField(" ", " : ", true);
//                    start.addField("Seconds", "00", true);
//                    event.getChannel().sendMessageEmbeds(start.build()).queue(message -> message.delete().queueAfter(60, TimeUnit.SECONDS));
//                    event.getChannel().sendMessage("It's time to take a break!").queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
//                    start.clear();
//                }
//            };
//
//            TimerTask ping2 = new TimerTask() {
//                @Override
//                public void run() {
//                    start.setTitle("Pomodoro Timer🍎");
//                    start.setDescription("Halfway there, keep going!");
//                    start.addField("Minutes", "12", true);
//                    start.addField(" ", " : ", true);
//                    start.addField("Seconds", "30", true);
//                    event.getChannel().sendMessageEmbeds(start.build()).queue(message -> message.delete().queueAfter(60, TimeUnit.SECONDS));
//                    start.clear();
//                }
//            };
//
//            TimerTask ping3 = new TimerTask() {
//                @Override
//                public void run() {
//                    start.setTitle("Pomodoro Timer🍎");
//                    start.setDescription("Timer is currently active!");
//                    start.setImage("https://cdn.dribbble.com/users/2059803/screenshots/5367644/bmo_space.gif");
//                    event.getChannel().sendMessageEmbeds(start.build()).queue(message -> message.delete().queueAfter(1450000, TimeUnit.MILLISECONDS));
//                    start.clear();
//                }
//            };
//
//            Timer timer = new Timer();
//            timer.schedule(ping, 1500000); // 25 minutes
//            timer.schedule(ping2, 750000); // 12.5 minutes - halfway
//            timer.schedule(ping3, 5000); // 5 seconds active timer ping

            // test timer for class presentation
            start.addField("Pomodoro Timer🍎", "You have started the timer!", false);
            start.addField("Minutes", "1", true);
            start.addField(" ", " : ", true);
            start.addField("Seconds", "00", true);
            start.setColor(new Color(0xc8dbaa));
            event.getChannel().sendMessageEmbeds(start.build()).queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
            start.clear();

            TimerTask ping = new TimerTask() {
                @Override
                public void run() {
                    start.setTitle("Pomodoro Timer🍎");
                    start.setDescription("Timer has stopped!");
                    start.addField("Minutes", "00", true);
                    start.addField(" ", " : ", true);
                    start.addField("Seconds", "00", true);
                    start.setColor(new Color(0xc8dbaa));
                    event.getChannel().sendMessageEmbeds(start.build()).queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                    event.getChannel().sendMessage("It's time to take a break!").queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
                    start.clear();
                }
            };

            TimerTask ping2 = new TimerTask() {
                @Override
                public void run() {
                    start.setTitle("Pomodoro Timer🍎");
                    start.setDescription("Halfway there, keep going!");
                    start.addField("Minutes", "00", true);
                    start.addField(" ", " : ", true);
                    start.addField("Seconds", "30", true);
                    start.setColor(new Color(0xc8dbaa));
                    event.getChannel().sendMessageEmbeds(start.build()).queue(message -> message.delete().queueAfter(10, TimeUnit.SECONDS));
                    start.clear();
                }
            };

            TimerTask ping3 = new TimerTask() {
                @Override
                public void run() {
                    start.setTitle("Pomodoro Timer🍎");
                    start.setDescription("Timer is currently active!");
                    start.setImage("https://cdn.dribbble.com/users/2059803/screenshots/5367644/bmo_space.gif");
                    start.setColor(new Color(0xc8dbaa));
                    event.getChannel().sendMessageEmbeds(start.build()).queue(message -> message.delete().queueAfter(54500, TimeUnit.MILLISECONDS));
                    start.clear();
                }
            };

            Timer timer = new Timer();
            timer.schedule(ping, 60000); // 1 minute
            timer.schedule(ping2, 30000); // 30 seconds - halfway
            timer.schedule(ping3, 5000); // 5 seconds active timer ping
        }
    }
}




