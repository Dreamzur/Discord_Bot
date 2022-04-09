package me.dahiverguerra;

import me.dahiverguerra.Commands.Help;
import me.dahiverguerra.Commands.Info;
import me.dahiverguerra.Commands.Meme;
import me.dahiverguerra.Commands.Invite;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public static JDA bot;
    public static String prefix = "!";


    public static void main(String[] args) throws LoginException {


        //Initializing the bot
        bot = JDABuilder.createDefault("OTU5NjEzNjQ1MzIxNTM1NDk4.Ykeb2Q.lKUTKAduDO_q1n1FA_qOrAEe1zM")
                .setActivity(Activity.listening("lo-fi beats")) //sets the bot status
                .addEventListeners(new Info()) //adds the info class to the main
                .addEventListeners(new Help()) //adds the help class to the main
                .addEventListeners(new Meme())
                .addEventListeners(new Invite())
                .build(); //builds instance and starts login process
    }
}
