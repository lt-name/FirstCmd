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
        for (String cmds : this.cmds) {
            String[] cmd = cmds.split("&");
            if ((cmd.length > 1) && (cmd[1].equals("con"))){
                Server.getInstance().dispatchCommand(new ConsoleCommandSender(), cmd[0].replace("@p", this.player.getName()));
            } else {
                Server.getInstance().dispatchCommand(player, cmd[0].replace("@p", player.getName()));
            }
        }
        owner.addplayer(this.player);
    }
}