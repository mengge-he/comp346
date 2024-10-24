
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Driver extends Thread{

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	 /*******************************************************************************************************************************************
    	  * TODO : implement all the operations of main class   																					*
    	  ******************************************************************************************************************************************/
        
          Network objNetwork = new Network("network");            /* Activate the network */
          objNetwork.start();
  
          // Create server thread
          Server server = new Server();
          server.start();  // Start server thread
  
          // Create client threads for sending and receiving
          Client clientSending = new Client("sending");
          clientSending.start();  // Start client sending thread
  
          Client clientReceiving = new Client("receiving");
          clientReceiving.start();  // Start client receiving thread
  
          // Join threads to wait for their completion
          try {

            clientSending.join();
            clientReceiving.join();

          } catch (InterruptedException e) {
              e.printStackTrace();
          }
  

    }
}
