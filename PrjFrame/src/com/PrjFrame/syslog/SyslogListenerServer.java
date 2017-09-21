package com.PrjFrame.syslog;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.productivity.java.syslog4j.SyslogConstants;

public class SyslogListenerServer {

	public static void main(String[] args) {
		 
    	try {
    		byte[] ipAddr = new byte[]{(byte)192, (byte)168, (byte)1, (byte)110};
    		InetAddress addr = InetAddress.getByAddress(ipAddr);

			DatagramSocket socket = new DatagramSocket(514,addr);
			
			byte[] buf = new byte[SyslogConstants.SYSLOG_BUFFER_SIZE];
			DatagramPacket packet = new DatagramPacket(buf,buf.length);
			while(true){
				socket.receive(packet);
				String getMsg = new String(buf,0,packet.getLength());
				byte[] temp = getMsg.toString().getBytes("utf-8");
				
				System.out.println("客户端发送数据为："+new String(temp, "utf-8"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
