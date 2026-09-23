import java.util.ArrayList;
import java.util.Objects;

class Spell{
    public static final String Attack="攻击型";
    public static final String HPheal="生命恢复型";
    public static final String MPheal="法力恢复型";

    private String name;
    private int levelRequire;
    private String type;
    private double damage;
    private double heal;
    private int manaCost;
    public Spell(String name, String type, double damage, double heal, int manaCost, int levelRequire) {
        this.name = name;
        this.levelRequire = levelRequire;
        this.type = type;
        this.damage = damage;
        this.heal = heal;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLevelRequire() {
        return levelRequire;
    }
    public void setLevelRequire(int levelRequire) {
        this.levelRequire = levelRequire;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public double getDamage() {
        return damage;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getHeal() {
        return heal;
    }
    public void setHeal(double heal) {
        this.heal = heal;
    }

    public int getManaCost() {
        return manaCost;
    }
    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj)
            return true;
        if (obj==null||getClass()!=obj.getClass())
            return false;
        Spell temp= (Spell)obj;
        return Objects.equals(name,temp.name);
    }
}

class Monster{
    private String name;
    private double healthPoint;
    private boolean isAlive;

    public Monster(String name,double healthPoint){
        this.name=name;
        this.healthPoint=healthPoint;
        isAlive=true;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public double getHealthPoint() {
        return healthPoint;
    }
    public void setHealthPoint(double healthPoint){
        this.healthPoint=healthPoint;
    }
    public void beAttacked(double HarmNum){
        healthPoint-=HarmNum;
        System.out.println("怪物"+name+"受到"+HarmNum+"点伤害!");
        if(healthPoint<0) {
            healthPoint = 0;
            isAlive=false;
            System.out.println("怪物"+name+"剩余血量为"+healthPoint);
            System.out.println("该怪物已死亡!");
            return;
        }
        System.out.println("怪物"+name+"剩余血量为"+healthPoint);
    }
}

class Wizard{
    public static final double MaxHP=100;
    public static final int MaxMP=50;

    private String name;
    private int level;
    private double HP;
    private int MP;
    private ArrayList<Spell> MagicBook;
    private int capacity;
    private boolean isAlive;    //存活状态

    public Wizard(String name,double HP,int MP,int level,int capacity){
        this.name=name;
        this.HP=HP;
        this.MP=MP;
        this.level=level;
        MagicBook=new ArrayList<Spell>();
        this.capacity=capacity;
        isAlive=true;
    }
    public boolean isAlive(){
        return isAlive;
    }
    public Spell findSpellByName(String name){      //查找对应法术
        for (int i=0; i<MagicBook.size();i++)
            if(MagicBook.get(i).getName().equals(name))
                return MagicBook.get(i);
        return null;
    }
    public void learnSpell(Spell spell){            //学习法术
        if (!isAlive){
            System.out.println("该法师已死亡，无法进行对应操作");
            return;
        }
        if(findSpellByName(spell.getName())!=null){
            System.out.println("已学习该法术！");
            return;
        }
        if (MagicBook.size() >= capacity) {
            System.out.println("法术书容量不足，无法学习！");
            return;
        }
        if (spell.getLevelRequire()> level) {
            System.out.println("等级不足，无法学习！");
            return;
        }
        MagicBook.add(spell);
        System.out.println("成功学习法术"+name);
    }
    public void removeSpellByName (String name){    //移除法术
        if (!isAlive){
            System.out.println("该法师已死亡，无法进行对应操作");
            return;
        }
        for (int i=0; i<MagicBook.size();i++)
            if(MagicBook.get(i).getName().equals(name)) {
                MagicBook.remove(i);
                System.out.println("已移除法术"+name+"！");
                return;
            }
        System.out.println("未找到对应法术！");
    }
    public ArrayList<Spell> getSpells(){            //返回法术列表
        return MagicBook;
    }
    public void castHealSpell(String name){         //释放回复法术
        if (!isAlive){
            System.out.println("该法师已死亡，无法进行对应操作");
            return;
        }
        for (int i=0; i<MagicBook.size();i++)
            if (MagicBook.get(i).getName().equals(name)){
                if (MP < MagicBook.get(i).getManaCost()) {
                    System.out.println("MP不足，无法释放");
                    return;
                } else {
                    if (MagicBook.get(i).getType().equals(Spell.HPheal)) {
                        System.out.println("法师"+this.name+"释放了法术"+name);
                        MP -= MagicBook.get(i).getManaCost();
                        HP += MagicBook.get(i).getHeal();
                        if (HP > Wizard.MaxHP)
                            HP = Wizard.MaxHP;
                        System.out.println("法师"+this.name+"回复了"+MagicBook.get(i).getHeal()+"点HP，还剩余"+HP+"点HP和"+MP+"点MP");
                    }
                    if (MagicBook.get(i).getType() == Spell.MPheal) {
                        System.out.println("法师"+this.name+"释放了法术"+name);
                        MP -= MagicBook.get(i).getManaCost();
                        MP += MagicBook.get(i).getHeal();
                        if (MP > Wizard.MaxMP)
                            MP = Wizard.MaxMP;
                        System.out.println("法师"+this.name+"回复了"+MagicBook.get(i).getHeal()+"点MP，还剩余"+HP+"点HP和"+MP+"点MP");
                    }
                    return;
                }
            }
        System.out.println("未找到对应回复法术！");
    }
    public void castAttackSpell(String name, Monster monster){
        //释放攻击法术
        if (!isAlive){
            System.out.println("该法师已死亡，无法进行对应操作");
            return;
        }
        for (int i=0; i<MagicBook.size();i++)
            if(MagicBook.get(i).getName().equals(name))
                if (MagicBook.get(i).getType().equals(Spell.Attack)){
                    if (!monster.isAlive()){
                        System.out.println("该怪物已死亡，不能作为攻击型法术目标");
                        return;
                    }
                    if (MP < MagicBook.get(i).getManaCost())
                        System.out.println("MP不足，无法释放");
                    else {
                        MP -= MagicBook.get(i).getManaCost();
                        System.out.println("法师"+this.name+"释放了法术"+name);
                        double temp = MagicBook.get(i).getDamage();
                        monster.beAttacked(temp);
                        HP -= 0.6 * temp;
                        System.out.println("法师"+this.name+"受到"+0.6*temp+"点伤害，还剩余"+HP+"点HP和"+MP+"点MP");
                        if (HP <= 0) {
                            HP = 0;
                            isAlive = false;
                            System.out.println("该法师已死亡!");
                        }
                    }
                    return;
                }
        System.out.println("未找到对应法术");
    }
}

public class Expr5_4 {
    public static void main(String[] args) {
        // 法师信息，姓名wizard，初始血量100，初始法力50，等级3，魔法书容量5
        Wizard wizard =  new Wizard("wizard", 100, 50, 3, 5);
        // 怪兽队伍信息，怪兽1: monster1，血量60；怪兽2: monster2，血量50
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("monster1", 60));
        monsters.add(new Monster("monster2", 50));
        // （可以选择性修改要学习的法术）学习法术
        wizard.learnSpell(new Spell("Fireball", "攻击型", 15, 0,10, 1));
        //wizard.learnSpell(new Spell("Holy Blessing", "生命恢复型", 0, 50,28, 5));
        wizard.learnSpell(new Spell("Ice Spike", "攻击型", 22, 0,14, 2));
        wizard.learnSpell(new Spell("Thunder Strike", "攻击型", 30, 0,30, 3));
        wizard.learnSpell(new Spell("Life Heal", "生命恢复型", 0, 20,8, 1));
        wizard.learnSpell(new Spell("Mana Regen", "法力恢复型", 0, 10,5, 1));
        //wizard.learnSpell(new Spell("Greater Heal", "生命恢复型", 0, 35,18, 3));

        // 打印学习的法术总数与列表
        System.out.println("魔法书包含法术数量：" + wizard.getSpells().size());
        for (Spell spell : wizard.getSpells()) {
            System.out.println("法术名:" + spell.getName() + "; 法术类型:" + spell.getType()+ "; 学习法术所需等级:" + spell.getLevelRequire());
        }
        // 查找法术
        Spell found = wizard.findSpellByName("Fireball");
        if (found != null) {
            System.out.println("已找到：" + found.getName());
        }
        else System.out.println("未找到该法术");
        // 移除法术
        wizard.removeSpellByName("Life Heal");
        System.out.println("删除后的法术数量：" + wizard.getSpells().size());

        // TODO 请设定法术施展顺序，击垮队伍monsters，
        // 要求：1.打印每一个法术施展情况，以及施展过后怪物的血量、法师的法力、血量情况，最终目标是法师健康，怪物血量为0
        for (int i = 0; i < 4; i++) {
            wizard.castAttackSpell("Fireball", monsters.get(1));
            if (!wizard.isAlive()) {
                System.out.println("战斗失败……");
                return;
            }
        }


        for (int i = 0; i < 7; i++)
            wizard.castHealSpell("Mana Regen");

        wizard.castAttackSpell("Ice Spike", monsters.get(0));
        if (!wizard.isAlive()) {
            System.out.println("战斗失败……");
            return;
        }

        wizard.castAttackSpell("Thunder Strike", monsters.get(0));
        if (!wizard.isAlive()) {
            System.out.println("战斗失败……");
            return;
        }

        System.out.println("战斗胜利！");
    }
}
