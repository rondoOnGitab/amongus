package Server;

import Classes.*; // Import eventuali classi definite dall'utente.

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

class App {
    public static void main(String[] args) throws IOException {
        // Crea un socket UDP sulla porta 12345
        DatagramSocket socket = new DatagramSocket(12345);

        byte[] buffer = new byte[1500]; // Dimensione buffer, conforme a MTU.
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        System.out.println("Server in ascolto sulla porta 12345...");

        while (true) {
            // Riceve un pacchetto dal client
            socket.receive(packet);
            String mex = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Messaggio ricevuto: " + mex);

            String mexRisp;
            if (mex.startsWith("Ciao")) {
                // Risposta predefinita per messaggi che iniziano con "Ciao"
                mexRisp = "Ciao " + mex.substring(4).trim();
            } else {
                // Risposta personalizzata, letta dall'input dell'utente
                System.out.print("Inserisci una risposta personalizzata: ");
                Scanner sc = new Scanner(System.in);
                mexRisp = sc.nextLine();
            }

            // Invia il messaggio di risposta al client
            byte[] bufferRisp = mexRisp.getBytes();
            DatagramPacket packetRisp = new DatagramPacket(bufferRisp, bufferRisp.length, packet.getAddress(), packet.getPort());
            socket.send(packetRisp);

            System.out.println("Risposta inviata: " + mexRisp);
        }
    }
}
