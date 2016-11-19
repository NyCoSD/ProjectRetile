/* Copyright 2016 Acquized
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.acquized.retile.config;

import net.cubespace.Yamler.Config.Comment;
import net.cubespace.Yamler.Config.Comments;
import net.cubespace.Yamler.Config.ConfigMode;
import net.cubespace.Yamler.Config.Path;
import net.cubespace.Yamler.Config.YamlConfig;

import java.io.File;

public class Config extends YamlConfig {

    // v  ProjectRetile  v

    @Comment("Set here the Prefix that will be infront of every Messages")
    @Path("ProjectRetile.Prefix")
    public String prefix = "&c> &7";

    @Comments({
            "Set here the Language Code that should be used for Message Printing",
            "This requires a File named \"messages_<locale>.properties\" in the \"locale\" Directory.",
            "If no file with the Locale's Paramter exist, a error will be thrown."
    })
    @Path("ProjectRetile.Locale")
    public String locale = "en";

    @Comments({
            "Should UUID's be resolved using BungeeCord?",
            "Only enable this if you encounter Lags when reporting.",
            "This may cause errors with wrong UUID on certain Networks"
    })
    @Path("ProjectRetile.ForceOfflineUUID")
    public boolean forceOfflineUUID = false;

    @Comments({
            "How long should the Cooldown be?",
            "The Cooldown is counted in seconds and only applies to /report."
    })
    @Path("ProjectRetile.Cooldown")
    public int cooldown = 60;

    @Comment("Should report messages be clickable?")
    @Path("ProjectRetile.ClickableMessages")
    public boolean clickableMsgs = true;

    @Comments({
            "How should the Time be formated?",
            "This is using java.text.SimpleDateFormat's Date and Time Pattern",
            "For a list of Patterns visit https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html"
    })
    @Path("ProjectRetile.DateFormat")
    public String dateFormat = "dd.MM.yyyy hh:mm:ss a";

    @Comment("Should the Updater be enabled? The Updater checks every Hour for a new Version.")
    @Path("ProjectRetile.Updater")
    public boolean updater = true;

    @Comment("Don't change this value unless you want to reset the Config")
    @Path("ProjectRetile.Version")
    public String version = "1.0.0-PRERELEASEg";

    // v  Connection Pooling  v

    @Comment("How many connections should be keept alive when idling?")
    @Path("Pools.MinimumPoolIdleSize")
    public int minPoolIdle = 5;

    @Comment("How many connection should be max. used?")
    @Path("Pools.MaximalPoolSize")
    public int maxPoolSize = 20;

    @Comments({
            "How long should we try to keep a connection alive until we mark it as timed out?",
            "Set higher if your database server is hosted somewhere completly else"
    })
    @Path("Pools.PoolTimeOut")
    public long poolTimeout = 5000;

    // v  Aliases  v

    @Comments({
            "Which Aliases should the Report Command have?",
            "The default Command /report will always stay."
    })
    @Path("Aliases.ReportCommand")
    public String[] reportAliases = { "r", "ticket", "reportuser" };

    @Comments({
            "Which Aliases should the Reports Command have?",
            "The default Command /listreports will always stay."
    })
    @Path("Aliases.ReportsCommand")
    public String[] reportsAliases = { "reports", "lr" };

    @Comments({
            "Which Aliases should the Toggle Command have?",
            "The default Command /togglereports will always stay."
    })
    @Path("Aliases.ToggleCommand")
    public String[] toggleAliases = { "toggle", "tr" };

    @Comments({
            "Which Aliases should the Info Command have?",
            "The default Command /reportinfo will always stay."
    })
    @Path("Aliases.InfoCommand")
    public String[] infoAliases = { "inforeport", "ir", "ri", "info" };

    @Comments({
            "Which Aliases should the Queue Command have?",
            "The default Command /waitingqueue will always stay."
    })
    @Path("Aliases.QueueCommand")
    public String[] queueAliases = { "queue", "waitingqueue" };

    // -------------------------------------------------

    public Config(File file) {
        CONFIG_FILE = file;
        CONFIG_HEADER = new String[]{
                "  ____            _           _   ____      _   _ _      ",
                " |  _ \\ _ __ ___ (_) ___  ___| |_|  _ \\ ___| |_(_) | ___ ",
                " | |_) | '__/ _ \\| |/ _ \\/ __| __| |_) / _ \\ __| | |/ _ \\",
                " |  __/| | | (_) | |  __/ (__| |_|  _ <  __/ |_| | |  __/",
                " |_|   |_|  \\___// |\\___|\\___|\\__|_| \\_\\___|\\__|_|_|\\___|",
                "               |__/                                      "};
        CONFIG_MODE = ConfigMode.DEFAULT;
    }

}
