package de.dhbw.studienarbeit.hearItApp.connector;

import android.util.Log;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import de.dhbw.studienarbeit.hearItApp.MainActivity;

/**
 * Class should implements the IConnector interface and should be used
 * by implementation of AR device printers. Provides the general structure of the
 * printing proccess. only the communication with the device has to be implemented through the
 * constructor of an implementation and the implementation of printMessage()
 *
 *  Created by Martin
 */

public abstract class AbstractConnector implements IConnector {

    /**
     * If recording, conversion and printing is ongoing this.isProcessing = true
     */
    protected boolean isProcessing;

    protected LinkedBlockingDeque<String> messageBuffer;

    public AbstractConnector(){
        this.messageBuffer = new LinkedBlockingDeque<String>();
    }

    @Override
    public void addToMessageBuffer(String message) {
        this.messageBuffer.add(message);
    }

    @Override
    public void startPrinting() {
        new Thread("AR Printing Thread"){
            public void run(){
                isProcessing = true;
                doPrinterJob();
            }
        }.start();
    }

    @Override
    public void stopPrinting(){
        this.isProcessing = false;
    }

    /**
     * Waits for a new message to appear in the message buffer to process it using
     * this.printMessage(String message) method
     */
    private void doPrinterJob(){
        while(this.isProcessing || !this.messageBuffer.isEmpty()){
            try {
                String newMessage = this.messageBuffer.poll(500, TimeUnit.MILLISECONDS);
                if (newMessage != null) {
                    if(!this.printMessage(newMessage)){
                        Log.e(MainActivity.LOG_TAG, "Failed to print message: " + newMessage);
                    }
                }
            }catch(InterruptedException e){
                Log.e(MainActivity.LOG_TAG, "Interrupted while " +
                        "polling new message from printer queue");
            }
        }
        Log.d(MainActivity.LOG_TAG, "Done printing messages");
    }

    /**
     * Prints out a single message to an AR device. Must be implemented device specific.
     * @param message
     * @return success
     */
    protected abstract boolean printMessage(String message);

}
