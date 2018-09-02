package io.anuke.ucore.util;

import io.anuke.ucore.core.Core;

public class Bundles{

    public static boolean enabled(){
        return Core.bundle != null;
    }

    public static String get(String key, String normal){
        return enabled() && has(key) ? get(key) : normal;
    }

    public static boolean has(String key){
        return Core.bundle != null && !(Core.bundle.get(key).startsWith("???") && Core.bundle.get(key).endsWith("???"));
    }

    public static String get(String name){
        return Core.bundle == null ? null : Core.bundle.get(name);
    }

    public static String getOrNull(String name){
        return has(name) ? get(name) : null;
    }

    public static String getNotNull(String name){
        String s = get(name);
        if(s == null || (s.endsWith("???") && s.startsWith("???"))){
            throw new NullPointerException("No key with name \"" + name + "\" found!");
        }
        return s;
    }

    public static String format(String key, Object... args){
        return Core.bundle.format(key, args);
    }

}
