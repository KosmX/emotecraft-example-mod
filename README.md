# Emotecraft Example mod

How to begin?

This is a Minecraft mod. So make a new minecraft mod.  
You should set up the basic things like names, etc.

To start modding Emotecraft, you need to implement emotecraft!

```groovy
dependencies{
    (...)
	//You'll mod Emotecraft.
	modImplementation "com.kosmx.emotecraft:emotes:${project.emotecraft_version}"
    (...)
}
```

If you want to include emotecraft in your mod jar, do  
`include "com.kosmx.emotecraft:emotes:${project.emotecraft_version}`


You can find the mod callbacks in `com.kosmx.emotecraft.EmotecraftCallbacks`  
There are comments in code, what are mostly useful...

Don't forget that you can use mixin on mods too.
