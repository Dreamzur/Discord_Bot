package me.dahiverguerra;

import me.dahiverguerra.Commands.*;
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
                .addEventListeners(new Meme()) //adds the meme class to the main
                .addEventListeners(new Invite()) //adds the invite class to the main
                .addEventListeners(new Study()) //adds a study class to the main
                .addEventListeners(new Pomodoro()) //adds the pomodoro class to the main
                .build(); //builds instance and starts login process
    }
}
