package com.kosmx.emotestealer;

import com.kosmx.emotecraft.EmotecraftCallbacks;
import net.fabricmc.api.ClientModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ClientModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "emotecraft-emotestealer";
    public static final String MOD_NAME = "Emote stealer";

    @Override
    public void onInitializeClient() {
        log(Level.INFO, "Initializing");
        //TODO: Initializer
        EmotecraftCallbacks.startPlayReceivedEmote.register(ExampleEvent::stealEmote);
    }



    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}