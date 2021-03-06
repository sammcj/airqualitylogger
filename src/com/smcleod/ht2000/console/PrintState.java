package com.smcleod.ht2000.console;

import com.smcleod.ht2000.usb.CSVUtils;
import com.smcleod.ht2000.usb.HT2000State;
import com.smcleod.ht2000.usb.HT2000UsbConnection;

import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class PrintState {
    private static final DateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception {
        String homeDir = System.getProperty("user.home");
        String fileDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
        String csvFile = String.format("%s/Desktop/airmonitor-%s.csv",homeDir, fileDate);

        FileWriter writer = new FileWriter(csvFile);

        HT2000UsbConnection usbConnection = new HT2000UsbConnection();
        try {
            System.out.println("Taking measurements every 1 minute and saving to" + csvFile + ", press enter to end");
            CSVUtils.writeLine(writer, Arrays.asList("Date","Time", "Temperature", "Humidity", "Co2 PPM"));

            while (System.in.available() == 0) {

                usbConnection.open();

                HT2000State state = usbConnection.readState();

//                String readDate = DATE_TIME_FORMATTER.format(state.getTime());

                Date dNow = new Date( );
                SimpleDateFormat formatDate = new SimpleDateFormat ("yyyy.MM.dd");
                SimpleDateFormat formatTime = new SimpleDateFormat ("hh:mm:ss");
                String currentDate = formatDate.format(dNow);
                String currentTime = formatTime.format(dNow);


                Double readTemp = state.getTemperature();
                Double readHumidity = state.getHumidity();
                Integer readCo2 = state.getCo2();

                System.out.println("Date: " + currentDate + " Time: " + currentTime + " Temperature: " + readTemp + " Humidity: " + readHumidity + " Co2 PPM: " + readCo2);
                CSVUtils.writeLine(writer, Arrays.asList(currentDate, currentTime, readTemp.toString(), readHumidity.toString(), readCo2.toString()));
                writer.flush();
                TimeUnit.SECONDS.sleep(60);
            }

            writer.close();
        } finally {
            usbConnection.close();
            HT2000UsbConnection.shutdown();
        }
    }
}
