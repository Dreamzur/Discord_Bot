package me.dahiverguerra;

import me.dahiverguerra.Commands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.Arrays;

public class DiscordBot {
    public static JDA bot;
    public static String prefix = "!";
    public static final GatewayIntent[] intents = {GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.GUILD_PRESENCES};


    public static void main(String[] args) throws LoginException {



        //Initializing the bot
        bot = JDABuilder.createDefault("OTU5NjEzNjQ1MzIxNTM1NDk4.Ykeb2Q.lKUTKAduDO_q1n1FA_qOrAEe1zM", Arrays.asList(intents))
                .enableCache(CacheFlag.VOICE_STATE) // allows bot to detect voice channels
                .setActivity(Activity.listening("lo-fi beats")) //sets the bot status
                .addEventListeners(new Info()) //adds the info class to the main
                .addEventListeners(new Help()) //adds the help class to the main
                .addEventListeners(new Meme()) //adds the meme class to the main
                .addEventListeners(new Invite()) //adds the invite class to the main
                .addEventListeners(new Study()) //adds a study class to the main
                .addEventListeners(new Pomodoro()) //adds the pomodoro class to the main
                .addEventListeners(new FortuneCookie()) //adds the FortuneCookie class to the main
                .addEventListeners(new Coin()) // adds the Coin (flip a coin) class to the main
                .addEventListeners(new Clear())
                .build(); //builds instance and starts login process
    }
}
