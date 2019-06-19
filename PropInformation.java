public class PropInformation{
    public  int weapon_level[] = {1,1,1};
    public  int weapon_value[] = {30,20,10};
    //int weapon_material[] = {10,10,10};

    public  int armor_level[] = {1,1,1,1,1,1,1,1,1,1,1,1};
    public  int armor_value[] = {30,20,10,30,20,10,30,20,10,30,20,10};//armor防禦,shoes血量,halmet血量,ironpant防禦
    //int armor_material[] = {10,10,10,10,10,10,10,10,10,10,10,10};

    PropInformation(){
    };
    public void upgrade(int n,int index){
        if(n==1){//weapon
            if(weapon_level[index]<10){
                weapon_level[index]++;
                weapon_value[index]++;
                
            }
        }
        if(n==0){//armor
            if(armor_level[index]<10){
                armor_level[index]++;
                armor_value[index]++;
            }
        }
        System.out.println(weapon_level[index]);
        System.out.println(weapon_value[index]);

}
}