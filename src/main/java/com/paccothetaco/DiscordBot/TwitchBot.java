package com.paccothetaco.DiscordBot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class TwitchBot extends ListenerAdapter {

    public static void main(String[] args) throws Exception {
        String botUsername = "Tacolieferant";
        String channelName = "Pacco_the_Taco";

        Configuration configuration = new Configuration.Builder()
                .setName(botUsername)
                .setServerHostname("irc.chat.twitch.tv")
                .setServerPort(6667)
                .setServerPassword(oauthToken)
                .addAutoJoinChannel("#" + channelName)
                .addListener(new TwitchBot())
                .buildConfiguration();

        PircBotX bot = new PircBotX(configuration);
        bot.startBot();
    }

    @Override
    public void onMessage(MessageEvent event) throws Exception {
        String message = event.getMessage();
        String sender = event.getUser().getNick();

        if (message.equalsIgnoreCase("!hallo")) {
            event.respond("Hallo, " + sender + "! Willkommen im Stream!");
        }
    }
}
