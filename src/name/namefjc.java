package name.namefjc;

import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import name.task.fjcTask;
import java.util.LinkedHashMap;
import java.util.Map;

public class namefjc extends PluginBase implements Listener {
    private LinkedHashMap<String, Config> config = new LinkedHashMap();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Config config1 = new Config(getDataFolder() + "/config.yml", Config.YAML);
        this.config.put("cmd",config1);
        Config config2 = new Config(getDataFolder() + "/player.yml", Config.YAML);
        this.config.put("player",config2);
        Server.getInstance().getPluginManager().registerEvents(this,this);
        getLogger().info("加载完成！");
    }

    @Override
    public void onDisable() {
        Config config = (Config)this.config.get("player");
        config.save();
        getLogger().info("已卸载！");
    }

    @EventHandler
    public void playerjoin(PlayerJoinEvent e){
        Config player = (Config)this.config.get("player");
        Map<String, Object> players = player.getAll();
        for(Map.Entry k : players.entrySet()){
            if (k.getKey().toString().equals(e.getPlayer().getName())&&
                    k.getValue().toString().equals("true")){
                return;
            }
        }
        this.getServer().getScheduler().scheduleDelayedTask(new fjcTask(this,e.getPlayer(),this.config),100);
    }
}
