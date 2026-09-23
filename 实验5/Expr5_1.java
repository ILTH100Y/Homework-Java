// 智能家居设备基类
class SmartHome {
    private String deviceName;
    private boolean state; 

    public SmartHome(String deviceName, boolean state) {
        this.deviceName = deviceName;
        this.state = state;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SmartHome类：设备名为" + deviceName + "  状态为" + (state?"打开":"关闭");
    }
}

// 智能窗帘类
class SmartCurtain extends SmartHome {
    public SmartCurtain(String deviceName, boolean state) {
        super(deviceName, state);
    }

    @Override
    public String toString() {
        return "SmartCurtain类：设备名为" + getDeviceName() + "，状态为" + (getState()?"打开":"关闭") + "。";
    }

    public void displayStatus() {
        System.out.println("设备【" + getDeviceName() + "】：窗帘已" + (getState()?"打开":"关闭") + "。");
    }
}

// 智能空调类
class SmartAirConditioner extends SmartHome {
    // 模式常量
    public static final String COOL = "制冷";
    public static final String HEAT = "制热";
    public static final String DRY = "除湿";
    public static final String FAN = "送风";

    private double temperature; // 当前室温
    private String mode;        // 模式

    public SmartAirConditioner(String deviceName, boolean state, double temperature, String mode) {
        super(deviceName, state);
        this.temperature = temperature;
        this.mode = mode;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "SmartAirConditioner类：设备名为" + getDeviceName() + "，状态为" + (getState()?"打开":"关闭") + "，模式为" + mode + "，当前室温为" + temperature + "。";
    }

    public void displayStatus() {
        System.out.println("设备【" + getDeviceName() + "】：当前模式为" + mode + "，室内温度为 " + temperature + "℃，请注意体感是否舒适。");
    }
}

// 智能音响类
class SmartSpeaker extends SmartHome {
    private String currentTrack;
    private String nextTrack;

    public SmartSpeaker(String deviceName, boolean state, String currentTrack, String nextTrack) {
        super(deviceName, state);
        this.currentTrack = currentTrack;
        this.nextTrack = nextTrack;
    }

    public String getCurrentTrack() {
        return currentTrack;
    }

    public void setCurrentTrack(String currentTrack) {
        this.currentTrack = currentTrack;
    }

    public String getNextTrack() {
        return nextTrack;
    }

    public void setNextTrack(String nextTrack) {
        this.nextTrack = nextTrack;
    }

    @Override
    public String toString() {
        return "SmartSpeaker类：设备名为" + getDeviceName() + "，状态为" + (getState()?"打开":"关闭") + "，当前播放曲目为" + currentTrack + "，下一首曲目为" + nextTrack + "。";
    }

    public void displayStatus() {
        System.out.println("设备【" + getDeviceName() + "】：当前播放《" + currentTrack + "》，请享受音乐。");
    }
}

public class Expr5_1 {
    public static void m1(SmartHome device){
        System.out.println(device.getDeviceName());
    }
    public static void m2(SmartHome device){
        System.out.println(device.toString());
    }
    public static void m3(SmartHome device){
        if (device instanceof SmartCurtain)
            ((SmartCurtain)device).displayStatus();
        else if (device instanceof SmartAirConditioner) {
            ((SmartAirConditioner)device).displayStatus();
        } else if (device instanceof SmartSpeaker)
            ((SmartSpeaker)device).displayStatus();
    }
    public static void main(String[] args){
        SmartHome[] arr={
                new SmartHome("基类",false),
                new SmartCurtain("窗帘",false),
                new SmartAirConditioner("空调",false,27,SmartAirConditioner.COOL),
                new SmartSpeaker("音响",false,"Bury the Light","Stardrop Tears")
        };
        for (int i=0;i<4;i++){
            m1(arr[i]);
            m2(arr[i]);
            m3(arr[i]);
            System.out.println();
        }
    }
}
