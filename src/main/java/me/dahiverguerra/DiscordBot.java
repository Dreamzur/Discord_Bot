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
                //sets the bot status
                //adds all the classes to the main
                .setActivity(Activity.listening("lo-fi beats"))
                .addEventListeners(new Listener())
                .addEventListeners(new Info())
                .addEventListeners(new Help())
                .addEventListeners(new Meme())
                .addEventListeners(new Invite())
                .addEventListeners(new Study())
                .addEventListeners(new Pomodoro())
                .addEventListeners(new FortuneCookie())
                .addEventListeners(new Coin())
                .addEventListeners(new Clear())
                //builds instance and starts login process
                .build();
    }
}
