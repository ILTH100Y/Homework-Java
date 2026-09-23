interface Playable{
    void play();
    default String getDescription() {
        return "该设备为通用播放器";
    }
}

class MusicPlayer implements Playable{
    private String name;

    public MusicPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play(){
        System.out.println("正在播放音乐："+name);
    }

    @Override
    public String getDescription(){
        return "该设备类型为音乐播放器";
    }
}

class VideoPlayer implements Playable{
    private String name;
    private double duration;

    public VideoPlayer(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public double getduration() {
        return duration;
    }

    public void setduration(double duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play(){
        System.out.printf("正在播放视频：%s，时长%.2f分钟",name,duration);
    }

    @Override
    public String getDescription(){
        return "该设备类型为视频播放器";
    }
}

public class Expr8_3 {
    public static void main(String[] args) {
        Object[] players = {
                new MusicPlayer("青花瓷"),
                new VideoPlayer("复仇者联盟", 120.5),
                new MusicPlayer("告白气球"),
                new VideoPlayer("阿凡达", 162.0),
                "普通的字符串",
                12345,
                new Object()
        };

        for (Object obj : players) {
            if (obj instanceof Playable) {
                Playable player = (Playable) obj;
                player.play();
                System.out.println("设备描述：" + player.getDescription());
                System.out.println("-------------------------");
            } else {
                System.out.println("[" + obj.getClass().getSimpleName() + "] 未实现Playable接口，跳过播放。");
                System.out.println("-------------------------");
            }
        }
    }
}
