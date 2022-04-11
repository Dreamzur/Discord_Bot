package me.dahiverguerra;

import me.dahiverguerra.Commands.*;
import me.dahiverguerra.utils.Config;
import me.dahiverguerra.utils.Listener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    public static JDA jda;
    public static String prefix = "!";


    public static void main(String[] args) throws LoginException {



        //Initializing the bot
        jda = JDABuilder.createDefault(Config.get("TOKEN"))
                // methods for the builder
                .setActivity(Activity.listening("lo-fi beats")) //sets the bot status
                .addEventListeners(new Listener()) //lets main run listeners class
                .addEventListeners(new Info()) //adds the info class to the main
                .addEventListeners(new Help()) //adds the help class to the main
                .addEventListeners(new Meme()) //adds the meme class to the main
                .addEventListeners(new Invite()) //adds the invite class to the main
                .addEventListeners(new Study()) //adds a study class to the main
                .addEventListeners(new Pomodoro()) //adds the pomodoro class to the main
                .addEventListeners(new FortuneCookie()) //adds the FortuneCookie class to the main
                .addEventListeners(new Coin()) // adds the Coin (flip a coin) class to the main
                .addEventListeners(new Clear()) // clears past messages
                .build(); //builds instance and starts login process
    }
}
