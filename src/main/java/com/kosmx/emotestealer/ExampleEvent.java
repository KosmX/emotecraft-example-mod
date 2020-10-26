package com.kosmx.emotestealer;

import com.kosmx.emotecraft.Emote;
import com.kosmx.emotecraft.Main;
import com.kosmx.emotecraft.config.EmoteHolder;
import com.kosmx.emotecraft.config.Serializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import org.apache.logging.log4j.Level;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExampleEvent {
    public static File EMOTEDIR = FabricLoader.getInstance().getGameDir().resolve("stolen_emotes").toFile();

    public static ActionResult stealEmote(Emote emote, PlayerEntity playerEntity){
        if(!EMOTEDIR.isDirectory()) {
            if (!EMOTEDIR.mkdir()) {
                Main.log(Level.WARN, "Can't create stolen emotes directory");
                return ActionResult.PASS;
            }
        }
        Path targetFile = EMOTEDIR.toPath().resolve(Integer.toString(emote.hashCode()) + ".json");
        try {   //Try-catch to catch potential BufferedWriter errors
            BufferedWriter writer = Files.newBufferedWriter(targetFile);
            EmoteHolder emoteHolder = new EmoteHolder(emote, new LiteralText(Integer.toString(emote.hashCode())).formatted(Formatting.WHITE), new LiteralText("someString").formatted(Formatting.GRAY), new LiteralText("").formatted(Formatting.GRAY), emote.hashCode());
            Serializer.serializer.toJson(emoteHolder, writer);  //Serialize our emote
            writer.close();     //Newer forget to close BufferedWriters.
        } catch (IOException e) {
            Main.log(Level.WARN, "Can't write stolen emote to file");
        }

        return ActionResult.PASS; // to not cancel any run stuff
    }
}
