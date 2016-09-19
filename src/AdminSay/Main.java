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
    //Sayer에 sender가 있는지 확인
    //if - else 문으로 2가지 경우로 나눔
    // - Sayer에 넣어주기
    // - Sayer에서 빼주기

}
}
}

}
}
