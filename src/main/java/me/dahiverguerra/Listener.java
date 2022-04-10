package me.dahiverguerra;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Listener extends ListenerAdapter {

    @Override
    public void onReady(@Nonnull ReadyEvent event){
        //outputs bot status on cmd
        System.out.printf("%#s is ready for some work!", event.getJDA().getSelfUser());
    }
}
