package com.paccothetaco.DiscordBot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class TwitchBot extends ListenerAdapter {

    public static void main(String[] args) throws Exception {
        String oauthToken = Secret.getOauthToken();
        String botUsername = Socials.botUsername;
        String channelName = Socials.channelName;

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
        String message = event.getMessage().toLowerCase();
        String username = event.getUser().getNick();

        if (message.equals("!twitter")) {
            event.respond("@" + username + ", here is my Twitter: https://twitter.com/" + Socials.TwitterUsername);
        }
        else if (message.equals("!insta") || message.equals("!instagram")) {
            event.respond("@" + username + ", here is my Instagram: https://instagram.com/" + Socials.InstagramUsername);
        }
        else if (message.equals("!tiktok")) {
            event.respond("@" + username + ", here is my TikTok: https://tiktok.com/@" + Socials.TikTokUsername);
        }
        else if (message.equals("!valorant")) {
            event.respond("@" + username + ", here is my Valorantname: " + Socials.ValorantUsername);
        }
        else if (message.equals("!donate")) {
            event.respond("@" + username + ", you can support me here: " + Socials.Donationlink);
        }
    }
}
