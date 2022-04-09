package me.dahiverguerra.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

import static me.dahiverguerra.DiscordBot.prefix;

public class Study extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(prefix + "study")) {

            EmbedBuilder study = new EmbedBuilder();
            study.setTitle("🤖 Study Timer Info");
            study.setImage("https://www.ntaskmanager.com/wp-content/uploads/2019/05/best-pomodoro-apps-blog-header-main-1.png");
            study.setColor(new Color(0xaba4c8));
            study.addField("!start", "This command starts the timer!", true);
            study.setFooter( "*Timer will run continuously for 25 minutes unless it implodes." +
                    " The bot will also let you know when the timer is halfway through those 25 minutes!" + "\n **For" +
                    " presentation purposes the timer will run for 1 minute and set off a remainder at 30 seconds.");
            event.getChannel().sendMessageEmbeds(study.build()).queue();
            study.clear();
        }
    }
}
