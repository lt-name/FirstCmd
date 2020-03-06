package name.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.scheduler.PluginTask;
import cn.nukkit.utils.Config;
import java.util.LinkedHashMap;
import java.util.List;

public class fjcTask extends PluginTask<name.namefjc.namefjc> {
    private Player player;
    private LinkedHashMap<String, Config> config;
    public fjcTask(name.namefjc.namefjc owner, Player player, LinkedHashMap<String, Config> config ) {
        super(owner);
        this.player = player;
        this.config = config;
    }

    @Override
    public void onRun(int i){
        Config config = (Config)this.config.get("cmd");
        List<String> cmds = config.getStringList("command");
        for (String cmd : cmds) {
            Server.getInstance().dispatchCommand(new ConsoleCommandSender(), cmd.replace("@p", this.player.getName()));
        }
        Config player = (Config)this.config.get("player");
        player.set(this.player.getName(),true);
        player.save();
    }
}