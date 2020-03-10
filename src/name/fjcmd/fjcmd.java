package name.fjcmd;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import java.util.List;
import name.fjcmd.task.delaycmd;

public class fjcmd extends PluginBase implements Listener {

    private Config config1,config2;
    private List<String> cmds;
    private List<String> players;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.config1 = new Config(getDataFolder() + "/config.yml", Config.YAML);
        this.cmds = this.config1.getStringList("command");
        this.config2 = new Config(getDataFolder() + "/player.yml", Config.YAML);
        this.players = this.config2.getStringList("player");
        getServer().getPluginManager().registerEvents(this,this);
        getLogger().info(TextFormat.GREEN+"加载完成！");
    }

    @Override
    public void onDisable() {
        this.config2.save();
        getLogger().info(TextFormat.RED+"已卸载！");
    }

    public Boolean addplayer(Player player) {
        this.players.add(player.getName());
        this.config2.set("player", this.players);
        this.config2.save();
        return true;
    }

    @EventHandler
    public void onPJE(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (player == null) { return; }
        //首次进服
        if (!this.players.contains(player.getName())) {
            getServer().getScheduler().scheduleDelayedTask(
                    this, new delaycmd(this, player,this.cmds), config1.getInt("delaycmd", 100));
        }
    }
}
