package AdminSay
import java.util.HashSet;
import java.util.Set;

import cn.nukkit.Player;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.command.defaults.SayCommand;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase implements Listener {

	Set<String> Sayer;

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		this.Sayer = new HashSet<>();
		this.registerCommand("/adsay", "명령어 입력후 입력하는 오피의 채팅이 say를 통해서 나갑니다", "/adsay", "OP");
	}

	@EventHandler
	public void onChat(PlayerChatEvent ev) {
		/* 채팅하는사람이 op권한을 갖고있는지 확인 */
		if (ev.getPlayer().isOp()) {
			if (this.Sayer.contains(ev.getPlayer().getName())) {
				Command a = new SayCommand("say");
				a.execute(ev.getPlayer(), "", ev.getMessage().split(" "));
				ev.setCancelled();
				return;
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		/* say명령어 입력시 */
		if (command.getName().equals("adsay")) {
			try { /* sender이 Player인지 확인 */
				if (sender instanceof Player) {
					/* sender이 op권한을 갖고있는지 확인 */
					if (sender.isOp()) {
						Player player = (Player) sender;
						/* 아직 sayer에 등록되지 않았는지 확인 */
						if (!this.Sayer.contains(player.getName())) {
							this.Sayer.add(player.getName());
							player.sendMessage(TextFormat.colorize("&6[ AdminSay ]&e : 이후 채팅이 say명령어를 통해서 나갑니다"));
							return true;
							/* 이미 sayer에 등록되어있는지 확인 */
						} else if (this.Sayer.contains(player.getName())) {
							this.Sayer.remove(player);
							player.sendMessage(TextFormat.colorize("&6[ AdminSay ]&e : 이후 채팅이 say명령어를 통해서 나가지 않습니다"));
							return true;
						}
					}
				}

				
			} catch (Exception e) {
				return true;
			}
		}
		return true;
	}
	public void registerCommand(String name, String descript, String usage, String permission) {
		SimpleCommandMap commandMap = getServer().getCommandMap();
		PluginCommand<Main> command = new PluginCommand<Main>(name, this);
		command.setDescription(descript);
		command.setUsage(usage);
		command.setPermission(permission);
		commandMap.register(name, command);
	}
}

