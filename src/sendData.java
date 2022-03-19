import java.io.IOException;
import java.net.DatagramPacket;
import java.util.concurrent.TimeUnit;

public class sendData{

    public static void main(String[] args) throws IOException, InterruptedException {
        sACNDataPacket sACNPacket = new sACNDataPacket("AlexPacket");
        sACNPacket.setUniverse(0);
        sACNPacket.setPacket();
        DatagramPacket rawPacketOne = new DatagramPacket(sACNPacket.getPacket(), 0, sACNPacket.packetLength, sACNPacket.address, sACNPacket.port);

        sACNSocket Socket = new sACNSocket();

        System.out.println("printing Packet");
        System.out.println(rawPacketOne);

        System.out.println("Sending packet" + "0");
        Socket.sendPacket(rawPacketOne);

        while(true){
            sACNPacket.setUniverse(255);
            sACNPacket.setPacket();
            System.out.println("Sending packet" + "255");
            Socket.sendPacket(rawPacketOne);
            TimeUnit.MILLISECONDS.sleep(250);
            sACNPacket.setUniverse(0);
            sACNPacket.setPacket();
            System.out.println("Sending packet" + "0");
            Socket.sendPacket(rawPacketOne);
            TimeUnit.MILLISECONDS.sleep(250);
        }
    }
}
