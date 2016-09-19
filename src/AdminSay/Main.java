package AdminSay

public class Main extends PluginBase implements  Listener{

Set<Player> Sayer;

@Override
public void onEnable(){
this.getServer().getPluginManager().registerEvents(this,this);
this.Sayer = new HashSet<>();
}
@Override
public boolean onCommand(CommandSender sender, Command command , String label, String[] args){
if(command.getName().equals("say")){
 if(sender instanceof Player){
   if(sender.isOp()){
/*아직 sayer에 등록되지 않았을때*/
if(){

/*이미 sayer에 등록되어있을때*/
}else if(){

}
}
}
}

}
}
