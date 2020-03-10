package name.fjcmd.task;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.scheduler.PluginTask;
import java.util.List;

public class delaycmd extends PluginTask<name.fjcmd.fjcmd> {

    private Player player;
    private List<String> cmds;

    public delaycmd(name.fjcmd.fjcmd owner, Player player, List<String> cmds) {
        super(owner);
        this.player = player;
        this.cmds = cmds;
    }

    @Override
    public void onRun(int i){
        //执行命令
        for (String cmd : this.cmds) {
            Server.getInstance().dispatchCommand(new ConsoleCommandSender(), cmd.replace("@p", this.player.getName()));
        }
        owner.addplayer(this.player);
    }
}