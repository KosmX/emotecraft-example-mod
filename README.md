# Emotecraft Example mod

How to begin?

This is a Minecraft mod. So make a new minecraft mod.  
You should set up the basic things like names, etc.  
I advice to start here [Fabricmc.net](https://fabricmc.net/wiki/tutorial:setup)

To start modding Emotecraft, you need to implement emotecraft!  
Add this to the gradle.build file:  

```groovy

repositories{
	(...)
	//using jcenter repository
	//If you are using jcenter already, you don't have to do it twice...
	jcenter()
	(...)
}
(...)
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
to build this, use gradle
```bash
./gradlew build
```
