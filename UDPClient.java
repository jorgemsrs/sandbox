import java.io.*;
import java.net.*;
import java.util.*;

class UDPClient
{
   private static long messageCount = 0;
   private static boolean loop = true;

   public static final String data = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean diam felis, condimentum eget dapibus et, pulvinar vel odio. Vivamus eleifend posuere dolor non fermentum. Duis congue velit a libero dignissim dapibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer rhoncus vehicula tellus, non elementum nibh dignissim eget. Sed ut nulla at turpis malesuada venenatis. Nullam sed iaculis turpis. In a accumsan elit. Nullam sit amet purus ac purus sodales pellentesque non ac ligula. Ut cras amet.";

   public static void main(String args[]) throws Exception
   {
      BufferedReader inFromUser =
         new BufferedReader(new InputStreamReader(System.in));

      InetAddress MC_INET_ADDRESS = InetAddress.getByName("232.0.2.70");
      InetAddress MDB_INET_ADDRESS = InetAddress.getByName("232.0.2.71");

      final MulticastSocket clientSocket = new MulticastSocket(8000);
      clientSocket.joinGroup(MDB_INET_ADDRESS);

      
      Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
         public void run() {
            loop = false;
            clientSocket.close();
            displayStats();
          }
      }));
      
      new Thread(new Runnable() {
         @Override
         public void run(){
            while (loop) {
               byte[] receiveData = new byte[1024];

               try {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  clientSocket.receive(receivePacket);
                  String modifiedSentence = new String(receivePacket.getData());
                  System.out.println("RECEIVED " + modifiedSentence);
               } catch(IOException e) {
                  // May get interrupted while receiving
               }
            }
         }
      }).start();

      while (loop) {
         byte[] sendData = new byte[data.length()];

         //String sentence = inFromUser.readLine();
         //sendData = UUID.randomUUID().toString().getBytes();
         sendData = data.getBytes();

         // Envia para MC
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, MC_INET_ADDRESS, 8000);
         clientSocket.send(sendPacket);
         System.out.println("SENT '" + new String(sendData) + "'");
         messageCount += 1;

         Thread.currentThread().sleep(400);
      }
   }

   private static final void displayStats() {
      System.out.println("\nSent " + messageCount + " messages");
   }
}