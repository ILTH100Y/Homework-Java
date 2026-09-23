public class Expr4_1 {
    public static void main(String[] args){
        SmartLight Test1=new SmartLight();
        Test1.turnOn();
        Test1.getStatus();
        Test1.setBrightness(80);
        Test1.changeColor("warm white");
        Test1.getStatus();
        Test1.changeColor("blue");
        Test1.getStatus();
        SmartLight M=new SmartLight("light_001","客厅主灯",70,"yellow");
        M.turnOn();
        M.getStatus();
        M.changeColor("blue");
        M.getStatus();
        SmartDevice Test2=new SmartLight();
        Test2.getStatus();
    }
}

class SmartDevice{
    private String deviceId;
    private String deviceName;
    private boolean isOn;
    public SmartDevice(){
        deviceId="000000";
        deviceName="No name";
        isOn=false;
    }
    public SmartDevice(String deviceId,String deviceName){
        this.deviceId=deviceId;
        this.deviceName=deviceName;
        isOn=false;
    }
    public void turnOn(){
        isOn=true;
    }
    public void turnOff(){
        isOn=false;
    }
    public String getDeviceId(){
        return deviceId;
    }
    public String getDeviceName(){
        return deviceName;
    }
    public boolean getisOn(){
        return isOn;
    }
    public void setDeviceId(String deviceId){
        this.deviceId=deviceId;
    }
    public void setDeviceName(String deviceName){
        this.deviceName=deviceName;
    }
    public void setisOn(boolean isOn){
        this.isOn=isOn;
    }
    public void getStatus(){
        System.out.println("设备Id："+deviceId);
        System.out.println("设备名称："+deviceName);
        System.out.println("开关状态："+isOn);
    }
}

class SmartLight extends SmartDevice{
    private int brightness;
    private String color;
    public SmartLight(){
        super();
        brightness=50;
        color="white";
    }
    public SmartLight(String deviceId,String deviceName
            ,int brightness,String color){
        super(deviceId,deviceName);
        this.brightness=brightness;
        this.color=color;
    }
    @Override
    public void turnOn(){
        super.turnOn();
        brightness=50;
    }
    @Override
    public void getStatus(){
        super.getStatus();
        System.out.println("亮度："+brightness);
        System.out.println("颜色："+color);
    }
    public void setBrightness(int level){
        brightness=level;
    }
    public void changeColor(String newColor){
        color=newColor;
    }
}

