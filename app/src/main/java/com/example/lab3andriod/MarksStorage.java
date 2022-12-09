package com.example.lab3andriod;

import android.app.Activity;
import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MarksStorage {
    String fileName = "Scores.txt";
    int attempts = 0 ;
    int avgscore;

    public void SaveScore(Activity activity, String scores) {
        FileOutputStream fileOutput = null;

        try {
            fileOutput = activity.openFileOutput(fileName, Context.MODE_APPEND);
            fileOutput.write(scores.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

        String dataFromStorage;
        public String GetData(Activity activity){

            FileInputStream inputStream = null;
            StringBuffer stringBuffer = new StringBuffer();
            int read = 0;
            try {
                inputStream = activity.openFileInput(fileName);
                while ((read = inputStream.read()) != -1){
                    stringBuffer.append((char)read);
                    dataFromStorage = stringBuffer.toString();
                }
                System.out.println("**** data from file ***"+dataFromStorage);
                return dataFromStorage;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "No data found";
        }

    public int CountNumberOfAttempts() {
        int i;
        attempts=0;
        for (i = 0; i < dataFromStorage.toCharArray().length; i++) {
            if (dataFromStorage.toCharArray()[i] == '#') {
                attempts++;
            }
        }
        return attempts;
    }

    public int CountAverageScore(){
        int i;
        avgscore=0;
        for (i = 0; i < dataFromStorage.toCharArray().length; i++) {
            if(dataFromStorage.toCharArray()[i]=='/'){
                avgscore = avgscore + Character.getNumericValue(dataFromStorage.toCharArray()[i-1]);
            }
            System.out.println("Attempts = "+attempts);
            System.out.println("Average Score = "+avgscore);
        }
        return avgscore;
    }

    //Function to reset data
    public void ResetData(Activity activity){

        FileOutputStream fileOutput = null;
        try {
            fileOutput = activity.openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutput.write("".getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}







